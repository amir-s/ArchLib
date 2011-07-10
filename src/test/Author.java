package test;

public class Author {
	private int id;
	private String name;
	private String website;
	private String email;
	
	public Author(int id, String name, String website, String email) {
		this.id = id;
		this.name = new String(name);
		this.website = new String(website);
		this.email = new String(email);
	}
	
	public Author() {}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = new String(name);
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = new String(email);
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = new String(website);
	}
}