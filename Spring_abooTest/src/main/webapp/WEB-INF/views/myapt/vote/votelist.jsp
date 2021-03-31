<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/generationhead.jsp" %>
<!DOCTYPE html>
<html>
  <body>
    
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="/index">ABOO</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="/index" class="nav-link">Home</a></li>
	          <li class="nav-item"><a href="/about" class="nav-link">About</a></li>
	          <li class="nav-item active"><a href="/myapt/schedule" class="nav-link">MyApt</a></li>
	          <li class="nav-item"><a class="nav-link" href="/board/info/listinfo">Board</a></li>
	          <li class="nav-item"><a href="/mypage/modifyinfo" class="nav-link">MyPage</a></li>
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
      <div class="slider-item bread-item" style="background-image: url(../../../resources/abooimg/logo_w.png);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container-fluid">
          <div class="row slider-text align-items-center justify-content-center" data-scrollax-parent="true">

            <div class="col-md-8 mt-5 text-center col-sm-12 ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
              <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index.html">Parking</a></span> <span class="mr-2">Schedule</span> <span>Institutions</span></p>
	            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Vote</h1>
            </div>
          </div>
        </div>
      </div>
    </section>
  
    <section class="ftco-section">
    	<div class="container">
    		<div class="row justify-content-center mb-5">
          <div class="col-md-7 text-center heading-section ftco-animate">
            <h2 class="mb-4">투표 목록</h2>
            <p>아파트 주민들과 상의하여 결정하여야 하는 안건에 대해 투표를 진행합니다.</p>
          </div>
        </div>
    		<div class="row">
    			<div class="col-md-12 ftco-animate">
    				<div class="table-responsive">
    					<c:choose>
    						<c:when test="${sessionScope.generation != null}">
    							<table class="table">
								    <thead class="thead-primary">
								      <tr>
								        <th class="w-10">투표 번호</th>
								        <th class="w-40">제목</th>
								        <th class="w-25">투표 기간</th>
								        <th class="w-15">투표 상태</th>
								        <th class="w-10">참여 여부</th>
								      </tr>
								    </thead>
								    <tbody>
								      <c:forEach items="${voteMng}" var="voteMng" varStatus="status" >
								      	<c:choose>
								      		<c:when test="${voteMng.voteIsFinish == 0}">
								      			<tr>
										          <td>${voteMng.voteNo}</td>
										          <td><a href="/myapt/vote/votedetail?voteNo=${voteMng.voteNo}" style="cursor: pointer; color: black;">${voteMng.voteTitle}</a></td>
										          <td>${voteMng.voteBeginDate} ~ ${voteMng.voteEndDate}</td>
										          <td>투표 중</td>
										          <td>${ifParticipate[status.index]}</td>
										        </tr>
								      		</c:when>
								      		<c:otherwise>
								      			<tr>
										          <td>${voteMng.voteNo}</td>
										          <td><a href="/myapt/vote/votedetail?voteNo=${voteMng.voteNo}" style="cursor: pointer; color: black;">${voteMng.voteTitle}</a></td>
										          <td>${voteMng.voteBeginDate} ~ ${voteMng.voteEndDate}</td>
										          <td>투표 완료</td>
										          <td>${ifParticipate[status.index]}</td>
										        </tr>
								      		</c:otherwise>
								      	</c:choose>
								      </c:forEach>
								    </tbody>
								  </table>
    						</c:when>
    						<c:otherwise>
    							<table class="table">
								    <thead class="thead-primary">
								      <tr>
								        <th class="w-15">투표 번호</th>
								        <th class="w-40">제목</th>
								        <th class="w-25">투표 기간</th>
								        <th class="w-20">투표 상태</th>
								      </tr>
								    </thead>
								    <tbody>
								      <c:forEach items="${voteMng}" var="voteMng" >
								      	<c:choose>
								      		<c:when test="${voteMng.voteIsFinish == 0}">
								      			<tr>
										          <td>${voteMng.voteNo}</td>
										          <td><a href="/myapt/vote/votedetail?voteNo=${voteMng.voteNo}" style="cursor: pointer; color: black;">${voteMng.voteTitle}</a></td>
										          <td>${voteMng.voteBeginDate} ~ ${voteMng.voteEndDate}</td>
										          <td>투표 중</td>
										        </tr>
								      		</c:when>
								      		<c:otherwise>
								      			<tr>
										          <td>${voteMng.voteNo}</td>
										          <td><a href="/myapt/vote/votedetail?voteNo=${voteMng.voteNo}" style="cursor: pointer; color: black;">${voteMng.voteTitle}</a></td>
										          <td>${voteMng.voteBeginDate} ~ ${voteMng.voteEndDate}</td>
										          <td>투표 완료</td>
										        </tr>
								      		</c:otherwise>
								      	</c:choose>
								      </c:forEach>
								    </tbody>
								  </table>
    						</c:otherwise>
    					</c:choose>
					  </div>
    			</div>
    		</div>
    	</div>
		<div class="container d-flex justify-content-end">
			<form class="search-form" style="width: 40%;">
	          <div class="form-group mb-0">
	            <div class="icon" style="cursor: pointer;">
	            	<a id="voteSearchIcon" class="icon-search"></a>
	            </div>
	            <input id="voteSearch" type="text" class="form-control" placeholder="제목을 입력하세요.">
	          </div>
         </form>
		</div>
		
		<c:choose>
			<c:when test="${sessionScope.admin != null}">
				<div class="container text-center d-flex justify-content-end">
			      <a href="/admin/vote/makevote" class="center-block btn btn-primary p-3 px-xl-4 py-xl-2 mt-3 btn-sm" style="background: linear-gradient(45deg, #12e6ca 0%, #8be55d 100%); border: none; color: white !important;">투표만들기</a>
			    </div>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
		
    	<div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">
              <ul>
                <li><a href="${context}/myapt/${paging.type}/votelist">&lt;&lt;</a></li>
                <li><a href="${context}/myapt/${paging.type}/votelist?page=${paging.prev}">&lt;</a></li>
	                <c:forEach begin="${paging.blockStart}" end="${paging.blockEnd}" var="page">
	                   <c:choose>
	                      <c:when test="${paging.currentPage eq page}">
	                         <li class="active"><a href="${context}/myapt/${paging.type}/votelist?page=${page}">${page}</a></li>
	                      </c:when>
	                      <c:otherwise>
	                         <li><a href="${context}/myapt/${paging.type}/votelist?page=${page}">${page}</a></li>
	                      </c:otherwise>
	                   </c:choose>
	              	 </c:forEach>
                <li><a href="${context}/myapt/${paging.type}/votelist?page=${paging.next}">&gt;</a></li>
                <li><a href="${context}/myapt/${paging.type}/votelist?page=${paging.lastPage}">&gt;&gt;</a></li>
              </ul>
            </div>
          </div>
        </div>
        
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
  
  <script type="text/javascript">
  	document.querySelector('#voteSearchIcon').addEventListener('click', (e)=>{
		let keyword = document.querySelector('#voteSearch').value;
		
		if(keyword){
  			location.href = '/myapt/vote/votesearch?voteSearch=' + keyword;
  		}else{
  			alert("검색할 게시글 제목을 입력해주세요.");
  		}
	})
  </script>
    
  </body>
</html>