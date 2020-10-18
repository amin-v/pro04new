/*package controller.legalpersoncontroller;

import model.entity.LegalPerson;
import model.service.LegalPersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/legalPerson/update.do")
public class Update extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id= Long.valueOf(req.getParameter("id"));
            String company = req.getParameter("company");
            LocalDate registerDate = LocalDate.parse(req.getParameter("registerDate"));
            String economicCode = req.getParameter("economicCode");
            LegalPerson legalPerson = new LegalPerson().setLegalPersonId(id).setRegisterDate(registerDate).setEconomicCode(economicCode).setCompany(company);
            LegalPersonService.getInstance().update(legalPerson);
            resp.sendRedirect("/legalPerson/Show.do?id="+legalPerson.getLegalPersonId()+"&company="+legalPerson.getCompany()+"&economicCode="+legalPerson.getEconomicCode()+"&registerDate="+legalPerson.getRegisterDate().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
 */
