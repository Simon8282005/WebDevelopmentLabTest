package controller;

import dao.SessionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SessionBean;

public class ScheduleServlet extends HttpServlet {
    private SessionDAO sessionDAO;    
    
    @Override
    public void init() {
        sessionDAO = new SessionDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch(action) {
            case "view":
                ArrayList<SessionBean> sessionList = new ArrayList<>();
                sessionList = sessionDAO.getAllSessions();
                
                request.setAttribute("sessionList", sessionList);
                request.getRequestDispatcher("SchedulePage.jsp").forward(request, response);
                
                break;
            case "delete":
                String id = request.getParameter("id");
                sessionDAO.deleteBooking(id);
                
                response.sendRedirect("ScheduleServlet?action=view");
                break;
        }
    }
}
