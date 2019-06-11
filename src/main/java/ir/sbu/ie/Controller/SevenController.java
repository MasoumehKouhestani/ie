package ir.sbu.ie.Controller;

import ir.sbu.ie.Service.SevenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
public class SevenController {
    @Inject
    private SevenService sevenService;

    @GetMapping("/eghdam")
    @Produces(MediaType.APPLICATION_JSON)
    public void userList(HttpServletRequest request, HttpServletResponse response) {

    }
}
