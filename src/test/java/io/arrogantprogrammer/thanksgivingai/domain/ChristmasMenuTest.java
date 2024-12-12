package io.arrogantprogrammer.thanksgivingai.domain;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChristmasMenuTest {

    @Test
    public void testCreatePromptForNone() {
        String prompt = ChristmasMenu.createPrompt(List.of());
        assertNotNull(prompt);
        assertEquals(ChristmasMenu.NONE_PROMPT, prompt);
    }

    @Test
    public void testCreatePromptForSingle() {
        String result = String.format(ChristmasMenu.SINGLE_PROMPT, "California", "California", "WESTPAC");
        System.out.println(result);
        String prompt = ChristmasMenu.createPrompt(List.of("California"));
        assertNotNull(prompt);
        assertTrue(prompt.contains("California"));
        assertTrue(prompt.contains("WESTPAC"));
    }

}
