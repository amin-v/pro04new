/*package controller.legalpersoncontroller;

import commons.ExceptionWrapper;
import model.entity.LegalPerson;
import model.service.LegalPersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/legalPerson/delete.do")
public class Delete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(req.getParameter("id"));
            LegalPerson legalPerson = new LegalPerson().setLegalPersonId(id);
            LegalPersonService.getInstance().delete(legalPerson);
            resp.sendRedirect("/legalPerson/index.jsp?state=delete successfully done");
        } catch (Exception e) {
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }

}
 */
