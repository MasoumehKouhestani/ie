package ir.sbu.ie.Controller;

import ir.sbu.ie.Service.nineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@RestController
public class nineController {
    @Inject
    private nineService nineService;

    @GetMapping("/listofuser")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return nineService.userList();
    }

    @PostMapping("/deactive")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String unconfrimed(@RequestBody String username, HttpServletRequest request, HttpServletResponse response) {
        username = username.substring(0, username.length() - 1);
        return nineService.deactive(username);
    }

    @PostMapping("/managerprofileset")
    @Consumes("application/x-www-form-urlencoded")
    public void signup(@FormParam("old") String old, @FormParam("name") String name, @FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean valid = nineService.profileset(old, name, username, email, password);
        if (valid == true) {

            response.sendRedirect("w2.html");

        } else
            response.sendRedirect("w1.html");
    }
}
