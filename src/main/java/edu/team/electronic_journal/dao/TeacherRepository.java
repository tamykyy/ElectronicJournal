package edu.team.electronic_journal.dao;

import edu.team.electronic_journal.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
    Optional<Teacher> findTeacherByEmail (String email);
}
