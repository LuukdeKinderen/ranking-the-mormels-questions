package nl.luukdekinderen.questions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String question;
    private String firstAnnotation;
    private String lastBestAnnotation;

    public Question() {

    }

    public Question(String question, String firstAnnotation, String lastBestAnnotation) {
        this.question = question;
        this.firstAnnotation = firstAnnotation;
        this.lastBestAnnotation = lastBestAnnotation;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getFirstAnnotation() {
        return firstAnnotation;
    }

    public String getLastBestAnnotation() {
        return lastBestAnnotation;
    }
}

