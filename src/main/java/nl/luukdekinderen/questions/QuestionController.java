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
    public Question GetQuestion(@PathVariable("questionId") String questionId) {
        questionService.addQuestion(new Question("test","test","test"));
        return questionService.getQuestion(questionId);
        //TODO: get from db

/*        Question question = new Question(
                "Wie is de langste speler?",
                "lange Jan, drink maar %d slokken daarboven!",
                "jij bent dan wel de kleinste, maar als je %d sokken drinkt ben je wel een grote speler!"
        );
        return question;*/
    }

    @GetMapping("/count")
    public long getCount(){

        return questionService.count();
    }

    @GetMapping("/random/{count}")
    public Question[] GetQuestions(@PathVariable("count") Integer count) {
        //TODO: get from db
        return questionService.getRandom(count);
/*         Question[] questions = new Question[count];

       for (int i =0; i<count; i++){
            Question question = new Question(
                    "Wie is de langste speler?",
                    "lange Jan, drink maar %d slokken daarboven",
                    "jij bent dan wel de kleinste, Maar als je %d sokken drinkt ben je wel een grote speler"
            );
            questions[i] = question;
        }
        return questions;*/
    }

    @PostMapping()
    public void addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }

    @PutMapping()
    public void updateQuestion(@RequestBody Question question) {
        questionService.updateQuestion(question);
    }

    @DeleteMapping()
    public void deleteQuestion(@RequestBody Question question){
        questionService.deleteQuestion(question);
    }

}
