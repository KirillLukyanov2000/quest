package ru.javarush.lukyanov.quest.model;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TeslaQuestConfiguration implements QuestConfiguration {

    private final HashMap<Integer, QuestLogic> questLevelConfig = new HashMap<>();

    @Override
    public void setQuestLevelConfig() {
        questLevelConfig.put(1, new QuestLogic(
                1,
                "Тебе выпал шанс прокатиться на Tesla Model X из Москвы до Нижнего Новгорода.\n" +
                        "Не забывай, что это электромобиль, и у тебя ограничен запас хода. \uD83D\uDD0B\n" +
                        "Рискнешь прокатиться с ветерком?",
                Arrays.asList(
                        new AnswerConfiguration("Супер, я готов. \uD83D\uDC4C", true),
                        new AnswerConfiguration("Я не рискну, в другой раз... \uD83C\uDF7C", false, "Ты отклонил вызов. Это фиаско. ❌")),
                2
        ));
        questLevelConfig.put(2, new QuestLogic(
                2,
                "Ты принял вызов, проехали половину пути, у тебя заряд батареи на 300 км,\n" +
                        " дотянешь или остановишься на зарядку? ⛽",
                Arrays.asList(
                        new AnswerConfiguration("Откажусь, машина-зверь, поеду просто быстрее.", false, "Машина встала в глухом лесу, телефон не ловит. Полное поражение.❌"),
                        new AnswerConfiguration("Надо зарядиться, до Нижнего Новгорода не дотяну никак... \uD83D\uDD0C", true)),
                3

        ));
        questLevelConfig.put(3, new QuestLogic(
                3,
                "Спускает колесо!!! Надо бы остановиться на ближайшем шиномонтаже и отремонтировать его.",
                Arrays.asList(
                        new AnswerConfiguration("Надо ремонтировать, так безопаснее. \uD83D\uDD27", true),
                        new AnswerConfiguration("Нормально, дотянем, нет желания тратить время. ⏳", false, "Колесо взорвалось, придется вызывать эвакуатор, это поражение!❌")),
                4
        ));
        questLevelConfig.put(4, new QuestLogic(
                4,
                "На въезде в Нижний Новгород останавливает сотрудник ГИБДД \uD83D\uDE98. Что будешь делать?",
                Arrays.asList(
                        new AnswerConfiguration("Ну что же, у меня все документы в порядке, остановлюсь, конечно. \uD83D\uDCF0", true),
                        new AnswerConfiguration("Он меня не догонит, полечу дальше. \uD83C\uDFCE", false, "Тебе догнали, машину конфискуют, это поражение!❌")),
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