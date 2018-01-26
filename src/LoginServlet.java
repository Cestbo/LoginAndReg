

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		if(checkLogin(username, password))
		{
			request.getRequestDispatcher("/MemberServlet").
			forward(request,response);
		}
		else
		{
			response.sendRedirect("Login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//验证用户登录
	boolean checkLogin(String name,String psw)
	{
		User user=User.getInstance();
		Map userMap=user.getMap();
		if(name!=null&&!name.equals("")&&psw!=null&&!psw.equals(""))
		{
			if(userMap.containsKey(name))
			{
				String s=(String)userMap.get(name);
				String a[]=s.split("##");
				if(a[0].equals(psw))
					return true;
			}
		}
			
		return false;
	}

}
