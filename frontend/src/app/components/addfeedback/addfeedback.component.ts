import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AppService } from 'src/app/app.service';

@Component({
  selector: 'app-addfeedback',
  templateUrl: './addfeedback.component.html',
  styleUrls: ['./addfeedback.component.css']
})
export class AddfeedbackComponent implements OnInit {
  constructor(private service: AppService, private router: Router) { }
  data: any
  
  form = new FormGroup({
    feedback: new FormControl('', [Validators.required]),
    
  })
  ngOnInit(): void {
  }
  submit(){
    this.data = this.form.value
    console.log(this.data)

    this.service.addfeedback(this.data).subscribe(data => {
      console.log(data)
    })
    this.router.navigate(['/']);
  }
}
