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
        <a class="logo" href="dashboard.jsp"></a>

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
                
            <c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
			</c:if>
			<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
			</c:if>
                    <h2 class="text-center">Nova Receita</h2>
                    
                    <form class="login-form" method="GET" action="receita">
                        <div class="form-group">
                            <label class="text-uppercase">De onde Recebeu?</label>
                            <input type="text" class="form-control" name="nome">
                        </div>
                       
                        <div class="form-group">
                            <label class="text-uppercase">Valor</label>
                            <input type="number" step="0.01" class="form-control" name="valor">
                        </div>

                        <div class="form-group">
                            <label class="text-uppercase">Data</label>
                            <input type="date" class="form-control" name="data" >
                        </div> 

                        <div class="form-check ml-3">
                            <label class="text-uppercase">É Recorrente?</label>
                            <br>
                            <input type="radio" class="form-check-input" id="radio1" name="recorrente" value="sim" checked>
                            <label class="form-check-label text-uppercase" for="radio1">Sim</label>
                          </div>
                          <p>
                          <div class="form-check ml-3">
                            <input type="radio" class="form-check-input" id="radio2" name="recorrente" value="nao" >
                            <label class="form-check-label text-uppercase" for="radio2">Não</label>
                          </div>
                        <div class="form-check">
                            <input type="submit" class="btn btn-login " value="Cadastrar">
                        </div>
                        
                    </form>
                </div>
                
            </div>
        </div>
    </section>

</body>

<script  type="text/javascript"src="assets/jquary,js"></script>
<script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.js"></script>

</html>