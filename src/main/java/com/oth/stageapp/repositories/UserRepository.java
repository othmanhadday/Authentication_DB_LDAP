package com.oth.stageapp.repositories;

import com.oth.stageapp.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Long> {
    UserApp findUserAppByUsername(String username);

    Optional<UserApp> findById(Optional<Long> id);
}
