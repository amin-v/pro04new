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

@WebServlet("/realPerson/update.do")
public class Update extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long id= Long.valueOf(req.getParameter("id"));
            String name = req.getParameter("name");
            String family=req.getParameter("family");
            String fatherName=req.getParameter("fatherName");
            LocalDate birthDate=LocalDate.parse(req.getParameter("birthDate"));
            String nationalCode=req.getParameter("nationalCode");
            RealPerson realPerson =new RealPerson().setName(name).setRealPersonId(id).setFamily(family).setFatherName(fatherName).setBirthDate(birthDate).setNationalCode(nationalCode);
            RealPersonCRUD.update(realPerson);
            resp.sendRedirect("/realPerson/Show.do?id="+realPerson.getRealPersonId()+"&name="+realPerson.getName()+"&family="+realPerson.getFamily()+"&fatherName="+realPerson.getFatherName()+"&birthDate="+realPerson.getBirthDate()+"&nationalCode="+realPerson.getNationalCode());
        }catch (Exception e){
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            resp.sendError(700);
        }
    }
}
