import { Injectable } from '@angular/core';
import axios from 'axios';
import {environment} from "../../environments/environment";
@Injectable({
  providedIn: 'root'
})
export class ChatGptService {
  private apiUrl = 'https://api.openai.com/v1/chat/completions';
  constructor() { }
  async getChatCompletion(prompt: string): Promise<any> {
    const headers = {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${environment.OPENAI_API_KEY}`,
    };

    const data = {
      model: 'gpt-3.5-turbo',
      messages: [{ role: 'system', content: 'You are a helpful assistant.' }, { role: 'user', content: prompt },
      ],max_tokens:100
    };

    try {
      const response = await axios.post(this.apiUrl, data, { headers });
      return response.data;
    } catch (error) {
      console.error('Error calling OpenAI API:', error);
      throw error;
    }
  }
}
