import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TVShowsDatabase
{

    String baseUrl = "http://api.tvmaze.com/search/";

    public String getURLSource(URL url) throws Exception
    {
        // get the openStream
        InputStream in = url.openStream();
        // read the content
        return new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining("\n"));
    }


    public JsonObject getShowsByName(String name) throws Exception
    {
        //Getting the things ready to connect to the web
        URL url = new URL(baseUrl + "shows?q=" + name);
        String body = getURLSource(url);
        String result = "{\"result\": " + body + "}";
        // construct JsonObject from given string
        return Jsoner.deserialize(result, new JsonObject());
    }


    public JsonObject getPeopleInShows(String query) throws Exception
    {
        URL url = new URL(baseUrl + "people?q=" + query);

        /* TODO: Read the information coming from the web*/
        String body = getURLSource(url);
        String result = "{\"result\": " + body + "}";
        // construct JsonObject from given string
        return Jsoner.deserialize(result, new JsonObject());
    }


    public String formatShowAsString(JsonObject doc)
    {
        String results = "";
        JsonArray shows = (JsonArray) doc.get("result");
        for (Object o : shows) {
            JsonObject show = (JsonObject) o;
            results += "Name:" + ((JsonObject)show.get("show")).get("name") + "\n";
            results += "Link:" + ((JsonObject)show.get("show")).get("url") + "\n";
            results += "Premiered:" + show.get("premiered") + "\n";
            results += "Summary:" + show.get("summary") + "\n";
        }
        return results;
    }

    public void saveShows(String text, String outfile)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outfile)))
        {
            bw.write(text);
        } catch (IOException e) {e.printStackTrace();
            System.exit(-1);
        }
    }

}
