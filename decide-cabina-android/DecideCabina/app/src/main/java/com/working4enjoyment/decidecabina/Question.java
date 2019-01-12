package com.working4enjoyment.decidecabina;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Question {

    private String desc;
    private List<Map<Integer, String>> options;

    public Question(String desc, List<Map<Integer, String>> options) {
        this.desc = desc;
        this.options = options;
    }

    public Question(Question question){
        this.desc = question.getDesc();
        this.options= question.getOptions();
    }

    public String getDesc() {
        return desc;
    }

    public List<Map<Integer, String>> getOptions() {
        return new ArrayList<>(options);
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setOptions(List<Map<Integer, String>> options) {
        this.options = options;
    }
}
