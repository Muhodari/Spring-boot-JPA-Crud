package com.myweb.services;

import com.myweb.models.User;
import com.myweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

@Autowired
    private UserRepository repo;

public List<User> listAll(){
    return (List<User>) repo.findAll();
}


}
