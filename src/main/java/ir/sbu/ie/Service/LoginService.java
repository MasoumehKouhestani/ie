package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Inject
    private UserRepository userRepository;


    public boolean userLogin(User user) {
        User resultUser;
        resultUser = userRepository.findByEmail(user.getEmail());
        if (resultUser == null) {
            return false;
        } else {
            if (resultUser.getPassword().equals(user.getPassword())) {
//                session.setAttribute("id", user.getId());
                return true;
            }
        }
        return false;
    }
}
