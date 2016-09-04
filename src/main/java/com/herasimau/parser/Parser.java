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
    private final static String CONNECTION_URL = "https://oneplus.net/it/oneplus-x";

    private Document doc;

    /**
     * @return the stock quantity text
     */
    public String parse() throws Exception {
        try {
            doc = Jsoup.connect(CONNECTION_URL).get();
            Element element = doc.select("p.supply > span.status").get(0);
            return element.ownText();
        }

        catch(IOException e) {
            e.printStackTrace();
        }

     throw new Exception("Parse failed");
    }

}