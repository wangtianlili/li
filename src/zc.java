import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


public class zc extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8");  
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			 String  u=request.getParameter("user");
		        String  p=request.getParameter("pass");
		    	try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("加载成功");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("有异常");
					e.printStackTrace();
				}
				try {
					Connection con = (Connection) DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/studb", "root", "zxcvbnm");
					System.out.println("连接成功");
					Statement sta = (Statement) con.createStatement();
				String  d=request.getParameter("user");
		        String h=request.getParameter("pass");
		        int n= sta.executeUpdate("insert stuinfo values(' "+d+"', '"+h+"')");	
		        System.out.println("更新"+n+"条");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("连接异常");
					e.printStackTrace();
				}
		
	
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	  
	}

}
