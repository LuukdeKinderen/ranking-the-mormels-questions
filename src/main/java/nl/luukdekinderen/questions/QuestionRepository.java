package nl.luukdekinderen.questions;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question,String> {

}
