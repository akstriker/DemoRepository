package com.example.model;

import java.util.Date;
import lombok.Data;
/**
 * 
 * @author bhupalp
 *
 */
@Data
public class StudentModel {
	  private String firstName;
	  private String lastName;
	  private String gender;
	  private Date dob;
	  private String email;
	  private Long phNo;
	  private String course;
	  private String addr;
}
