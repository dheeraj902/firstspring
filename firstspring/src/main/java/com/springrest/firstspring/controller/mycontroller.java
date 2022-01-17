package com.springrest.firstspring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.firstspring.entities.Course;
import com.springrest.firstspring.services.Courseservice;

@RestController
public class mycontroller {
	@Autowired
	
	public Courseservice cour;
	
	
	
	//get courses
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return cour.getCourses();
	}
	
	//single course get
	@GetMapping("/courses/{courseID}")
	public Course getCourse(@PathVariable String courseID ) {
		return this.cour.getCourse(Long.parseLong(courseID));
		
	}
	
	//course add
	@PostMapping( "/courses")
	public Course addCourse(@RequestBody Course course) {
		return cour.addCourse(course);
	}
	
	//update course using put
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return cour.updateCourse(course);
	}
	
	//delete course
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.cour.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
//	public void deleteCourse(@PathVariable String courseId){
//		 cour.deleteCourse(Long.parseLong(courseId));
//		
	}
	
	
}
