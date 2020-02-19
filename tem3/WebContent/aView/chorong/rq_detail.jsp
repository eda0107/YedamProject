<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/layout/sick_head.jsp"%>
<script src="<%=request.getContextPath()%>/aView/chorong/js/chorong.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/aView/chorong/css/chorong.css">
<%@ include file="/layout/sick_menu.jsp"%>

<form id="frm" name="frm" method="post">
	<!-- 컨텐츠 위치 -->
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<!-- 넘어온 값을 이용하여 접수내역/예약내역으로 구분하여 출력 -->
						<h1>진료신청내역</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">홈</a></li>
							<li class="breadcrumb-item active">일반회원</li>
						</ol>
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


						<!-- 1. 신청한 병원 상세정보 (병원이름, 의사이름, 주소, 진료예약시간) -->
						<div class="card card-secondary">
							<div class="card-header">
								<h3 class="card-title">상세정보</h3>
							</div>
							<div class="card-body">

								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<!--  -->
											<label for="hosName">병원명</label> <input type="text"
												id="hosName" name="hosName" class="form-control"
												value="${dto.artr_name}병원명" disabled> <br> <label
												for="hosAddr">주소</label>
											<textarea id="hosAddr" name="hosAddr" class="form-control"
												disabled>${dto.artr_name}주소주소</textarea>
											<br> <label for="hosTel">연락처</label> <input type="text"
												id="hosTel" name="hosTel" class="form-control"
												value="${dto.artr_name}연락처" disabled> <br> <label
												for="DrInfo">의사 및 진료과목</label> <input type="text"
												id="DrInfo" name="DrInfo" class="form-control"
												value="${dto.artr_name}의사이름 진료과목" disabled> <br>
											<label for="toDr">의사선생님에게 한 마디</label>
											<textarea id="toDr" name="toDr" class="form-control" disabled></textarea>
											<br>


											<!-- 예약일 경우에만 표시 -->
											<label for="medDay">진료날짜</label> <input type="text"
												id="medDay" name="medDay" class="form-control" value="진료날짜"
												disabled> <br> <label for="medTime">진료시간</label>
											<input type="text" id="medTime" name="medTime"
												class="form-control" value="진료시간" disabled>



											<!-- 접수일 경우에만 표시 -->
											<label for="medTime">도착예상시간</label> <input type="text"
												id="medTime" name="medTime" class="form-control"
												value="도착예상시간" disabled> <br> <label for="toDr">의사선생님에게
												한 마디</label>
											<textarea id="toDr" name="toDr" class="form-control" disabled></textarea>
											<br>
											<!-- 	3. 예상 대기인원수 출력 (프로시저 이용) -->
											<label for="waiting">예상대기인원수</label> <input type="text"
												id="waiting" name="waiting" class="form-control"
												value="예상대기인원수  n명" disabled>

										</div>


									</div>
								</div>
							</div>





							<!-- 신청폼푸터 // 제출 및 기타 버튼 위치
						2. 예약/접수취소 버튼 -->

							<div class="card-footer">
								<button onclick="toBeforeMedList()" class="btn btn-secondary">확인</button>
								<button onclick="cancelRes()"
									class="btn btn-secondary float-right">진료신청취소</button>
							</div>


						</div>

						<!-- 
						 	이전: 진료현황 리스트 페이지
						 	다음: "병원정보 상세조회 페이지,진료현황 리스트 페이지(예약취소버튼 누를 경우)"
						 -->


					</div>
					<!--/.col (left) -->




					<!-- right column -->
					<div class="col-md-12">

						<div class="card card-secondary">
							<div class="card-header">
								<h3 class="card-title">주의사항</h3>
							</div>
							<div class="card-body">

								<div class="row">
									<div class="col-sm-12">
										<div>
											<span style="font-weight: bold;"> 1.</span> 병원 내원시 살려죠 서비스를
											통해 예약/접수하였다고 알려주세요.
										</div>
										<div>
											<span style="font-weight: bold;"> 2.</span> 예약/접수를 취소하실 경우
											패널티가 부여됩니다. (3회 취소시 서비스이용이 제한됩니다.)
										</div>
										<div>
											<span style="font-weight: bold;"> 3.</span> 예약/접수는 병원사정으로 인해
											취소될 가능성이 있습니다.
										</div>
									</div>
								</div>
							</div>
						</div>


					</div>
					<!--/.col (right) -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
</form>

<%@ include file="/layout/all_footer.jsp"%>
</body>
</html>




