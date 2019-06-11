package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


@Service
public class SignUpService {

    @Inject
    private UserRepository userRepository;

    public boolean userSignUp(User user) {
        User u1 = userRepository.findByEmail(user.getEmail());
        User u2 = userRepository.findByUsername(user.getUsername());
        if (u1 == null && u2 == null) {
            if (user.getPosition().equals("student") || user.getPosition().equals("manager")) user.setConfirmed(true);
            else user.setConfirmed(false);
            userRepository.save(user);
            return true;
        } else return false;
    }

}
