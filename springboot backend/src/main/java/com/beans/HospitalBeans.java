package com.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="hospital_table")
@DynamicInsert
public class HospitalBeans {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	long id;
	
	@Column
	private String name;
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private String appointmentdate;
	@Column
	private String speciality;
	@Column
	private String consultant;
	@Column
	@ColumnDefault(value="'9:00 AM TO 9:30AM'")
	private String slot;
	@Column
	@ColumnDefault(value="'Free'")
	private String status;

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAppointmentdate() {
		return appointmentdate;
	}
	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getConsultant() {
		return consultant;
	}
	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
