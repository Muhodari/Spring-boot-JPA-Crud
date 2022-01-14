package com.myweb.repository;

import com.myweb.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

public Long countById(Integer id);

}
