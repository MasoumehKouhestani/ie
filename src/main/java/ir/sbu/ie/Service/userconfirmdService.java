package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service
public class userconfirmdService {

    @Inject
    private UserRepository userRepository;

    public Object[] unconfirmdlist() {

        List<User> findforconfiremd = userRepository.findforconfiremd();

        return findforconfiremd.toArray();
    }

    public String confrimed(String username) {

        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setConfirmed(true);
            userRepository.save(user);

            return "true";
        }
        return "false";
    }

    public String unconfirmd(String Username) {
        User user = userRepository.findByUsername(Username);
        if (user != null) {
            user.setConfirmed(false);
            userRepository.delete(user);
            return "true";
        }
        return "false";
    }
}
