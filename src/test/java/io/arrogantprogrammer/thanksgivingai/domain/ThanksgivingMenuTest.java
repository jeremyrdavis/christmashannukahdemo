package io.arrogantprogrammer.thanksgivingai.domain;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ThanksgivingMenuTest {

    @Test
    public void testCreatePromptForNone() {
        String prompt = ThanksgivingMenu.createPrompt(List.of());
        assertNotNull(prompt);
        assertEquals(ThanksgivingMenu.NONE_PROMPT, prompt);
    }

    @Test
    public void testCreatePromptForSingle() {
        String result = String.format(ThanksgivingMenu.SINGLE_PROMPT, "California", "California", "WESTPAC");
        System.out.println(result);
        String prompt = ThanksgivingMenu.createPrompt(List.of("California"));
        assertNotNull(prompt);
        assertTrue(prompt.contains("California"));
        assertTrue(prompt.contains("WESTPAC"));
    }

}
