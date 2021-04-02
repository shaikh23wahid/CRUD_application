import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TodoserviceService } from 'src/app/services/todoservice.service';

@Component({
  selector: 'app-todo-details',
  templateUrl: './todo-details.component.html',
  styleUrls: ['./todo-details.component.scss']
})
export class TodoDetailsComponent implements OnInit {

  currentTodo: any;
  message = '';

  constructor(
    private todoService: TodoserviceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.message = '';
    this.getTodo(this.route.snapshot.paramMap.get('id'));
  }

  getTodo(id: string | null) {
    this.todoService.get(id)
      .subscribe(data => {
          this.currentTodo = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  updateStatus(status: any) {
    const data = {
      title: this.currentTodo.title,
      description: this.currentTodo.description,
      status: status
    };

    this.todoService.update(this.currentTodo._id, data)
      .subscribe(response => {
          this.currentTodo.published = status;
          console.log(response);
        },
        error => {
          console.log(error);
        });
  }

  updateTodo() {
    this.todoService.update(this.currentTodo._id, this.currentTodo)
      .subscribe(response=> {
          console.log(response);
          this.message = 'The Todo was updated successfully!';
        },
        error=> {
          console.log(error);
        });
  }

  deleteTodo() {
    this.todoService.delete(this.currentTodo._id)
      .subscribe(response => {
          console.log(response);
          this.router.navigate(['/todos']);
        },
        error => {
          console.log(error);
        });
  }
}