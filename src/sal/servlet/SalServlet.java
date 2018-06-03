package sal.servlet;

import sal.dao.SalDaoImp;
import sal.vo.Sal;

import java.io.IOException;
import java.util.List;

public class SalServlet {
	public List<Sal> getSalList() throws IOException {
		return new SalDaoImp().getSalList();
	}
}
