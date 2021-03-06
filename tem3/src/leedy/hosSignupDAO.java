package leedy;

import java.sql.SQLException;
import java.util.List;

import kty.DAO;
import lastdto.hosMemberDTO;
import lastdto.searchDTO;

public class hosSignupDAO extends DAO {

	public hosSignupDAO() {
		super();
	}

	public int hosInsert(hosMemberDTO dto) {
		int n = 0;

		String sql = "insert into hos_member"
				+ "(hos_id, hos_bizno, hos_name, hos_phone, hos_pw, hos_addr, biz_time "
				+ " ) values(?, ?, ?, ?, ?, ?, ?)";

		try {
			// 병원회원정보 테이블 값 넣기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getHosId());
			pstmt.setString(2, dto.getHosBizno());
			pstmt.setString(3, dto.getHosName());
			pstmt.setString(4, dto.getHosPhone());
			pstmt.setString(5, dto.getHosPw());
			pstmt.setString(6, dto.getHosAddr());
			pstmt.setString(7, dto.getHosBizTime());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
		}

		return n;
	}

	public int searchInsert(List<searchDTO> list) {
		int n = 0;
		int i;
		String sql = "insert into search(sech_no, hos_id, code)"+
		" values(sech_seq.nextval,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			
			// 서치코드 값넣기
			for(i=0; i<list.size(); i++ ) {
				searchDTO dto = new searchDTO();
				dto = list.get(i);
				   
				pstmt.setString(1, dto.getHosId());
				pstmt.setString(2, dto.getCode());
				pstmt.executeUpdate();    
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}
	
	
	//id 중복체크
	public boolean isIdChk(String id) {
		
		boolean b = true;
		String sql = "select hos_id from hos_member where hos_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b=false;
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return b;
		
	}
	
	//사업자번호 중복체크
	public boolean isBizChk(String biz) {
		
	boolean b = true;
	String sql = "select hos_bizno from hos_member where hos_bizno=?";
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, biz);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			b=false;
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close();
	}

	return b;
	}

}
