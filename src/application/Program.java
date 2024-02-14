package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("---SELLER TESTS---");
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> sellersList = sellerDao.findByDepartment(department);
		for(Seller obj : sellersList) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		sellersList = sellerDao.findAll();
		for(Seller obj : sellersList) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller INSERT ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller UPDATE ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: seller DELETE ===");
		System.out.println("Enter the id of the seller for delete test: ");
		int sellerId = sc.nextInt();
		sellerDao.deleteById(sellerId);
		System.out.println("Delete completed!");
		
		System.out.println("---DEPARTMENT TESTS---");
		
		System.out.println("\n=== TEST 7: department INSERT ===");
		Department newDepartment = new Department(null, "Games");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n === TEST 8: department UPDATE ===");
		System.out.println("Enter the id of the department for delete test: ");
		int departmentId = sc.nextInt();
		departmentDao.deleteById(departmentId);
		System.out.println("Delete completed!");
		
		System.out.println("=== TEST 9: department findById ===");
		department = departmentDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 10: department findAll ===");
		List<Department> departmentList = departmentDao.findAll();
		for(Department obj : departmentList) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
