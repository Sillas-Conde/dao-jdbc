package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Department dep = new Department(0,"Books");
		System.out.println(dep);
		
		Date birth = new Date();
		Seller seller = new Seller(0, "Sillas", "sillasconde@outlook.com", birth,2500.0, dep);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println(seller);
		
	}

}
