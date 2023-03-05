package edu.pucmm.eict;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.JavalinRenderer;
import io.javalin.rendering.template.JavalinFreemarker;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        JavalinRenderer.register(new JavalinFreemarker(), ".ftl");
        var app = Javalin.create(javalinConfig -> {
            javalinConfig.staticFiles.add(staticFileConfig -> {
                staticFileConfig.hostedPath = "/";
                staticFileConfig.directory = "/publico";
                staticFileConfig.location = Location.CLASSPATH;
            });
        }).start(7006);

        app.get("/", ctx -> {
            ctx.render("templates/home.ftl");
        });
    }
}