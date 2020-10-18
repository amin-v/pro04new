package controller.realpersoncontroller;


import commons.ExceptionWrapper;
import model.entity.RealPerson;
import model.service.RealPersonCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/realPerson/findByFamily.do")
public class SearchByFamily extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String family = req.getParameter("family");
            List<RealPerson> realPersonList= RealPersonCRUD.getInstance().findByFamily(family);
            req.setAttribute("realPersons",realPersonList);
            req.getRequestDispatcher("/realPerson/searchByFamily.jsp").forward(req,resp);
        }catch (Exception e){
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }
}
