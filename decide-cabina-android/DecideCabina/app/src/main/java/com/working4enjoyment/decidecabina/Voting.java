package com.working4enjoyment.decidecabina;

<<<<<<< HEAD
=======
import java.io.Serializable;
>>>>>>> CLIENTE_VOTACION_ANDROID_#4
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class Voting implements Serializable {


    private Integer id;
    private String name;
    private String desc;
    private Question question;
    private Calendar startDate;
    private Calendar endDate;


    public Voting(Integer id, String name, String desc, Question question, Calendar startDate, Calendar endDate) {
        this.id = id;
        this.desc = desc;
        this.question = question;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Question getQuestion() {
        return new Question(question);
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }
}
