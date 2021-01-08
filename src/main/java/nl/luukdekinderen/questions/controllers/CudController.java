package nl.luukdekinderen.questions.controllers;

import nl.luukdekinderen.questions.models.Question;
import nl.luukdekinderen.questions.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cud")
public class CudController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/test")
    public String loggedIn(){
        return "test";
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
