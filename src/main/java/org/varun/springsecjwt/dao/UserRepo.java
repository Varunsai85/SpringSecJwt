package org.varun.springsecjwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.varun.springsecjwt.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
