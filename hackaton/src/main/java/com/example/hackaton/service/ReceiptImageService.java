package com.example.hackaton.service;

import com.example.hackaton.dto.receiptImage.ReceiptImageResponseDto;
import com.example.hackaton.entity.ReceiptImageEntity;
import com.example.hackaton.exception.CommonException;
import com.example.hackaton.exception.ReceiptImageException;
import com.example.hackaton.exception.model.ErrorResponse;
import com.example.hackaton.mapper.ManualHackathonMapper;
import com.example.hackaton.repository.ReceiptImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.hackaton.exception.constants.Constant.UNEXPECTED_INTERNAL_ERROR;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiptImageService {
    private final ReceiptImageRepository repository;
    private final ManualHackathonMapper mapper;

    private final Path root = Paths.get("static/image");
    private Path foundFile;
    private String fileFinalName;

    public ReceiptImageResponseDto getById(Long id) {
        ReceiptImageEntity branchImage= repository.findById(id).orElseThrow(()-> new ReceiptImageException(id));
        return mapper.toReceiptImageResponseDto(branchImage);
    }

    public List<ReceiptImageResponseDto> getAll() {
        return mapper.toReceiptImageResponseDtoList(repository.findAll());
    }

    @Transactional
    public ReceiptImageResponseDto saveFile(MultipartFile multipartFile) throws IOException{
        ReceiptImageEntity receiptImage = new ReceiptImageEntity();
        receiptImage.setReceiptImageSource(fileUrlMain(multipartFile));
        receiptImage.setCreatedAt(LocalDateTime.now());
        String fileName = receiptImage.getReceiptImageSource()
                .substring(receiptImage.getReceiptImageSource().lastIndexOf('/') + 1);
        fileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8);

        receiptImage.setReceiptImageName(fileName);
        receiptImage.setReceiptImageNameForDisplay(multipartFile.getOriginalFilename());
        repository.save(receiptImage);

        ReceiptImageResponseDto receiptImageResponseDto = mapper.toReceiptImageResponseDto(receiptImage);
        log.info("Created corporate file: {}", receiptImageResponseDto);
        return receiptImageResponseDto;
    }

    public String fileUrlMain(MultipartFile multipartFile){
        String fileName = multipartFile.getOriginalFilename();

        String[] parts = fileName.split("\\.");
        fileName = parts[0] + System.currentTimeMillis() + "." + parts[1];
        fileFinalName = fileName;

        try(InputStream inputStream = multipartFile.getInputStream()) {
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
            Path filePath = root.resolve(fileFinalName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            return ServletUriComponentsBuilder.fromCurrentContextPath().path("/receipt/downloadFile/" + fileFinalName).toUriString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public void delete(Long id) {
        ReceiptImageEntity corporateFileEntity = repository.findById(id).orElseThrow(
                 ()-> new ReceiptImageException(id)
        );
        String fileName = corporateFileEntity.getReceiptImageName();
        try {
            fileName = URLDecoder.decode(fileName, StandardCharsets.UTF_8);

            Path file = root.resolve(fileName);
            Files.delete(file);
            repository.deleteById(id);
        } catch (Exception e) {
            throw new CommonException(UNEXPECTED_INTERNAL_ERROR, e.getMessage());
        }
    }

    public Resource getFilesAsResource (String fileName) throws Exception{
        Files.list(root).forEach(file-> {
            if (file.getFileName().toString().startsWith(fileName)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null){
            return new UrlResource(foundFile.toUri());
        }
        return null;
    }
}
