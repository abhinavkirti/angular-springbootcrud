import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StatusHospitalComponent } from './status-hospital/status-hospital.component';
import { FindSlotComponent } from './find-slot/find-slot.component';
import { UpdateStatusComponent } from './update-status/update-status.component';

const routes: Routes = [
{path:'',redirectTo:'slot',pathMatch:'full'},
{path:'status',component:StatusHospitalComponent},
{path:'slot',component:FindSlotComponent},
{path:'update/:id',component:UpdateStatusComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
