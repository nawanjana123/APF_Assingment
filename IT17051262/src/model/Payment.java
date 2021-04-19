package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {
	
	private Connection connect() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/payment?serverTimezone=UTC", "root", "");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
		
		return con;
	}
	
	public String insertPayment(int userID, int projectID, String amount, String method) {
		
		String output="";
		
		try {
			Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for inserting."; 
			 }	 
			 
			 String query = "insert into payments(`userID`,`projectID`,`amount`,`method`) values (?,?,?,?)";
			 
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 preparedStmt.setInt(1, userID);
			 preparedStmt.setInt(2, projectID);
			 preparedStmt.setDouble(3, Double.parseDouble(amount));
			 preparedStmt.setString(4, method);
		
			 preparedStmt.execute();
			 
			 con.close();
			 
			 
			 output = "Inserted successfully";
	
		}catch (Exception e){
			 
			output = "Error while inserting the payments.";
			System.err.println(e.getMessage());
			System.out.println(e);
		}
			 
		return output;
	}
	
	public String readPayment() {
		
		String output = "";
		
		try{
			
			Connection con = connect();
		 
			if (con == null){
				return "Error while connecting to the database for reading.";
			}
			
			output = "<table border='1'>"
					+ "<tr>"
						+ "<th>Payment ID</th>"
						+ "<th>UserID</th>" 
						+ "<th>ProjectID</th>" 
						+ "<th>Amount</th>"
						+ "<th>Method</th>" 
						+ "<th>Update</th>"
						+ "<th>Remove</th>"
					+ "</tr>";

			String query = "select * from payments";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
		
			while (rs.next()){
			 
				String paymentID = Integer.toString(rs.getInt("paymentID"));
				String userID = Integer.toString(rs.getInt("userID"));
				String projectID = Integer.toString(rs.getInt("projectID"));
				String amount = Double.toString(rs.getDouble("amount"));
				String method = rs.getString("method");
				
				output += "<tr><td>" + paymentID + "</td>";
				output += "<td>" + userID + "</td>";
				output += "<td>" + projectID + "</td>";
				output += "<td>" + amount + "</td>";
				output += "<td>" + method + "</td>";
				
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><form method='post' action='payment.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='paymentID' type='hidden' value='"+paymentID+"'>" 
						+ "</form></td></tr>";
			 }
			 con.close();
			 
			 output += "</table>";
			 
		 }catch (Exception e){
		
			 output = "Error while reading the payments.";
			 System.err.println(e.getMessage());
		 }
		 
		return output;
	
	} 
	
	
	public String updatePayment(int paymentID,int userID, int projectID, String amount, String method) {
		
		String output = "";
		
		try{
		 
			Connection con = connect();
		 
			if (con == null){
				return "Error while connecting to the database for updating."; 
			}
		 
			String query = "UPDATE payments SET userID=?,projectID=?,amount=?,method=? WHERE paymentID=?";
			 
			PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			preparedStmt.setInt(1, userID);
			preparedStmt.setInt(2, projectID);
			preparedStmt.setDouble(3, Double.parseDouble(amount));
			preparedStmt.setString(4, method);
			preparedStmt.setInt(5, paymentID);
		 
			preparedStmt.execute();
		 
			con.close();
			output = "Updated successfully";
		 
		}catch (Exception e){
		 
			output = "Error while updating the payment.";
			System.err.println(e.getMessage());
		 
		}
		 
		return output;
	}
	
	
	public String deletePayment(String paymentID){
	 
		String output = "";
	 
		try{
	 
			Connection con = connect();
	 
			if (con == null){
				return "Error while connecting to the database for deleting.";
			}
	 
			String query = "delete from payments where paymentID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, Integer.parseInt(paymentID));
			preparedStmt.execute();
			con.close();
	 
			output = "Deleted successfully";
		}catch (Exception e){
	 
			output = "Error while deleting the payment.";
			System.err.println(e.getMessage());
		}
	 
		return output;
	 
	} 

}
