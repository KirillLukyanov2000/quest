package ru.javarush.lukyanov.quest.model;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PorscheQuestConfiguration implements QuestConfiguration {

    private final HashMap<Integer, QuestLogic> questLevelConfig = new HashMap<>();
    @Override
    public void setQuestLevelConfig(){
        questLevelConfig.put(1, new QuestLogic(
                1,
                "Тебе выпал шанс прокатиться на Porsche Taycan Turbo S из Москвы до Санкт-Петербурга.\n" +
                        "Не забывай, что это электромобиль, и у тебя ограничен запас хода.\n" +
                        "Рискнешь прокатиться с ветерком?",
                Arrays.asList(
                        new AnswerConfiguration("Супер, я готов.", true),
                        new AnswerConfiguration("Я не рискну, в другой раз...", false, "Ты отклонил вызов. Это фиаско.")),
                2
        ));
        questLevelConfig.put(2, new QuestLogic(
                2,
                "Ты принял вызов, проехали половину пути, у тебя заряд батареи на 200 км,\n" +
                        " дотянешь или остановишься на зарядку?",
                Arrays.asList(
                        new AnswerConfiguration("Надо зарядиться, до Санкт-Петербурга не дотяну никак...", true),
                        new AnswerConfiguration("Откажусь, машина-зверь, поеду просто быстрее.", false, "Машина встала в глухом лесу, телефон не ловит. Полное поражение.")),
                3
        ));
        questLevelConfig.put(3, new QuestLogic(
                3,
                "На въезде в Санкт-Петербург останавливает сотрудник ГИБДД. Что будешь делать?",
                Arrays.asList(
                        new AnswerConfiguration("Ну что же, у меня все документы в порядке, остановлюсь, конечно.", true),
                        new AnswerConfiguration("Он меня не догонит, полечу дальше.", false, "Тебе догнали, машину конфискуют, это поражение!")),
                0
        ));
    }

    @Override
    public Map<Integer, QuestLogic> getQuestLevelConfig() {
        return questLevelConfig;
    }

    @Override
    public int getInitialLevelId() {
        return 1;
    }
}