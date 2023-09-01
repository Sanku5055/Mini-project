package com.velocity.ajay.online.shopping.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("resource")
public class GetDetails {

	public void getProductDetails() throws SQLException {

		System.out.println("Enter the product id>>");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		System.out.println("Enter the product name>>");
		String name = scanner.next();
		System.out.println("Enter the product description>>");
		String description = scanner.next();
		System.out.println("Enter the product price>>");
		float price = scanner.nextFloat();
		Product product = new Product();
		product.setProductId(id);
		product.setProductName(name);
		product.setProductDescription(description);
		product.setProductPrice(price);
		getAddProductIntoMYSQL(product);

	}

	private void getAddProductIntoMYSQL(Product product) throws SQLException {

		CommanMethodJDBC commanMethodJDBC = new CommanMethodJDBC();
		Connection connection = commanMethodJDBC.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"insert into product(productid,productname,productdescription,productprice)values(?,?,?,?)");
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getProductDescription());
			preparedStatement.setFloat(4, product.getProductPrice());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();
		}
	}

	public static void main(String[] args) {

		System.out.println("Enter how many product add here>>");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		GetDetails details = new GetDetails();
		for (int i = 1; i <= number; i++) {
			try {
				details.getProductDetails();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
