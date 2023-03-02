import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddfeedbackComponent } from './components/addfeedback/addfeedback.component';
import { UpdatefeedbackComponent } from './components/updatefeedback/updatefeedback.component';
import { ViewfeedbacksComponent } from './components/viewfeedbacks/viewfeedbacks.component';

const routes: Routes = [
  { path: '', component: ViewfeedbacksComponent },
  { path: 'add', component: AddfeedbackComponent },
  { path: 'update/:id', component: UpdatefeedbackComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
