package com.thanhtran.thanh_tran_a1.servlet;

import com.thanhtran.thanh_tran_a1.model.PizzaOrder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thanh Tran
 */
public class PlaceOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            PizzaOrder order = new PizzaOrder();
            writeHeaderInfo(out);

            // create session
            HttpSession session = request.getSession();

            // set Parameters
            String size = request.getParameter("size");
            session.setAttribute("size", size);
            order.setSize(size);

            // get delivery option
            String delivery = request.getParameter("deliveryChoice");
            String deliveryMessage;
            // check if user selected delivery or pickup
            boolean deliverySelected;
            if (delivery.equalsIgnoreCase("Delivery")) {
                deliverySelected = true;
                deliveryMessage = "Your pizza will be delivered within ";
                session.setAttribute("delivery", deliveryMessage);
            } else {
                deliverySelected = false;
                deliveryMessage = "Your pizza will be ready for pickup in ";
                session.setAttribute("delivery", deliveryMessage);
            }
            order.setDelivery(deliverySelected);

            String[] toppingsList = request.getParameterValues("toppings");

            // Null handler just in case the user picks no toppings at all...             
            if (toppingsList != null) {
                order.setToppings(toppingsList);
            }
            //if null don't call setToppings method.

            //cost of the pizza Mario
            Double pizzaCost = order.getPrice();
            session.setAttribute("pizzaCost", pizzaCost);

            String pageToRedirect = "displayOrder.jsp";

            RequestDispatcher rd = request.getRequestDispatcher(pageToRedirect);

            rd.forward(request, response);

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
