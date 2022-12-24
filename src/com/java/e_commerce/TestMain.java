package com.java.e_commerce;

import java.sql.SQLException;

public class TestMain extends Cart {
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		getUserDetails();
		getProductDetails();
		getBuyDetails();
		getCartDetails();
		getSumOfPrice();
		getLoginDetails();
	}

}
