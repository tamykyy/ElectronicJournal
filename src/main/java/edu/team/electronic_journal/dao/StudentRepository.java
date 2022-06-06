package edu.team.electronic_journal.dao;

import edu.team.electronic_journal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
