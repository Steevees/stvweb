package webpack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class comment
 */
@WebServlet("/comment")
public class webcmt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public webcmt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//File f1=new File("D:/demo/eclipseworkspace/openpro1/WebContent/cmt.xml");

		//boolean b=f1.createNewFile();
		//System.out.println(new File("cmt.txt").getAbsolutePath());
		//System.out.println(b);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("fdf");
		String s=request.getParameter("cmnt");
		PrintWriter pw=response.getWriter();
		String u=request.getParameter("userid");
		
		pw.write("Thanks For Comment");
		
		try {
		
		//System.out.println("fdf");
		FileWriter fr=new FileWriter("cmt.txt",true);
		 BufferedWriter bw=new BufferedWriter(fr);
		 bw.append("<br>");
		 bw.write("<div class='alert alert-warning'>"+s+"<br>");
			bw.write("By : "+u);
			bw.write("</div>");
		
		bw.flush();
		bw.close();
		fr.close();
		}
		finally {
		
			
		}
		
		
		
	}

}
