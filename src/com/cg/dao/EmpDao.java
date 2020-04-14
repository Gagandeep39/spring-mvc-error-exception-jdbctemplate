package com.cg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.beans.Emp;
import com.cg.service.EmployeeService;
/**
 * 
 * @author Gagandeep
 * @time 7:21:42 pm
 * @date 14-Apr-2020
 */
public class EmpDao {

	@Autowired
	EmployeeService serviceEmployee;

	public void setServiceEmployee(EmployeeService serviceEmployee) {
		this.serviceEmployee = serviceEmployee;
	}

	public int save(Emp p) {
		return serviceEmployee.save(p);
	}

	public int update(Emp p) {
		return serviceEmployee.update(p);
	}

	public int delete(int id) {
		return serviceEmployee.delete(id);
	}

	public Emp getEmpById(int id) {
		return serviceEmployee.getEmpById(id);
	}

	public List<Emp> getEmployees() {
		return serviceEmployee.getEmployees();
	}
}