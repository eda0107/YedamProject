<%@page import="java.sql.Date"%>
<%@page import="lastdto.mediRqdetailDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/layout/sick_head.jsp"%>
<script src="<%=request.getContextPath()%>/aView/chorong/js/chorong.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/aView/chorong/css/chorong.css?ver=6">
<style>
.btn {
	margin: 5px;
	font-size:0.9rem;
}
</style>
<%@ include file="/layout/sick_menu.jsp"%>

<!-- 컨텐츠 위치 -->

<!-- Content Wrapper. Contains page content -->

<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>진료완료이력</h1>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<!-- left column -->
				<div class="col-md-12">

					<!-- 신청한 병원 상세정보 (병원이름, 의사이름, 주소, 진료예약시간) -->
					<div class="card card-default">
						<div class="card-header">
							<h3 class="card-title">상세정보</h3>
						</div>
						<div class="card-body">

							<div class="row">
								<div class="col-sm-12">
									<div class="item rqDetailInfo">
										<span class="rqDetailLabel">병원명</span>${dto.hosName }</div>
									<div class="item rqDetailInfo">
										<span class="rqDetailLabel">주소</span>${dto.hosAddr }</div>
									<div class="item rqDetailInfo">
										<span class="rqDetailLabel">병원연락처</span>${dto.hosPhone }</div>
									<div class="item rqDetailInfo">
										<span class="rqDetailLabel">담당의사</span>${dto.artrName }</div>


									<!-- 코드테이블 완성 후 수정할 것. -->
									<c:if test="${dto.artrSub == 'CS10'}">
										<div class="item rqDetailInfo">
											<span class="rqDetailLabel">진료과목</span>내과
										</div>
									</c:if>
									<c:if test="${dto.artrSub == 'CS20'}">
										<div class="item rqDetailInfo">
											<span class="rqDetailLabel">진료과목</span>소아과
										</div>
									</c:if>
									<c:if test="${dto.artrSub == 'CS30'}">
										<div class="item rqDetailInfo">
											<span class="rqDetailLabel">진료과목</span>외과
										</div>
									</c:if>
									<c:if test="${dto.artrSub == 'CS40'}">
										<div class="item rqDetailInfo">
											<span class="rqDetailLabel">진료과목</span>정형외과
										</div>
									</c:if>
									<c:if test="${dto.artrSub == 'CS50'}">
										<div class="item rqDetailInfo">
											<span class="rqDetailLabel">진료과목</span>치과
										</div>
									</c:if>


									<div class="item rqDetailInfo">
										<span class="rqDetailLabel">의사선생님께 한 마디</span>${dto.msg }</div>


									<!-- 예약일 경우에만 표시 -->
									<c:if test="${dto.rqstTy == 'D002'}">
										<div class="item rqDetailInfo">
											<span class="rqDetailLabel">진료날짜</span>${dto.resDt }</div>
										<div class="item rqDetailInfo">
											<span class="rqDetailLabel">진료예약시간</span>${dto.resTm }</div>
									</c:if>
									<!-- 접수일 경우에만 표시 -->
									<c:if test="${dto.rqstTy == 'D001'}">
										<div class="item rqDetailInfo">
											<span class="rqDetailLabel">진료일자</span>${dto.rqstDt }</div>
									</c:if>
								</div>


							</div>
						</div>

						<form id="frm" name="frm" method="post">
							<!-- 							선택한 진료신청항목의 진료신청번호를 전송_ 리뷰등록시 값 넘겨야 함 -->
							<input type="hidden" id="rqstNo" name="rqstNo" value="${rqstNo}">
							<!-- 							신고, 리뷰, 재접수시 필요한 값 넘김 -->
							<input type="hidden" id="hosId" name="hosId" value="${dto.hosId}">
							<input type="hidden" id="hosName" name="hosName"
								value="${dto.hosName}">


							<!-- 신청폼푸터 // 제출 및 기타 버튼 위치-->
							<div class="card-footer">
								<div class="row text-center">
									<button onclick="toList()" class="btn btn-secondary col">
										목록으로</button>
									<button onclick="toReport()" class="btn btn-secondary col">
										병원신고</button>
								</div>
								<div class="row text-center">
									<button onclick="toReview()" class="btn btn-secondary col">
										리뷰등록</button>
									<button onclick="toRequest()" class="btn btn-secondary col">
										다시접수</button>
								</div>
							</div>
						</form>
					</div>


				</div>
				<!--/.col (left) -->




				<!-- right column -->
				<div class="col-md-12"></div>
				<!--/.col (right) -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->




<%@ include file="/layout/all_footer.jsp"%>
<script>
	function toList() {
		frm.action = "SMedDoneList.do";
		frm.submit();
	}
	function toReport() {
		frm.action = "SDeclaration.do";
		frm.submit();
	}
	function toReview() {
		frm.action = "SReviewWrite.do";
		frm.submit();
	}
	function toRequest() {
		frm.action = "SHospitalInfo.do";
		frm.submit();
	}
</script>
</body>
</html>




