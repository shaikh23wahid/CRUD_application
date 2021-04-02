import { Component, OnInit } from '@angular/core';
import { TodoserviceService } from 'src/app/services/todoservice.service';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss']
})
export class TodoListComponent implements OnInit {

  todos: any;
  currentTodo: any;
  currentIndex = -1;
  title = '';

  constructor(private todoService: TodoserviceService) { }

  ngOnInit(): void {
    this.retrieveTodos();
  }

  retrieveTodos() {
    this.todoService.getAll()
      .subscribe((response: any) => {
        this.todos = response['todoList'];
        console.log(response);
      }, error => {
        console.log(error);
      });
  }

  refreshList() {
    this.retrieveTodos();
    this.currentTodo = null;
    this.currentIndex = -1;
  }

  setActiveTodo(todo: null, index: number) {
    this.currentTodo = todo;
    this.currentIndex = index;
  }

  removeAllTodos() {
    this.todoService.deleteAll()
      .subscribe(response => {
        console.log(response);
        this.retrieveTodos();
      }, error => {
        console.log(error);
      });
  }

  searchTitle() {
    this.todoService.findByTitle(this.title)
      .subscribe(
        data => {
          this.todos = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}
