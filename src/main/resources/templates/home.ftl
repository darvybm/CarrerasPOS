<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Carrusel de imágenes</title>
  <!-- Importar los estilos de Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <style>
    .navbar {
      box-shadow: 0 -50px 40px 0 rgba(231, 168, 1, 0.5);
    }
  </style>
</head>
<body>
<!-- Navbar -->
<nav class="navbar fixed-bottom py-3" style="background-color: #222222">
  <div class="container-fluid justify-content-end">
    <button class="btn p-3" type="button" style="background-color: #e7a801; font-size: 25px; font-weight: bolder; color: black; border-radius: 30px; font-family: 'Montserrat', sans-serif">Saca tu Factura Open House</button>
  </div>
</nav>

<!-- Carrusel -->
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner" sty>
    <div class="carousel-item active">
      <img class="d-block w-100" src="/images/slideIndex1.png" alt="Primera imagen">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="/images/slideIndex2.png" alt="Segunda imagen">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="/images/slideIndex3.png" alt="Tercera imagen">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Anterior</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Siguiente</span>
  </a>
</div>


<!-- Importar los scripts de jQuery y Bootstrap -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>