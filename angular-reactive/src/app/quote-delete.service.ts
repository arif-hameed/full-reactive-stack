import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class QuoteDeleteService {

  url: string = 'http://localhost:8080/quote-delete';

  constructor(private http: HttpClient) {}

  deleteQuote(id: number): Observable<any>  {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

}
