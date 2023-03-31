import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HospitalService } from '../services/hospital.service';
import { Hospital } from '../POJOS/Hospital';

@Component({
  selector: 'app-find-slot',
  templateUrl: './find-slot.component.html',
  styleUrls: ['./find-slot.component.css']
})
export class FindSlotComponent implements OnInit {

  hospital: Hospital = new Hospital();
  submitted = false;
  constructor(private hospitalService: HospitalService,
    private router: Router) { }
    ngOnInit() {
    }
    newHospital(): void {
      this.submitted = false;
      this.hospital = new Hospital();
    }
    save() {
      this.hospitalService
      .createHospital(this.hospital).subscribe(data => {
        console.log(data)
        this.hospital = new Hospital();
        
      }, 
      error => console.log(error));
    }
    onSubmit() {
      this.submitted = true;
      this.save();
      this.router.navigate(['status']);    
    }
    

}
