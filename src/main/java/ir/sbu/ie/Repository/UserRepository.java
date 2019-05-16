package ir.sbu.ie.Repository;

import ir.sbu.ie.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer>{
    public User findByEmail(String email);
}
