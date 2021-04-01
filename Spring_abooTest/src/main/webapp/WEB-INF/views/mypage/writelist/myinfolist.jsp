<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/generationhead.jsp" %>
<!DOCTYPE html>
<html>
  <body>
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.html">WebHost</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="/index" class="nav-link">Home</a></li>
	          <li class="nav-item"><a href="/about" class="nav-link">About</a></li>
	          <li class="nav-item"><a href="/myapt/schedule" class="nav-link">MyApt</a></li>
	          <li class="nav-item"><a class="nav-link" href="/board/info/listinfo">Board</a></li>
	          <li class="nav-item active"><a href="/mypage/modifyinfo" class="nav-link">MyPage</a></li>
	          <c:choose>
	          <c:when test="${sessionScope.generation == null}">
	          <li class="nav-item cta"><a href="/login" class="nav-link"><span>Login</span></a></li>	          
	          </c:when>
	          <c:when test="${sessionScope.generation != null}">
	          <li class="nav-item cta"><a href="/logout" class="nav-link"><span>Logout</span></a></li>	          
	          </c:when>
	          </c:choose>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->

    <section class="home-slider owl-carousel">
      <div class="slider-item bread-item" style="background-image: url(../../../../resources/images/bg_1.jpg);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container-fluid">
          <div class="row slider-text align-items-center justify-content-center" data-scrollax-parent="true">

            <div class="col-md-8 mt-5 text-center col-sm-12 ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
              <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="/mypage/myalarm">My alarm</a></span><span class="mr-2"><a href="/mypage/myvehicle">My Management Fee</a></span><span class="mr-2"><a href="/mypage/modifyinfo">My Information</a></span><span class="mr-2"><a href="/mypage/writelist/myinfolist">My write list</a></span></p>
	            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">My write list</h1>
            </div>
          </div>
        </div>
      </div>
    </section>
  
    <section class="ftco-section">
    	<c:choose>
    		<c:when test="${!empty board}">
    			<div class="container">
		    		<div class="row justify-content-center mb-5">
			          <div class="col-md-7 text-center heading-section ftco-animate">
			            <h2 class="mb-4">내가 작성한 글</h2>
			            <p>정보&질문, 인테리어, 중고 게시판에서 작성한 나의 글 목록입니다.</p>
			          </div>
			        </div>
		    		<div class="row">
		    			<div class="dropdown mb-4 pl-md-3">
						  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
						    정보&질문
						    <span class="caret"></span>
						  </button>
						  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						    <li role="presentation"><a class="d-block text-muted" role="menuitem" tabindex="-1" href="/mypage/writelist/myinfolist">정보&질문</a></li>
						    <li role="presentation"><a class="d-block text-muted" role="menuitem" tabindex="-1" href="/mypage/writelist/myinteriorlist">인테리어</a></li>
						    <li role="presentation"><a class="d-block text-muted" role="menuitem" tabindex="-1" href="/mypage/writelist/myusedlist">중고</a></li>
						  </ul>
						</div>
		    			<div class="col-md-12 ftco-animate">
		    				<div class="table-responsive">
			    				<table class="table">
								    <thead class="thead-primary">
								      <tr>
								        <th class="w-15">글 번호</th>
								        <th class="w-15">게시판</th>
								        <th class="w-50">제목</th>
								        <th class="w-20">작성 날짜</th>
								      </tr>
								    </thead>
								    <tbody>
								      <c:forEach items="${board}" var="board">
								      	  <tr>
									        <td>${board.bIdx}</td>
									        <td>정보&질문</td>
									        <td><a href="/board/info/detailinfo?bIdx=${board.bIdx}" style="cursor: pointer; color: black;">${board.bTitle}</a></td>
									        <td>${board.bWdate}</td>
									      </tr>
								      </c:forEach>
								    </tbody>
								  </table>
							  </div>
		    			</div>
		    		</div>
		    	</div>
		    	<div class="row mt-5">
		          <div class="col text-center">
		            <div class="block-27">
		              <ul>
		                <li><a href="${context}/mypage/writelist/${paging.type}">&lt;&lt;</a></li>
		                <li><a href="${context}/mypage/writelist/${paging.type}?page=${paging.prev}">&lt;</a></li>
			                <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
			                   <c:choose>
			                      <c:when test="${paging.currentPage eq page}">
			                         <li class="active"><a href="${context}/mypage/writelist/${paging.type}?page=${page}">${page}</a></li>
			                      </c:when>
			                      <c:otherwise>
			                         <li><a href="${context}/mypage/writelist/${paging.type}?page=${page}">${page}</a></li>
			                      </c:otherwise>
			                   </c:choose>
			              	 </c:forEach>
		                <li><a href="${context}/mypage/writelist/${paging.type}?page=${paging.next}">&gt;</a></li>
		                <li><a href="${context}/mypage/writelist/${paging.type}?page=${paging.lastPage}">&gt;&gt;</a></li>
		              </ul>
		            </div>
		          </div>
		        </div>
    		</c:when>
    		<c:otherwise>
    			<div class="container">
		    		<div class="row justify-content-center mb-5">
			          <div class="col-md-7 text-center heading-section ftco-animate">
			            <h2 class="mb-4">내가 작성한 글</h2>
			            <p>정보&질문, 인테리어, 중고 게시판에서 작성한 나의 글 목록입니다.</p>
			          </div>
			        </div>
			        <div class="row">
			        	<div class="dropdown mb-4 pl-md-3">
						  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
						    정보&질문
						    <span class="caret"></span>
						  </button>
						  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
						    <li role="presentation"><a class="d-block text-muted" role="menuitem" tabindex="-1" href="/mypage/writelist/myinfolist">정보&질문</a></li>
						    <li role="presentation"><a class="d-block text-muted" role="menuitem" tabindex="-1" href="/mypage/writelist/myintlist">인테리어</a></li>
						    <li role="presentation"><a class="d-block text-muted" role="menuitem" tabindex="-1" href="/mypage/writelist/myusedlist">중고</a></li>
						  </ul>
						</div>
			        </div>
			        <div class="mt-5 mb-5 text-center">아직 작성한 글이 없습니다.</div>
		    	</div>
    		</c:otherwise>
    	</c:choose>
    </section>

    <footer class="ftco-footer ftco-bg-dark ftco-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">ABOO</h2>
              <p>아파트를 부탁해!<br>
              아파트 주변 공공기관부터 투표, 관리비납부, 차량등록, 층간소음 문의 등 관리하기 편한 기능을 제공합니다.
              </p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-5">
              <h2 class="ftco-heading-2">Unseful Links</h2>
              <ul class="list-unstyled">
                <li><a href="/myapt/parking" class="py-2 d-block">Parking</a></li>
                <li><a href="/board/info/listinfo" class="py-2 d-block">Info Board</a></li>
                <li><a href="/board/interior/intlist" class="py-2 d-block">Interior Board</a></li>
                <li><a href="/board/used/usedlist" class="py-2 d-block">Used Board</a></li>
                <li><a href="/myapt/schedule" class="py-2 d-block">Apt Schedule</a></li>
                <li><a href="/myapt/institutions" class="py-2 d-block">Institutions</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Navigational</h2>
              <ul class="list-unstyled">
                <li><a href="/index" class="py-2 d-block">Home</a></li>
                <li><a href="/about" class="py-2 d-block">About</a></li>
                <li><a href="/myapt/schedule" class="py-2 d-block">MyApt</a></li>
                <li><a href="/baord/info/listinfo" class="py-2 d-block">Board</a></li>
                <li><a href="/mypage/modifyinfo" class="py-2 d-block">MyPage</a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Office</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">6, Teheran-ro 14-gil, Gangnam-gu, Seoul, Republic of Korea</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+82 123 4567 8910</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">choayoung91@naver.com</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">gmldnjs74@gmail.com</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">minh0380@naver.com</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">psuny1031@naver.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> <i class="icon-heart" aria-hidden="true"></i> by aboo for a better apartment.
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="../../../../resources/js/generation/jquery.min.js"></script>
  <script src="../../../../resources/js/generation/jquery-migrate-3.0.1.min.js"></script>
  <script src="../../../../resources/js/generation/popper.min.js"></script>
  <script src="../../../../resources/js/generation/bootstrap.min.js"></script>
  <script src="../../../../resources/js/generation/jquery.easing.1.3.js"></script>
  <script src="../../../../resources/js/generation/jquery.waypoints.min.js"></script>
  <script src="../../../../resources/js/generation/jquery.stellar.min.js"></script>
  <script src="../../../../resources/js/generation/owl.carousel.min.js"></script>
  <script src="../../../../resources/js/generation/jquery.magnific-popup.min.js"></script>
  <script src="../../../../resources/js/generation/aos.js"></script>
  <script src="../../../../resources/js/generation/jquery.animateNumber.min.js"></script>
  <script src="../../../../resources/js/generation/bootstrap-datepicker.js"></script>
  <script src="../../../../resources/js/generation/jquery.timepicker.min.js"></script>
  <script src="../../../../resources/js/generation/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="../../../../resources/js/generation/google-map.js"></script>
  <script src="../../../../resources/js/generation/main.js"></script>
    
  </body>
</html>