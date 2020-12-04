package nl.luukdekinderen.rankingthemormels.resources;

import nl.luukdekinderen.rankingthemormels.models.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @GetMapping("/{questionId}")
    public Question GetQuestion(@PathVariable("questionId") Integer questionId) {
        //TODO: get from db

        Question question = new Question(
                questionId,
                "Wie is de langste speler?",
                "lange Jan, drink maar %d slokken daarboven!",
                "jij bent dan wel de kleinste, maar als je %d sokken drinkt ben je wel een grote speler!"
        );
        return question;
    }

    @GetMapping("/random/{count}")
    public Question[] GetQuestions(@PathVariable("count") Integer count) {
        //TODO: get from db
        Question[] questions = new Question[count];

        for (int i =0; i<count; i++){
            Question question = new Question(
                    i,
                    "Wie is de langste speler?",
                    "lange Jan, drink maar %d slokken daarboven",
                    "jij bent dan wel de kleinste, Maar als je %d sokken drinkt ben je wel een grote speler"
            );
            questions[i] = question;
        }
        return questions;
    }

}
