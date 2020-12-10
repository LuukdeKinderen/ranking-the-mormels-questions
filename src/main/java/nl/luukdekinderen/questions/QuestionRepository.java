package nl.luukdekinderen.questions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface QuestionRepository extends CrudRepository<Question, Long> {

    long count();
    Page<Question> findAll(Pageable pageable);


}
