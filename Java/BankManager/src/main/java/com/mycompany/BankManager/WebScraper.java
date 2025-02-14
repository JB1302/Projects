/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BankManager;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author jstev
 */
public class WebScraper {

    public void cambioDolar() {
        Document doc = null;

        try {
            doc = Jsoup.connect("https://www.google.com/search?client=firefox-b-d&q=Cambio+del+dolar+en+Costa+Rica").get();

            String title = doc.title(); //Obtener el titulo
            String[] partes = title.split("-"); //Recortar el texto sobrante
            String tituloCorregido = partes[0]; // Cargar la parte del texto que interesa

            // Seleccionar el span con la clase "fx-to"
            Elements spans = doc.select(".SwHCTb"); //Seleccionar el elemento necesario

            for (Element span : spans) { //Iterar el arreglo
                  JOptionPane.showMessageDialog(null,"[" + tituloCorregido + ": " + "₡ " + span.text() + "]"); //Imprimir el tipo de cambio
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
