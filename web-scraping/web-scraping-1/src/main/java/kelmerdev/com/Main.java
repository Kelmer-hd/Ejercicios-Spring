package kelmerdev.com;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            // 2: Conectarse a la web
            String url = "https://books.toscrape.com";
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(5000)
                    .get();

            // 3: Extraer la información -> titulo h1
            Elements titulos = doc.select("h1");
            for (Element titulo : titulos){
                System.out.println("Titulo entontrado: " + titulo.text());
            }

            // 4. Extraer links
            Elements enlaces = doc.select("a[href]");
            for (Element enlace : enlaces) {
                System.out.println("Link: " + enlace.attr("href"));
                System.out.println("Texto: " + enlace.text());
            }

            // 5. Extraer datos de una tabla
            Elements filas = doc.select("table tr");
            for (Element fila : filas) {
                Elements columnas = fila.select("td");
                for (Element columna : columnas) {
                    System.out.print(columna.text() + "\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 6. Método para extraer datos específicos (ejemplo)
    public static void extraerProductos(String url) {
        try {
            Document doc = Jsoup.connect(url).get();

            // Ejemplo: extraer productos de una tienda online
            Elements productos = doc.select(".producto"); // Clase CSS del producto

            for (Element producto : productos) {
                String nombre = producto.select(".nombre").text();
                String precio = producto.select(".precio").text();
                String descripcion = producto.select(".descripcion").text();

                System.out.println("Producto: " + nombre);
                System.out.println("Precio: " + precio);
                System.out.println("Descripción: " + descripcion);
                System.out.println("-------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 7. Método para guardar los datos en un archivo
    public static void guardarDatos(String datos, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(datos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

