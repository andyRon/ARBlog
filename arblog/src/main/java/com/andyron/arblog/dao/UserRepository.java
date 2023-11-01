package com.andyron.arblog.dao;

import com.andyron.arblog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andy Ron
 */
public interface UserRepository  extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
