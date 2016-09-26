package zttc.itat.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import zttc.itat.model.SystemContext;

/*
 * javax.servlet.Filter, a filter stands before a servlet. 
 */
public class SystemContextFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req,
			             ServletResponse resp,
			             FilterChain chain) throws IOException, ServletException {
		int offset = 0;

		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (NumberFormatException e) {
		}

		try {
			SystemContext.setOffset(offset);
			SystemContext.setSize(15);
			/* pass the request to the next filter in the filter chain. 
			*if no filter in the chain, to the servlet the request if for.
			*/
			chain.doFilter(req, resp);
		}finally {// remove, so next request can have a different value.
			SystemContext.removeOffset();
			SystemContext.removeSize();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
