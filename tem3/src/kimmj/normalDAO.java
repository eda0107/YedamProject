package kimmj;

import java.sql.SQLException;
import java.util.ArrayList;

import lastdto.sickJoinMemberDTO;
import lastdto.sickMemberDTO;

public class normalDAO extends DAO {
	public static String sql;
	
	// 전체 리스트
	public ArrayList<sickJoinMemberDTO> select() {
		ArrayList<sickJoinMemberDTO> list = new ArrayList<>();
		sql = "SELECT * FROM Sick_Member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sickJoinMemberDTO dto = new sickJoinMemberDTO();
				dto.setSicId("sic_ID");
				dto.setSicName("sic_name");
				dto.setSicPhone("sic_Phone");
				dto.setSicStt("sic_stt");
				dto.setRvNo(rs.getInt("rv_no"));
				dto.setStarPoint(rs.getInt("star_point"));
				dto.setDecNo(rs.getInt("dec_no"));
				dto.setDecDttm(rs.getDate("dec_dttm"));
				list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
	
	// 등급별 조회
	public ArrayList<sickJoinMemberDTO> select(String sicStt) {
		ArrayList<sickJoinMemberDTO> list = new ArrayList<>();
		sql = "SELECT * FROM Sick_Member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sickJoinMemberDTO dto = new sickJoinMemberDTO();
				dto.setSicId("sic_ID");
				dto.setSicName("sic_name");
				dto.setSicPhone("sic_Phone");
				dto.setRvNo(rs.getInt("rv_no"));
				dto.setStarPoint(rs.getInt("star_point"));
				dto.setDecNo(rs.getInt("dec_no"));
				dto.setDecDttm(rs.getDate("dec_dttm"));
				list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	
	
	// 이름 조회
	public ArrayList<sickJoinMemberDTO> select(String sicName) {
		ArrayList<sickJoinMemberDTO> list = new ArrayList<>();
		sql = "SELECT * FROM Sick_Member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sickJoinMemberDTO dto = new sickJoinMemberDTO();
				dto.setSicId("sic_ID");
				dto.setSicPhone("sic_Phone");
				dto.setSicStt("sic_stt");
				dto.setRvNo(rs.getInt("rv_no"));
				dto.setStarPoint(rs.getInt("star_point"));
				dto.setDecNo(rs.getInt("dec_no"));
				dto.setDecDttm(rs.getDate("dec_dttm"));
				list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	
	
	// 전화번호 조회
	public ArrayList<sickJoinMemberDTO> select(String sicPhone) {
		ArrayList<sickJoinMemberDTO> list = new ArrayList<>();
		sql = "SELECT * FROM Sick_Member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sickJoinMemberDTO dto = new sickJoinMemberDTO();
				dto.setSicId("sic_ID");
				dto.setSicName("sic_name");
				dto.setSicStt("sic_stt");
				dto.setRvNo(rs.getInt("rv_no"));
				dto.setStarPoint(rs.getInt("star_point"));
				dto.setDecNo(rs.getInt("dec_no"));
				dto.setDecDttm(rs.getDate("dec_dttm"));
				list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	
	
	
	// 등급별, 이름 조회
	public ArrayList<sickJoinMemberDTO> select(String sicStt, String sicName) {
		ArrayList<sickJoinMemberDTO> list = new ArrayList<>();
		sql = "SELECT * FROM Sick_Member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sickJoinMemberDTO dto = new sickJoinMemberDTO();
				dto.setSicId("sic_ID");
				dto.setSicPhone("sic_Phone");
				dto.setRvNo(rs.getInt("rv_no"));
				dto.setStarPoint(rs.getInt("star_point"));
				dto.setDecNo(rs.getInt("dec_no"));
				dto.setDecDttm(rs.getDate("dec_dttm"));
				list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	
	
	
	// 이름, 전화번호 조회
	public ArrayList<sickJoinMemberDTO> select(String sicName, String sicPhone) {
		ArrayList<sickJoinMemberDTO> list = new ArrayList<>();
		sql = "SELECT * FROM Sick_Member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sickJoinMemberDTO dto = new sickJoinMemberDTO();
				dto.setSicId("sic_ID");
				dto.setSicStt("sic_stt");
				dto.setRvNo(rs.getInt("rv_no"));
				dto.setStarPoint(rs.getInt("star_point"));
				dto.setDecNo(rs.getInt("dec_no"));
				dto.setDecDttm(rs.getDate("dec_dttm"));
				list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	
	
	
	// 등급, 전화번호 조회
	public ArrayList<sickJoinMemberDTO> select(String sicStt, String sicPhone) {
		ArrayList<sickJoinMemberDTO> list = new ArrayList<>();
		sql = "SELECT * FROM Sick_Member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sickJoinMemberDTO dto = new sickJoinMemberDTO();
				dto.setSicId("sic_ID");
				dto.setSicName("sic_name");
				dto.setRvNo(rs.getInt("rv_no"));
				dto.setStarPoint(rs.getInt("star_point"));
				dto.setDecNo(rs.getInt("dec_no"));
				dto.setDecDttm(rs.getDate("dec_dttm"));
				list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	
	
	// 등급별, 이름, 전화번호 조회
	public ArrayList<sickJoinMemberDTO> select(String sicStt, String sicName, String sicPhone) {
		ArrayList<sickJoinMemberDTO> list = new ArrayList<>();
		sql = "SELECT * FROM Sick_Member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sickJoinMemberDTO dto = new sickJoinMemberDTO();
				dto.setSicId("sic_ID");
				dto.setRvNo(rs.getInt("rv_no"));
				dto.setStarPoint(rs.getInt("star_point"));
				dto.setDecNo(rs.getInt("dec_no"));
				dto.setDecDttm(rs.getDate("dec_dttm"));
				list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	}
