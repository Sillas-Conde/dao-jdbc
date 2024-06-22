package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {
		
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==========================");
		System.out.println("TEST findById");
		
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		

	}

}
