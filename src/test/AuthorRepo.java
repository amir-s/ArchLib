package test;
import java.sql.*;
import java.util.*;



public class AuthorRepo {
	
	private static AuthorRepo instance = new AuthorRepo();
	
	public static AuthorRepo getRepo() {
		return instance;
	}
	
	public Vector<Author> getAll() throws SQLException {
		Vector<Author> res = new Vector<Author>();
		Connection con = DBConn.get();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM authors");
		while (rs.next()) {
			res.add(new Author(rs.getInt("id"), rs.getString("name"), rs.getString("website"), rs.getString("email")));
		}
		return res;
	}

	public void insert(Author auth) throws SQLException {
		Connection con = DBConn.get();
		PreparedStatement ps = con.prepareStatement("INSERT INTO authors VALUES (NULL, ?, ?, ?)");
		ps.setString(1, auth.getName());
		ps.setString(2, auth.getEmail());
		ps.setString(3, auth.getWebsite());
		ps.execute();
	}
	
	public Author getByID (int ID) throws SQLException {
		Connection con = DBConn.get();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM authors WHERE id = ?");
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		if (!rs.next()) return null;
		return new Author(rs.getInt("id"),rs.getString("name"),rs.getString("website"),rs.getString("email"));
	}

	public void update(Author auth) throws SQLException {
		Connection con = DBConn.get();
		PreparedStatement ps = con.prepareStatement("REPLACE INTO authors VALUES (?, ?, ?, ?)");
		ps.setInt(1, auth.getID());
		ps.setString(2, auth.getName());
		ps.setString(3, auth.getEmail());
		ps.setString(4, auth.getWebsite());
		ps.execute();
	}

	public void deleteByID(int ID) throws SQLException {
		Connection con = DBConn.get();
		PreparedStatement ps = con.prepareStatement("DELETE FROM authors WHERE id = ?");
		ps.setInt(1, ID);
		ps.execute();
	}
	
	
	
}