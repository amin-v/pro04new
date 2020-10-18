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
import java.util.List;

@WebServlet("/legalPerson/findByEconomicCode.do")
public class SearchByEconomicCode extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        try {
            String economicCode = req.getParameter("economicCode");
           List<LegalPerson> legalPersonList =  LegalPersonService.getInstance().findByEconomicCode(economicCode);
            req.setAttribute("legalPersons", legalPersonList);
            req.getRequestDispatcher("/legalPerson/index.jsp").forward(req,resp);
        }catch (Exception e){
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }

}
 */

