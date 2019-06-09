package ir.sbu.ie.Repository;

import ir.sbu.ie.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository  extends JpaRepository<User,Integer> {
    @Query(value = "SELECT * FROM USER where confirmed = false", nativeQuery = true)
    public List<User> findforconfiremd() ;



    public User findByEmail(String email);

    public User findByName(String name);

    public User findByUsername(String username);


}
