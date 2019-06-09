package ir.sbu.ie.Repository;

import ir.sbu.ie.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository  extends JpaRepository<User,Integer> {
    public User findByEmail(String email);

    public User findByName(String name);

    public User findByUsername(String username);
}
