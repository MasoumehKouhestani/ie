package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Inject
    public LoginService loginService;

    @GetMapping("/userlogin")
    @Consumes("application/x-www-form-urlencoded")
    public boolean login(@FormParam("email") String email, @FormParam("password") String password) {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        boolean result = loginService.userLogin(user);
        return result;
    }

}
