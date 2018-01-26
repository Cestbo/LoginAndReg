

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String surepassword=request.getParameter("surepassword");
		String email=request.getParameter("email");
		List<String> errors=new ArrayList<String>(); 
		if(isValidEmail(email))
		{
			errors.add("无效的邮箱号");
		}
		if(isValidPassword(password, surepassword))
		{
			errors.add("密码为空或不一致");
		}
		if(isValidUsername(username))
		{
			errors.add("用户名存在或为空");
		}
		if(errors.isEmpty())
		{
			User user=User.getInstance();
			Map<String, String> map=user.getMap();
			map.put(username, password+"##"+email);
			request.getRequestDispatcher("Regsuccess.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("Regfail.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public boolean isValidUsername(String username)
	{
		User user=User.getInstance();
		Map<String, String> userMap=user.getMap();
		if(username==null || username.equals(""))
			return true;
		else{
			if(userMap.get(username)!=null && !userMap.get(username).equals(""))
				return true;
		}
		return false;
	}

	public boolean isValidPassword(String password,String surepassword)
	{
		if(password==null || password.equals(""))
			return true;
		else
		{
			if(!password.equals(surepassword))
				return true;
		}
		return false;
	}
	
	public boolean isValidEmail(String email)
	{
		if(email!=null && !email.equals(""))
		{
			return !email.matches("^[\\w-]+@[\\w-]+\\.[\\w-]+$");
		}
		return true;
	}
}
