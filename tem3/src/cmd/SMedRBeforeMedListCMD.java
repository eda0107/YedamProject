
package cmd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import kcrDAO.HosInfoDAO;
import kcrDAO.MediRqstDAO;
import lastdto.hosMemberDTO;
import lastdto.mediRqstDTO;

public class SMedRBeforeMedListCMD implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //S22 진료신청현황 리스트(예약) 페이지
		
		// String id = request.getParameter("id"); 
		//로그인중인 아이디를 받아오도록// 나중에 세션으로 변경
		String id = "sic1"; //가상의 파라미터
		String type = "res";
		
		//두 테이블을 조인하고, list는 dto별로 각각 받아오기.
		MediRqstDAO dao = new MediRqstDAO();
		List<mediRqstDTO> listRq = new ArrayList<>(); 
		listRq = dao.selectAll(id, type);
		
		
		HosInfoDAO dao2 = new HosInfoDAO();
		List<hosMemberDTO> listHos = new ArrayList<>();
		listHos = dao2.selectAll(id, type);
		
		System.out.println(listRq+"//"+listHos);
		
		if(listRq == null && listHos == null) {
			String isNull = "내역이 존재하지 않습니다.";
			request.setAttribute("isNull", isNull); 
			System.out.println(isNull);
		} else {
			request.setAttribute("list1", listRq);
			request.setAttribute("list2", listHos);
			request.setAttribute("id", id); 
		}
			
		
		
		
		String path ="aView/chorong/med_RbeforeMedList.jsp";
		
		return path;
	}

}
