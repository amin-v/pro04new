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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/realPerson/conditionalFind")
public class ConditionalFind extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            RealPerson realPerson = new RealPerson();
            String name=req.getParameter("name");
            String family=req.getParameter("family");
            String fatherName =req.getParameter("fatherName");
            if (name==null && family==null && fatherName==null) {
                System.out.println(req.getHeader("referer"));
                resp.sendRedirect(req.getHeader("referer"));
                return;
            }
            if(name.trim().equals("") && family.trim().equals("") && fatherName.trim().equals("")){
                resp.sendRedirect(req.getHeader("referer"));
                return;
            }
            realPerson.setName(name);
            realPerson.setFamily(family);
            realPerson.setFatherName(fatherName);
            Map<String,Object> parameters=new HashMap<>();
            String where=conditionMaker(realPerson,parameters);
            List<RealPerson> realPersonList= RealPersonCRUD.conditionalFind(where,parameters);
            req.setAttribute("realPersons",realPersonList);
            req.getRequestDispatcher("/realPerson/index.jsp").forward(req,resp);
        } catch (Exception e) {
            req.setAttribute("errorMessage", ExceptionWrapper.getMessage(e));
            req.getRequestDispatcher("/realPerson/index.jsp").forward(req,resp);
        }
    }

    public String conditionMaker(RealPerson realPerson, Map<String,Object> parameters){
        StringBuilder where=new StringBuilder("");
        if(realPerson.getName().trim()!=""){
            where.append(" person.name=:name and");
            parameters.put("name",realPerson.getName());
        }
        if(realPerson.getFamily()!=""){
            where.append(" person.family=:family and");
            parameters.put("family",realPerson.getFamily());
        }
        if(realPerson.getFatherName()!=""){
            where.append(" person.fatherName=:fatherName");
            parameters.put("fatherName",realPerson.getFatherName());
        }
        if(where.toString().endsWith("and")){
            where.delete(where.toString().lastIndexOf("and"),where.length());
        }
       return where.toString();
    }
}
