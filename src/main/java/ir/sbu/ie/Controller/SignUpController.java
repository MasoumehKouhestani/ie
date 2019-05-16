package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Service.SignUpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Inject
    public SignUpService signUpManager;

    @PostMapping("/usersignup")
    @Consumes("application/x-www-form-urlencoded")
    public void signup(@FormParam("name") String name, @FormParam("username") String username, @FormParam("email") String email
            , @FormParam("password") String password, @FormParam("position") String position, @FormParam("section") String section) {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPosition(position);
        user.setSection(section);
        signUpManager.userSignUp(user);
    }
}
