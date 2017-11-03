package user;

public class Student extends User {
	private String banji;
	private String courses;

	Student() {
		super();
	}

	Student(String ID, String name, String password, String pwdHint, String role, String banji, String courses) {
		super(ID, name, password, pwdHint, role);
		this.banji = banji;
		this.courses = courses;
	}

	public String getBanji() {
		return banji;
	}

	public void setBanji(String banji) {
		this.banji = banji;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}
}
