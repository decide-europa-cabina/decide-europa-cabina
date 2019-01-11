package com.working4enjoyment.decidecabina;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Voting {

    private Integer id;
    private String name;
    private String desc;
    private Map<String, Map<Integer, String>> options;
    private Question question;
    private Calendar startDate;
    private Calendar endDate;

    public Voting(Integer id, String name, String desc, Map<String, Map<Integer, String>> options, Question question, Calendar startDate, Calendar endDate) {
        this.id = id;
        this.desc = desc;
        this.options = options;
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

    public Map<String, Map<Integer, String>> getOptions() {
        return new HashMap<String, Map<Integer, String>>(options);
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

    public void setOptions(Map<String, Map<Integer, String>> options) {
        this.options = options;
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
