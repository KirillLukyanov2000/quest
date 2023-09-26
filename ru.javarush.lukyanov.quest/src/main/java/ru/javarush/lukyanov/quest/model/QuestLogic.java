package ru.javarush.lukyanov.quest.model;


import java.util.List;
import java.util.Objects;

public class QuestLogic {
    private final int id;
    private final String description;
    private final List<AnswerConfiguration> options;
    private final int nextStepId;

    public QuestLogic(int id, String description, List<AnswerConfiguration> options, int nextStepId) {
        if (Objects.isNull(description)) {
            throw new IllegalArgumentException("description parameter can't be null.");
        } else if (Objects.isNull(options)) {
            throw new IllegalArgumentException("options parameter can't be null.");
        }
        this.id = id;
        this.description = description;
        this.options = options;
        this.nextStepId = nextStepId;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public List<AnswerConfiguration> getOptions() {
        return options;
    }

    public int getNextStepId() {
        return nextStepId;
    }

    public AnswerConfiguration getAnswerOptionById(int optionId) {
        return this.options.stream()
                .filter(option -> option.getId() == optionId)
                .findFirst()
                .orElseGet(null);
    }
}