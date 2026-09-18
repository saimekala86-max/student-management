package com.sai.studentmanagement.repository;

import com.sai.studentmanagement.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
        Students findByName(String name);
        Students findByEmail(String email);

       // Students findByUsername(String username);


}

