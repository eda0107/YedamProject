<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="dbconnect.jsp"%>
<%@ include file="/layout/hos_head.jsp"%>
<%@ include file="/layout/hos_menu.jsp"%>

	<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
	<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>의사목록관리</h1>
					</div>
				</div>
			</div>
	<!-- /.container-fzluid -->
		</section>
			
      <!-- Main content -->
 	<section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title"></h3>

                <div class="card-tools">
                  <div class="input-group input-group-sm" style="width: 150px;">
                    <input type="text" name="table_search" class="form-control float-right" placeholder="Search">

                    <div class="input-group-append">
                      <button type="submit" class="btn btn-default"><i class="fas fa-search"></i></button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- /.card-header -->
        <form class="form-horizontal" action="">
              <div class="card-body table-responsive p-0" style="height: 400px;">
                <table class="table table-hover table-valign-middle">
                  <thead>
            		<tr>
            		<th>번호</th>
            		<th>이름</th>
            		<th>과목</th>
            		<th></th>
            		</tr>
            	<c:forEach items="${list}" var="dto">
                    <tr>
      			      <td>${dto.artrNo}</td>
                      <td>${dto.artrName}</td>
 			        <c:choose>
						<c:when test="${dto.artrSub =='CS10'}">
							<td>내과</td>
						</c:when>
						<c:when test="${dto.artrSub =='CS20'}">
							<td>소아과</td>
						</c:when>
						<c:when test="${dto.artrSub =='CS30'}">
							<td>외과</td>
						</c:when>
						<c:when test="${dto.artrSub =='CS40'}">
							<td>정형외과</td>
						</c:when>
						<c:otherwise>
							<td>치과</td>
						</c:otherwise>
					</c:choose>
					<td>
					<a class="btn btn-block btn-default btn-sm" href="#"> 
                              	<i class="fas fa-trash">
                              	</i> </a>
					</td>			
                    </tr>
                 </c:forEach>
   					
                  </tbody>
								
                </table>
              </div>
			<a class="btn btn-block btn-secondary" href="${pageContext.request.contextPath}/HDoctorAdd.do">의사추가</a>
       </form>
             
              
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div>
        </div>
        </section>

				<!-- Control Sidebar -->
				<aside class="control-sidebar control-sidebar-dark">
					<!-- Control sidebar content goes here -->
				</aside>
				<!-- /.control-sidebar -->
		</div>
		<!-- ./wrapper -->
<br><br>
<%@ include file="/layout/all_footer.jsp"%>
</body>
</html>