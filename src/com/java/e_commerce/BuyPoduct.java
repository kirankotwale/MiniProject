package com.java.e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BuyPoduct extends ProductInfo {

	public static void getBuyDetails() {

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the no.of product");
			int num=sc.nextInt();
			for(int i=1;i<=num;i++) {
			String sql = "select * from ecommerce.product";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
			Statement statement = con.createStatement();
			// statement.execute(sql);
			ResultSet rs = statement.executeQuery(sql);
			System.out.println(" **Welcome To Electronic Mart** ");
			// iterate through the java resultset
			
				System.out.println("Enter product Id ");
				int input = sc.nextInt();
				int productId = 0;
				String discription = "";
				String poductprice = "";
				String poductname = "";
				int productquantity = 0;
 

				
                 
					while (rs.next()) {
						if (rs.getInt(1) == input) {
						productId = productId + rs.getInt(1);
						discription = discription + rs.getString(2);
						poductname = poductname + rs.getString(4);
						poductprice = poductprice + rs.getString(3);
						productquantity = productquantity + rs.getInt(5);
					}
				}
					

	//			  Scanner sc1=new Scanner(System.in); 
				  System.out.println("Enter the quantity");
				  int quantity =sc.nextInt();
				  int qty = productquantity - quantity;
     				if (quantity < productquantity && quantity > 0) {
     			     		PreparedStatement stmt = con
     				
							.prepareStatement("insert into addcart(id,price,name,quantity)values(?,?,?,?)");

					stmt.setInt(1, productId); // 1 first parameter in query.
					stmt.setString(2, poductprice);
					stmt.setString(3, poductname);
					stmt.setInt(4, quantity);
					stmt.executeUpdate();
					System.out.println("Record is inserted.");
					PreparedStatement stmt1 = con
							.prepareStatement("update product set productquantity=? where productId=?");
					stmt1.setInt(1, qty);
					stmt1.setInt(2, productId);
					stmt1.executeUpdate();
					System.out.println("product table updated");
					System.out.println("-------------------------------------------------------");
					stmt.close();
					con.close();
     				} else {
    					System.out.println("Invalid Input");     					
     				}
			}
		} catch (Exception e) {
			e.getMessage();

		}
	}
}
