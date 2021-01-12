package nl.luukdekinderen.questions.controllers;

import nl.luukdekinderen.questions.models.Question;
import nl.luukdekinderen.questions.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {
        "https://ranking-the-mormels-admin.herokuapp.com",
        "https://ranking-the-mormels-logic.herokuapp.com",
        "http://localhost:3000",
        "http://localhost:8080"
})
@RequestMapping("/question")
public class ReadController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/{questionId}")
    public Question GetQuestion(@PathVariable("questionId") Long questionId) throws Exception {
        try {
            return questionService.getQuestion(questionId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @GetMapping("/all")
    public List<Question> GetAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/random/{count}")
    public List<Question> GetQuestions(@PathVariable("count") Integer count) {
        return questionService.getRandom(count);
    }

    @ExceptionHandler
    public void handleException() {

    }
}
