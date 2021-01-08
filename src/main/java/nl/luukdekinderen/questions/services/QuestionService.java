package nl.luukdekinderen.questions.services;

import nl.luukdekinderen.questions.repositories.QuestionRepository;
import nl.luukdekinderen.questions.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Question getQuestion(Long id) throws Exception  {
        Optional<Question> question = questionRepository.findById(id);

        question.orElseThrow(() -> new Exception("Not found with id: " + id));

        return questionRepository.findById(id).get();
    }

    public List<Question> getRandom(Integer count) {
        Random r = new Random();
        Long qty = questionRepository.count();

        List<Question> questions = new ArrayList<>();
        List<Integer> rows = randomRows(qty, count);

        for (int i = 0; i < count; i++) {

            Page<Question> questionPage = questionRepository.findAll(PageRequest.of(rows.get(i), 1));

            Question q = null;
            if (questionPage.hasContent()) {
                q = questionPage.getContent().get(0);
            }
            questions.add(q);
        }

        return questions;
    }

    private List<Integer> randomRows(Long tableSize, Integer count) {
        ArrayList<Integer> tableRows = new ArrayList<Integer>();
        for (int i = 1; i < tableSize; i++) {
            tableRows.add(i);
        }
        Collections.shuffle(tableRows);

        ArrayList<Integer> randomTableRows = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            randomTableRows.add(tableRows.get(i));
        }
        return randomTableRows;
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
