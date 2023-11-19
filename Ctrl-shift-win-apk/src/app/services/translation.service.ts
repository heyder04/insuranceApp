import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TranslationService {
  private apiUrl3 = ' https://translation.googleapis.com/language/translate/v2';
  constructor(private http:HttpClient) { }
  translate(text: string, targetLanguage: string): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    const params = new HttpParams()
      .set('key', environment.TRANSLATION)
      .set('q', text)
      .set('target', targetLanguage);

    return this.http.post(this.apiUrl3, null, { headers, params });
  }
}
