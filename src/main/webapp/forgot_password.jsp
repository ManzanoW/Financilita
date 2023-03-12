<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
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
                        <h2 class="text-center">Digite seu email:</h2>
                        <form class="login-form">
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Email">
                            </div>
                            <div class="form-check">
                                <button type="submit" class="btn btn-login mb-4">Enviar</button>
                            </div>
                        </form>
    
                        <div class="login-link">
                            <div class="d-flex justify-content-center">
                                Espere, eu me lembro da senha! <a href="index.jsp" class="ml-2"> Clique aqui</a>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
        </section>
</body>
</html>