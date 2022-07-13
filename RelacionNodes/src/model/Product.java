package model;

public class Product {
	
	private String name;
	private int code;
	private int value;
	
	public String getName() {
		return name;
	}
	public int getCode() {
		return code;
	}
	public int getValue() {
		return value;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Product(String name, int code, int value) {
		super();
		this.name = name;
		this.code = code;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", code=" + code + ", value="+"$" + value + "]";
	}
	
	
}
