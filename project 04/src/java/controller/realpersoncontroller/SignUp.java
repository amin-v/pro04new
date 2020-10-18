package controller.realpersoncontroller;

import commons.ExceptionWrapper;
import model.entity.RealPerson;
import model.service.RealPersonCRUD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/realPerson/signUp.do")
public class SignUp extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String family=req.getParameter("family");
            String fatherName=req.getParameter("fatherName");
            LocalDate birthDate=LocalDate.parse(req.getParameter("birthDate"));
            System.out.println(req.getParameter("registerDate"));
            String nationalCode=req.getParameter("nationalCode");
            RealPerson realPerson = new RealPerson().setName(name).setFamily(family).setFatherName(fatherName).setBirthDate(birthDate).setNationalCode(nationalCode);
            RealPersonCRUD.persist(realPerson);
            resp.sendRedirect("/realPerson/index.jsp?state=register was successfully");
        }catch (Exception e){
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }

}
