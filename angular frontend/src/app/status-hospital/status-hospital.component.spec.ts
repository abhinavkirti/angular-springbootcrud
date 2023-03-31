import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusHospitalComponent } from './status-hospital.component';

describe('StatusHospitalComponent', () => {
  let component: StatusHospitalComponent;
  let fixture: ComponentFixture<StatusHospitalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatusHospitalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatusHospitalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
