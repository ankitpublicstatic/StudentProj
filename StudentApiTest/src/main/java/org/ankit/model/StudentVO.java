package org.ankit.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO {
	private String name;
	private Byte age;
	private String address;
	private Long ObMarks;
	
}