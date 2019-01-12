package com.working4enjoyment.decidecabina;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Question implements Serializable {

    private String desc;
    private List<Map<String, String>> options;

    public Question(String desc, List<Map<String, String>> options) {
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

    public List<Map<String, String>> getOptions() {
        return new ArrayList<>(options);
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setOptions(List<Map<String, String>> options) {
        this.options = options;
    }
}
