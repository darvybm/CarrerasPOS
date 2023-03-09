package edu.pucmm.eict;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.JavalinRenderer;
import io.javalin.rendering.template.JavalinThymeleaf;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Main {
    public static void main(String[] args) {
        String url = "https://api.powerbi.com/beta/4017af08-a2e1-4daa-9180-5b3bc8ee84fa/datasets/c04cf1c6-7e64-4a30-8856-bcd7a31ae80c/rows?language=en-us&disableBranding=1&authComplete=true&key=Ttp74qaF3h6a9vlAj4qigN0nFqTLQhK4wX7YGGTb0ClLHyEPCiRdAjxk%2BrsMUge4brC%2F0xygqsdIP%2FN7uDig1w%3D%3D";
        List<Estudiante> estudiantes = new ArrayList<>();

        JavalinRenderer.register(new JavalinThymeleaf(), ".html");
        Javalin app = Javalin.create().start(4000);
        app.cfg.staticFiles.add(staticFileConfig -> {
            staticFileConfig.hostedPath = "/";
            staticFileConfig.directory = "/public";
            staticFileConfig.location = Location.CLASSPATH;
        });
        app.get("/", ctx -> ctx.redirect("/templates/home.html"));

        app.post("/registrarCarrera", ctx -> {
           String carrera = ctx.formParam("carrera");
           String nombre = ctx.formParam("nombre");
           String sexo = ctx.formParam("sexo");
           String provincia = ctx.formParam("provincia");
           int edad = ctx.formParamAsClass("edad", Integer.class).get();

            Estudiante estudiante = new Estudiante(nombre,sexo,edad,provincia,carrera);
            JSONObject json = new JSONObject();
            json.put("id", estudiante.getId());
            json.put("nombre", estudiante.getNombre());
            json.put("edad", estudiante.getEdad());
            json.put("sexo", estudiante.getSexo());
            json.put("provincia", estudiante.getProvincia());
//            json.put("carrera", estudiante.getCarrera());
            json.put("carrera", "prueba (NULL)");

            JSONArray jsonArray = new JSONArray();
            jsonArray.put(json);

            String jsonString = jsonArray.toString();

            enviarPowerBI(jsonString, url);
            estudiantes.add(estudiante);
            ctx.redirect("/");
        });

    }

    private static void enviarPowerBI(String json, String urlPoweBi) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            HttpPost httpPost = new HttpPost(urlPoweBi);

            httpPost.setHeader("Content-type", "application/json");
            System.out.println(json);
            httpPost.setEntity(new StringEntity(json, StandardCharsets.UTF_8));

            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseString);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            httpClient.close();
        }

    }
}