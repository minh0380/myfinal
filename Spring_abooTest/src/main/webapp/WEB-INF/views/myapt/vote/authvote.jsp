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
  
    <section class="ftco-section contact-section ftco-degree-bg">
      <div class="container">
        <div class="row d-flex mb-5 contact-info">
          <div class="col-md-12 mb-4">
            <h2 class="h4">세대원 인증</h2>
          </div>
          <div class="w-100"></div>
          <div class="col-md-12 w-100">
            <p>투표를 진행하기 위해 아파트 세대원임을 인증해주세요.</p>
          </div>
        </div>
        <div class="row block-9 d-flex justify-content-center text-center">
          <div class="col-md-9 pr-md-5">
            <form action="/myapt/vote/authvoteimpl" method="post" id="frm_authvote">
              <input type="text" name="voteNo" style="display: none;" value="${voteNo}">
              <input type="text" name="apartmentIdx" style="display: none;" value="${sessionScope.generation.apartmentIdx}">
              <input type="text" name="generationIdx" style="display: none;" value="${sessionScope.generation.generationIdx}">
              <h5 class="font-weight-bold text-left">세대 정보</h5>
              <div class="form-group d-flex">
                <input type="text" class="form-control" name="building" required="required" placeholder="Your Building"><span class="ml-3 mr-3 align-self-center">동</span>
                <input type="text" class="form-control" name="num" required="required" placeholder="Your Unit"><span class="ml-3 align-self-center">호</span>
              </div>
              <h5 class="font-weight-bold text-left mt-5">세대원 정보</h5>
              <div class="form-group d-flex">
                <span class="col-md-3 align-self-center text-left">이름</span><input type="text" class="form-control" name="name" required="required" placeholder="Your Name">
              </div>
              <div class="form-group d-flex">
                <span class="col-md-3 align-self-center text-left">전화번호</span><input type="text" class="form-control" name="tell" id="tell" required="required" placeholder="전화번호는 '-'를 제외한 숫자만 입력해주세요.">
                <input id="tellsms" type="button" onclick='certSms()' value="전송" class="btn btn-primary py-2 px-2 col-md-2 ml-3" style="background: linear-gradient(45deg, #56c8fb 0%, #627bed 100%); border: none; color: white !important;">
              </div>
              <div class="form-group d-flex">
                <span class="col-md-3 align-self-center text-left">인증번호</span><input type="text" class="form-control" name="certNum" id="certNum" required="required" placeholder="Your Certification Number">
                <input id="smsconfirm" type="button" onclick='certNumConfirm()' value="확인" class="btn btn-primary py-2 px-2 col-md-2 ml-3" style="background: linear-gradient(45deg, #56c8fb 0%, #627bed 100%); border: none; color: white !important;">
              </div>
              <div class="form-group">
                <input type="submit" value="다음" class="btn btn-primary py-3 px-5 col-md-5 mt-5" style="background: linear-gradient(45deg, #12e6ca 0%, #8be55d 100%); border: none; color: white !important;">
              </div>
            </form>
          
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
  
  <script>
  	let certSms = () => {
  		let tell = document.querySelector('#tell').value;
  		if(tell){
  			fetch("/myapt/vote/certsms?tell=" + tell,{
  				method:"GET"
  			})
  			.then(response => response.text())
  			.then(text => {
  				if(text == 'success'){
  					alert("인증번호가 전송되었습니다.");
  				}else{
  					alert("인증번호 전송 중 에러가 발생했습니다.");
  				}
  			})
  		}else{
  			alert("인증번호가 전송될 전화번호를 입력해주세요.");
  		}
  	};
  	
  	let certNumFlg = false;
  	let certNumConfirm = () => {
  		let certNumber = document.querySelector('#certNum').value;
  		if(certNumber){
  			fetch("/myapt/vote/certconfirm?certNumber=" + certNumber,{
  				method:"GET"
  			})
  			.then(response => response.text())
  			.then(text => {
  				if(text == 'success'){
  					alert("인증이 완료되었습니다.");
  					certNumFlg = true;
  				}else{
  					alert("인증번호를 다시 확인해주세요.");
  				}
  			})
  		}else{
  			alert("인증번호를 입력해주세요.");
  		}
  	};
  	
  	//지워줘야함!!!!
  	//let certNumFlg = true;
  	
  	document.querySelector('#frm_authvote').addEventListener('submit',(e)=>{
  		if(!certNumFlg){
  			e.preventDefault();
  			alert("전화번호 인증을 완료해주세요.");
  		}
  	});
  </script>
    
  </body>
</html>