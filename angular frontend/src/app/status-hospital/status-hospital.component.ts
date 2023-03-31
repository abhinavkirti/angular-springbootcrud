import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HospitalService } from '../services/hospital.service';
import { Hospital } from '../POJOS/Hospital';

@Component({
  selector: 'app-status-hospital',
  templateUrl: './status-hospital.component.html',
  styleUrls: ['./status-hospital.component.css']
})
export class StatusHospitalComponent implements OnInit {

  hospitals!: Observable<Hospital[]>;
  hospital!: Hospital;
  status!: number;
  id!: number;
  constructor(private hospitalService: HospitalService ,
    private router: Router) {}
    ngOnInit() {
      this.reloadData();
    }
    reloadData() {
      this.hospitals = this.hospitalService.getHospitalList();
    }
    deleteHospital(id: number) {
      this.hospitalService.deleteHospital(id)
        .subscribe(
          data => {
            console.log(data);
            this.reloadData();
          },
          error => console.log(error));
    }

    updateHospital() {
    
      this.hospitalService.updateHospital(this.id, this.hospital)
        .subscribe(data => {
          console.log(data);
          this.hospital = new Hospital();
          this.router.navigate(['/status']);
          
        }, error => console.log(error));
    }

    display(id: number)
    {
      this.updateHospital();
      
      this.router.navigate(['update',id]);
      
    }
    
    
  }


