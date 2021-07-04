package org.ankit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "Details about the contact")
public class ContactDTO implements Serializable{
	@ApiModelProperty(notes = "The unique id of the contact")
	private Integer id;
	@ApiModelProperty(notes = "The person's name ")
	private String name;
	@ApiModelProperty(notes = "The person's phone number")
	private String phone;
	
	

}
