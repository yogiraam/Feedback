import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AddfeedbackComponent } from './components/addfeedback/addfeedback.component';
import { UpdatefeedbackComponent } from './components/updatefeedback/updatefeedback.component';
import { ViewfeedbacksComponent } from './components/viewfeedbacks/viewfeedbacks.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AddfeedbackComponent,
    UpdatefeedbackComponent,
    ViewfeedbacksComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }