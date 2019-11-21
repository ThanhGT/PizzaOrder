<%-- 
    Document   : displayOrder
    Created on : Sep 24, 2019, 8:03:22 PM
    Author     : Thanh Tran
--%>

<%@page import="java.util.Random"%>
<%@page import="com.thanhtran.thanh_tran_a1.model.PizzaOrder"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
    </head>

    <!-- Get the variables from the session  -->
    <% String name = (String)session.getAttribute("name"); %>
    <% String phone = (String) session.getAttribute("phone");%>
    <% String size = (String) session.getAttribute("size"); %>
    <% String[] toppings = request.getParameterValues("toppings"); %>
    <% String deliveryMessage = (String) session.getAttribute("delivery"); %>
    <% Double pizzaCost = (Double) session.getAttribute("pizzaCost"); %>

    <!-- Using the infuriating jsp notation, put the variables in the HTML body -->
    <body>
        <h1>Pizza Order for <% out.print(name); %>, 
            <% out.print(phone); %> total, $<% out.print(pizzaCost); %> 
        </h1>

        <h2><% out.print(deliveryMessage); %>            
            <!-- Get a random time within 30-40 minutes. -->
            <% Random rand = new Random();
                int time = (rand.nextInt((40 - 30) + 1)) + 30; %>;   
            <%= time %> minutes 
        </h2>

        <h3><% out.print(size); %> pizza with                               
            <ul>
                <% if (toppings != null) { %>
                <% for (int i = 0; i < toppings.length; i++) { %>
                <li> <% out.print(toppings[i]);
                    } %> 
                    <% } else { %>
                    <% out.print("No toppings");
                    }%>
                </li>
            </ul>
        </h3>        


    </body>
</html>