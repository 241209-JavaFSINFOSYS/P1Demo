package com.revature.DAOs;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //make the class a bean
public interface UserDAO extends JpaRepository<User, Integer> {

    //Find a User by their Team id FK
    public List<User> findByTeamTeamId(int teamId);

}
