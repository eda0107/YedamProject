package kcr;

import java.sql.SQLException;

import command.DAO;
import lastdto.mediRqdetailDTO;

public class MediRqdetailDAO extends DAO {
	
	
	// 진료취소처리하기
			public int makeMedCancelStatus(int rqstNo) {
				System.out.println("DAO왔음");
				int n= 0 ;
				String sql1 = "UPDATE medi_info SET mctt_stt = '0' WHERE rqst_no = ?";
				String sql2 = "UPDATE medi_rqst SET rqst_ty = 'D003' WHERE rqst_no = ?";
				try {
					pstmt = conn.prepareStatement(sql1);
					pstmt.setInt(1, rqstNo);
					n  += pstmt.executeUpdate();
					System.out.println("====at DAO MakeMedDoneStatus 처리건수(mctt stt)"+ n);
					pstmt = conn.prepareStatement(sql2);
					pstmt.setInt(1, rqstNo);
					n  += pstmt.executeUpdate();
					System.out.println("====at DAO MakeMedDoneStatus 처리건수(rqst_ty)"+ n);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close();
				}
				return n;
			}
	
	
	// 진료완료처리하기
		public int MakeMedDoneStatus(int rqstNo) {
			int n= 0 ;
			String sql = "update medi_info set mctt_stt='Y' where rqst_no = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rqstNo);
				n  = pstmt.executeUpdate();
				System.out.println("====at DAO MakeMedDoneStatus 처리건수"+ n);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return n;
		}
	
	// 진료완료 여부 가져오기 
	public String getHosNow(int rqstNo) {
		String mcttStt = null;
		String sql = "select * from medi_info where rqst_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rqstNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mcttStt = rs.getString("mctt_stt");
			} 
			System.out.println("======DAO에서 mctt_stt:" + mcttStt + "=====");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mcttStt;
	}
	

	// 진료신청상세 단건조회__ 
	// 신청현황상세, 진료신청완료페이지,
	//( 진료신청현황목록을 통해 볼 수 있으므로 mctt_stt 진료상태가 전(Y)이거나 취소인지는 사전에 필터링되어 있음 )
	// 진료이력
	//( 진료이력목록을 통해 볼 수 있으므로 mctt_stt 진료상태가 후(Y)인지는 사전에 필터링되어 있음 )
	public mediRqdetailDTO selectOne(int rqstNo) {
		
		mediRqdetailDTO dto = new mediRqdetailDTO();
		
		String sql = "SELECT * " 
				+ " FROM MEDIRQDETAIL "
				+ " WHERE RQST_NO = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rqstNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setRqstNo(rs.getInt("RQST_NO"));
				dto.setSicId(rs.getString("SIC_ID"));
				dto.setRqstDt(rs.getString("RQST_DT"));//신청날짜
				dto.setRqstTm(rs.getString("RQST_TM"));//신청날짜
				dto.setHosId(rs.getString("HOS_ID"));
				dto.setResDt(rs.getString("RES_DT"));//예약날짜
				dto.setResTm(rs.getString("RES_TM"));//예약시간
				dto.setArtrNo(rs.getInt("ARTR_NO"));
				dto.setRqstTy(rs.getString("RQST_TY"));
				dto.setMsg(rs.getString("MSG"));
				dto.setDcryNo(rs.getInt("DCRY_NO"));
				dto.setIfTime(rs.getString("IFTIME"));		

				dto.setHosName(rs.getString("HOS_NAME"));
				dto.setHosPhone(rs.getString("HOS_PHONE"));
				dto.setHosAddr(rs.getString("HOS_ADDR"));

				dto.setArtrName(rs.getString("ARTR_NAME"));
				dto.setArtrSub(rs.getString("ARTR_SUB"));
				System.out.println("at mediRqdetail DAO "+dto.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	// 예상대기인원수 구하는 프로시저 호출
	public int getNoOfWaiting(String hosId, int rqstNo) {
		int NoOfWaiting = 0;
		String call = "{call waiting_sel(?,?,?)}";
		try {
			cstmt = conn.prepareCall(call);
			
			// IN parameter설정
			cstmt.setString(1, hosId);
			cstmt.setInt(2, rqstNo);
			
			// Out parameter의 Type설정
			cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(3, java.sql.Types.INTEGER);
			
			// CallableStatement실행
			cstmt.executeQuery();
			
			String outHosId = cstmt.getString(1);
			NoOfWaiting = cstmt.getInt(3);
			// Out parameter의 값을 얻고, 출력한다.
			System.out.println("fromDAO    "+"hosId: " +  outHosId
			+ ", NoOfWaiting : "+ NoOfWaiting);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return NoOfWaiting;
	}

	// 당일접수 신청
	public int tmrInsert(mediRqdetailDTO dto) {
		int r = 0;
		String sql;

		if (dto.getDcryNo() != 0) {
			sql = "insert into MEDI_RQST" 
					+ " (RQST_NO, SIC_ID,  HOS_ID, " 
					+ " ARTR_NO, RQST_TY, DCRY_NO, MSG, IFTIME)"
					+ " values" 
					+ " (RQST_SEQ.nextval, ?, ?, " 
					+ " ?, 'D001', ? ,?, ?)"; // D001 당일접수
		} else { // 기록물을 선택하지 않은 경우를 위해서
			sql = "insert into MEDI_RQST" 
					+ " (RQST_NO, SIC_ID,  HOS_ID, " 
					+ " ARTR_NO, RQST_TY, MSG, IFTIME)" 
					+ " values"
					+ " (RQST_SEQ.nextval, ?, ?, " 
					+ " ?, 'D001', ?, ?)"; // D001 당일접수
		}
		try {
			if (dto.getDcryNo() != 0) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getSicId());
				pstmt.setString(2, dto.getHosId());
				pstmt.setInt(3, dto.getArtrNo());
				pstmt.setInt(4, dto.getDcryNo());
				pstmt.setString(5, dto.getMsg());
				pstmt.setString(6, dto.getIfTime());
			} else {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getSicId());
				pstmt.setString(2, dto.getHosId());
				pstmt.setInt(3, dto.getArtrNo());
				pstmt.setString(4, dto.getMsg());
				pstmt.setString(5, dto.getIfTime());
			}

			r = pstmt.executeUpdate();
			System.out.println(r + "건 입력완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return r;
	}

	
	
	
	// 예약 신청
	public int resInsert(mediRqdetailDTO dto) {
		int r = 0;
		String sql;

		if (dto.getDcryNo() != 0) {
			sql = "insert into MEDI_RQST " 
					+ "(RQST_NO, SIC_ID, HOS_ID, RES_DTTM, " 
					+ "ARTR_NO, RQST_TY, DCRY_NO, MSG) "
					+ "values " 
					+ "(RQST_SEQ.nextval, ?, ?, TO_DATE( ? , 'YYYYMMDDHH24MI'), " 
					+ "?, 'D002', ? ,?)"; // D002 예약
		} else { // 기록물을 선택하지 않은 경우를 위해서
			sql = "insert into MEDI_RQST " 
					+ "(RQST_NO, SIC_ID, HOS_ID, RES_DTTM, " 
					+ "ARTR_NO, RQST_TY, MSG) "
					+ "values " 
					+ "(RQST_SEQ.nextval, ?, ?, TO_DATE( ? , 'YYYYMMDDHH24MI'), " 
					+ "?, 'D002', ?)"; // D002 예약
		}
		try {
			if (dto.getDcryNo() != 0) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getSicId());
				pstmt.setString(2, dto.getHosId());
				pstmt.setString(3, dto.getResDt()+ dto.getResTm()); //"20201122"+"1855" 
				pstmt.setInt(4, dto.getArtrNo());
				pstmt.setInt(5, dto.getDcryNo());
				pstmt.setString(6, dto.getMsg());
			} else {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getSicId());
				pstmt.setString(2, dto.getHosId());
				pstmt.setString(3, dto.getResDt()+ dto.getResTm());
				pstmt.setInt(4, dto.getArtrNo());
				pstmt.setString(5, dto.getMsg());
			}
			r = pstmt.executeUpdate();
			System.out.println(r + "건 입력완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return r;

	}

	// 가장 최근 진료신청정보
	public mediRqdetailDTO getHotRqst(String sicId) {
		mediRqdetailDTO dto = new mediRqdetailDTO();
		try {
			String sql = "SELECT ROWNUM, R.* " 
					+ " FROM MEDIRQDETAIL R "
					+ " WHERE SIC_ID = ? "
					+ " AND ROWNUM = 1"
					+ " ORDER BY RQST_NO DESC ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sicId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setRqstNo(rs.getInt("RQST_NO"));
				dto.setSicId(rs.getString("SIC_ID"));
				dto.setRqstDt(rs.getString("RQST_DT"));//신청날짜
				dto.setRqstTm(rs.getString("RQST_TM"));//신청날짜
				dto.setHosId(rs.getString("HOS_ID"));
				dto.setResDt(rs.getString("RES_DT"));//예약날짜
				dto.setResTm(rs.getString("RES_TM"));//예약시간
				dto.setArtrNo(rs.getInt("ARTR_NO"));
				dto.setRqstTy(rs.getString("RQST_TY"));
				dto.setMsg(rs.getString("MSG"));
				dto.setDcryNo(rs.getInt("DCRY_NO"));
				dto.setIfTime(rs.getString("IFTIME"));				

				dto.setHosName(rs.getString("HOS_NAME"));
				dto.setHosPhone(rs.getString("HOS_PHONE"));
				dto.setHosAddr(rs.getString("HOS_ADDR"));

				dto.setArtrName(rs.getString("ARTR_NAME"));
				dto.setArtrSub(rs.getString("ARTR_SUB"));
				System.out.println("select된 최신신청건  " + dto.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	
	
	// 진료신청 취소처리하고 페널티값부여및페널티 처리하는 프로시저 실행
	public int CancelAndPenalty(String sicId, int rqstNo) {
		int r = 0;
		String call = "{call CANCEL_N_PENALTY(?, ?) }";

		try {
			cstmt = conn.prepareCall(call);

			// IN parameter설정
			cstmt.setInt(1, rqstNo);
			cstmt.setString(2, sicId);
			

			// CallableStatement실행
			cstmt.executeUpdate();

			System.out.println(r+"건 취소완료");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return r;
	}

}
