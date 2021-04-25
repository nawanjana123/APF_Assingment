package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class researchermanagementModel {
	
	private int researcherID;
	private String name;
	private String age;
	private String address;
	private String email;
	private String researchID;
	private String researchname;
	
	
	public researchermanagementModel() {
		super();
	}

	public researchermanagementModel(int researcherID, String name, String age, String address, String email, String researchID, String researchname) {
		super();
		this.researcherID = researcherID;
		this.name = name;
		this.age = age;
		this.address = address;
		this.email = email;
		this.researchID = researchID;
		this.researchname = researchname;
		
	}
	
	public int getResearcherID() {
		return researcherID;
	}

	public void setResearcherID(int researcherID) {
		this.researcherID = researcherID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getResearchID() {
		return researchID;
	}

	public void setResearchID(String researchID) {
		this.researchID = researchID;
	}
	
	public String getResearchname() {
		return researchname;
	}

	public void setResearchname(String researchname) {
		this.researchname = researchname;
	}
	
	@Override
	public String toString() {
		return "researchermanagementModel [researcherID=" + researcherID + ", name=" + name + ", age=" + age + ", address=" + address + ", email=" + email + ", researchID=" + researchID + ", researchname=" + researchname +
				"]";
	}

}
