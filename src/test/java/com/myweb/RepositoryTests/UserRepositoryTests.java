package com.myweb.RepositoryTests;

import com.myweb.models.User;
import com.myweb.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Test
    public void  TestAddNew(){

        User user = new User();

        user.setEmail("rugamba@gmail.com");
        user.setPassword("ruhgamba123");
        user.setFirstName("rugamba");
        user.setLastName("sadate");
        User savedUser = repo.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void listAll(){
     Iterable<User> users = repo.findAll();
     Assertions.assertThat(users).hasSizeGreaterThan(0);

     for(User user:users){
         System.out.println(user);
     }
    }

@Test
    public void testUpdate(){
        Integer userId=1;
    Optional<User> optionalUser = repo.findById(userId);

    User user= optionalUser.get();
    user.setEmail("muco@gmail.com");
    user.setPassword("muco123");
    repo.save(user);

    User updatedUser = repo.findById(userId).get();
    Assertions.assertThat(updatedUser.getPassword()).isEqualTo("muco123");

}



}
