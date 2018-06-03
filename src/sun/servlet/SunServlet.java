package sun.servlet;

import sun.dao.SunDaoImp;
import sun.vo.SunType;

import java.io.IOException;
import java.util.List;

public class SunServlet {
	public List<SunType> getSunType() throws IOException {
		return new SunDaoImp().getSunType();
	}
}
