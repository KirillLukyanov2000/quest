package ru.javarush.lukyanov.quest.model.entity;

import ru.javarush.lukyanov.quest.model.AnswerConfiguration;

import java.util.List;
import java.util.Objects;

public class Question {
    private final List<AnswerConfiguration> options;
    private final String description;

    public Question(String description, List<AnswerConfiguration> options) {
        if (Objects.isNull(description)) {
            throw new IllegalArgumentException("description parameter can't be null.");
        } else if (Objects.isNull(options)) {
            throw new IllegalArgumentException("options parameter can't be null.");
        }
        this.description = description;
        this.options = options;
    }

    public List<AnswerConfiguration> getOptions() {
        return options;
    }

    public String getDescription() {
        return description;
    }
}