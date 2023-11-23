package com.dcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcs.dto.Interview;

public interface IInterviewDAO extends JpaRepository<Interview, Integer>{

}
