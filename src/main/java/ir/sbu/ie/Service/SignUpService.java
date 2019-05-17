package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


@Service
public class SignUpService {

    @Inject
    private UserRepository userRepository;

    public void userSignUp(User user) {
        if (user.getPosition() == "student") user.setConfirmed(true);
        else user.setConfirmed(false);
        userRepository.save(user);
    }

}
