package test;
import java.sql.*;
import java.util.*;



public class BookRepo {
	
	private static BookRepo instance = new BookRepo();
	
	public static BookRepo getRepo() {
		return instance;
	}
	
	public Vector<Book> getAll() throws SQLException {
		Vector<Book> res = new Vector<Book>();
		Connection con = DBConn.get();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM books");
		while (rs.next()) {
			res.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("isbn"), rs.getInt("year"), rs.getString("publisher"), rs.getInt("author_id"), rs.getString("filename")));
		}
		return res;
	}

	public void insert(Book book) throws SQLException {
		Connection con = DBConn.get();
		PreparedStatement ps = con.prepareStatement("INSERT INTO books VALUES (NULL, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, book.getTitle());
		ps.setInt(2, book.getAuthor_id());
		ps.setString(3, book.getIsbn());
		ps.setInt(4, book.getYear());
		ps.setString(5, book.getPublisher());
		ps.setString(6, book.getFileName());
		ps.execute();
	}
	
	public Book getByID (int ID) throws SQLException {
		Connection con = DBConn.get();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE id = ?");
		ps.setInt(1, ID);
		ResultSet rs = ps.executeQuery();
		if (!rs.next()) return null;
		return new Book(rs.getInt("id"),rs.getString("title"),rs.getString("isbn"),rs.getInt("year"),rs.getString("publisher"),rs.getInt("author_id"),rs.getString("filename"));
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