package ru.javarush.lukyanov.quest.model;


import java.util.Map;

public interface QuestConfiguration {
    void setQuestLevelConfig();

    Map<Integer, QuestLogic> getQuestLevelConfig();

    int getInitialLevelId();
}
