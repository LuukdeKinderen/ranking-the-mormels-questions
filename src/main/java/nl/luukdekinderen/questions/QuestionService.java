package nl.luukdekinderen.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

    public Question getQuestion(Long id) {
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

        return  questions;
    }

    private List<Integer> randomRows(Long tableSize, Integer count){
        ArrayList<Integer> tableRows = new ArrayList<Integer>();
        for (int i=1; i<tableSize; i++) {
            tableRows.add(i);
        }
        Collections.shuffle(tableRows);

        ArrayList<Integer> randomTableRows = new ArrayList<Integer>();
        for (int i=0; i<count; i++) {
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
