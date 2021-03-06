<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String ctx = request.getContextPath();
%>
<html>
<head>
<!-- Basic Page Needs -->
<meta charset="utf-8">
<title>CGS - Contact</title>
<meta name="description" content="A Template by Gozha.net">
<meta name="keywords" content="HTML, CSS, JavaScript">
<meta name="author" content="Gozha.net">

<!-- Mobile Specific Metas-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta content="telephone=no" name="format-detection">

<!-- icon -->
<link rel="shortcut icon" type="image/x-icon"
	href="<%=ctx%>/resources/css/img/favicon.png" />

<!-- Fonts -->
<!-- Font awesome - icon font -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
<!-- Roboto -->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,700'
	rel='stylesheet' type='text/css'>
<!-- Open Sans -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:800italic'
	rel='stylesheet' type='text/css'>

<!-- Stylesheets -->

<!-- Mobile menu -->
<link href="<%=ctx%>/resources/css/gozha-nav.css" rel="stylesheet" />
<!-- Select -->
<link href="<%=ctx%>/resources/css/external/jquery.selectbox.css"
	rel="stylesheet" />

<!-- REVOLUTION BANNER CSS SETTINGS -->
<!-- <link rel="stylesheet" type="text/css" -->
<%-- 	href="<%=ctx%>/resources/rs-plugin/css/settings.css" media="screen" /> --%>

<!-- Custom -->
<link href="<%=ctx%>/resources/css/style.css?v=1" rel="stylesheet" />


<!-- Modernizr -->
<script src="<%=ctx%>/resources/js/external/modernizr.custom.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]> 
    	<script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7/html5shiv.js"></script> 
		<script src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.3.0/respond.js"></script>		
    <![endif]-->
<style>
section.container {
    height: 400px;
}
</style>
</head>

	<body>
   

        <!-- Header section -->
        <jsp:include page="menu.jsp" flush="false"/>
        
     
        
        <!-- Main content -->
        <section class="container">
            <h2 class="page-heading heading--outcontainer">Contact</h2>
            <div class="contact">
                <p class="contact__title">CGS에 대한 문의사항이 있으면  <br><br>아래 연락처로 연락 주시기 바랍니다<br/></p>
                <span class="contact__mail">support@cinemags.com</span>
                <span class="contact__tel">032-808-8080</span>
            </div>
        </section>

        <div class="contact-form-wrapper">
            <div class="container">
                <div class="col-sm-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
                    <form id='contact-form' class="form row" method='post' novalidate="" action="send.php">
                        <p class="form__title">고객님의 말씀을 듣겠습니다.</p>
                        <div class="col-sm-6">
                            <input type='text' placeholder='이름을 적어주세요' name='user-name' class="form__name">
                        </div>
                        <div class="col-sm-6">
                            <input type='email' placeholder='메일 주소를 적어주세요' name='user-email' class="form__mail">
                        </div>
                        <div class="col-sm-12">
                            <textarea placeholder="문의사항/건의사항을 적어주세요" name="user-message" class="form__message"></textarea>
                        </div>
                        <button type="submit" class='btn btn-md btn--danger'>문의하기</button>
                       
                    </form>
                </div>
            </div>
        </div>
        
		<jsp:include page="footer.jsp"></jsp:include>


    <!-- open/close -->
        <div class="overlay overlay-hugeinc">
            
            <section class="container" style="height:45%">

                <div class="col-sm-4 col-sm-offset-4">
                    <button type="button" class="overlay-close">Close</button>
                    <form id="login-form" class="login" method='get' novalidate=''>
                        <p class="login__title">sign in <br><span class="login-edition">welcome to A.Movie</span></p>

                        <div class="social social--colored">
                                <a href='#' class="social__variant fa fa-facebook"></a>
                                <a href='#' class="social__variant fa fa-twitter"></a>
                                <a href='#' class="social__variant fa fa-tumblr"></a>
                        </div>

                        <p class="login__tracker">or</p>
                        
                        <div class="field-wrap">
                        <input type='email' placeholder='Email' name='user-email' class="login__input">
                        <input type='password' placeholder='Password' name='user-password' class="login__input">

                        <input type='checkbox' id='#informed' class='login__check styled'>
                        <label for='#informed' class='login__check-info'>remember me</label>
                         </div>
                        
                        <div class="login__control">
                            <button type='submit' class="btn btn-md btn--warning btn--wider">sign in</button>
                            <a href="#" class="login__tracker form__tracker">Forgot password?</a>
                        </div>
                    </form>
                </div>

            </section>
        </div>

	<!-- JavaScript-->
        <!-- jQuery 1.9.1--> 
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/external/jquery-1.10.1.min.js"><\/script>')</script>
        <!-- Migrate --> 
        <script src="<%=ctx%>/resources/js/external/jquery-migrate-1.2.1.min.js"></script>
        <!-- Bootstrap 3--> 
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>

        <!-- Mobile menu -->
        <script src="<%=ctx%>/resources/js/jquery.mobile.menu.js"></script>
         <!-- Select -->
        <script src="<%=ctx%>/resources/js/external/jquery.selectbox-0.2.min.js"></script>

        <!--*** Google map  ***-->
        <script src="https://maps.google.com/maps/api/js?sensor=true"></script> 
        <!--*** Google map infobox  ***-->
        <script src="<%=ctx%>/resources/js/external/infobox.js"></script>

        <!-- Form element -->
        <script src="<%=ctx%>/resources/js/external/form-element.js"></script>
        <!-- Form validation -->
        <script src="<%=ctx%>/resources/js/form.js"></script>

        <!-- Custom -->
        <script src="<%=ctx%>/resources/js/custom.js"></script> 
		
		<script type="text/javascript">
            $(document).ready(function() {
                init_Contact ();
            });
		</script>

</body>
</html>
