package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 * 
 * @author bhupalp
 *
 */
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "Student_Details_DB")
public class StudentEntity {
  @Id
  @GeneratedValue
  @Column(name = "studentId",length = 10)
  private Integer studentId;
  @Column(name = "FirstName",length = 20)
  private String firstName;
  @Column(name = "LastName",length =20)
  private String lastName;
  @Column(name = "Gender",length =5)
  private String gender;
  @Column(name = "DOB")
  private Date dob;
  @Column(name = "Email",length = 30)
  private String email;
  @Column(name = "PhoneNo",length = 10)
  private Long phNo;
  @Column(name = "Course",length = 20)
  private String course;
  @Column(name = "Address",length = 20)
  private String addr;
}
