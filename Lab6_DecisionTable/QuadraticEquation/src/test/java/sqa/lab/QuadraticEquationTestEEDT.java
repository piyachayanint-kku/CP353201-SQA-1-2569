package sqa.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("QuadraticEquation - Extended Entry Decision Table")
class QuadraticEquationTestEEDT {

    private final QuadraticEquation sut = new QuadraticEquation();

    @DisplayName("EEDT rules")
    @ParameterizedTest(name = "{0} ({1}): a={2}, b={3}, c={4} -> {5}")
    @CsvSource({
        // Rule#, TCID,  a,   b,   c,   expected
        "1, TC001, 0,   5,   3,   NOT_QUADRATIC",
        "2, TC002, 0,   0,   7,   NOT_QUADRATIC",
        "4, TC004, 1,   5,   2,   REAL_ROOTS",
        "5, TC005, 1,   4,   4,   EQUAL_ROOTS",
        "6, TC006, 1,   2,   3,   IMAGINARY_ROOTS",

        "1, TC007, 0,   100, 100, NOT_QUADRATIC",
        "4, TC008, 1,   100, 0,   REAL_ROOTS",
        "4, TC009, 100, 100, 24,  REAL_ROOTS",
        "5, TC010, 100, 100, 25,  EQUAL_ROOTS",
        "6, TC011, 100, 0,   100, IMAGINARY_ROOTS"
    })
    void testEedtRules(int ruleNo, String testCaseId, int a, int b, int c, RootNature expected) {
        RootNature actual = sut.determineRootNature(a, b, c);
        assertEquals(expected, actual,
            String.format("Rule#%d / %s failed for a=%d, b=%d, c=%d (discriminant = %d)",
                          ruleNo, testCaseId, a, b, c, (b * b) - (4 * a * c)));
    }
}