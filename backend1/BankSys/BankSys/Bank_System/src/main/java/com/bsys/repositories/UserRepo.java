package com.bsys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bsys.models.User;
public interface UserRepo extends JpaRepository<User,Integer>{
     User findByEmail(String email);
}
