//package mySQLconnection;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class MySQLconnectionDemo {
//
//	public static void main(String[] args) {
//		
//		String sqlSelectAllPersons = "SELECT * FROM customers c WHERE contactFirstName LIKE 'da%'";
//		String connectionUrl = "jdbc:mysql://boratech.cxz8zslametr.us-east-1.rds.amazonaws.com:3306/classicmodels";
//
//		try (
////				Connection conn = DriverManager.getConnection(connectionUrl, "students", "bora123456");
//////				PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
//////				ResultSet rs = ps.executeQuery()) {
////				Statement s =conn.createStatement();
////				ResultSet rs = s.executeQuery(sqlSelectAllPersons)){
//
//			while (rs.next()) {
//				String firstname = rs.getString("contactFirstName");
//				String lastName = rs.getString("contactLastName");
//				System.out.println(firstname + " " + lastName);
//				// do something with the extracted data...
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
