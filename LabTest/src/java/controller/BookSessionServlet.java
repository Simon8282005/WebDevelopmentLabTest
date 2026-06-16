package controller;

import dao.SessionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SessionBean;

public class BookSessionServlet extends HttpServlet {
    private SessionDAO sessionDAO;

    @Override
    public void init() {
        sessionDAO = new SessionDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String student_name = request.getParameter("name");
            String branch_location = request.getParameter("location");
            String lesson_type = request.getParameter("lesson");
            String status = "";

            if (request.getParameter("status") == null) {
                status = "Booked";
            } else {
                status = request.getParameter("status");
            }

            System.out.println("Name: " + student_name);
            System.out.println("Location: " + branch_location);
            System.out.println("Lesson: " + lesson_type);
            System.out.println("Status: " + status);
            
            sessionDAO.bookSession(new SessionBean(student_name, branch_location, lesson_type, status));
            response.sendRedirect("ScheduleServlet?action=view");
        }
    }
