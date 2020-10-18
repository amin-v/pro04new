package controller.loanController;

import commons.ExceptionWrapper;
import commons.exceptions.BusinessException;
import model.entity.FacilityProfile;
import model.entity.GrantCondition;
import model.service.GrantConditionalCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/facilityProfile/CreateGrantCondition.do")
public class CreateGrantCondition extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
        try {
            //  if (Objects.isNull(req.getParameter("name")) &&
            //        Objects.isNull(req.getParameter("minDuration")) &&
            //      Objects.isNull(req.getParameter("maxDuration")) &&
            //    Objects.isNull(req.getParameter("minAmount")) &&
            //  Objects.isNull(req.getParameter("maxAmount"))) {
            //inja dare mige , hoy asghar agha , hade aghal , bayad yek shart bezari
            // throw new BusinessException("at least there should be one condition");
            //}
            // GrantCondition grantCondition = new GrantCondition();

            // if (Objects.isNull(req.getParameter("name"))) {
            //  grantCondition.setMinDuration(Integer.valueOf(req.getParameter("name")));
            // }

            String loanName = req.getParameter("loanName");
            String interestRate = req.getParameter("interestRate");
            long rowNumber = Long.parseLong((req.getParameter("rowNumber")));
//            List<GrantCondition> grantConditions = new ArrayList<GrantCondition>();

            //      for (int count = 1; count <= rowNumber; count++) {
            GrantCondition grantCondition = new GrantCondition();
            grantCondition.setName(req.getParameter("grantName"));
//                if(req.getParameter("minDuration")!=null)
            grantCondition.setMinDuration(Long.parseLong(req.getParameter("minDuration")));
            grantCondition.setMaxDuration(Long.parseLong(req.getParameter("maxDuration")));
            grantCondition.setMaxAmount(BigDecimal.valueOf(Long.parseLong(req.getParameter("maxAmount"))));
            grantCondition.setMinAmount(BigDecimal.valueOf(Long.parseLong(req.getParameter("minAmount"))));
            GrantConditionalCRUD.validate(grantCondition);
//                grantConditions.add(grantCondition);
            //   }

//            if (grantConditions.size() > 0) {
//                GrantConditionalCRUD.create(grantConditions,loanName,interestRate);
//                // req.setAttribute("interestRate",interestRate);
//                 //req.setAttribute("loanName",loanName);
//                // req.setAttribute("rowNumber",rowNumber);
//                req.setAttribute("title", "تایید ثبت تسهیلات");
//                req.setAttribute("header", "تسهیلات " + loanName + " با موفقیت ثبت شد.");
//            }
            FacilityProfile facilityProfile = new FacilityProfile(loanName, interestRate);
            GrantConditionalCRUD.persist(facilityProfile, grantCondition);
            req.setAttribute("title", "تایید ثبت تسهیلات");
            req.setAttribute("header", "تسهیلات " + loanName + " با موفقیت ثبت شد.");
            // req.getRequestDispatcher("/loan/GrantCondition.jsp").forward(req,resp);
            resp.sendRedirect("/loan/result-page.jsp");
        } catch (NumberFormatException | BusinessException e) {
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }
}
