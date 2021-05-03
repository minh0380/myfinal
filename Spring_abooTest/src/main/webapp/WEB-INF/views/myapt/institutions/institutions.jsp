<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/generationhead.jsp" %>
<!DOCTYPE html>
<head>
	<!-- kakao developers에서 웹 플랫폼 url 꼭 수정하기!! -->
	<style>
		.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
		.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
		.map_wrap {position:relative;width:100%;height:500px;}
		#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
		.bg_white {background:#fff;}
		#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
		#menu_wrap .option{text-align: center;}
		#menu_wrap .option p {margin:10px 0;}  
		#menu_wrap .option button {margin-left:5px;}
		#placesList li {list-style: none;}
		#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
		#placesList .item span {display: block;margin-top:4px;}
		#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
		#placesList .item .info{padding:10px 0 10px 55px;}
		#placesList .info .gray {color:#8a8a8a;}
		#placesList .info .jibun {padding-left:26px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
		#placesList .info .tel {color:#009900;}
		#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
		#placesList .item .marker_1 {background-position: 0 -10px;}
		#placesList .item .marker_2 {background-position: 0 -56px;}
		#placesList .item .marker_3 {background-position: 0 -102px}
		#placesList .item .marker_4 {background-position: 0 -148px;}
		#placesList .item .marker_5 {background-position: 0 -194px;}
		#placesList .item .marker_6 {background-position: 0 -240px;}
		#placesList .item .marker_7 {background-position: 0 -286px;}
		#placesList .item .marker_8 {background-position: 0 -332px;}
		#placesList .item .marker_9 {background-position: 0 -378px;}
		#placesList .item .marker_10 {background-position: 0 -423px;}
		#placesList .item .marker_11 {background-position: 0 -470px;}
		#placesList .item .marker_12 {background-position: 0 -516px;}
		#placesList .item .marker_13 {background-position: 0 -562px;}
		#placesList .item .marker_14 {background-position: 0 -608px;}
		#placesList .item .marker_15 {background-position: 0 -654px;}
		#pagination {margin:10px auto;text-align: center;}
		#pagination a {display:inline-block;margin-right:10px;}
		#pagination .on {font-weight: bold; cursor: default;color:#777;}
	</style>
</head>
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
	          <c:when test="${sessionScope.generation == null and sessionScope.admin == null}">
	          <li class="nav-item cta"><a href="/login" class="nav-link"><span>Login</span></a></li>	          
	          </c:when>
	          <c:when test="${sessionScope.generation != null or sessionScope.admin != null}">
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
              <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index.html">Parking</a></span> <span class="mr-2">Schedule</span> <span>Vote</span></p>
	            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Institution</h1>
            </div>
          </div>
        </div>
      </div>
    </section>
  
    <section class="ftco-section contact-section ftco-degree-bg">
      <div class="container">
        <div class="row d-flex mb-5 contact-info">
          <div class="col-md-12 mb-4">
            <h2 class="h4">아파트 주변 공공기관</h2>
          </div>
          <div class="w-100"></div>
        <div class="w-100 d-flex">
          <div class="col-md-6">
            <div class="col-md-12" id="map"></div>
          </div>
          <div class="col-md-6 d-flex justify-content-center">
            <div class="tab-pane fade show active" id="v-pills-whatwedo" role="tabpanel" aria-labelledby="v-pills-whatwedo-tab">
	            <div id="menu_wrap" class="bg_white w-100 h-100">
			        <ul id="placesList"></ul>
			        <div id="pagination"></div>
			    </div>
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
                <li><a href="/bdmin/contactus" class="py-2 d-block">Contact us</a></li>
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
  <!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script> -->
  <!-- <script src="../../../../resources/js/generation/google-map.js"></script> -->
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=&libraries=services,clusterer,drawing"></script>
  <script src="../../../../resources/js/generation/main.js"></script>
  
  <script type="text/javascript">
	  //마커를 담을 배열입니다
	  var markers = [];
	
	  var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	      mapOption = {
	          center: new kakao.maps.LatLng(${apt.apartmentLat}, ${apt.apartmentLng}), // 지도의 중심좌표
	          level: 1 // 지도의 확대 레벨
	      };  
	
	  // 지도를 생성합니다    
	  var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	  // 장소 검색 객체를 생성합니다
	  var ps = new kakao.maps.services.Places();  
	
	  // 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
	  var infowindow = new kakao.maps.InfoWindow({zIndex:1});
	
	  // 키워드로 장소를 검색합니다
	  searchPlaces();
	
	  // 키워드 검색을 요청하는 함수입니다
	  function searchPlaces() {
	
	      var keyword = "${apt.apartmentAddress}" + "공공기관";
	
	      if (!keyword.replace(/^\s+|\s+$/g, '')) {
	          alert('키워드를 입력해주세요!');
	          return false;
	      }
	
	      // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
	      ps.keywordSearch( keyword, placesSearchCB); 
	  }
	
	  // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
	  function placesSearchCB(data, status, pagination) {
	      if (status === kakao.maps.services.Status.OK) {
	
	          // 정상적으로 검색이 완료됐으면
	          // 검색 목록과 마커를 표출합니다
	          displayPlaces(data);
	
	          // 페이지 번호를 표출합니다
	          displayPagination(pagination);
	
	      } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
	
	          alert('검색 결과가 존재하지 않습니다.');
	          return;
	
	      } else if (status === kakao.maps.services.Status.ERROR) {
	
	          alert('검색 결과 중 오류가 발생했습니다.');
	          return;
	
	      }
	  }
	
	  // 검색 결과 목록과 마커를 표출하는 함수입니다
	  function displayPlaces(places) {
	
	      var listEl = document.getElementById('placesList'), 
	      menuEl = document.getElementById('menu_wrap'),
	      fragment = document.createDocumentFragment(), 
	      bounds = new kakao.maps.LatLngBounds(), 
	      listStr = '';
	      
	      // 검색 결과 목록에 추가된 항목들을 제거합니다
	      removeAllChildNods(listEl);
	
	      // 지도에 표시되고 있는 마커를 제거합니다
	      removeMarker();
	      
	      for ( var i=0; i<places.length; i++ ) {
	
	          // 마커를 생성하고 지도에 표시합니다
	          var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
	              marker = addMarker(placePosition, i), 
	              itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다
	
	          // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
	          // LatLngBounds 객체에 좌표를 추가합니다
	          bounds.extend(placePosition);
	
	          // 마커와 검색결과 항목에 mouseover 했을때
	          // 해당 장소에 인포윈도우에 장소명을 표시합니다
	          // mouseout 했을 때는 인포윈도우를 닫습니다
	          (function(marker, title) {
	              kakao.maps.event.addListener(marker, 'mouseover', function() {
	                  displayInfowindow(marker, title);
	              });
	
	              kakao.maps.event.addListener(marker, 'mouseout', function() {
	                  infowindow.close();
	              });
	
	              itemEl.onmouseover =  function () {
	                  displayInfowindow(marker, title);
	              };
	
	              itemEl.onmouseout =  function () {
	                  infowindow.close();
	              };
	          })(marker, places[i].place_name);
	
	          fragment.appendChild(itemEl);
	      }
	
	      // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
	      listEl.appendChild(fragment);
	      menuEl.scrollTop = 0;
	
	      // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
	      map.setBounds(bounds);
	  }
	
	  // 검색결과 항목을 Element로 반환하는 함수입니다
	  function getListItem(index, places) {
	
	      var el = document.createElement('li'),
	      itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
	                  '<div class="info">' +
	                  '   <h5>' + places.place_name + '</h5>';
	
	      if (places.road_address_name) {
	          itemStr += '    <span>' + places.road_address_name + '</span>' +
	                      '   <span class="jibun gray">' +  places.address_name  + '</span>';
	      } else {
	          itemStr += '    <span>' +  places.address_name  + '</span>'; 
	      }
	                   
	        itemStr += '  <span class="tel">' + places.phone  + '</span>' +
	                  '</div>';           
	
	      el.innerHTML = itemStr;
	      el.className = 'item';
	
	      return el;
	  }
	
	  // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
	  function addMarker(position, idx, title) {
	      var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
	          imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
	          imgOptions =  {
	              spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
	              spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
	              offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
	          },
	          markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
	              marker = new kakao.maps.Marker({
	              position: position, // 마커의 위치
	              image: markerImage 
	          });
	
	      marker.setMap(map); // 지도 위에 마커를 표출합니다
	      markers.push(marker);  // 배열에 생성된 마커를 추가합니다
	
	      return marker;
	  }
	
	  // 지도 위에 표시되고 있는 마커를 모두 제거합니다
	  function removeMarker() {
	      for ( var i = 0; i < markers.length; i++ ) {
	          markers[i].setMap(null);
	      }   
	      markers = [];
	  }
	
	  // 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
	  function displayPagination(pagination) {
	      var paginationEl = document.getElementById('pagination'),
	          fragment = document.createDocumentFragment(),
	          i; 
	
	      // 기존에 추가된 페이지번호를 삭제합니다
	      while (paginationEl.hasChildNodes()) {
	          paginationEl.removeChild (paginationEl.lastChild);
	      }
	
	      for (i=1; i<=pagination.last; i++) {
	          var el = document.createElement('a');
	          el.href = "#";
	          el.innerHTML = i;
	
	          if (i===pagination.current) {
	              el.className = 'on';
	          } else {
	              el.onclick = (function(i) {
	                  return function() {
	                      pagination.gotoPage(i);
	                  }
	              })(i);
	          }
	
	          fragment.appendChild(el);
	      }
	      paginationEl.appendChild(fragment);
	  }
	
	  // 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
	  // 인포윈도우에 장소명을 표시합니다
	  function displayInfowindow(marker, title) {
	      var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';
	
	      infowindow.setContent(content);
	      infowindow.open(map, marker);
	  }
	
	   // 검색결과 목록의 자식 Element를 제거하는 함수입니다
	  function removeAllChildNods(el) {   
	      while (el.hasChildNodes()) {
	          el.removeChild (el.lastChild);
	      }
	  }
  </script>
  </body>
</html>