package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println("================================");
		System.out.println("TEST findById:");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("================================");
		System.out.println("TEST findByDepartment:");
		Department department = new Department(1,null);
		
		List<Seller> sellerList = sellerDao.findByDepartment(department);
		for (Seller sellerExemple: sellerList) {
			System.out.println(sellerExemple);
		}

		
		
		
	}

}
