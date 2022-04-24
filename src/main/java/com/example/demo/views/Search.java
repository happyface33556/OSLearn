package com.example.demo.views;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Search {

    @Id
    private String parameter;
    private String input;

    public Search(String parameter, String input) {
        this.parameter = parameter;
        this.input = input;
    };

    public Search() {
    }

    public String getParameter() {
        return parameter;
    }

    public String getInput() {
        return input;
    }
}
