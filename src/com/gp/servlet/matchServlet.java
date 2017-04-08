package com.gp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gp.bean.gamematchBean;
import com.gp.service.matchService;
/**
 * Servlet implementation class matchServlet
 */
@WebServlet("/matchServlet")
public class matchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public matchServlet() {
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (null==request.getParameter("oper")) {
			List<gamematchBean> list = matchService.getInstance().getMatchs("");
			request.setAttribute("list", list);
			request.getRequestDispatcher("matchList.jsp").forward(request, response);
		}else if (request.getParameter("oper").equals("detail")){
			int matchID =Integer.parseInt(request.getParameter("matchID"));
			gamematchBean gamematch = matchService.getInstance().getOnematch(matchID);
			request.setAttribute("gamematch", gamematch);
			request.getRequestDispatcher("matchList.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
