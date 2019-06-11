package ir.sbu.ie.Controller;

import ir.sbu.ie.Service.TenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;

@RestController
public class TenController {
    @Inject
    private TenService tenService;

    @PostMapping("/getReport")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] getReport(@FormParam("section") String section, @FormParam("type") String type, @FormParam("referenceperson") String referenceperson
            , @FormParam("startdate") String startdate, @FormParam("finishdate") String finishdate, HttpServletRequest request, HttpServletResponse response) throws ParseException {

        return tenService.reportList(section, type, referenceperson);
    }
}
