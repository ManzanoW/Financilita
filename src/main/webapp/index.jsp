<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Financilita | Facilidade Financeira</title>
    <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css"
    />
    <link rel="stylesheet" href="assets/css/index.css" />
    <script src="assets/js/scripts.js" defer></script>
</head>
<body>

  <header>
    <a class="logo" href="index.jsp"></a>
    
    <div>
      <input type="checkbox" name="change-theme" id="change-theme" />
      <label for="change-theme">
        <i class="bi bi-sun"></i>
        <i class="bi bi-moon"></i
      ></label>
    </div>
  </header>

  <section class="login-block">
    <div class="container">
	    <div class="row">
		    <div class="col-md-5 login-sec">
          <div class="login-logo">
            
          </div>
          	<c:if test="${empty user }">
		      <h2 class="text-center">Área Restrita</h2>
		      <span class="navbar-text text-danger" style="margin-right:10px" >
		      	${erro }	  	
		      </span>
		      <form class="login-form" action="login" method="post">
            <div class="form-group">
              <label class="text-uppercase">Email</label>
              <input type="text" name="email" class="form-control">
            </div>
            <div class="form-group">
              <label class="text-uppercase">Senha</label>
              <input type="password" name="password" class="form-control">
            </div>
            <div class="form-check">
              <button type="submit" class="btn btn-login mb-4">Entrar</button>
            </div>
          </form>
          </c:if>

          <div class="login-link">
            <div class="d-flex justify-content-center">
              Não possui conta? <a href="register.jsp" class="ml-2"> Registre-se!</a>
            </div>
            <div class="d-flex justify-content-center">
              Esqueceu a senha? <a href="forgot_password.jsp" class="ml-2"> Recuperar Agora!</a>
            </div>
          </div>

        </div>
		    <div class="col-md-7 banner-sec">
          <div class="banner-text">
            <p class="title">Um prazer te ver de novo</p>
            <h2>Bem-vindo(a) de volta!</h2>
            <p class="description mt-3">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation</p>
          </div>
        </div>
      </div>
    </div>
  </section>

</body>
</html>