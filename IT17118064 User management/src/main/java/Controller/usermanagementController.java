package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.usermanagementModel;
import DBConnector.Connector;

public class usermanagementController {
	
	Connector con = Connector.getInstance();

	private usermanagementController() {
	}

	private static final usermanagementController obj = new usermanagementController();

	public static usermanagementController getInstance() {
		return obj;
	}

	public void save(usermanagementModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO user(userID,name,age,address,phone,email) VALUES ('" + obj.getUserID() + "', '"+ obj.getName() + "', '" + obj.getAge() + "', '" + obj.getAddress() + "', '" + obj.getPhone() + "', '" + obj.getEmail() + "')");
	}

	public void update(usermanagementModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE user SET name = '" + obj.getName() + "', age = '" + obj.getAge() + "', address = '" + obj.getAddress() + "', phone = '" + obj.getPhone() + "', email = '" + obj.getEmail() + "'" + "WHERE userID='"
				+ obj.getUserID() + "'");
	}

	public void delete(usermanagementModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM user WHERE userID ='" + obj.getUserID() + "'");
	}

	public List<usermanagementModel> searchAll() throws Exception {
		List<usermanagementModel> list = new ArrayList<usermanagementModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM user");
		while (rset.next()) {
			usermanagementModel obj = new usermanagementModel();
			obj.setUserID(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAge(rset.getString(3));
			obj.setAddress(rset.getString(4));
			obj.setPhone(rset.getString(5));
			obj.setEmail(rset.getString(6));

			list.add(obj);
		}
		return list;
	}

	public usermanagementModel search(int userID) throws Exception {
		con.getConnection();
		usermanagementModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM user WHERE userID='" + userID + "'");
		while (rset.next()) {
			obj.setUserID(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAge(rset.getString(3));
			obj.setAddress(rset.getString(4));
			obj.setPhone(rset.getString(5));
			obj.setEmail(rset.getString(6));

		}
		return obj;
	}


}
