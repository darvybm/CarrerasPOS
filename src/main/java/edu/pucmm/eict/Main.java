package edu.pucmm.eict;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.JavalinRenderer;
import io.javalin.rendering.template.JavalinThymeleaf;

public class Main {
    public static void main(String[] args) {
        JavalinRenderer.register(new JavalinThymeleaf(), ".html");
        Javalin app = Javalin.create().start(4000);
        app.cfg.staticFiles.add(staticFileConfig -> {
            staticFileConfig.hostedPath = "/";
            staticFileConfig.directory = "/public";
            staticFileConfig.location = Location.CLASSPATH;
        });
        app.get("/hello", ctx -> ctx.html("Hello World from Javalin!"));
        app.get("/", ctx -> ctx.redirect("/home.html"));

    }
}