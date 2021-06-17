<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Spring web application">
    <meta name="author" content="Sam Meehan">
    <title>Beer Web App</title>
    <style>
        .headingBox{
            border-color: black;
            color: darkgoldenrod;
            display: flex;
            flex-direction: row;
            border-style: double;
            padding: 10px;
            width: 800px;
        }
        button{
            font-size: 20px;
            background-color: black;
            color: white;
            height: 50px;
            width: 500px;
            margin-left: 50px;
            margin-top: 10px;
            transition-duration: 0.4s;
        }
        button:hover {
            background-color: goldenrod;
            color: black;

        }
        .beerDetailBox{
            border-style: double;
            width: 800px;
            padding: 10px;
        }
        .font-size-20{
            font-size: 20px;
        }
        .header{
            font-size: 25px;
        }
    </style>
</head>

<body>
<div class="headingBox">
    <div>
        <h1 class="header">The Random Beer App</h1>
    </div>
    <div>
        <button id="newBeer">Get a new  tasty beer</button>
    </div>
</div>
<div class="beerDetailBox">
    <p class="font-size-20"> <strong style="font-size: 22px"> Beer name: </strong> ${beerName}</p>
    <p class="font-size-20"> <strong style="font-size: 22px"> Beer Description: </strong><br> ${beerDescription}</p>
    <p class="font-size-20"> <strong style="font-size: 22px"> If your already drunk and wont remember the name, here's a shorter version: </strong><br> ${beerShortName}</p>
</div>
<div class="beerDetailBox">
    <p class="font-size-20"><strong style="font-size: 22px">Brewery name:</strong> ${breweryName}</p>
</div>

<script>
    const button = document.getElementById("newBeer");
    button.addEventListener("click", function (){
        window.location.reload();
    })
</script>

</body>

</html>