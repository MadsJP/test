<%@ page import="data.DB" %>
<%@ page import="data.Aftale" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Christoffer
  Date: 01-11-2019
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" dir="ltr">
<head>
    <link rel="stylesheet" type="text/css" href="booking.css">
    <meta charset="UTF-8">
    <!-- <meta name"description" content="Dette er vores Sundhedsplatform"> --> <!-- Kunne ikke finde ud af hvad det her bruges til-->
    <title>Oversigt</title>
</head>


<body>
<header>
    <h1>Aftale side: <% out.println(request.getParameter("CPR")); %></h1>
    <hr>
    <nav>
        <!-- Her skal der stå links -->
    </nav>
</header>
<%  DB db = new DB();


  %>

<main>
    <h1 id="head1">Vælg venligst Hospital & afdeling</h1>
    <div>
        <form>
            <p>
                <label>Hospital:
                    <select id="hospital" name="hospital">
                        <option value="" selected="selected">Vælg hospital</option>
                        <option value="riget" >Rigshospitalet</option>
                        <option value="hill" >Hillerød</option>
                        <option value="gen" >Gentofte</option>
                    </select>
                </label>
            </p>
        </form>
        <form>
            <p>
                <label>Afdeling:
                    <select id="afdeling" name="afdeling">
                        <option value="" selected="selected">Vælg afdeling</option>
                        <option value="kardio" >Kardiologisk afd.</option>
                        <option value="endo" >Endokrinologisk afd.</option>
                        <option value="blod" >Blodprøver</option>
                    </select>
                </label>
            </p>
        </form>
        Vælg Dato:
        <label>
            <input name ="bestil tid" type = "date">
        </label>
        <br>
        <input type="button" name="OK" value="OK">
    </div>
    <br>
    <!-- Ovenstående stykke er hentet fra https://www.quackit.com/html/html_editors/scratchpad/?example=/html/codes/html_form_code_right_aligned_labels , men er modificeret -->
    <hr>
    <h1 id="head2">Nuværende booking(er):</h1>
    <div>
       <table style="width:100%">
           <thead>
           <tr>
               <td> <b> Tidspunkt </b>  </td>
               <td> <b> Sygehus </b> </td>
               <td> <b> Afdeling </b> </td>
               <td> <b> Varighed </b> </td>
               <td> <b> Undersøgelse </b> </td>
           </tr>
           </thead>
           <tbody>
           <% List<Aftale> aftaler = DB.getAftale();
               /* System.out.println(aftaler.size()); */
               for(int i=0; i<aftaler.size(); i++) {
                   Aftale app = aftaler.get(i);
                   String Sygehus = app.getSygehus();
                   String Type = app.getType();
                   String Dato = app.getDato();
           %>
           <!---- Her indsættes din tabel ---->
           <tr>
               <td> <% out.println(Dato); %></td>
               <td> <% out.print(Sygehus);%> </td>
               <td> Mangler </td>
               <td> Mangler </td>
               <td> <% out.println(Type); %> </td>

           </tr>
           <% }%>
           </tbody>
       </table>

    </div>
    <br>
    <hr>
    <h1 id="head3">Tidligere besøg/bookinger:</h1>
    <div>
        <p>Få noget til at vise tidligere bookinger</p>
    </div>


</main>

<footer>
    <hr/>
    <p>Oprettet af: Mads, Magnus & Rasmus</p>
    <p>Kontakt information: <a href="su1@server.dk">
        su1@server.dk</a>.</p>
    <button onclick="topFunction()" id="myBtn" title="Go to top">Top</button> <!-- En knap så man kan komme tilbage til toppen, snuppet fra stackoverflow-->
</footer>

</body>
