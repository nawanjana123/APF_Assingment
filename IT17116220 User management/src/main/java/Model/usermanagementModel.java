package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class usermanagementModel {
	
	private int userID;
	private String name;
	private String age;
	private String address;
	private String phone;
	private String email;
	
	public usermanagementModel() {
		super();
	}

	public usermanagementModel(int userID, String name, String age, String address,String phone, String email) {
		super();
		this.userID = userID;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.email = email;
		
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	@Override
	public String toString() {
		return "usermanagementModel [userID=" + userID + ", name=" + name + ", age=" + age + ", address=" + address +  ", phone=" + phone + ", email=" + email +
				"]";
	}
}
