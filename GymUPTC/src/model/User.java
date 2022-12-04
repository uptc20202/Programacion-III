package model;

public class User {
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", rol=" + rol + ", student=" + student + "]";
	}

	private String id;
	private String password;
	private Rol rol;
	private boolean allowBooking;
	private Student student;
	
	public User(String id, String password, String rol1, Student student) {
		super();
		this.id = id;
		this.password = password;
		this.rol = Rol.valueOf(rol1);
		this.allowBooking = true;
		this.student = student;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Rol getRol() {
		return rol;
	}

	public Student getStudent() {
		return student;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isAllowBooking() {
		return allowBooking;
	}

	public void setAllowBooking(boolean allowBooking) {
		this.allowBooking = allowBooking;
	}
	
	
	
	

}
