package com.city.atm.servlet.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This subclass of {@code HttpServlet} creates an HTTP servlet that computes the current year
 * and the output is printed on the footer of every JSP page.
 * 
 * @author Simon Njenga
 * @since 0.1
 */
public class YearCalculator extends HttpServlet {

    /**
     * Serialization marker.
     */
    private static final long serialVersionUID = 5473151833849926992L;

    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException, ServletException {

        res.setContentType("text/html");
        Calendar cal = Calendar.getInstance();
        PrintWriter out = res.getWriter();
        out.print(cal.get(Calendar.YEAR));
    }

    public void destroy() {
        // Intentionally empty!
    }
}
