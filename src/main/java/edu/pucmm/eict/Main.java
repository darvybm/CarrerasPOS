package edu.pucmm.eict;

import edu.pucmm.eict.modelos.Carrera;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.JavalinRenderer;
import io.javalin.rendering.template.JavalinFreemarker;
import io.javalin.rendering.template.JavalinThymeleaf;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Creando las carreras
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));
        CarritoPos.getInstance().addCarrera(new Carrera("Ingenieria en ciencias de la Computacion", "https://www.emagister.com/blog/wp-content/uploads/2019/04/GettyImages-1146417905.jpg"));



        JavalinRenderer.register(new JavalinFreemarker(), ".ftl");
        Javalin app = Javalin.create().start(7003);
        app.cfg.staticFiles.add(staticFileConfig -> {
            staticFileConfig.hostedPath = "/";
            staticFileConfig.directory = "/public";
            staticFileConfig.location = Location.CLASSPATH;
        });
        //app.get("/", ctx -> ctx.render("templates/home.ftl"));
        app.get("/", ctx -> ctx.redirect("/carreras"));
        app.get("/carreras", ctx -> {
            Map<String, Object> modelo = new HashMap<>();
            modelo.put("datos", CarritoPos.getInstance().getCarreras());
            ctx.render("/templates/carreras.ftl", modelo);
        });

    }
}