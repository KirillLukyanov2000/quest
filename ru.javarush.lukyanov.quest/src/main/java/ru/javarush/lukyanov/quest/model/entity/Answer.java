package ru.javarush.lukyanov.quest.model.entity;

public class Answer {
    private final boolean success;
    private final int nextStepId;
    private final String message;

    public Answer(boolean success, int nextStepId, String message) {
        this.success = success;
        this.nextStepId = nextStepId;
        this.message = message;
    }
}