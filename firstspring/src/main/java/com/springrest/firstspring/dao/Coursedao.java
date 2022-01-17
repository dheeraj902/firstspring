package com.springrest.firstspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.firstspring.entities.Course;

public interface Coursedao extends JpaRepository<Course,Long> {

}
