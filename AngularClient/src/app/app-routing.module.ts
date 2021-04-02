import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddTodoComponent } from './component/add-todo/add-todo.component';
import { TodoDetailsComponent } from './component/todo-details/todo-details.component';
import { TodoListComponent } from './component/todo-list/todo-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'todos', pathMatch: 'full' },
  { path: 'todos', component: TodoListComponent },
  { path: 'todo-detail/:id', component: TodoDetailsComponent },
  { path: 'add', component: AddTodoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
