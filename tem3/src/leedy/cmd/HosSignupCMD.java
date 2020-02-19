package leedy.cmd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import lastdto.hosMemberDTO;
import lastdto.searchDTO;
import leedy.hosSignupDAO;

public class HosSignupCMD implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = "";
			
		List<searchDTO> list = new ArrayList<>();
		hosMemberDTO hdto = new hosMemberDTO();
		hosSignupDAO dao = new hosSignupDAO();

		int i;
		String[] code = request.getParameterValues("code");

		for (i = 0; i < code.length; i++) {
			searchDTO dto = new searchDTO();
			dto.setHosId(request.getParameter("hos_id"));
			dto.setCode(code[i]);
			list.add(dto);
		}
		for (i = 0; i < list.size(); i++) {
			searchDTO dto = new searchDTO();
			dto = list.get(i);
			System.out.println(i + "번째 searchDTO는 " + dto.toString());
		}

		// 파라미터 받아오기?
		hdto.setHosId(request.getParameter("hos_id"));
		hdto.setHosBizno(request.getParameter("how_bizno"));
		hdto.setHosName(request.getParameter("hos_name"));
		hdto.setHosPhone(request.getParameter("hos_phone"));
		hdto.setHosPw(request.getParameter("hos_pw"));
		hdto.setHosAddr(request.getParameter("hos_addr"));
		hdto.setHosBizTime(request.getParameter("biz_time"));
		System.out.println(hdto.toString());

		int r = dao.hosInsert(hdto);
		int n = dao.searchInsert(list);

		return path;
	}
}