# This application is a Spring based app which fetches data from an external API.

I use a service class and a GET request to fetch and return the data in its entirety from the chosen API
(http://api.brewerydb.com/v2/beer/random/?withBreweries=Y&hasLabels=Y&key=a5c1b917e7ba62dcd79f434ed73bc72d)

I then use a controller class to create a ModelAndView which maps chosen data and renders it to a jsp file which can
be then viewed on the browser (http://localhost:8080/)

Using a RESTApi I then rendered chosen values to http://localhost:8080/api/beer

Simply download this application in a zip file, open in your chosen IDE and run the WebappApplication classes main method. 

Once the server has succesfully started you can navigate to: 

1. http://localhost:8080/ - to find a rendered page 
2. http://localhost:8080/api/beer - to find the raw data from the RESTApi

Thank you!
