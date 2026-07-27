package com.sqa.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ShiftCipherTest {

    private ShiftCipher cipher;

    @BeforeEach
    void setUp() {
        cipher = new ShiftCipher();
    }


    @Nested
    @DisplayName("encrypt(plainText, key)")
    class EncryptTests {

        @DisplayName("Valid EC - TC001~TC005")
        @ParameterizedTest(name = "{0}: encrypt(\"{1}\", key={2}) => \"{3}\"")
        @CsvSource({
                "TC001, ATTACK, 0,  ATTACK",
                "TC002, ATTACK, 17, RKKRTB",
                "TC003, ATTACK, 26, ATTACK",
                "TC004, ATTACK, 30, EXXEGO",
                "TC005, ATTACK, -4, WPPWYG",
                "TC0011, AttAck, 17, RkkRtb"
        })
        void encrypt_validInput_returnsExpectedCipherText(String tcId, String plainText, int key, String expected) {
            String actual = cipher.encrypt(plainText, key);
            assertEquals(expected, actual, tcId + " failed");
        }

        @DisplayName("Invalid EC - TC006~TC009")
        @ParameterizedTest(name = "{0}: encrypt(\"{1}\", key={2}) should throw IllegalArgumentException")
        @CsvSource(value = {
                "TC006, AttAck,     17",
                "TC007, ATT4CK,     17",
                "TC008, '',         17",
                "TC009, NULL_TEXT,  17"
        }, nullValues = "NULL_TEXT")
        void encrypt_invalidInput_throwsIllegalArgumentException(String tcId, String plainText, int key) {
            assertThrows(IllegalArgumentException.class,
                    () -> cipher.encrypt(plainText, key),
                    tcId + " expected IllegalArgumentException");
        }
    }

    @Nested
    @DisplayName("decrypt(cipherText, key)")
    class DecryptTests {

        @DisplayName("Valid EC - TC001~TC005")
        @ParameterizedTest(name = "{0}: decrypt(\"{1}\", key={2}) => \"{3}\"")
        @CsvSource({
                "TC001, RKKRTB, 0,   RKKRTB",
                "TC002, RKKRTB, 17,  ATTACK",
                "TC003, ATTACK, 26,  ATTACK",
                "TC004, EXXEGO, 30,  ATTACK",
                "TC005, WPPWYG, -4,  ATTACK"
                
        })
        void decrypt_validInput_returnsExpectedPlainText(String tcId, String cipherText, int key, String expected) {
            String actual = cipher.decrypt(cipherText, key);
            assertEquals(expected, actual, tcId + " failed");
        }

        @DisplayName("Invalid EC - TC006~TC009")
        @ParameterizedTest(name = "{0}: decrypt(\"{1}\", key={2}) should throw IllegalArgumentException")
        @CsvSource(value = {
                "TC006, RkkRTB,     17",
                "TC007, RKK4TB,     17",
                "TC008, '',         17",
                "TC009, NULL_TEXT,  17"
        }, nullValues = "NULL_TEXT")
        void decrypt_invalidInput_throwsIllegalArgumentException(String tcId, String cipherText, int key) {
            assertThrows(IllegalArgumentException.class,
                    () -> cipher.decrypt(cipherText, key),
                    tcId + " expected IllegalArgumentException");
        }
    }

}
