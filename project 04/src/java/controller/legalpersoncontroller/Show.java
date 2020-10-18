/*package controller.legalpersoncontroller;

import commons.ExceptionWrapper;
import model.entity.LegalPerson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/legalPerson/Show.do")
public class Show extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            String company = req.getParameter("company");
            LocalDate registerDate = LocalDate.parse(req.getParameter("registerDate"));
            String economicCode = req.getParameter("economicCode");
            LegalPerson legalPerson = new LegalPerson(id, company, registerDate, economicCode);
            req.setAttribute("legalPerson", legalPerson);
            req.getRequestDispatcher("/showCreated/index.jsp").forward(req, resp);
        }catch (Exception e){
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }

}
 */
