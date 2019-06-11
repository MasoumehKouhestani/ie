package ir.sbu.ie.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController

public class test {
    @RequestMapping("/test")
    void test(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        request.getSession().setAttribute("email","sal");
        RequestDispatcher m =request.getRequestDispatcher("ten.html");
        m.forward(request,response);
    }
    @RequestMapping("/test1")
    void test1(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        System.out.println(request.getSession().getAttribute("email"));


    }

}
