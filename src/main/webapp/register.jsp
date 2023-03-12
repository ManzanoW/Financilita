<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">

<html lang="en">

<head>
    <!-- Required meta tags -->
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
    <link rel="stylesheet" href="assets/css/register.css" />
    <script src="assets/js/scripts.js" defer></script>
</head>

<body>

    <header>
        <a class="logo" href="index.jsp"></a>

        <div>
            <input type="checkbox" name="change-theme" id="change-theme" />
            <label for="change-theme">
                <i class="bi bi-sun"></i>
                <i class="bi bi-moon"></i></label>
        </div>
    </header>

    <section class="login-block">
        <div class="container">
            <div class="row">
                <div class="col-md-12 login-sec">
                    <div class="login-logo">

                    </div>
                    <c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
					
                    <form class="login-form" method="GET" action="cadastroconta" >
                    
                        <div class="form-group">
                            <label class="text-uppercase">Nome</label>
                            <input type="text" class="form-control" placeholder="" name="nomePessoa">
                        </div>
                        <div class="form-group">
                            <label class="text-uppercase">Nome do Usuário</label>
                            <input type="text" class="form-control" placeholder="" name="nomeUser">
                        </div>
                        <div class="form-group">
                            <label class="text-uppercase">Email</label>
                            <input type="email" class="form-control" placeholder="" name="email">
                        </div>
                        <div class="form-group">
                            <label class="text-uppercase">CPF</label>
                            <input type="text" class="form-control" placeholder="" name="cpf">
                        </div>
                        <div class="form-group">
                            <label class="text-uppercase">Senha</label>
                            <input type="password" class="form-control" placeholder="" name="senha">
                        </div>
                        <div class="form-check">
                            <input type="submit" class="btn btn-login mb-4" value="Cadastrar">
                        </div>
                    </form>

                    <div class="login-link">
                        <div class="d-flex justify-content-center">
                            Já possui uma conta? <a href="index.jsp" class="ml-2"> Entre agora!</a>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
    </section>

</body>
<script  type="text/javascript"src="assets/jquary,js"></script>
<script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.js"></script>
</html>