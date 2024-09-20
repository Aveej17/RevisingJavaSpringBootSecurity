package org.example.LearningAuthentication.repository;

import org.example.LearningAuthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmailAddress(String emailAddress);

}
