package nl.luukdekinderen.rankingthemormels.models;

public class Question {

    private Integer questionId;
    private String question;
    private String firstPersAnnotation;
    private String lastBestAnnotation;

    public Question() {

    }

    public Question(Integer questionId, String question, String firstPersAnnotation, String lastBestAnnotation) {
        this.questionId = questionId;
        this.question = question;
        this.firstPersAnnotation = firstPersAnnotation;
        this.lastBestAnnotation = lastBestAnnotation;
    }

}

