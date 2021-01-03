package edu.lodz.pl.biu.backend.repository;

import edu.lodz.pl.biu.backend.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
