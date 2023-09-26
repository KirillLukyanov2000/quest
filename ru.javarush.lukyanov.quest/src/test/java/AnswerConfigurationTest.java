import ru.javarush.lukyanov.quest.model.AnswerConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AnswerConfigurationTest {
    private final String description = "Challenge accepted";
    private final int id = 1;
    private String failMessage = "You lost";

    @Test
    @DisplayName("new AnswerOption increments globalId")
    void answerOptionCreationIncrementsGlobalId() {
        AnswerConfiguration answerConfiguration1 = new AnswerConfiguration(description, true);
        AnswerConfiguration answerConfiguration2 = new AnswerConfiguration(description, false);
        AnswerConfiguration answerConfiguration3 = new AnswerConfiguration(description, true, failMessage);

        int currId = answerConfiguration1.getId();
        assertEquals(answerConfiguration3.getId(), currId + 2);
    }

    @Test
    @DisplayName("new AnswerOption with isTrueAnswer returns True")
    void answerOptionCreationWithTrueAnswerFlagReturnsTrue() {
        AnswerConfiguration answerConfiguration = new AnswerConfiguration(description, true);

        assertTrue(answerConfiguration.isTrueAnswer());
    }

    @Test
    @DisplayName("new AnswerOption without failMessage does not fail")
    void answerOptionCreationWithWithoutFailMessageDoesNotFail() {
        AnswerConfiguration answerConfiguration = new AnswerConfiguration(description, true);

        assertNull(answerConfiguration.getFailMessage());
    }

}
