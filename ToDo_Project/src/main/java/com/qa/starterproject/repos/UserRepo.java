package com.qa.starterproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.qa.starterproject.persistence.domain.UserDomain;

public interface UserRepo extends JpaRepository <UserDomain, Long> {

}