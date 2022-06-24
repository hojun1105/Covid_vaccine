package vaccineProgram;

public class Client {
	private int num;
	private String id;
	private String pw;
	private int age;
	private String gender;
	private String phone;
	private String part;
	
	
	public Client() {}
	
	public Client(int num, String id, String pw) {
		this.num = num;
		this.id = id;
		this.pw = pw;
	}

	public Client(int num) {
		this.num = num ;
	}

	public Client(int num, String id, String pw, int age, String gender, String phone) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPart() {
		return part;
	}
	
	public void setPart(String part) {
		this.part = part;
	}
	
	

	@Override
	public String toString() {
		return "Client [num=" + num + ", id=" + id + ", pw=" + pw + ", age=" + age + ", gender=" + gender
				+ ", phone=" + phone + "]";
	}
	
	
	
	

}
