package sun.action;

import sun.servlet.SunServlet;
import sun.vo.SunType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SunAction extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		SunServlet servlet = new SunServlet();
		List<SunType> list = servlet.getSunType();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/sun/index.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doPost(request, response);
	}
}
