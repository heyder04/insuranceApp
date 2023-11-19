package com.example.hackaton.controller;

import com.example.hackaton.dto.receiptImage.ReceiptImageResponseDto;
import com.example.hackaton.service.ReceiptImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/receipt")
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class ReceiptImageController {
    private final ReceiptImageService receiptImageService;
    @GetMapping
    public ResponseEntity<List<ReceiptImageResponseDto>> getAllCorporateFiles() {
        List<ReceiptImageResponseDto> files = receiptImageService.getAll();
        return ResponseEntity.ok().body(files);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceiptImageResponseDto> getCorporateFileById(@PathVariable Long id) {
        ReceiptImageResponseDto file = receiptImageService.getById(id);
        return ResponseEntity.ok().body(file);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorporateFile(@PathVariable Long id) {
        receiptImageService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ReceiptImageResponseDto> uploadFile(
            @RequestParam("file") MultipartFile file){

        try {
            return ResponseEntity.ok(receiptImageService.saveFile(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileName") String fileName){
        Resource resource = null;

        try {
            resource = receiptImageService.getFilesAsResource(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (resource == null){
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }

}
