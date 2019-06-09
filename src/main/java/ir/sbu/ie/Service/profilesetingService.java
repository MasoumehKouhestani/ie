package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


@Service
public class profilesetingService {

    @Inject
    private UserRepository userRepository;

    public boolean userSignUp(User user) {
        User u1 =userRepository.findByEmail(user.getEmail());
        User u2=userRepository.findByUsername(user.getUsername());
        if(u1 == null && u2==null){
            if (user.getPosition().equals("student")) user.setConfirmed(true);
            else user.setConfirmed(false);
            userRepository.save(user);
            return true;
        }
        else return false;
    }

    public boolean profileset(String session, String name, String username, String email, String password, String newpassword) {
        User user =userRepository.findByEmail(session);
        User u2 =userRepository.findByEmail(email);
        User u3=userRepository.findByUsername(username);
        if(u2 == null && u3==null && user.getPosition()!=password){
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
