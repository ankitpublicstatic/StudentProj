package org.ankit.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rest_api_student")
public class Student {
	
	
	
		@Id
		@Type(type="int")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(length=15)
		@Type(type="string")
		@NonNull
		private String name;
		
		
		@Type(type="int")
		@NonNull
		private Byte age;
		
		@Column(length=15)
		@Type(type="string")
		@NonNull
		private String address;
		
		@Column(name = "obmarks")
		@NonNull
		private Long ObMarks;
		
		
	
	}