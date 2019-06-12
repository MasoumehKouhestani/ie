package ir.sbu.ie.Controller;

import ir.sbu.ie.Service.TenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.List;

@Controller
public class TenController {
    @Inject
    private TenService tenService;

    Object[] list;

    @PostMapping("/getReport")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public String getReport(@FormParam("section") String section, @FormParam("type") String type, @FormParam("referenceperson") String referenceperson
            , @FormParam("startdate") String startdate, @FormParam("finishdate") String finishdate, HttpServletRequest request, HttpServletResponse response) throws ParseException {

        request.getSession().setAttribute("section", section);
        request.getSession().setAttribute("type", type);
        request.getSession().setAttribute("referenceperson", referenceperson);
        return "redirect:/eleven.html";
    }

//    @GetMapping("/reportList")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Object[] showReports(HttpServletRequest request, HttpServletResponse response) throws ParseException {
//
//       return tenService.reportList((String) request.getSession().getAttribute("section"),(String) request.getSession().getAttribute("typr"),
//               (String) request.getSession().getAttribute("referenceperson"));
//    }
}
