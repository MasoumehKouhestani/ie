package ir.sbu.ie.Controller;

import ir.sbu.ie.Service.profilesetingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import java.io.IOException;

@Controller
public class profilesetingController {
    @Inject
    private profilesetingService profilesetingService;

    @PostMapping("/profileseting")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public String signup(@FormParam("name") String name, @FormParam("username") String username, @FormParam("email") String email
            , @FormParam("password") String password, @FormParam("newpassword") String newpassword, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String session = (String) request.getSession().getAttribute("email");
        boolean valid = profilesetingService.profileset(session, name, username, email, password, newpassword);
        if (valid == true) {
            request.getSession().setAttribute("email", email);
            return "redirect:/w2.html";

        } else
            return "redirect:/w3.html";
    }

}