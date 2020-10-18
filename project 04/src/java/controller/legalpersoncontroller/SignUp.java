package controller.legalpersoncontroller;

/*import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/legalPerson/signUp.do")
public class SignUp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String company = req.getParameter("company");
            String economicCode=req.getParameter("economicCode");
           LocalDate registerDate=LocalDate.parse(req.getParameter("registerDate"));
            System.out.println(req.getParameter("registerDate"));
            LegalPerson legalPerson = new LegalPerson().setCompany(company).setEconomicCode(economicCode).setRegisterDate(registerDate);
            LegalPersonService.getInstance().persist(legalPerson);
            resp.sendRedirect("/legalPerson/index.jsp?state=register was successfully");
        }catch (Exception e){
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }

}
 */
