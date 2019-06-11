package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Service.SignUpService;
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
public class SignUpController {
    @Inject
    private SignUpService signUpService;

    @PostMapping("/signup")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public String signup(@FormParam("name") String name, @FormParam("username") String username, @FormParam("email") String email
            , @FormParam("password") String password, @FormParam("position") String position, @FormParam("section") String section, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPosition(position);
        user.setSection(section);
        boolean valid = signUpService.userSignUp(user);
        if (valid == true) {
            if (position.equals("student")) {
                request.getSession().setAttribute("email", email);
                return "redirect:/orginalstudent.html";
            }
            if (position.equals("manager")) {
                request.getSession().setAttribute("email", email);
                return "redirect:/orginal.html";
            }
            return "redirect:/waiting.html";
        } else
            return "redirect:/w1.html";
    }

}