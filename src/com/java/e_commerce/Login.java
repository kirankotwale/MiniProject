package com.java.e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

	public static void getUserDetails() throws SQLException, ClassNotFoundException {
		System.out.println("*******Welcome To Online Shopping ....please Login Here..********");
		Scanner sc = new Scanner(System.in);
		// System.out.println();
		System.out.println("Enter the Customer UserName");
		String userName = sc.next();
		System.out.println("Enter the Customer Password");
		String password = sc.next();
		System.out.println("Enter the mailId..");
		String mailId = sc.next();
		User user = new User(userName, password, mailId);

		user.setUserName(userName);
		user.setPassword(password);
		user.setMailId(mailId);
		System.out.println("Customer UserName >>" + user.getUserName());
		System.out.println("Customer Passwod >>" + user.getPassword());
		System.out.println("Customer mailId >>" + user.getMailId());
		System.out.println("Login Successfully...!!");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
		PreparedStatement stmt = con.prepareStatement("insert into user(userName,password,mailId)values(?,?,?)");

		stmt.setString(1, userName);
		stmt.setString(2, password);
		stmt.setString(3, mailId);
		System.out.println("User Details Inserted successfully..!!");
		int i = stmt.executeUpdate();
		System.out.println("--------------------------------------");
		con.close();
		stmt.close();

	}

	public static void getLoginDetails() throws ClassNotFoundException, SQLException {
		String s = "select * from ecommerce.user";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
		Statement statement = con.createStatement();
		// statement.execute(sql);
		ResultSet rs = statement.executeQuery(s);
		System.out.println(" **Welcome To User Login History** ");
		// iterate through the java resultset
		while (rs.next()) {

			int id = rs.getInt("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String mailId = rs.getString("mailId");
			System.out.println();
			// print the results
			System.out.format("%s, %s, %s\n", username, password, mailId);
			System.out.println("-----------------------------------");
		}
		}
	}

