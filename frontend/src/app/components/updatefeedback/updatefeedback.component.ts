import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AppService } from 'src/app/app.service';
import { Feedback } from 'src/app/feedback';

@Component({
  selector: 'app-updatefeedback',
  templateUrl: './updatefeedback.component.html',
  styleUrls: ['./updatefeedback.component.css']
})
export class UpdatefeedbackComponent implements OnInit {

  feedback?: Feedback
  data: any


  constructor(private service: AppService, private route: ActivatedRoute, private router : Router) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.service.getFeedbackById(id).subscribe(data => {
      this.feedback = data
      console.log(this.feedback)
    })
  }

  form = new FormGroup({
    email: new FormControl('', [Validators.required]),
    pNo: new FormControl('', [Validators.required]),
    address: new FormControl('', [Validators.required])
  })

  submit(){
    this.data = this.form.value
    console.log(this.data)
    
    this.service.updateFeedback(this.feedback?.id, this.data).subscribe(data => {
      console.log(data)
    })

    this.router.navigate(['/']);
  }

}