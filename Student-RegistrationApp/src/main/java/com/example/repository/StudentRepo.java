package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.StudentEntity;
/**
 * 
 * @author bhupalp
 *
 */
public interface StudentRepo extends JpaRepository<StudentEntity,Serializable> {

}
