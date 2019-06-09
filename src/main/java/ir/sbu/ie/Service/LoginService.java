package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


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
            if (resultUser.getPassword().equals(user.getPassword()) && resultUser.isConfirmed()) {
                return true;
            }
        }
        return false;
    }

    public User getUser(User user){
        return userRepository.findByEmail(user.getEmail());
    }

    public String getUserPosition(User user){
        return user.getPosition();
    }
}
