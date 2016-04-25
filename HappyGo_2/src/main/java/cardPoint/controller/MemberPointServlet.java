package cardPoint.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

import model.CustomerBean;
import model.CustomerService;

import org.hibernate.Session;

import AAA000.DayDevice;
import cardPoint.model.CardPointBean;
import cardPoint.model.CardPointService;

/**
 * Servlet implementation class MemberPointServlet
 */
@WebServlet("/cardPoint/MemberPoint.do")
public class MemberPointServlet extends HttpServlet {
	   
    public MemberPointServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//String memberId = (String) session.getAttribute("memberId");
		//String memberId = "mb01";
		String memberId = request.getParameter("memberId");
		
		Map<String ,String>errorMap = new HashMap<String, String>();
		if(memberId==null || memberId.trim().length()==0 || memberId.trim().equals("輸入會員帳號")){
			errorMap.put("errorEmpty", "會員帳號必須輸入");
		}
		if(!errorMap.isEmpty()){
			request.setAttribute("error", errorMap);
			RequestDispatcher rd = request.getRequestDispatcher("/cardPoint/cardPoint_list.jsp");
			rd.forward(request, response);
			return;
		}
		
		CustomerService custServ = new CustomerService();
		CustomerBean memberBean = custServ.login(memberId);
		if(memberBean==null){
			errorMap.put("errorIdEmpty", "查無此會員");
			request.setAttribute("error", errorMap);
			RequestDispatcher rd = request.getRequestDispatcher("/cardPoint/cardPoint_list.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		List<CardPointBean> pointList = new ArrayList<CardPointBean>();
		CardPointService pointService = new CardPointService();
		DayDevice dayDevice = new DayDevice();
		pointList = pointService.unUsePoint(memberId);
		if(pointList.size()==0){
			request.setAttribute("memberId", memberId);
			//request.setAttribute("point", pointList);
			request.setAttribute("totalPoint", 0);
			RequestDispatcher rd = request.getRequestDispatcher("/cardPoint/cardPoint_list.jsp");
			rd.forward(request, response);
			return;
		}
		
		int i=0;
		for(CardPointBean pointBean : pointList){
			pointList.get(i).setdDate(dayDevice.parse_DBtoWeb(pointBean.getdDate()));
			pointList.get(i).setTranDate(dayDevice.parse_DBtoWeb(pointBean.getTranDate()));
			i++;
		}
		request.setAttribute("memberId", memberId);
		request.setAttribute("point", pointList);
		request.setAttribute("totalPoint", pointService.totalPoint(memberId));
		
		CardPointBean lastPointBean = pointService.LastPoint(memberId);
		lastPointBean.setdDate(dayDevice.parse_DBtoWeb(lastPointBean.getdDate()));
		request.setAttribute("LastPoint", lastPointBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("/cardPoint/cardPoint_list.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
