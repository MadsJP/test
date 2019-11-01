<%--
  Created by IntelliJ IDEA.
  User: Christoffer
  Date: 01-11-2019
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr" xmlns:width="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <!-- <meta name "description" content="Dette er vores Sundhedsplatform"> --> <!-- Kunne ikke finde ud af hvad det her bruges til-->
    <title>Sundhedsplatform</title>
</head>
<header>
    <p style="text-align:center;">
        <img src="header.png" alt="Her er et billede" width="250" height="194"/> </p>
    <!-- Overskrift -->
    <!–– /br  Break point -->
    <hr/> <!–– Break point med linje-->
    <nav>
        <!-- Her skal der stå links -->
    </nav>
</header>
<body style="background-color: white;">

<div id="intro">
    <p>Velkommen til din sundhedsplatform. <br><br>
        På denne hjemmeside kan man finde oplysninger omkring aftaler, ændre aftaler og se sine ambulante behandlinger.</p>
</div>
<div>
    <p align="center">
        <a href="login.html">
            <button>Log på og se dine sundhedsaftaler her</button> <!-- Sådan laver du links -->
        </a>
    </p>
    <p style="text-align:center;">
        <img src="https://jyllands-posten.dk/debat/kronik/image/10054262/eeud0q/ALTERNATES/h-5_3/adoc6unkafzxcqg1n5czzlg0.jpg" alt="Her er et billede" height="250" width:="250"/> </p>
    <article>
        <!--<p style="color:black; text-align:center;"><small>Komisk billede ;)</b></small></p>  -->
        <!-- Rå Tekst -->
    </article>
</div>

</body>
<footer>
    <hr>
    <!-- <p>Oprettet af: Mads, Magnus & Rasmus</p> -->
    <p>Contact information: <a href="su1@server.dk">
        su1@server.dk</a>.</p>
    <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button> <!-- En knap så man kan komme tilbage til toppen-->
</footer>
</html>