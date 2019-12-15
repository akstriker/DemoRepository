package com.example.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.StudentEntity;
import com.example.model.StudentModel;
import com.example.service.StudentService;
/**
 * 
 * @author bhupalp
 *
 */

@RestController
public class StudentRestController {
	/**
	 * StudentService interface
	 */
    @Autowired
	private StudentService service;
    
    /**
     * This is log4j to generate Log message
     */
	private static final Logger logger = LoggerFactory.getLogger(StudentRestController.class);

    /**
     * This methode is To Save StudentDetails
     * @param student StudentDetails from user
     * @return String as message with StudentId
     */
    @PostMapping(value = "/studentInsert",produces = {"application/xml","application/json"})
    public @ResponseBody String saveStudentDetails(@RequestBody StudentModel student) {
    	String rollNo =null;
    	StudentEntity entity=service.insertStudentDetails(student);
    	logger.info("Student Details Entity:"+entity);
    	if(entity!=null) {
    		 rollNo ="Your RollNumber:"+entity.getStudentId();
    	}
    	return rollNo ;
    }
    /**
     * 
     * @param <object>
     * @param student
     * @return
     */
    @PostMapping(value = "/studentUpdate",produces = {"application/xml","application/json"})
    public @ResponseBody String modifyStudentDetailsById(@RequestBody StudentModel student,@RequestParam("sid")Integer studentId){
        logger.debug("Post Method UpdateStudentDetails execution Started");
    	String result=null;
		try {
			if(studentId!=null) { 
			result= service.updateStudentDetailsByRollNo(student,studentId);
			}
			else {
				result="Your StudentId Is Wrong";
			}
		} catch (Exception e) {
			result="Hello Your Data Is Not Available ..Please Register Your Details";
			e.printStackTrace();			
		}
		logger.debug("Post Method UpdateStudentDetails execution completed");
    	return result;
    }
    
    /**
     * This method is to Remove StudentDetails from DataBase
     * @param studentId studentId 
     * @return 
     */
    @GetMapping(value = "/studentDelete",produces = {"application/xml","application/json"})
    public @ResponseBody String removeStudentDetailsById(@RequestParam("sid") Integer studentId) {
    	logger.debug("Get Methode Remove StudentDetails Execution Started");
    	logger.info("StudentId:"+studentId);
      String result;
	try {
		result = service.deleteStudentByRollNo(studentId);
	} catch (Exception e) {
		result="StudentDetails Not available for this StudentId";
		e.printStackTrace();
	}
      logger.debug("Get Methode Remove StudentDetails Execution Completed");
      return result;
    }
    
    /**
     * This method is to Get StudentDetails By StudentId
     * @param studentId studentId from user
     * @return StudentEntity to return StudentDetails in the form  of object 
     */
    @GetMapping(value = {"/studentDetails"},produces = {"application/xml","application/json"})
    public StudentEntity fetchAllDetailsById(@RequestParam("sid")Integer studentId) {
    	logger.debug("Get Methode Execution Started");
    	logger.info("StudentId "+studentId);
    	StudentEntity entity=new StudentEntity();
		try {
			entity = service.getAllDetailsById(studentId);
			logger.info("StudentDetails:"+entity);
			
		} catch (Exception e) {
			logger.info("StudentDetails Not available for this StudentId");
			e.printStackTrace();
		}
    	logger.debug("Get Methode Execution Completed");
    	return entity;
    }
}
