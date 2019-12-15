package com.example.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.StudentEntity;
import com.example.model.StudentModel;
import com.example.repository.StudentRepo;

/**
 * 
 * @author bhupalp
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	/**
	 * This is log4j to generate Log message
	 */
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	/**
	 * Inject StudentRepo
	 */
	@Autowired
	private StudentRepo repo;

	/**
	 * This methode to insert studentDetails
	 * 
	 * @param StudentModel
	 * @return StudentEntity
	 */
	@Override
	public StudentEntity insertStudentDetails(StudentModel student) {
		logger.debug("===ServiceClass InsertStudent Methode Execution Started===");
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(student, entity);
		StudentEntity optEntity = repo.save(entity);
		logger.debug("===ServiceClass InsertStudent Methode Execution Completed===");
		return optEntity;
	}

	/**
	 * This method to Update StudentDetails
	 * 
	 * @param StudentModel
	 * @return Entity
	 */
	@Override
	public String updateStudentDetailsByRollNo(StudentModel student,Integer studentId) throws Exception {
		logger.debug("===Service UpdateStudent Methode Execution Started===");
		StudentEntity entity = new StudentEntity();
		String result=null;
			Optional<StudentEntity> optEntity=repo.findById(studentId);
			StudentEntity Upentity=optEntity.get();
		if(Upentity!=null) {
			BeanUtils.copyProperties(student, Upentity);
			entity=repo.save(Upentity);
    		result= "Update Successfull of StudentId "+entity.getStudentId();
    	}else {
    		result= "For this StudentId "+studentId+" Details Are Not Available";
    	}
			logger.debug("===Service UpdateStudent Methode Execution Completed===");
	return result;
	}

	/**
	 * This method to Delete StudentData from DB
	 * @param studentId
	 * @return 
	 */
	@Override
	public String deleteStudentByRollNo(Integer studentId)throws Exception {
		logger.debug("===ServiceClass DeleteStudent Methode Execution Started===");
		String result=null;
		if(studentId!=null) {
		repo.deleteById(studentId);
		result="Delelet Successfull";
		}else {
			result= "StudentId is Wrong";
		}
		logger.debug("===ServiceClass InsertStudent Methode Execution Completed===");
		return result;
	}

	/**
	 * This method is to Get StudentDetails By Id
	 * @param sid studentId
	 */
	@Override
	public StudentEntity getAllDetailsById(Integer sid)throws Exception {
		logger.debug("===ServiceClass GetStudentDetails Methode Execution Started===");
		logger.info("Service Fetch Studentid:" + sid);
		if (sid!= null) {
			Optional<StudentEntity> optEntity = repo.findById(sid);
			StudentEntity entity = optEntity.get();
			logger.info("Student All Details:" + entity);
			return entity;
		} else {
			return null;
		}
	}
}
