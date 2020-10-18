package controller.loanController;

import commons.ExceptionWrapper;
import model.entity.FacilityProfile;
import model.service.FacilityProfileCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/facilityProfile/signUp.do")
public class CreateFacilityProfile extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo : at least one of the condition should not be empty
        try {

            //   if (Objects.isNull(req.getParameter("loanName"))) {
            //     throw new BusinessException("your loan should have a name");
            // }

            //if (Objects.isNull(req.getParameter("interestRate"))) {
            //   throw new BusinessException("your loan should have interestedRate");
            //}

            String loanName = req.getParameter("loanName");
            String interestRate = req.getParameter("interestRate");
            FacilityProfile facilityProfile = new FacilityProfile();

            facilityProfile.setLoanName(loanName).setInterestRate(interestRate);
            FacilityProfileCRUD.validate(loanName.trim(), interestRate.trim());
            //FacilityProfileCRUD.persist(facilityProfile);
            req.setAttribute("loanName", loanName);
            req.setAttribute("interestRate", interestRate);
            req.setAttribute("facilityProfile", facilityProfile);

            req.getRequestDispatcher("/loan/GrantCondition.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }
}