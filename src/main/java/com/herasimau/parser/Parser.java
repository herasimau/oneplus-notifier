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

    /**
     * @return the stock quantity text
     */
    public String parse(){
        try {
            doc = Jsoup.connect(connectionUrl).get();
            Element element = doc.select("p.supply > span.status").get(0);
            return element.ownText();
        }

        catch(IOException e) {
            e.printStackTrace();
        }

     return null;
    }

}