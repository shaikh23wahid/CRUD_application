import { Component, OnInit } from '@angular/core';
import { TodoserviceService } from 'src/app/services/todoservice.service';

@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.scss']
})
export class AddTodoComponent implements OnInit {
  todo = {
    _id: 0,
    name: '',
    description: '',
    title: '',
    status: false
  };
  submitted = false;

  constructor(private todoService: TodoserviceService) { }

  ngOnInit(): void {
  }

  saveTodo() {
    const data = {
      title: this.todo.title,
      description: this.todo.description,
      name: this.todo.name,
      status: this.todo.status
    }

    this.todoService.create(data)
    .subscribe(response => {
      console.log(response);
      this.submitted = true;
    },
    error => {
      console.log(error);
    });
  }

  newTodo() {
    this.submitted = false;
    this.todo = {
      _id: 0,
      title: '',
      name: '',
      description: '',
      status: false
    }
  }
}
