package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBConnector.Connector;
import Model.researchermanagementModel;


public class researchermanagementController {
	
	Connector con = Connector.getInstance();

	private researchermanagementController() {
	}

	private static final researchermanagementController obj = new researchermanagementController();

	public static researchermanagementController getInstance() {
		return obj;
	}

	public void save(researchermanagementModel obj) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO researcher(researcherID,name,age,address,email,researchID,researchname) VALUES ('" + obj.getResearcherID() + "', '"+ obj.getName() + "', '" + obj.getAge() + "', '" + obj.getAddress() + "', '" + obj.getEmail() + "', '" + obj.getResearchID() +  "', '" + obj.getResearchname() + "')");
	}

	public void update(researchermanagementModel obj) throws Exception {
		con.getConnection();
		con.aud("UPDATE researcher SET name = '" + obj.getName() + "', age = '" + obj.getAge() + "', address = '" + obj.getAddress() + "', email = '" + obj.getEmail() + "', researchID = '" + obj.getResearchID() +  "', researchname = '" + obj.getResearchname() + "'" + "WHERE researcherID='"
				+ obj.getResearcherID() + "'");
	}

	public void delete(researchermanagementModel obj) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM researcher WHERE researcherID ='" + obj.getResearcherID() + "'");
	}

	public List<researchermanagementModel> searchAll() throws Exception {
		List<researchermanagementModel> list = new ArrayList<researchermanagementModel>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM researcher");
		while (rset.next()) {
			researchermanagementModel obj = new researchermanagementModel();
			obj.setResearcherID(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAge(rset.getString(3));
			obj.setAddress(rset.getString(4));
			obj.setEmail(rset.getString(5));
			obj.setResearchID(rset.getString(6));
			obj.setResearchname(rset.getString(7));

			list.add(obj);
		}
		return list;
	}

	public researchermanagementModel search(int researcherID) throws Exception {
		con.getConnection();
		researchermanagementModel obj = null;
		ResultSet rset = con.srh("SELECT * FROM researcher WHERE researcherID='" + researcherID + "'");
		while (rset.next()) {
			obj.setResearcherID(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAge(rset.getString(3));
			obj.setAddress(rset.getString(4));
			obj.setEmail(rset.getString(5));
			obj.setResearchID(rset.getString(6));
			obj.setResearchname(rset.getString(7));

		}
		return obj;
	}


}
