package com.example.webapp;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BeerApi {

  @Autowired
  private GetBeerService getBeerService;

  @GetMapping(path = "/beer", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity < Object > getBeerDetails() {

    List < JSONObject > beerEntities = new ArrayList<>();

    JSONObject beerEntity = new JSONObject();

    for (Map.Entry < String, String > entry: getBeerService.getBeerData().entrySet()) {
      beerEntity.put(entry.getKey(), entry.getValue());
    }

    beerEntities.add(beerEntity);

    return new ResponseEntity<>(beerEntities, HttpStatus.OK);
  }
}