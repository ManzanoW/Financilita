<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Financilita | Facilidade Financeira</title>
  <link rel="shortcut icon" href="assets/img/favicon.png" type="image/x-icon">

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css" />
  <link rel="stylesheet" href="assets/css/Card.css" />
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
      <div class="card-body">
        <div class="container mt-3">
          <h2>Selecione a operadora do cart�o:</h2>

          <div class="form-check mt-4">
            <input type="radio" class="form-check-input" id="radio1" name="optradio" value="mastercard" checked>
            <label class="form-check-label" for="radio1">MASTERCARD</label>
          </div>
          <p>
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio2" name="optradio" value="visa" >
            <label class="form-check-label" for="radio2">VISA</label>
          </div>
          <p>
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio3" name="optradio" value="elo" >
            <label class="form-check-label" for="radio3">ELO</label>
          </div>
          <p>
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio4" name="optradio" value="americanExpress" >
            <label class="form-check-label" for="radio4">AMERICAN EXPRESS</label>
          </div>
          <p>
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio5" name="optradio" value="hipercard" >
            <label class="form-check-label" for="radio5">HIPERCARD</label>
          </div>
          <br>
          <form>
            <div class="row">
              <div class="col">
                <input type="text" class="form-control" placeholder="4 �ltimos n�meros do cart�o" maxlength="16">
              </div>
              <div class="col">
                <input type="text" class="form-control" placeholder="Nome no cart�o" name="nome">
              </div>
            </div>
          </form>
          <br>
          <br>

          <div class="form-check">
            <button type="submit" class="btn btn-login mb-4" href="dashboard.html">Entrar</button>
          </div>
        </div>
        </form>
        <br>
        <br>


        </form>
      </div>







    </div>


    </div>
  </section>

</body>

</html>