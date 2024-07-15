package in.srivath.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.srivath.util.ConnectionFactory;

public class BooksDao {
	private static final String insertSQL = "INSERT INTO BOOKS VALUES(?,?,?)";

	public boolean saveBook(int bookId, String bookName, int bookPrice) {
		int count = 0;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(insertSQL);
			pstmt.setInt(1, bookId);
			pstmt.setString(2, bookName);
			pstmt.setInt(3, bookPrice);
			count = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count > 0;
	}
}
