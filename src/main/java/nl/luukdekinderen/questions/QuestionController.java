package nl.luukdekinderen.questions;

import nl.luukdekinderen.questions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/{questionId}")
    public Question GetQuestion(@PathVariable("questionId") Long questionId) {
        return questionService.getQuestion(questionId);
    }

    @GetMapping("/all")
    public List<Question> GetAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/random/{count}")
    public List<Question> GetQuestions(@PathVariable("count") Integer count) {
        return questionService.getRandom(count);
    }

    @PostMapping
    public void addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }


    @PutMapping
    public void updateQuestion(@RequestBody Question question) {
        questionService.updateQuestion(question);
    }

    @DeleteMapping
    public void deleteQuestion(@RequestBody Question question){
        questionService.deleteQuestion(question);
    }

}
