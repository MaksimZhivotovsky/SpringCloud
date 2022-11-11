package com.libraryservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@Entity
@Table(name = "library")
public class Library {

	@Id
	@Column(name = "library_id")
	private String libraryId;
	@Column(name = "name")
	private String name;
	@Column(name = "contact_phone")
	private String contactPhone;
	@Column(name = "adress")
	private String adress;
}
