package ir.sbu.ie.Service;

import ir.sbu.ie.Entity.User;
import ir.sbu.ie.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;


@Service
public class nineService{

    @Inject
    private UserRepository userRepository;
    ;

    public Object[] userList() {

        List<User> find= userRepository.findAll();

        return find.toArray();
    }

    public String confrimed(String username) {

        User user=userRepository.findByUsername(username);
        if(user !=null){
            user.setConfirmed(true);
            userRepository.save(user);

            return "true";
        }
        return "false";}

    public String deactive(String Username) {
        User user=userRepository.findByUsername(Username);
        if(user !=null){
            user.setConfirmed(false);
            userRepository.save(user);
            return "true";
        }
        return "false";}

    public boolean profileset(String old, String name, String username, String email, String newpassword) {
        User user =userRepository.findByEmail(old);
        User u2 =userRepository.findByEmail(email);
        User u3=userRepository.findByUsername(username);
        if(u2 == null && u3==null){
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
