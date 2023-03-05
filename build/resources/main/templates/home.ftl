<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrusel con Bootstrap</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css">
    <style>
        .carousel-item {
            height: 100vh;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>
</head>
<body>
<div class="container w-100 m-0 p-0">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner w-100 m-0 p-0">
            <div class="carousel-item active" style="background-image:url('https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg')"></div>
            <div class="carousel-item" style="background-image:url('https://escueladeposgrado.edu.pe/wp-content/uploads/2020/11/Importancia-de-los-Sistema-de-Informacion-en-una-empresa-scaled.jpg')"></div>
            <div class="carousel-item" style="background-image:url('https://escueladeposgrado.edu.pe/wp-content/uploads/2021/12/Ingenieri%CC%81adesistemasenmexico.jpg')"></div>
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
    <nav class="navbar fixed-bottom navbar-dark bg-dark">
        <button class="btn btn-primary">Ir a la siguiente página</button>
    </nav>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
