package com.springrest.firstspring.services;

//import java.util.ArrayList;

import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.firstspring.dao.Coursedao;
import com.springrest.firstspring.entities.Course;
@Service
public class Courseserviceimpl implements Courseservice {
	@Autowired
	private Coursedao courdao;

	//List<Course> list;
	public Courseserviceimpl() {
	//	list=new ArrayList<>();
	//	list.add(new Course(902,"java spring","this is my 1st spring"));
	}
	
	
	@Override
	public List<Course> getCourses(){
		
		//return list;
		return courdao.findAll();
	}



	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse (long courseID) {
//		Course c= null;
//		for (Course course : list)
//		{
//			if(course.getId()==courseID)
//			{
//				c=course;
//				break;
//			}
//		}
		return courdao.getOne(courseID);
		//return c;
	}


	@Override
	public Course addCourse(Course course) {
	//	list.add(course);
		courdao.save(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
//		list.forEach(e ->{
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//				
//			}
//		});
		courdao.save(course);
		return course;
	}


	
	@Override
	public void deleteCourse(long parseLong) {
	//	list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		@SuppressWarnings("deprecation")
		Course entity= courdao.getOne(parseLong);
		courdao.delete(entity);
	}
	

}
