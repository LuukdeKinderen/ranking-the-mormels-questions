package nl.luukdekinderen.questions.controllers;

import nl.luukdekinderen.questions.models.Question;
import nl.luukdekinderen.questions.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {
        "https://ranking-the-mormels-admin.herokuapp.com",
        "http://localhost:3000"
})
@RequestMapping("/cud")
public class CudController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public void addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }

    @PutMapping
    public void updateQuestion(@RequestBody Question question) {
        questionService.updateQuestion(question);
    }

    @DeleteMapping
    public void deleteQuestion(@RequestBody Question question) {
        questionService.deleteQuestion(question);
    }
}
