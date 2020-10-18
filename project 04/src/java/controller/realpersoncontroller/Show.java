package controller.realpersoncontroller;

import commons.ExceptionWrapper;
import model.entity.RealPerson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/realPerson/Show.do")
public class Show extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            String name = req.getParameter("name");
            String fatherName = req.getParameter("fatherName");
            String family = req.getParameter("family");
            LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
            String nationalCode = req.getParameter("nationalCode");
            RealPerson realPerson = new RealPerson(id, name, family, fatherName, birthDate, nationalCode);
            req.setAttribute("realPerson", realPerson);
            req.getRequestDispatcher("/showCreated/index.jsp").forward(req, resp);
        }catch (Exception e){
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }
}
