package ir.sbu.ie.Controller;

import ir.sbu.ie.Service.ElevenService;
import ir.sbu.ie.Service.TenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;

@RestController
public class ElevenController {

    @Inject
    private TenService tenService;

    @GetMapping("/reportList")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] showReports(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        return tenService.reportList(request.getSession().getAttribute("section").toString(),request.getSession().getAttribute("type").toString(),
                request.getSession().getAttribute("referenceperson").toString());
    }

}


