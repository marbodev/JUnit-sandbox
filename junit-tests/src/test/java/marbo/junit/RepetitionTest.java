package marbo.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.RepeatedTest.LONG_DISPLAY_NAME;
import static org.junit.jupiter.api.RepeatedTest.SHORT_DISPLAY_NAME;

public class RepetitionTest {

    @RepeatedTest(10)
    void testSomething_basic() {}

    @RepeatedTest(value = 10, name = LONG_DISPLAY_NAME)
    void testSomething_LONG() {}

    @RepeatedTest(value = 10, name = SHORT_DISPLAY_NAME)
    void testSomething_SHORT() {}

    //{displayName} :: repetition {currentRepetition} of {totalRepetitions}
    @RepeatedTest(value = 10, name = "{displayName} -> iteration {currentRepetition} of {totalRepetitions}")
    void testSomething_CUSTOM() {}

    @RepeatedTest(10)
    void testSomethingPassRepetitionInfo(RepetitionInfo repetitionInfo) {
        System.out.println("Current repetition= " + repetitionInfo.getCurrentRepetition());
    }

    @BeforeEach
    void before(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("BeforeEach: " + testInfo.getDisplayName());
    }

    @AfterEach
    void after(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("AfterEach: " + testInfo.getDisplayName());
    }

}
