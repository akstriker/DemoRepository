package com.example.service;


import com.example.entity.StudentEntity;
import com.example.model.StudentModel;
/**
 * This class is StudentService interface 
 * @author bhupalp
 *
 */
public interface StudentService {
    public StudentEntity insertStudentDetails(StudentModel student);
    public String updateStudentDetailsByRollNo(StudentModel student,Integer studentId) throws Exception;
    public String deleteStudentByRollNo(Integer studentId) throws Exception;
    public StudentEntity getAllDetailsById(Integer sid) throws Exception;
}
