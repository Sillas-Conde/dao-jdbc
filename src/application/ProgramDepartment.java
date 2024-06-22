package application;

import java.util.List;

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
		
		System.out.println("==========================");
		System.out.println("TEST findAll");
		
		List<Department> deps = departmentDao.findAll();
		for (Department depExemple : deps) {
			System.out.println(depExemple);
		}
		
		System.out.println("==========================");
		System.out.println("TEST insert");
		dep = new Department(null,"Teste");
		departmentDao.insert(dep);
		System.out.println(dep);
		
		System.out.println("==========================");
		System.out.println("TEST deleteById");
		System.out.println(departmentDao.findById(dep.getId()));
		departmentDao.deleteById(dep.getId());
		System.out.println(departmentDao.findById(dep.getId()));
		
		System.out.println("==========================");
		System.out.println("TEST update");
		dep = departmentDao.findById(6);
		System.out.println(departmentDao.findById(dep.getId()));
		dep.setName("Mecatrônica");
		departmentDao.update(dep);
		System.out.println(departmentDao.findById(dep.getId()));

	}

}
