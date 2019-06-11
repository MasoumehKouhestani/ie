package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Service.SevenService;
import ir.sbu.ie.Service.eightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@RestController
public class eightController {
    @Inject
    private eightService eightService;

    @GetMapping("/listofcaseeight")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] caseList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getSession().getAttribute("email").toString();
        return eightService.caseList(email);
    }
    @PostMapping("/rezayat")
    public void rezayat(@RequestBody String caseid,HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getSession().getAttribute("case").toString());
        System.out.println(id);
         eightService.setrezayat(id, true);

            response.sendRedirect("w2.html");


    }
    @PostMapping("/narezayat")
    public void narezayat(@RequestBody String caseid,HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getSession().getAttribute("case").toString());
        System.out.println(id);
        eightService.setrezayat(id, false);

        response.sendRedirect("w2.html");


    }



}
