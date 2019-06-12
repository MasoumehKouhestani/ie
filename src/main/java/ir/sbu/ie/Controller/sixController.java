package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Service.nineService;
import ir.sbu.ie.Service.sixService;
import ir.sbu.ie.Service.userconfirmdService;
import ir.sbu.ie.Service.profilesetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;

@RestController
public class sixController {
    @Inject
    private sixService sixService;

    @GetMapping("/listofcase")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] macaseList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return sixService.caseList();
    }
    @GetMapping("/listofcaseem")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] emcaseList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getSession().getAttribute("email").toString();
        return sixService.emcaseList(email);
    }
    @PostMapping("/redirectegdam")
    @Consumes(MediaType.TEXT_PLAIN)
    public void requestBody(@RequestBody String caseid,HttpServletRequest request,HttpServletResponse response) throws IOException {
        caseid=caseid.substring(0,caseid.length()-1);
        System.out.println(caseid);
        System.out.println(request.getSession().getAttribute("email"));
        request.getSession().setAttribute("case",caseid);
        boolean ismanager=sixService.ismanager(request.getSession().getAttribute("email"));
        if(ismanager==true)
            response.sendRedirect("seven.html");


        else
            response.sendRedirect("sevenForEmplyee.html");
    }


}
