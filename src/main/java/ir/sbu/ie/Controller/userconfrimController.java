package ir.sbu.ie.Controller;

import ir.sbu.ie.Service.userconfirmdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@RestController
public class userconfrimController {
    @Inject
    private userconfirmdService userconfirmdService;

    @GetMapping("/listunconfrimed")
    @Produces(MediaType.APPLICATION_JSON)
    public Object[] unconfirmedlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return userconfirmdService.unconfirmdlist();
    }

    @PostMapping("/confrimed")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String confrimed(@RequestBody String username, HttpServletRequest request, HttpServletResponse response) {
        username = username.substring(0, username.length() - 1);
        System.out.println(username);
        return userconfirmdService.confrimed(username);
    }

    @PostMapping("/unconfrimed")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String unconfrimed(@RequestBody String username, HttpServletRequest request, HttpServletResponse response) {
        username = username.substring(0, username.length() - 1);
        return userconfirmdService.unconfirmd(username);
    }

}