package nl.luukdekinderen.rankingthemormels.resources;

import nl.luukdekinderen.rankingthemormels.models.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @GetMapping("/{questionId}")
    public Question GetQuestion(@PathVariable("questionId") Integer questionId) {
        //TODO: get from db

        Question question = new Question(
                questionId,
                "Wie is de langste speler?",
                "Lange Jan, drink maar {drinkcount} slokken daarboven",
                "Jij bent dan wel de kleinste, Maar als je {drinkcount} sokken drinkt ben je wel een grote speler"
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
                    "Lange Jan, drink maar {drinkcount} slokken daarboven",
                    "Jij bent dan wel de kleinste, Maar als je {drinkcount} sokken drinkt ben je wel een grote speler"
            );
            questions[i] = question;
        }


        return questions;
    }

}
