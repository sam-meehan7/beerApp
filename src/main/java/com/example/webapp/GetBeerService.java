package com.example.webapp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Service
public class GetBeerService {

  public Map < String, String > getBeerData() {

    Map < String, String > beerMap = null;

    JSONParser parse = new JSONParser();

    try {
      Map<String, String> beerData = new HashMap<>();
      URL url = new URL("https://api.brewerydb.com/v2/beer/random/?withBreweries=Y&hasLabels=Y&key=a5c1b917e7ba62dcd79f434ed73bc72d");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();

      int responsecode = conn.getResponseCode();

      if (responsecode != 200) {
        throw new RuntimeException("HttpResponseCode: " + responsecode);
      } else {

        String inline = "";
        Scanner scanner = new Scanner(url.openStream());

        //Write all the JSON data into a string using a scanner
        while (scanner.hasNext()) {
          inline += scanner.nextLine();
        }
        scanner.close();

        //Using the JSON simple library parse the string into a json object
        JSONObject data_obj = (JSONObject) parse.parse(inline);
        JSONObject obj = (JSONObject) data_obj.get("data");
        JSONObject style = (JSONObject) obj.get("style");
        JSONArray brew = (JSONArray) obj.get("breweries");


        beerData.put("beerName", style.get("name").toString());
        beerData.put("beerDescription", style.get("description").toString());
        beerData.put("beerShortName", style.get("shortName").toString());


        for (Object o : brew) {
          JSONObject new_obj = (JSONObject) o;
          beerData.put("breweryName", new_obj.get("name").toString());
        }

        beerMap = beerData;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return beerMap;
  }
}