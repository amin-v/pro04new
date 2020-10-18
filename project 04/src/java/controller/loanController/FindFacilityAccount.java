package controller.loanController;

import commons.ExceptionWrapper;
import model.entity.FacilityProfile;
import model.entity.RealPerson;
import model.service.FacilityProfileCRUD;
import model.service.RealPersonCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/facilityAccount/FindFacilityAccount.do")
public class FindFacilityAccount extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String customerNumber = req.getParameter("customerNumber");
            List<RealPerson> realPersonList = RealPersonCRUD.getInstance().findById(Long.valueOf(customerNumber));
            List<FacilityProfile> facilityProfileList = FacilityProfileCRUD.getInstance().findAll();
            System.out.println("khkhkhkhh" + facilityProfileList.size());
            String customerExists;
            if (realPersonList.size() > 0) {
                customerExists = "true";
                RealPerson realPerson = realPersonList.get(0);
                FacilityProfile facilityProfile = facilityProfileList.get(0);
                req.setAttribute("customerExists", customerExists);
                req.setAttribute("realCustomer", realPerson);
                req.setAttribute("loanTypes", facilityProfile);
                req.setAttribute("customerExists", customerExists);
                req.setAttribute("realCustomer", realPerson);
                req.setAttribute("loanTypes", facilityProfileList);
                req.getRequestDispatcher("/loan/FacilityAccount.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }
}
