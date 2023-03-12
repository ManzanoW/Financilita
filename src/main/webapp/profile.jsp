<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
  <!-- Required meta tags -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Financilita | Facilidade Financeira</title>
  <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css" />
  <link rel="stylesheet" href="assets/css/profile.css" />
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

  <section>
  <div class="card">
    <div class="card-header">
      <h5 class="title">Editar Perfil</h5>
    </div>
    <div class="card-body">
      <form>
        <div class="row">
          <div class="col-md-5 pr-md-1">
            <div class="form-group">
              <label>Apelido</label>
              <input type="text" class="form-control" placeholder="Seu Apelido" >
            </div>
          </div>
          <div class="col-md-3 px-md-1">
            <div class="form-group">
              <label>Usu�rio</label>
              <input type="text" class="form-control" placeholder="Seu Usu�rio" value="">
            </div>
          </div>
          <div class="col-md-4 pl-md-1">
            <div class="form-group">
              <label for="exampleInputEmail1">Endere�o de Email</label>
              <input type="email" class="form-control" placeholder="Seu Email">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 pr-md-1">
            <div class="form-group">
              <label>Primeiro nome</label>
              <input type="text" class="form-control" placeholder="Seu Nome" value="">
            </div>
          </div>
          <div class="col-md-6 pl-md-1">
            <div class="form-group">
              <label>Sobrenome</label>
              <input type="text" class="form-control" placeholder="Seu Sobrenome" value="">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <div class="form-group">
              <label>Endere�o</label>
              <input type="text" class="form-control" placeholder="Seu Endere�o" value="">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4 pr-md-1">
            <div class="form-group">
              <label>Cidade</label>
              <input type="text" class="form-control" placeholder="Sua Cidade" value="">
            </div>
          </div>
          <div class="col-md-4 px-md-1">
            <div class="form-group">
              <label>Pa�s</label>
              <input type="text" class="form-control" placeholder="Seu Pa�s" value="">
            </div>
          </div>
          <div class="col-md-4 pl-md-1">
            <div class="form-group">
              <label>CEP</label>
              <input type="text" class="form-control" placeholder="Seu CEP" maxLength="9">
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-8">
            <div class="form-group">
              <label>Sobre mim</label>
              <textarea rows="4" cols="80" class="form-control" placeholder="Coloque sua descri��o aqui :)"
                value="Mike"></textarea>
            </div>
          </div>
        </div>
      </form>
    </div>
    <div class="form-check">
      <button type="submit" class="btn btn-login mb-4" href="">Concluir</button>
    </div>
  </section>
</body>

</html>