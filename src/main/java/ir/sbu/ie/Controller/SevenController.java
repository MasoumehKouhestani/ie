package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.CaseEntity;
import ir.sbu.ie.Service.SevenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@RestController
public class SevenController {
    @Inject
    private SevenService sevenService;

    @GetMapping("/eghdam")
    @Produces(MediaType.APPLICATION_JSON)
    public CaseEntity getcase(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getSession().getAttribute("case").toString());
        System.out.println(id);
        return sevenService.getcase(id);
    }

    @PostMapping("/changereferto")
    @Consumes("application/x-www-form-urlencoded")
    public void changeReferTo(@FormParam("name") String name, @FormParam("des1") String des, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getSession().getAttribute("case").toString());
        System.out.println(id);
        String email = request.getSession().getAttribute("email").toString();
        boolean valid = sevenService.changerrefer(id, email, name, des);
        if (valid)
            response.sendRedirect("w2.html");
        else
            response.sendRedirect("worngreferTo.html");

    }

    @PostMapping("/changestate")
    @Consumes("application/x-www-form-urlencoded")
    public void changestate(@FormParam("s") String state, @FormParam("des") String des, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getSession().getAttribute("case").toString());
        System.out.println(id);
        String email = request.getSession().getAttribute("email").toString();
        sevenService.changestate(id, email, des, state);

        response.sendRedirect("w2.html");


    }

}
