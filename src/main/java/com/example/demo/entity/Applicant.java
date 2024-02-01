package com.example.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="TBL_APPLICANT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicantId;
	
	@Column(name="age")
	private int age;
	
	@Column(name="dob")
	private Date dob;
	
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="accno")
	private Account account;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="modifiedBy")
	private String modifiedBy;
	
	@Column(name="modifiedDate")
	private Date modifiedDate;
	
	@PreUpdate
	@PrePersist
	public void updateTimeStamps()
	{
		Date date = new Date();
		String userId = "admin";
		this.modifiedDate = date;
		this.modifiedBy = userId;
		if(this.createdDate == null) {
			this.createdDate = date;
			this.createdBy = userId;
		}
	}
	
}
