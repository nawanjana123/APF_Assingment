package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Funder {
	
	//A common method to connect to the DB
			public Connection connect()
			 {
			 Connection con = null;
			 try
			 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 //Provide the correct details: DBServer/DBName, username, password
			 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/funder?serverTimezone=UTC", "root", "");
			 
			//For testing
			 System.out.print("Successfully connected"); 
			 
			 }
			 catch (Exception e)
			 {e.printStackTrace();}
			 return con;
			 }
			
			//insert to database
			public String insertItem(String funderName, String funderNIC, String funderAddress, String funderEmail, String funderPhone)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for inserting."; }
			 // create a prepared statement
			 String query = " insert into fundertable(`funderID`,`funderName`,`funderNIC`,`funderAddress`,`funderEmail`,`funderPhone`)"
			 + " values (?, ?, ?, ?, ?, ?)";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, 0);
			 preparedStmt.setString(2, funderName);
			 preparedStmt.setString(3, funderNIC);
			 preparedStmt.setString(4, funderAddress);
			 preparedStmt.setString(5, funderEmail);
			 preparedStmt.setString(6, funderPhone);
			
			 
			// execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Inserted successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while inserting the item.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }
			
			
			
			
			public String readItems()
			 {
			 String output = "";
			 try
			 {
				 
			 Connection con = connect();
			 
			 if (con == null)
			 {
			 return "Error while connecting to the database for readingggg."; }
			 // Prepare the html table to be displayed
			 output = "<table border=\"1\"><tr><th>funderID</th><th> funderName </th><th> funderNIC </th><th> funderAddress </th><th> funderEmail </th><th> funderPhone </th><th>Update</th><th>Remove</th></tr>";
			 String query = "select * from fundertable";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 // iterate through the rows in the result set
			 while (rs.next())
			 {
				 String funderID = Integer.toString(rs.getInt("funderID"));
				 String funderName = rs.getString("funderName");
				 String funderNIC = rs.getString("funderNIC");
				 String funderAddress = rs.getString("funderAddress");		
				 String funderEmail = rs.getString("funderEmail");
				 String funderPhone = rs.getString("funderPhone");
				
			 // Add into the html table
				 output += "<tr><td>" + funderID + "</td>";
				 output += "<td>" + funderName + "</td>";
				 output += "<td>" + funderNIC + "</td>";
				 output += "<td>" + funderAddress + "</td>";
				 output += "<td>" + funderEmail + "</td>";
				 output += "<td>" + funderPhone + "</td>";
				 
			 // buttons
			 output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"+ "<td><form method=\"post\" action=\"items.jsp\">" + "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
			 + "<input name=\"funderID\" type=\"hidden\" value=\"" + funderID
			 + "\">" + "</form></td></tr>";
			 }
			 con.close();
			 // Complete the html table
			 output += "</table>";
			 }
			 catch (Exception e)
			 {
			 output = "Error while reading the items.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 } 
			
			

			public String updateItem(String funderID, String funderName, String funderNIC, String funderAddress, String funderEmail, String funderPhone)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for updating."; }
			 // create a prepared statement
			 String query = "UPDATE fundertable SET funderName=?,funderNIC=?,funderAddress=?,funderEmail=?,funderPhone=?WHERE funderID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setString(1, funderName);
			 preparedStmt.setString(2, funderNIC);
			 preparedStmt.setString(3, funderAddress);
			 preparedStmt.setString(4, funderEmail);
			 preparedStmt.setString(5, funderPhone);
			 preparedStmt.setInt(6,Integer.parseInt(funderID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Updated successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while updating the item.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }
			
			public String deleteItem(String funderID)
			 {
			 String output = "";
			 try
			 {
			 Connection con = connect();
			 if (con == null)
			 {return "Error while connecting to the database for deleting."; }
			 // create a prepared statement
			 String query = "delete from fundertable where funderID=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(funderID));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 output = "Deleted successfully";
			 }
			 catch (Exception e)
			 {
			 output = "Error while deleting the item.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 } 


			
			
			
			
			
			

}
