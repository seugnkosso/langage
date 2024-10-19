import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CrudComponent } from './crud/crud.component';
import { Component, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,CrudComponent,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'

})
export class AppComponent  {

  title = 'front-end';
}
