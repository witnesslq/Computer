package sal.action;

import sal.servlet.SalServlet;
import sal.vo.Sal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SalAction extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		SalServlet salServlet = new SalServlet();
		List<Sal> list = salServlet.getSalList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/sal/index.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doPost(request, response);
	}
}
