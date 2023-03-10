<!DOCTYPE html>
<html>
<head>
<title>Carreras</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/css/productoCard.css">
<link rel="stylesheet" type="text/css" href="/css/navbar.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    .navbar {
        box-shadow: 0 -10px 40px 0 rgba(0, 0, 0, 0.5);
    }
    .card {
        box-shadow: 0 0 20px rgba(0,10,0,1);
    }
</style>
</head>
<body style="background-color: #181818">

<!--Scrip para que pueda funcionar el desplegable de bootstrap-->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>

<nav class="navbar fixed-bottom py-3" style="background-color: #222222">
    <div class="container-fluid justify-content-end">
        <button class="btn p-3" type="button" style="background-color: #e7a801; font-size: 25px; font-weight: bolder; color: black; border-radius: 30px; font-family: 'Montserrat', sans-serif">Regresar</button>
    </div>
</nav>

<!--Banner para presentar la página (En este caso con temática de tienda de Manga)-->

<div class="bg-image text-center"
     style="background-image:linear-gradient(rgba(0,0,0,0.8),rgba(0,0,0,0.8)), url('https://www.pucmm.edu.do/noticias/PublishingImages/8-Open-House-10%20(1).jpg');
     box-shadow: 10px 10px 50px rgba(0,10,0,1);">
    <div class="py-4">
        <h1 class="display-2 fw-bold text-warning">I<span style="color:white;">CC</span></h1>
        <div class="col-lg-6 mx-auto">
            <p class="fs-5 mb-4 text-white">Elige la carrera que deseas y guardala contigo</p>
        </div>
    </div>
</div>
<!--Listado de productos (Mangas)-->

<div class="container-fluid bg-trasparent container-maxW"
     style="position: relative; padding: 0.5rem 1.2rem; margin-top: 2rem; margin-bottom: 10rem">
    <h1 class="fw-bold text-warning" style="margin-bottom: 20px">> C<span style="color:#DCDCDC;">arreras</span></h1>
    <div class="row row-cols-2 row-cols-xs-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-3">
        <#list datos as carrera>
            <div class="col">
                <div class="card", style="background-color: #202020">
                    <img src="${carrera.urlFoto}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title" style="color: #DCDCDC">${carrera.nombre}</h5>
                        <a class="btn" style="color: white; background-color: #e7a801; margin-top: 8px; width: 100%; padding: 5px">Seleccionar</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
</body>
</html>