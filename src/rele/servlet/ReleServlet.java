package rele.servlet;

import rele.dao.ReleDaoImp;
import rele.vo.Rele;

import java.io.IOException;
import java.util.List;

public class ReleServlet {
	public List<Rele> getReles() throws IOException {
		return new ReleDaoImp().getReles();
	}
}
