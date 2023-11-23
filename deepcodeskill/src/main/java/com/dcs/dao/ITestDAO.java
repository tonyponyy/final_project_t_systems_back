package com.dcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcs.dto.Test;

public interface ITestDAO extends JpaRepository<Test, Integer>{

}
