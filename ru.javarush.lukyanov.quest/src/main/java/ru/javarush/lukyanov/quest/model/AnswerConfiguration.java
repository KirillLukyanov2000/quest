package ru.javarush.lukyanov.quest.model;


import java.util.Objects;

public class AnswerConfiguration {
    private final String description;
    private static int totalCount = 1;
    private final int id;
    private final boolean isTrueAnswer;
    private String failMessage;

    public AnswerConfiguration(String description, boolean isTrueAnswer) {
        if (Objects.isNull(description)) {
            throw new IllegalArgumentException("description parameter can't be null.");
        }
        totalCount++;
        this.id = totalCount;
        this.description = description;
        this.isTrueAnswer = isTrueAnswer;
    }

    public AnswerConfiguration(String description, boolean isTrueAnswer, String failMessage) {
        this(description, isTrueAnswer);
        this.failMessage = failMessage;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isTrueAnswer() {
        return isTrueAnswer;
    }

    public String getFailMessage() {
        return failMessage;
    }
}