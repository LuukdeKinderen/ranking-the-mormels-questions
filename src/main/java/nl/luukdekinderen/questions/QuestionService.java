package nl.luukdekinderen.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll()
                .forEach(questions::add);
        return questions;
    }

    public Question getQuestion(String id) {
        return questionRepository.findById(id).get();
    }

    public Question[] getRandom(Integer count) {
        return new Question[count];
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public void updateQuestion(Question question) {
        questionRepository.save(question);
    }

    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }

    public long count() {
        return questionRepository.count();
    }


}
