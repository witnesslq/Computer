package fkl.action;

import fkl.servlet.FklServlet;
import fkl.vo.Fkl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FklAction extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		FklServlet servlet = new FklServlet();
		List<Fkl> list = servlet.getFklList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("jsp/fkl/index.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		doPost(request, response);
	}
}
