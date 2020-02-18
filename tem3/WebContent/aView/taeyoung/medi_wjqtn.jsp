<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/layout/hos_head.jsp"%>

<style>
 .float-right{ border: none;
}
.dropdown {
  position: relative;
  display: inline-block;
}
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px 0px;
  z-index: 1;
}

.dropdown-content a {
  color: #696969;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

table{
		text-align:center;
}
</style>
<%@ include file="/layout/hos_menu.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>진료현황</h1>
						</div>
						<div class="col-sm-6">
							<!--  <ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">홈</a></li>
								<li class="breadcrumb-item active">접수</li>
							</ol>-->
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
         <div class="dropdown">
			당일&nbsp;접수&nbsp;<i class="fas fa-caret-down"></i>
		<div class="dropdown-content">
    		<a href="${pageContext.request.contextPath}/HMediAll.do">전체</a>
    		<a href="${pageContext.request.contextPath}/HMediWjqtn.do">당일 접수</a>
   			<a href="${pageContext.request.contextPath}/HMediReserve.do">예약</a>
 		 </div>
		</div><br>
        <div class="row">
                  <div class="col-12" >

            <div class="card">
            
              <div class="card-header border-0">
            
                <h3 class="card-title"><!-- 제목 --></h3>
                
                <div class="card-tools">
                </div>
              </div>
              <div class="card-body table-responsive p-0">
                <table class="table table-striped table-valign-middle">
                  <thead>
                  <tr>
               <th style="width:5%;">번호</th>
               <th style="width:28%;">이름</th>
               <th style="width:28%;">시간</th>
               <th style="width:29%;">담당의</th>
             </tr>
            </thead>
             <tbody>
             <c:forEach items="${list}" var="list">
                <tr>
                  <td>${list.rqstNo}</td>
                  <td>${list.sicId}<span class="badge bg-warning">NEW</span></td>
                  <td>${list.rqstDttm}</td>
                  <td>
                    <a href="#" class="text-muted">
                    ${list.artrNo}&nbsp;<i class="fas fa-search"></i>
                      </a>
                  </td>
                </tr>
                </c:forEach>
                   
                  </tbody>
                </table>
              </div>
            </div>
            <!-- /.card -->
          </div>
          </div></div></section>
  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<%@ include file="/layout/all_footer.jsp"%>

<script>
	$("tr").click(function() {
		console.log("click");
		location.href = "${pageContext.request.contextPath}/ ";
	})
</script>
</body>
</html>
