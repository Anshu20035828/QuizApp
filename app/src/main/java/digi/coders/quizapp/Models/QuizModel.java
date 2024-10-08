package digi.coders.quizapp.Models;

public class QuizModel {
  String id,question,answer_a,answer_b,answer_c,answer_d,answer_e,answer_f,correct_answer,name,category,difficulty;

    public QuizModel() {
    }

    public QuizModel(String question,String answer_a, String answer_b, String answer_c, String answer_d, String answer_e, String answer_f) {
        this.question=question;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.answer_e = answer_e;
        this.answer_f = answer_f;
    }

    public QuizModel(String id, String question, String answer_a, String answer_b, String answer_c, String answer_d, String answer_e, String answer_f, String correct_answer, String name, String category, String difficulty) {
        this.id = id;
        this.question = question;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.answer_e = answer_e;
        this.answer_f = answer_f;
        this.correct_answer = correct_answer;
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_a() {
        return answer_a;
    }

    public void setAnswer_a(String answer_a) {
        this.answer_a = answer_a;
    }

    public String getAnswer_b() {
        return answer_b;
    }

    public void setAnswer_b(String answer_b) {
        this.answer_b = answer_b;
    }

    public String getAnswer_c() {
        return answer_c;
    }

    public void setAnswer_c(String answer_c) {
        this.answer_c = answer_c;
    }

    public String getAnswer_d() {
        return answer_d;
    }

    public void setAnswer_d(String answer_d) {
        this.answer_d = answer_d;
    }

    public String getAnswer_e() {
        return answer_e;
    }

    public void setAnswer_e(String answer_e) {
        this.answer_e = answer_e;
    }

    public String getAnswer_f() {
        return answer_f;
    }

    public void setAnswer_f(String answer_f) {
        this.answer_f = answer_f;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
