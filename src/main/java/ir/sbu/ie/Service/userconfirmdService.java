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
    ;

    public List unconfirmd() {

        List<User> findforconfiremd = userRepository.findforconfiremd();
        for(User s :findforconfiremd){
            System.out.println(s.getEmail());
        }

        return findforconfiremd;
    }

}
