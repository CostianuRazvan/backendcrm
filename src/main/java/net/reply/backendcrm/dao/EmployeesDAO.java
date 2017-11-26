package net.reply.backendcrm.dao;

import java.util.List;

import net.reply.backendcrm.dto.Employees;

public interface EmployeesDAO {
	
	
	boolean add(Employees employees);
	List<Employees> list();
	boolean update(Employees employees);
	boolean deleteALL();
	Employees get(int id);

}
