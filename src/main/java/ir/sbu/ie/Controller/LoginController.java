package ir.sbu.ie.Controller;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Controller
public class LoginController {

    @Inject
    public LoginService loginService;

    @PostMapping("/login")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public String login(@FormParam("email") String email, @FormParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);

        boolean result = loginService.userLogin(user);
        if (result) {
            request.getSession().setAttribute("email",email);
            user = loginService.getUser(user);
            request.getSession().setAttribute("positon",user.getPosition());
            if (user.getPosition().equals("student"))
                return "redirect:/orginalstudent.html";
            else if (user.getPosition().equals("employee") || user.getPosition().equals("professor"))
                return "redirect:/orginalEmployee.html";
            else if (user.getPosition().equals("manager"))
                return "redirect:/orginal.html";
        }
        return "redirect:/worgPassOrEmail.html";
    }

}
