import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ReturnStatement } from '@angular/compiler';

const baseUrl = 'http://localhost:8096/todomanagement/api';

@Injectable({
  providedIn: 'root'
})
export class TodoserviceService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get(baseUrl + "/todoController/getTodos");
  }

  get(id: any) {
    return this.http.get(`${baseUrl}/todoController/getTodoById/${id}`);
  }

  create(data: any) {
    return this.http.post(`${baseUrl}/todoController/addTodo`, data);
  }

  update(id: Number, data: any) {
    return this.http.put(`${baseUrl}/todoController/updateTodo/`, data);
  }

  delete(id: Number) {
    return this.http.delete(`${baseUrl}/todoController/deleteTodo/${id}`);
  }

  deleteAll() {
    return this.http.delete(`${baseUrl}/todoController/deleteAll`);
  }

  findByTitle(title: String) {
    return this.http.get(`${baseUrl}/todoController/findByTitle?title=${title}`);
  }
 }
