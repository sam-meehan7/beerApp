package com.example.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BeerController {

  @Autowired
  private GetBeerService getBeerService;

  // @RequestMapping("/") displays the return value to "localhost:8080"

  @RequestMapping("/")
  public ModelAndView beerHome() {
    ModelAndView view = new ModelAndView();
    view.addObject("beerName", getBeerService.getBeerData().get("beerName"));
    view.addObject("beerDescription", getBeerService.getBeerData().get("beerDescription"));
    view.addObject("beerShortName", getBeerService.getBeerData().get("beerShortName"));
    view.addObject("breweryName", getBeerService.getBeerData().get("breweryName"));
    view.setViewName("home");
    return view;
  }

}