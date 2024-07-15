package in.srivath.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.srivath.dao.BooksDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertBookServlet")
public class InsertBookServlet extends HttpServlet {
	
	public InsertBookServlet() {
		System.out.println("InsertBookServlet:: Constructor");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

		// capture form data
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		String bookName = req.getParameter("bookName");
		int bookPrice = Integer.parseInt(req.getParameter("bookPrice"));

		// call save method from bookDao class
		BooksDao booksDao = new BooksDao();
		boolean bool = booksDao.saveBook(bookId, bookName, bookPrice);

		// send response to client
		PrintWriter writer = res.getWriter();
		String response = "";
		if (bool) {
			response = "<h1>Record inserted.</h1>";
		} else {
			response = "<h1>Insertion failed!</h1>";
		}
		writer.append(response);
	}
}
