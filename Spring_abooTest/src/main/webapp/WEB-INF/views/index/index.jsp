<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/generationhead.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<script src="https://threejs.org/build/three.min.js"></script>
	<style>
		#c {
		    width: 100%;
		    height: 100%;
		    display: block;
		    background: url(../../../resources/abooimg/인덱스_건물.png) no-repeat center center;
		    background-size: 50%;
		}
	</style>
</head>
<body>
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="/index">ABOO</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="/index" class="nav-link">Home</a></li>
	          <li class="nav-item"><a href="/about" class="nav-link">About</a></li>
	          <li class="nav-item"><a href="/myapt/schedule" class="nav-link">MyApt</a></li>
	          <li class="nav-item"><a class="nav-link" href="/board/info/listinfo">Board</a></li>
	          <li class="nav-item"><a href="/mypage/modifyinfo" class="nav-link">MyPage</a></li>
	          <c:choose>
		          <c:when test="${sessionScope.generation == null and sessionScope.admin == null}">
		          	<li class="nav-item cta"><a href="/login" class="nav-link"><span>Login</span></a></li>	          
		          </c:when>
		          <c:when test="${sessionScope.generation != null}">
		          	<li class="nav-item cta"><a href="/logout" class="nav-link"><span>Logout</span></a></li>	          
		          </c:when>
                  <c:when test="${sessionScope.admin != null}">
                    <li class="nav-item cta"><a href="/admin/logout" class="nav-link"><span>Logout</span></a></li>	
                  </c:when>		                    
	          </c:choose>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
    <div style="background: linear-gradient(45deg, #fb83b5 0%, #9a51ff 100%);">
    <canvas id="c" class="home-slider owl-carousel" style="height: 750px;"></canvas>
    </div>
    <!-- <section class="home-slider owl-carousel">
      <div class="slider-item" style="background-image: url(../../../resources/images/bg_1.jpg);">
        <div class="overlay"></div>
        <div class="container-fluid">
          <div class="row slider-text align-items-center" data-scrollax-parent="true">

            <div class="col-md-5 wrap col-sm-12 ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
              <h1 class="mb-4 mt-5" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Everything you get what you need to Host your website</h1>
              <p class="mb-4 mb-md-5 sub-p" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Up to 90% Discount with Free Domain Name Registration</p>
              <p><a href="/bdmin/contactus" class="btn btn-primary p-3 px-xl-5 py-xl-3">Get started</a> <a href="/about" class="btn btn-primary btn-primary-2 p-3 px-xl-5 py-xl-3">Read more</a></p>
            </div>
            <div class="col-md-6 ftco-animate">
            	<img src="../../../resources/abooimg/인덱스_건물.png" class="img-fluid" alt="">
            </div>

          </div>
        </div>
      </div>
    </section> -->
    
    <section class="ftco-section services-section bg-light">
      <div class="container">
      	<div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 text-center heading-section ftco-animate">
            <h2 class="mb-4">The WebHost Guarantee</h2>
            <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-guarantee"></span>
              	</div>
              </div>
              <div class="media-body p-2 mt-3">
                <h3 class="heading">100% Uptime Guarantee</h3>
                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              </div>
            </div>      
          </div>
          <div class="col-md-4 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-shield"></span>
              	</div>
              </div>
              <div class="media-body p-2 mt-3">
                <h3 class="heading">Safe and Secured</h3>
                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              </div>
            </div>    
          </div>
          <div class="col-md-4 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-support"></span>
              	</div>
              </div>
              <div class="media-body p-2 mt-3">
                <h3 class="heading">Our Dedicated Support</h3>
                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              </div>
            </div>      
          </div>
					<div class="col-md-4 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-cloud-computing"></span>
              	</div>
              </div>
              <div class="media-body p-2 mt-3">
                <h3 class="heading">Domain Transfer</h3>
                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              </div>
            </div>      
          </div>
          <div class="col-md-4 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-settings"></span>
              	</div>
              </div>
              <div class="media-body p-2 mt-3">
                <h3 class="heading">DNS Control</h3>
                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              </div>
            </div>    
          </div>
          <div class="col-md-4 d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services d-block text-center">
              <div class="d-flex justify-content-center">
              	<div class="icon d-flex align-items-center justify-content-center">
              		<span class="flaticon-loading"></span>
              	</div>
              </div>
              <div class="media-body p-2 mt-3">
                <h3 class="heading">Fast Loaded</h3>
                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              </div>
            </div>      
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section ftco-partner">
    	<div class="container">
    		<div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 text-center heading-section heading-section-white ftco-animate">
            <h2 class="mb-4">Our Clients</h2>
            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in</p>
          </div>
        </div>
    		<div class="row">
    			<div class="col-sm ftco-animate">
    				<a href="#" class="partner"><img src="../../../resources/images/partner-1.png" class="img-fluid" alt="Colorlib Template"></a>
    			</div>
    			<div class="col-sm ftco-animate">
    				<a href="#" class="partner"><img src="../../../resources/images/partner-2.png" class="img-fluid" alt="Colorlib Template"></a>
    			</div>
    			<div class="col-sm ftco-animate">
    				<a href="#" class="partner"><img src="../../../resources/images/partner-3.png" class="img-fluid" alt="Colorlib Template"></a>
    			</div>
    			<div class="col-sm ftco-animate">
    				<a href="#" class="partner"><img src="../../../resources/images/partner-4.png" class="img-fluid" alt="Colorlib Template"></a>
    			</div>
    			<div class="col-sm ftco-animate">
    				<a href="#" class="partner"><img src="../../../resources/images/partner-5.png" class="img-fluid" alt="Colorlib Template"></a>
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


  <script src="../../../resources/js/generation/jquery.min.js"></script>
  <script src="../../../resources/js/generation/jquery-migrate-3.0.1.min.js"></script>
  <script src="../../../resources/js/generation/popper.min.js"></script>
  <script src="../../../resources/js/generation/bootstrap.min.js"></script>
  <script src="../../../resources/js/generation/jquery.easing.1.3.js"></script>
  <script src="../../../resources/js/generation/jquery.waypoints.min.js"></script>
  <script src="../../../resources/js/generation/jquery.stellar.min.js"></script>
  <script src="../../../resources/js/generation/owl.carousel.min.js"></script>
  <script src="../../../resources/js/generation/jquery.magnific-popup.min.js"></script>
  <script src="../../../resources/js/generation/aos.js"></script>
  <script src="../../../resources/js/generation/jquery.animateNumber.min.js"></script>
  <script src="../../../resources/js/generation/bootstrap-datepicker.js"></script>
  <script src="../../../resources/js/generation/jquery.timepicker.min.js"></script>
  <script src="../../../resources/js/generation/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="../../../resources/js/generation/google-map.js"></script>
  <script src="../../../resources/js/generation/main.js"></script>
  <script type="text/javascript">
  	/* let middle = document.querySelector('#c');
  	const scene = new THREE.Scene();
  	scene.background = new THREE.Color("#fb83b5");
  	const camera = new THREE.PerspectiveCamera( 75, middle.clientWidth / middle.clientHeight, 0.1, 1000 );
	const renderer = new THREE.WebGLRenderer();
	renderer.setSize( middle.clientWidth, middle.clientHeight );
	middle.appendChild( renderer.domElement );
	
	const geometry = new THREE.BoxGeometry(); //기하학 도형 오브젝트 생성
	const material = new THREE.MeshBasicMaterial( { color: "yellow" } ); //오브젝트에 적용할 재질, MeshBasicMaterial은 2d느낌의 재질
	const cube = new THREE.Mesh( geometry, material ); //도형과 재질을 합쳐서 새로운 object 생성
	//cube.position.set(5,5,-5);
	scene.add( cube ); //무대에 추가
	camera.position.z = 5;
	
	//화면 랜더링
	function animate() {
		requestAnimationFrame( animate );
		cube.rotation.x += 0.01;
		cube.rotation.y += 0.01;
		renderer.render( scene, camera );	
	}
	animate(); */
	
	function main() {
	      const canvas = document.querySelector('#c');
	      const renderer = new THREE.WebGLRenderer({
	        canvas,
	        alpha: true,
	      });

	      const fov = 75;
	      const aspect = 2;  // the canvas default
	      const near = 0.1;
	      const far = 5;
	      const camera = new THREE.PerspectiveCamera(fov, aspect, near, far);
	      camera.position.z = 2;

	      const scene = new THREE.Scene();

	      {
	        const color = 0xFFFFFF;
	        const intensity = 1;
	        const light = new THREE.DirectionalLight(color, intensity);
	        light.position.set(-1, 2, 4);
	        scene.add(light);
	      }

	      const boxWidth = 1;
	      const boxHeight = 1;
	      const boxDepth = 1;
	      const geometry = new THREE.BoxGeometry(boxWidth, boxHeight, boxDepth);

	      function makeInstance(geometry, color, x) {
	        const material = new THREE.MeshPhongMaterial({ color });

	        const cube = new THREE.Mesh(geometry, material);
	        scene.add(cube);

	        cube.position.x = x;

	        return cube;
	      }

	      const cubes = [
	        makeInstance(geometry, 0x44aa88, 0),
	        makeInstance(geometry, 0x8844aa, -2),
	        makeInstance(geometry, 0xaa8844, 2),
	      ];

	      function resizeRendererToDisplaySize(renderer) {
	        const canvas = renderer.domElement;
	        const width = canvas.clientWidth;
	        const height = canvas.clientHeight;
	        const needResize = canvas.width !== width || canvas.height !== height;
	        if (needResize) {
	          renderer.setSize(width, height, false);
	        }
	        return needResize;
	      }

	      function render(time) {
	        time *= 0.001;

	        if (resizeRendererToDisplaySize(renderer)) {
	          const canvas = renderer.domElement;
	          camera.aspect = canvas.clientWidth / canvas.clientHeight;
	          camera.updateProjectionMatrix();
	        }

	        cubes.forEach((cube, ndx) => {
	          const speed = 1 + ndx * .1;
	          const rot = time * speed;
	          cube.rotation.x = rot;
	          cube.rotation.y = rot;
	        });

	        renderer.render(scene, camera);

	        requestAnimationFrame(render);
	      }

	      requestAnimationFrame(render);
	    }

	    main();
  </script>
    
</body>
</html>