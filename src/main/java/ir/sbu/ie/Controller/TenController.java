package ir.sbu.ie.Controller;

import ir.sbu.ie.Service.TenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;

@RestController
public class TenController {
    @Inject
    private TenService tenService;

    @PostMapping("/getReport")
    @Produces("application/x-www-form-urlencoded")
    public Object[] getReport(@FormParam("section") String section, @FormParam("type") String type, @FormParam("referenceperson") String referenceperson
            , @FormParam("startdate") String startdate, @FormParam("finishdate") String finishdate, HttpServletRequest request, HttpServletResponse response) {

        return tenService.reportList(section, type, referenceperson, startdate, finishdate);
    }
}
