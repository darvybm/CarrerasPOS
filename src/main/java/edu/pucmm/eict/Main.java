package edu.pucmm.eict;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.JavalinRenderer;
import io.javalin.rendering.template.JavalinThymeleaf;

import java.awt.*;
import java.awt.print.*;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
        Javalin app = Javalin.create().start(9000);
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
//            estudiante.setCarrera("NULL TODAVIA");

            JSONObject json = new JSONObject();
            json.put("id", estudiante.getId());
            json.put("nombre", estudiante.getNombre());
            json.put("edad", estudiante.getEdad());
            json.put("sexo", estudiante.getSexo());
            json.put("provincia", estudiante.getProvincia());
            json.put("carrera", estudiante.getCarrera());

            JSONArray jsonArray = new JSONArray();
            jsonArray.put(json);

            String jsonString = jsonArray.toString();

            enviarPowerBI(jsonString, url);
            estudiantes.add(estudiante);

            // Imprimir la factura en una impresora
            PrinterJob printerJob = PrinterJob.getPrinterJob();
            Printable printable = new StringPrintable(estudiante.generarBoleto());
            printerJob.setPrintable(printable);

            try {
                printerJob.print();
                System.out.println("Imprimió");
            } catch (PrinterException e) {
                e.printStackTrace();
            }

            try (PrintWriter writer = new PrintWriter(new File("imprimir.txt"))) {
                // Escribir el string formateado en el archivo
                writer.write(estudiante.generarBoleto());

            } catch (FileNotFoundException e) {
                System.out.println("El archivo no se pudo crear.");
                e.printStackTrace();
            }

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

    private static class StringPrintable implements Printable {
        private String string;
        public StringPrintable(String string) {
            this.string = string;
        }
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            graphics.drawString(string, 100, 100);
            return Printable.PAGE_EXISTS;
        }
    }
}