import ru.javarush.lukyanov.quest.model.AnswerConfiguration;
import ru.javarush.lukyanov.quest.model.QuestLogic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class QuestLogicTest {

    private final List<AnswerConfiguration> options = Arrays.asList(
            new AnswerConfiguration("Accept", true),
            new AnswerConfiguration("Decline", false, "You declined the challenge and lost")
    );
    private final int firstStepId = 1;
    private final int secondStepId = 2;
    private final String description = "Do you want to drive a new Electric car?";

    @Test
    @DisplayName("new Step with null description parameter fails")
    void constructorFailsWithNullDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuestLogic(
                        firstStepId,
                        null,
                        options,
                        secondStepId
                ));
    }

    @Test
    @DisplayName("new Step with null options parameter fails")
    void constructorFailsWithNullOptions() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuestLogic(
                        firstStepId,
                        description,
                        null,
                        secondStepId
                ));
    }

    @Test
    @DisplayName("First step points to the next step")
    void firstStepIdPointsToSecondStepId() {
        QuestLogic firstQuestLogic = new QuestLogic(
                firstStepId,
                description,
                options,
                secondStepId
        );

        assertEquals(firstQuestLogic.getNextStepId(), secondStepId);
    }
}
