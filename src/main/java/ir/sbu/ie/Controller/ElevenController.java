package ir.sbu.ie.Controller;

import ir.sbu.ie.Service.ElevenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@RestController
public class ElevenController {

    @Inject
    private ElevenService elevenService;

    @GetMapping("/listofReports")
    @Consumes(MediaType.APPLICATION_JSON)
    public void caseList(HttpServletRequest request, HttpServletResponse response) {
    }

}


