package com.example.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
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
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="TBL_ACCOUNT", uniqueConstraints = {@UniqueConstraint(columnNames = {"aadharNo"})})
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="accno")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Long accNo;
	
	@Column(name="name")
	private String accHolderName;
	
	@Column(name="aadharNo")
	private Long aadhar;
	
	@Column(name="createdBy")
	private String createdBy;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="modifiedBy")
	private String modifiedBy;
	
	@Column(name="modifiedDate")
	private Date modifiedDate;
	
	@JsonIgnore
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Applicant applicant;
	
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

	public Account(Long accNo2, String accHolderName2, Long aadhar2) {
		this.aadhar = aadhar2;
		this.accNo= accNo2;
		this.accHolderName = accHolderName2;
	}
	
	public Account(String accHolderName2, Long aadhar2) {
		this.aadhar = aadhar2;
		this.accHolderName = accHolderName2;
	}
	
}
