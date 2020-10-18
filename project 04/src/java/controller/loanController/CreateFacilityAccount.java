package controller.loanController;

import commons.ExceptionWrapper;
import commons.exceptions.BusinessException;
import model.entity.FacilityAccount;
import model.entity.FacilityProfile;
import model.entity.RealPerson;
import model.service.FacilityAccountCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/facilityAccount/CreatFacilityAccount.do")
public class CreateFacilityAccount extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long customerId = Long.parseLong(req.getParameter("customerId"));
        String amount = req.getParameter("amount");
        String duration = req.getParameter("duration");
        long loanTypeId= Long.parseLong(req.getParameter("chosenLoanType"));
try {
    //long retrieveLonaTypeId= FacilityAccountCRUD.validate(amount,duration,loanTypeId);
  //  RealPerson realPerson=new RealPerson(customerId);
    FacilityAccount facilityAccount =new FacilityAccount(amount,duration);
    FacilityProfile facilityProfile =new FacilityProfile().setLoanTypeId(loanTypeId);
    RealPerson realPerson=new RealPerson().setRealPersonId(customerId);
    FacilityAccountCRUD.persist(facilityProfile,realPerson, facilityAccount);
    req.setAttribute("loanTypes", facilityProfile);
} catch (NumberFormatException | BusinessException e) {
    req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
    resp.sendError(700);
}

    }
}
