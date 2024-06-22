package application;

import java.util.Date;
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

		System.out.println("================================");
		System.out.println("TEST findAll:");
		sellerList = sellerDao.findAll();
		for (Seller sellerExemple: sellerList) {
			System.out.println(sellerExemple);
		}
		
		System.out.println("================================");
		System.out.println("TEST insert:");
		department = new Department(1,null);
		seller = new Seller(10, "Kleiton", "kleiton@gmail.com", new Date(), 5000.0, department);
		//sellerDao.insert(seller);
		System.out.println("Inserted Id:");
		System.out.println(
				sellerDao.findById(seller.getId())
		);	
		
		
	}

}
