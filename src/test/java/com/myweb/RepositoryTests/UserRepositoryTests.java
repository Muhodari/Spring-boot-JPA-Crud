package com.myweb.RepositoryTests;

import com.myweb.models.User;
import com.myweb.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Test
    public void  TestAddNew(){

        User user = new User();

        user.setEmail("sagamba@gmail.com");
        user.setPassword("sagamaba123");
        user.setFirstName("sagamba");
        user.setLastName("sadate");
        User savedUser = repo.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

}
