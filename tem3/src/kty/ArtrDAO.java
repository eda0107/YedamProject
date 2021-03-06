package kty;

import java.util.ArrayList;
import java.util.List;

import lastdto.artrInfoDTO;

public class ArtrDAO extends DAO {

	// 추가
	public int insert(artrInfoDTO dto) {
		int r = 0;
		try {
			String sql = "insert into ARTR_INFO(ARTR_NO, HOS_ID, ARTR_NAME, ARTR_SUB)"
						+ " values(ARTR_SEQ.nextval, ?, ?, ?)"; // ARTR_seq.nextval
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getHosId());
			pstmt.setString(2, dto.getArtrName());
			pstmt.setString(3, dto.getArtrSub());
			r = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}
	
	//전체리스트
	public List<artrInfoDTO> selectList(String hosId) {
		List<artrInfoDTO> list = new ArrayList<artrInfoDTO>();
		try {
			String sql = "select * from ARTR_INFO WHERE HOS_ID = ? order by ARTR_NO ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hosId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				artrInfoDTO dto = new artrInfoDTO();
				dto.setArtrNo(rs.getInt("ARTR_NO"));
				dto.setHosId(rs.getString("HOS_ID"));
				dto.setArtrName(rs.getString("ARTR_NAME"));
				dto.setArtrSub(rs.getString("ARTR_SUB"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
}
