package fkl.servlet;

import fkl.dao.FklDaoImp;
import fkl.vo.Fkl;

import java.io.IOException;
import java.util.List;

public class FklServlet {
	public List<Fkl> getFklList() throws IOException {
		return new FklDaoImp().getFklList();
	}
}
