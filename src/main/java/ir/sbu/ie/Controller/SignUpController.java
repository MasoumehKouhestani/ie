package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

@Controller
@RequestMapping("/signup")
public class SignUpController {
    @Inject
    public SignUpService signUpService;

    @PostMapping("/usersignup")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public String signup(@FormParam("name") String name, @FormParam("username") String username, @FormParam("email") String email
            , @FormParam("password") String password, @FormParam("position") String position, @FormParam("section") String section) throws ServletException, IOException {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPosition(position);
        user.setSection(section);
        signUpService.userSignUp(user);
        if (position.equals("student")) {
            return "redirect:/orginalstudent.html";
        }
        return "redirect:/waiting.html";
    }
}