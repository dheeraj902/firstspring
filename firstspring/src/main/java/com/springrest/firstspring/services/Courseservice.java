package com.springrest.firstspring.services;

import java.util.List;

import com.springrest.firstspring.entities.Course;

public interface Courseservice {
	public List<Course> getCourses();
	public Course getCourse(long courseID);
	public Course addCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long parseLong);

}
