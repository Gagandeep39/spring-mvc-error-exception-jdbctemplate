package com.cg.service;

import java.util.List;

import com.cg.beans.Emp;
/**
 * 
 * @author Gagandeep
 * @time 7:21:50 pm
 * @date 14-Apr-2020
 */
public interface EmployeeOperations {
	public int save(Emp p);

	public int update(Emp p);

	public int delete(int id);

	public Emp getEmpById(int id);
	
	public List<Emp> getEmployees();
	
}
