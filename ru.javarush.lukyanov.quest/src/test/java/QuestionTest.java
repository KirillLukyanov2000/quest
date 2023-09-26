import ru.javarush.lukyanov.quest.model.AnswerConfiguration;
import ru.javarush.lukyanov.quest.model.entity.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class QuestionTest {

    private final List<AnswerConfiguration> options = Arrays.asList(
            new AnswerConfiguration("Accept", true),
            new AnswerConfiguration("Decline", false, "You declined the challenge and lost")
    );
    private final String description = "Do you want to drive a new Electric car?";

    @Test
    @DisplayName("new Question with null description parameter fails")
    void constructorFailsWithNullDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new Question(
                        null,
                        options
                ));
    }

    @Test
    @DisplayName("new Question with null options parameter fails")
    void constructorFailsWithNullOptions() {
        assertThrows(IllegalArgumentException.class, () ->
                new Question(
                        description,
                        null
                ));
    }
}
