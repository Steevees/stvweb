package webpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet(name = "EmailServlet", urlPatterns = {"/EmailServlet"})

public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s=request.getParameter("cmnt");
		PrintWriter pw=response.getWriter();
		String u=request.getParameter("userid");
		String e=request.getParameter("email");
		
		System.out.println(s);
		System.out.println(u);
		System.out.println(e);
		
		System.out.println("reached1");
	
		

	        String from = "Email : "+e;
	        String to = "steeveissacsaju@gmail.com";
	        String subject = u;
	        String message = "Comment : "+s+"\n"+from;
	        final String login = "messengerkurosaki@gmail.com";
	        final String password = "webprofile";

	    
	        

	    
	            Properties props = new Properties();            
	            props.setProperty("mail.smtp.host", "smtp.gmail.com");
	            props.setProperty("mail.smtp.port", "587");
	            props.setProperty("mail.smtp.auth", "true");
	            props.setProperty("mail.smtp.starttls.enable", "true");
	            
	            System.out.println("reached2");
	            
	        //    Authenticator auth = new SMTPAuthenticator(login, password);
	            

	           // Session session = Session.getInstance(props, auth);
	            
	            Session session = Session.getInstance(props,new javax.mail.Authenticator()
	            {
	          	  protected PasswordAuthentication getPasswordAuthentication() 
	          	  {
	          	 	 return new PasswordAuthentication(login,password);
	          	  }
	           });
	            System.out.println("reached3");
	            
	            MimeMessage msg = new MimeMessage(session);
	
	            try {
					msg.setText(message);
					
					msg.setSubject(subject);
			        msg.setFrom(new InternetAddress(login));
			        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			        Transport.send(msg);
			        System.out.println("reached4,Mail Sent");
			        response.setContentType("text/plain");
		          response.setCharacterEncoding("ISO-8859-1"); 
		            response.getWriter().write("Thanks For The Comment"); 
		          //  pw.write("Thanks For The Comment");
					
					
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	          

	           
	            
	           
	          

	}
	
    private class SMTPAuthenticator extends Authenticator {

        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password) {
            authentication = new PasswordAuthentication(login, password);
            System.out.println("reached4mid");
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }

	
	

}
