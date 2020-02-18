package kcrDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kty.DAO;
import lastdto.hosMemberDTO;

public class HosInfoDAO extends DAO {
	
	
	
	public List<hosMemberDTO> selectAll() {
		List<hosMemberDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM HOS_MEMBER";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				hosMemberDTO dto = new hosMemberDTO();
				dto.setHosId(rs.getString("HOS_ID"));
				dto.setHosBizno(rs.getString("HOS_BIZNO"));
				dto.setHosName(rs.getString("HOS_NAME"));
				dto.setHosPhone(rs.getString("HOS_PHONE"));
				dto.setHosPw(rs.getString("HOS_PW"));
				dto.setHosAddr(rs.getString("HOS_ADDR"));
				dto.setHosLat(rs.getInt("HOS_LAT"));
				dto.setHosLng(rs.getInt("HOS_LNG"));
				dto.setHosStart(rs.getString("BIZ_START"));
				dto.setHosLast(rs.getString("BIZ_LAST"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return list;
	}
	
	
	
	
	//단건조회
		public hosMemberDTO selectOne(int hosNo) {
			hosMemberDTO dto = new hosMemberDTO();
			try {
				String sql = "SELECT * FROM HOS_MEMBER"
						+ " WHERE HOS_ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, hosNo);
				rs = pstmt.executeQuery();
				if(rs.next()) { 
					dto.setHosBizno(rs.getString("HOS_BIZNO"));
					dto.setHosName(rs.getString("HOS_NAME"));
					dto.setHosPhone(rs.getString("HOS_PHONE"));
					dto.setHosPw(rs.getString("HOS_PW"));
					dto.setHosAddr(rs.getString("HOS_ADDR"));
					dto.setHosLat(rs.getInt("HOS_LAT"));
					dto.setHosLng(rs.getInt("HOS_LNG"));
					dto.setHosStart(rs.getString("BIZ_START"));
					dto.setHosLast(rs.getString("BIZ_LAST"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return dto;
		}
		
		
		
		
	
		
		
		
}
	
