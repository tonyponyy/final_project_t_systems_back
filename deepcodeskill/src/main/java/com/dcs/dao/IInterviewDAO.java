package com.dcs.dao;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dcs.dto.Interview;

public interface IInterviewDAO extends JpaRepository<Interview, Integer>{

	//TODO SANEAR
		@Query("SELECT i FROM Interview i WHERE LOWER(i.title) LIKE LOWER(CONCAT('%', :title, '%'))")
		public Page<Interview> findByTitle(@Param("title")String name, PageRequest pageRequest);
	}
