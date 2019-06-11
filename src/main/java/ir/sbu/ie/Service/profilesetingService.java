package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


@Service
public class profilesetingService {

    @Inject
    private UserRepository userRepository;

    public boolean profileset(String session, String name, String username, String email, String password, String newpassword) {
        User user = userRepository.findByEmail(session);
        User u2 = userRepository.findByEmail(email);
        User u3 = userRepository.findByUsername(username);
        if (u2 == null && u3 == null && user.getPassword().equals(password)) {
            user.setPassword(newpassword);
            user.setEmail(email);
            user.setUsername(username);
            user.setName(name);
            userRepository.save(user);
            return true;
        }
        return false;
    }

}
