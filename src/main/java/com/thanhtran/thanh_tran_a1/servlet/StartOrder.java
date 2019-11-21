/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtran.thanh_tran_a1.servlet;

import com.thanhtran.thanh_tran_a1.model.PizzaOrder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thanh Tran
 */
public class StartOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            writeHeaderInfo(out);

            // get parameters (i.e. the things that the user typed in) name and phone from the HTML
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");

            //create a session object
            //it's like instantiating/creating a new object in Java: 
            //Cloud cloud = new Cloud();
            HttpSession session = request.getSession();
            
            //every time we call setAttribute("myAttributeName", myAttributeValue),
            //we actually, create a new attribute called "myAttributeName".
            //that attribute is stored where? In the session of course! 
            //after the attribute is created, using setAttribute will just re-adjust
            //the value of that attribute.
            // setAttribute takes 2 parameters: 
            // 1.) The Name of the attribute (a string)
            // 2.) The VALUE of the attribute (any)
            session.setAttribute("name", name); // set attribute name
            session.setAttribute("phone", phone);   // set attribute phone

            //display users name
            out.println("<h1>Hi " + name + "</h1>");
            // display users phone number
            out.println("<h1> " + phone + "</h1>");

            // form to be processed using POST method to the PlaceOrder servlet
            out.println("<form action=\"PlaceOrder.do\" method=\"POST\">");
            out.println("<select name='deliveryChoice'>");
            out.println("<option value=\"delivery\">Delivery</option>");
            out.println("<option value=\"pickUp\">PickUp</option>");
            out.println("</select>");
            out.println("<br><br>");
            out.println("<input type= \"radio\" name=\"size\" value=\"Small\" checked>Small($5)");
            out.println("<input type= \"radio\" name=\"size\" value=\"Medium\">Medium($7)");
            out.println("<input type= \"radio\" name=\"size\" value=\"Large\">Large($9)<br>");
            out.println("<input type= \"checkbox\" name=\"toppings\" value=\"pepperoni\">Pepperoni<br>");
            out.println("<input type= \"checkbox\" name=\"toppings\" value=\"sausage\">Sausage<br>");
            out.println("<input type= \"checkbox\" name=\"toppings\" value=\"spinach\">Spinach<br>");
            out.println("<input type= \"checkbox\" name=\"toppings\" value=\"pepper\">Pepper<br><br>");
            out.println("<input type=\"submit\" value=\"Place My Order\" id=\"submit\">");
            out.println("</form>");

            writeFooterInfo(out);
        }

    }

    private void writeHeaderInfo(final PrintWriter out) {

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Pizza Order Servlet</title>");
        out.println("</head>");
        out.println("<body>");
    }

    private void writeFooterInfo(final PrintWriter out) {
        out.println("</body>");
        out.println("</html>");
    }
}
