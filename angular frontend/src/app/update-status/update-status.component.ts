import { Component, OnInit } from '@angular/core';
import { HospitalService } from '../services/hospital.service';
import { Hospital } from '../POJOS/Hospital';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-status',
  templateUrl: './update-status.component.html',
  styleUrls: ['./update-status.component.css']
})
export class UpdateStatusComponent implements OnInit {

  id!: number;
  hospital!: Hospital;
  constructor(private route: ActivatedRoute,private router: Router,
    private hospitalService: HospitalService) { }
    ngOnInit() {
      this.hospital = new Hospital();
  
      this.id = this.route.snapshot.params['id'];
      
      this.hospitalService.getHospital(this.id)
        .subscribe(data => {
          console.log(data)
          this.hospital = data;
        }, error => console.log(error));
    }
  
    updateHospital() {
      this.hospitalService.updateHospital(this.id, this.hospital)
        .subscribe(data => {
          console.log(data);
          this.hospital = new Hospital();
          this.gotoList();
        }, error => console.log(error));
    }
  
    onSubmit() {
      this.updateHospital();    
      window.alert("Booking Done");
    }
  
    gotoList() {
      this.router.navigate(['/status']);
    }

}
