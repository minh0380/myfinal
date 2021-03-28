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
	          <li class="nav-item"><a href="/myapt/schedule" class="nav-link">MyApt</a></li>
	          <li class="nav-item active"><a class="nav-link" href="/board/info/listinfo">Board</a></li>
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
              <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index.html">Info</a></span> <span>Used</span></p>
	            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Interior</h1>
            </div>
          </div>
        </div>
      </div>
    </section>
  
    <section class="ftco-section">
      <div class="container">
        <div class="row">
          <div class="col-md-8 ftco-animate" style="flex: 0 0 100% !important; max-width: 100% !important;">
          	<div class="d-flex justify-content-between">
          		<h2 class="mb-3">${interiorBrd.intTitle}</h2>
          		<div class="d-flex align-self-center">
          			<span class="mr-4">${interiorBrd.intWriter}</span>
          			<i class="fas fa-clock align-self-center mr-2"></i>
          			<span>${interiorBrd.intRegDate}</span>
          			<c:choose>
          				<c:when test="${sessionScope.generation.generationIdx == interiorBrd.generationIdx}">
          					<div class="d-flex justify-content-end ml-4">
	          					<a href="/board/interior/intmodify?intPostNo=${interiorBrd.intPostNo}" class="mr-4"><i class="fas fa-pen" style="color: #666666;"></i></a>
				            	<a onclick="intDelete()" class="mr-4" style="cursor: pointer;"><i class="fas fa-trash" style="color: #666666;"></i></a>
				            	<a href="/board/interior/intlist" class="mr-4"><i class="fas fa-list-ul" style="color: #666666;"></i></a>
			            	</div>
          				</c:when>
          				<c:when test="${sessionScope.admin != null}">
          					<div class="d-flex justify-content-end ml-4">
	          					<a href="#" class="mr-4"><i class="fas fa-ban" style="color: #666666;"></i></a>
	          					<a href="/board/interior/intlist" class="mr-4"><i class="fas fa-list-ul" style="color: #666666;"></i></a>
          					</div>
          				</c:when>
          				<c:otherwise>
          					<div class="d-flex justify-content-end ml-4">
          						<a href="/board/interior/intlist" class="mr-4"><i class="fas fa-list-ul" style="color: #666666;"></i></a>
          					</div>
          				</c:otherwise>
          			</c:choose>
          			<%-- <div class="d-flex justify-content-end ml-4">
          				<a href="#" class="mr-4"><i class="fas fa-ban" style="color: #666666;"></i></a>
		            	<a href="/board/interior/intmodify?intPostNo=${interiorBrd.intPostNo}" class="mr-4"><i class="fas fa-pen" style="color: #666666;"></i></a>
		            	<a onclick="intDelete()" class="mr-4" style="cursor: pointer;"><i class="fas fa-trash" style="color: #666666;"></i></a>
		            	<a href="/board/interior/intlist" class="mr-4"><i class="fas fa-list-ul" style="color: #666666;"></i></a>
		            </div> --%>
          		</div>
          	</div>
          	<hr>
             ${interiorBrd.intContent}
            <div class="pt-5 mt-5">
              <h3 class="mb-5">${intCmtCnt} Comments</h3>
              <ul class="comment-list">
                <c:choose>
                	<c:when test="${intCmtCnt == 0}">
                		<li class="comment">작성된 댓글이 없습니다.</li>
                	</c:when>
                	<c:otherwise>
              			<c:forEach items="${intCmtList}" var="intCmt">
			                <li class="comment">
			                  	<div class="vcard bio">
			                      <img src="../../../../resources/abooimg/user.jpg" alt="Image placeholder">
			                    </div>
			                    <div class="comment-body">
			                      <h3>${intCmt.intCmtWriter}</h3>
			                      <div class="meta">${intCmt.intCmtRegDate}</div>
			                      <p>${intCmt.intCmtContent}</p>
			                      <c:choose>
			                      	<c:when test="${sessionScope.generation.generationIdx == intCmt.generationIdx}">
			                      		<p>
			                      		  <a href="#" class="mr-4"><i class="fas fa-pen" style="color: #666666;"></i></a>
					              		  <a href="intCmtDelete(${intCmt.intCmtNo})" class="mr-4"><i class="fas fa-trash" style="color: #666666;"></i></a>
			                      		</p>
			                      	</c:when>
			                      	<c:when test="${sessionScope.admin != null}">
			                      		<p>
			                      		  <a href="#" class="mr-4"><i class="fas fa-ban" style="color: #666666;"></i></a>
			                      		</p>
			                      	</c:when>
			                      </c:choose>
			                      <!-- <p>
			                      	<a href="#" class="mr-4"><i class="fas fa-ban" style="color: #666666;"></i></a>
					              	<a href="#" class="mr-4"><i class="fas fa-pen" style="color: #666666;"></i></a>
					              	<a href="#" class="mr-4"><i class="fas fa-trash" style="color: #666666;"></i></a>
			                      </p> -->
			                    </div>
			                </li>
		                </c:forEach>
                	</c:otherwise>
                </c:choose>
              </ul>
              <!-- END comment-list -->
              
              <div class="comment-form-wrap pt-5">
                <h3 class="mb-5">Leave a comment</h3>
                <form action="/board/interior/intcmtupload" method="post" enctype="multipart/form-data" class="p-5 bg-light">
                  <div class="form-group">
                    <label for="message">Message</label>
                    <input style="display: none;" name="generationIdx" value="${sessionScope.generation.generationIdx}">
                    <input style="display: none;" name="intPostNo" value="${interiorBrd.intPostNo}">
                    <textarea name="intCmtContent" id="intCmtContent" cols="30" rows="10" class="form-control"></textarea>
                  </div>
                  <div class="form-group">
                    <input type="submit" value="Post Comment" class="btn py-3 px-4 btn-primary">
                  </div>

                </form>
              </div>
            </div>

          </div> <!-- .col-md-8 -->

        </div>
      </div>
    </section> <!-- .section -->

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
  	let intDelete = () => {
  		let intPostNo = ${interiorBrd.intPostNo};
  		if(confirm("게시물을 삭제하시겠습니까?")){
  			fetch("/board/interior/intdelete?intPostNo=" + intPostNo,{
  	  			method:"GET"
  	  		})
  	  		.then(response => response.text())
  	  		.then(text => {
  	  			if(text == 'success'){
  	  				alert("게시물이 삭제되었습니다.");
					location.href = "/board/interior/intlist";
  	  			}else{
  	  				alert("게시물 삭제 중 에러가 발생했습니다.");
  	  				location.href = "/board/interior/intlist";
  	  			}
  	  		})
  		}else{
  			alert("취소되었습니다.");
  		}
  	}
  	
  	let intCmtDelete = (intCmtNo) => {
  		let intPostNo = ${interiorBrd.intPostNo};
  		if(confirm("댓글을 삭제하시겠습니까?")){
  			fetch("/board/interior/intcmtdelete?intCmtNo=" + intCmtNo,{
  				method:"GET"
  			})
  			.then(response => response.text())
  	  		.then(text => {
  	  			if(text == 'success'){
  	  				alert("댓글이 삭제되었습니다.");
					location.href = "/board/interior/intdetail?intPostNo=" + intPostNo;
  	  			}else{
  	  				alert("댓글 삭제 중 에러가 발생했습니다.");
  	  				location.href = "/board/interior/intdetail?intPostNo=" + intPostNo;
  	  			}
  	  		})
  		}else{
  			alert("취소되었습니다.");
  		}
  	}
  </script>
    
  </body>
</html>