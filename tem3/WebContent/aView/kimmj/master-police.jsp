<%@page import="kimmj.decDAO"%>
<%@page import="lastdto.declarationDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/layout/admin_head.jsp"%>
<script>
	$(document).on("click", ".toMasterPoliceDetail", function() {
		var sicId = $(this).attr("sic_id");
		console.log(sicId);
		$("#sicId").attr("value", sicId);
		frm.submit();
	});
</script>
<style type="text/css">/* Chart.js */
@
keyframes chartjs-render-animation {
	from {opacity: .99
}

to {
	opacity: 1
}

}
.chartjs-render-monitor {
	animation: chartjs-render-animation 1ms
}

.chartjs-size-monitor, .chartjs-size-monitor-expand,
	.chartjs-size-monitor-shrink {
	position: absolute;
	direction: ltr;
	left: 0;
	top: 0;
	right: 0;
	bottom: 0;
	overflow: hidden;
	pointer-events: none;
	visibility: hidden;
	z-index: -1
}

.chartjs-size-monitor-expand>div {
	position: absolute;
	width: 1000000px;
	height: 1000000px;
	left: 0;
	top: 0
}

.chartjs-size-monitor-shrink>div {
	position: absolute;
	width: 200%;
	height: 200%;
	left: 0;
	top: 0
}

.info-box {
	width: 270px;
	height: 20px;
	text-align: center;
	border: solid 1px;
	font-size: 20px;
	margin-top: 15px;
}

.info-box-small {
	width: 100px;
	height: 30px;
	border: solid 1px;
	text-align: center;
	margin-left: 30px;
	margin-right: 10px;
	padding: 5px;
}

.info-box-content {
	margin: 13px 0px 0px 0px;
	text-align: center;
}

.listbox {
	width: 270px;
	height: 140px;
	margin-left: 30px;
	padding: 10px;
	text-align: center;
}

.name {
	font-size: 20px;
	margin-left: 30px;
}

.info {
	padding: 10px;
}
.listbox2 {
	width: 270px;
	height: 140px;
	border: solid 1px;
	margin-left: 50px;
	margin-bottom: 30px;
	padding: 10px;
	text-align: center;
	background-color: #EAEAEA;
	color: #747474;
}

.card-header {
	 background-color: #FFFFF2;
}
.card {
    position: relative;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction: column;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 1 solid rgba(0,0,0,.125);
    border-radius: 0.25rem;
}
</style>

<%@ include file="/layout/admin_menu.jsp"%>
<jsp:useBean id="dao" class="kimmj.decDAO"/>
<%
request.setCharacterEncoding("UTF-8");
String keyField = request.getParameter("keyField");
String keyWord = request.getParameter("keyWord");
%>
<div class = "card">
	<div class = "card-header text-center">
		<div class = "text-center" style = "padding: 10px 0px 0px 0px">
			<h4>
				<b>신고 관리</b>
			</h4>
		</div>
	</div>
	<% 
	ArrayList<declarationDTO> list = dao.select();
	for(declarationDTO dto : list) { 
	%>
	<div class="card-body">
	<table class = "listbox" onclick = "location.href = 'MPoliceDetail.do?sicId=<%= dto.getSicId()%>';">

		<tr>
			<td class = "info">
				<b> 회원 ID: </b> <%= dto.getSicId() %>
			</td>
		</tr>
		<tr>
			<td class = "info">
				<b> 신고 대상 병원: </b> <%= dto.getHosId() %>
			</td>
		</tr>
		<tr>
			<td class = "info">
				<b> 신고일자: </b> <%= dto.getDecDttm() %>
			</td>
		</tr>
	</table>
	<input type = "hidden" id = "sicId" name = "sicId">
	</div>
</div>
<% } %>

<%@ include file="/layout/all_footer.jsp"%>
</body>
</html>