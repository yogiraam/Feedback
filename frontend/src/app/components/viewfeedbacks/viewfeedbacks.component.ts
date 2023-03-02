import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';

@Component({
  selector: 'app-viewfeedbacks',
  templateUrl: './viewfeedbacks.component.html',
  styleUrls: ['./viewfeedbacks.component.css']
})
export class ViewfeedbacksComponent implements OnInit {

feedbacks: any[] | undefined
  url: string = "http://localhost:8081/";

  constructor(private service: AppService, private router: Router) { 
   
  }

  ngOnInit(): void {
    this.service.getFeedbacks().subscribe(data => {
      this.feedbacks = data;
    })
  }

  deleteFeedback(id: number){
    this.service.deleteFeedback(id).subscribe(data => {
      this.feedbacks= this.feedbacks?.filter(feedback=> feedback.id !== id);
    })
    
      setTimeout(()=>{
        window.location.reload();
      }, 100);
  
  }

  updateFeedback(id: number){
    this.router.navigate(['update', id]);
  }

}
