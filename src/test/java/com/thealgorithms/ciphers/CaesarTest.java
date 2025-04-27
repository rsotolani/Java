package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CaesarTest {

    Caesar caesar = new Caesar();

    @Test
    void caesarEncryptTest() {
        // given
        String textToEncrypt = "Encrypt this text";

        // when
        String cipherText = caesar.encode(textToEncrypt, 5);

        // then
        assertEquals("Jshwduy ymnx yjcy", cipherText);
    }

    @Test
    void caesarDecryptTest() {
        // given
        String encryptedText = "Jshwduy ymnx yjcy";

        // when
        String cipherText = caesar.decode(encryptedText, 5);

        // then
        assertEquals("Encrypt this text", cipherText);
    }

    @Test
    void caesarEncryptWithInvalidCharacter() {
        // given
        String textToEncrypt = "Hello! How are you?"; // Contém "!" e "?"

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            caesar.encode(textToEncrypt, 3);
        });

        assertEquals("Message contains invalid characters. Only Latin letters and spaces are allowed.", exception.getMessage());
    }

    @Test
    void caesarDecryptWithInvalidCharacter() {
        // given
        String encryptedText = "Khoor! Jqw ctg aqw?"; // Contém "!" e "?"

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            caesar.decode(encryptedText, 3);
        });

        assertEquals("Encrypted message contains invalid characters. Only Latin letters and spaces are allowed.", exception.getMessage());
    }
}
