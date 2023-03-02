import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { Feedback } from './feedback';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private url = "http://localhost:8081/";

  constructor(private http: HttpClient) { }

  // Add User - Create
  addfeedback(feedback: Feedback){
    return this.http.post<Feedback>(`${this.url}add`, feedback)
  }

  // Get Users - Read
  getFeedbacks(): Observable<any[]>{
    return this.http.get<any[]>(this.url+'users')
  }

  // Get User by Id - Read
  getFeedbackById(id: number): Observable<Feedback>{
    return this.http.get<Feedback>(`${this.url}user/${id}`)
  }

  // Update User - Update
  updateFeedback(id?: number ,feedback?: any): Observable<any>{
    return this.http.put<any>(`${this.url}update/${id}`, feedback)
  }

  // Delete User - Delete
  deleteFeedback(id: number): Observable<any>{
    return this.http.delete<any>(`${this.url}delete/${id}`)
  }

}