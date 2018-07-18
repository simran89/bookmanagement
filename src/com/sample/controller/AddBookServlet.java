
package com.sample.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samle.biz.Book;
import com.samle.biz.Business;

@WebServlet(description = "This is simple Servlet", urlPatterns = { "/AddBook" })
public class AddBookServlet extends HttpServlet{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doMethod(HttpServletRequest req, HttpServletResponse res) throws Exception
	{


		try{
	
		
			Book book = new Book();
		
		String action =req.getParameter("action");
		String bookId = req.getParameter("BookID");
		int bookid = Integer.parseInt(bookId); 
	
	
		
		String booktitle =req.getParameter("BookTitle");
		book.setBookid(bookid);
		booktitle ="JavaEE";
		book.setBooktitle(booktitle);
		String jsonResponse = null;
		System.out.println(booktitle);
//		if(booktitle.equalsIgnoreCase("JavaEE"))
//		{
////			jsonResponse = "{" + "\"result\":\"success\""+"}";
//
//			jsonResponse = "Success";
////			res.setContentType("application/json");
//			
//			
//
//	        PrintWriter pw = res.getWriter();
//
//	        pw.print(jsonResponse);
//	 
//	        boolean error = pw.checkError();
//	        System.out.println("Error? " + error); 
//	        pw.close();
//			System.out.println(jsonResponse);
//		}
//		else
//		{
//			PrintWriter pw = res.getWriter();
//			jsonResponse ="failures";
//	        pw.print(jsonResponse);
//	 
//	        boolean error = pw.checkError();
//	        System.out.println("Error? " + error); 
//	        pw.close();
//			System.out.println(jsonResponse);
//		}
//	
		System.out.println(book.getBooktitle());
//		
		String invoiceNumber = req.getParameter("InvoiceNo");
		int invoiceNo =Integer.parseInt(invoiceNumber) ;
		book.setInvoiceNo(invoiceNo);
		String authorname =req.getParameter("AuthorName");
		book.setAuthorname(authorname);
//		
		String publisher= req.getParameter("publisher");
		book.setPublisher(publisher);
//		
		String edition  =req.getParameter("Edition");
		book.setEdition(edition);
//		
		String date =req.getParameter("invoiceDate");
		DateFormat df = new SimpleDateFormat("yyyy-MM-DD");

		
		  java.util.Date utilDate = df.parse(date);
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		book.setInvoicedate(sqlDate);
//		
//	
//		
		String costValue =req.getParameter("cost");
		double cost = Double.parseDouble(costValue);
		book.setCost(cost);
		
		System.out.println(jsonResponse);
	
		Business b = new Business();
		b.doADDBooks(book);
		
		if(action.equalsIgnoreCase("Add Book"))
		{
		RequestDispatcher dispatcher = req.getRequestDispatcher("/DiaplayBooks.jsp");
		dispatcher.forward( req, res);
		
		
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		
		
		
		
	}

	
	public void doPost( HttpServletRequest req, HttpServletResponse res)
	{
		try {
			doMethod(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doGet( HttpServletRequest req, HttpServletResponse res)
	{
		try {
			doMethod(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
