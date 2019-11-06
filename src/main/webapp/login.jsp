<%--
  Created by IntelliJ IDEA.
  User: Christoffer
  Date: 01-11-2019
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <!-- <meta name"description" content="Dette er vores Sundhedsplatform"> --> <!-- Kunne ikke finde ud af hvad det her bruges til-->
    <title>Sundhedsplatform</title>
</head>
<body style="background-color: white;">
<header>
    <h1 style="color: black; text-align:center">Login side</h1>
    <hr>
    <nav>
        <!-- Her skal der stå links -->
    </nav>
</header>

<main>
    <p style="color: black; text-align: left;">Du kan her logge ind med CPR-NR og password</p>
   <form action="booking.jsp" method="POST" >

        CPR-NUMMER:<br>

        <input type="number" id="CPRnummer" placeholder="CPR" required name="CPR" />
        <br> PASSWORD:
        <br>
        <input id="password" type="password" placeholder="Password" required />
        <br>
        <input type="submit" value="Log ind"/>

   </form>
</main>

<footer>
    <hr/>
    <p>Oprettet af: Mads, Magnus & Rasmus</p>
    <p>Kontakt information: <a href="su1@server.dk">
        su1@server.dk</a>.</p>
    <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button> <!-- En knap så man kan komme tilbage til toppen, snuppet fra stackoverflow-->
</footer>



</body>
</html>
