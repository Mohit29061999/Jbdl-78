package com.jbdl.LibraryManagement.constants;

//bookYype

public enum Operator {
    EQUALS("="),
    NOTEQUALS("!="),
    LIKE("like"),
    GREATERTHAN(">"),
    LESSTHAN("<");

    private String value;
    Operator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
