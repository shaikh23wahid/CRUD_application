import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTodoComponent } from './component/add-todo/add-todo.component';
import { TodoDetailsComponent } from './component/todo-details/todo-details.component';
import { TodoListComponent } from './component/todo-list/todo-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddTodoComponent,
    TodoDetailsComponent,
    TodoListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
