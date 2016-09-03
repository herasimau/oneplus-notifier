package com.herasimau.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * @author herasimau on 03.09.2016.
 */
public class Parser {

    //Connection url to check for stock update
    private  String connectionUrl = "https://oneplus.net/it/oneplus-x";

    private Document doc;

    public  boolean isOutOfStock(){
        try {
            doc = Jsoup.connect(connectionUrl).get();

            //search for "Out of stock" text in HTML page
            Element element = doc.select("p.supply > span.status").get(0);
            //return true if we have found "Out of stock" on the position class="supply" and class="status"
            return element.ownText().equals("Out of stock")?true:false;
        }

        catch(IOException e) {
            e.printStackTrace();
        }

     return true;
    }

}