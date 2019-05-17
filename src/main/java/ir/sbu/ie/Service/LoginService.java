package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Inject
    private UserRepository userRepository;
    @Autowired
    private HttpSession httpSession;

    public boolean userLogin(User user) {
        User resultUser;
        resultUser = userRepository.findByEmail(user.getEmail());
        if (resultUser == null) {
            return false;
        } else {
            if (resultUser.getPassword().equals(user.getPassword()) && resultUser.isConfirmed()) {
                return true;
            }
        }
        return false;
    }
}
