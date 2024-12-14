package io.arrogantprogrammer.christmashannukah.domain;

import io.arrogantprogrammer.christmashannukah.api.MenuRecord;

public class HannukahMenu {


    public static String createInvitationPrompt(MenuRecord menuRecord) {
        StringBuilder stringBuilder = new StringBuilder(IMAGE_PROMPT);
        menuRecord.items().forEach(item -> {
            stringBuilder.append("\n- ").append(item.item());
            stringBuilder.append("\n  ").append(item.description());
        });
        stringBuilder.append("\nDo not include any text in the image.  Ignore the \"Revised Prompt\"");
        return stringBuilder.toString();
    }

    public static String createMenuPrompt() {
        return BASIC_PROMPT;
    }

    static final String IMAGE_PROMPT = """
        Create a visual only invitation for a Hannukah party. Do not include any text.  Use traditional Hannukah imagery along with any or all of the following finger foods that will be served at the party:
        """;

    static final String BASIC_PROMPT = """
            Create a list of finger foods for a Hannukah party. 
            There should be between 3 and 6 savory dishes and 2 or 3 sweet dishes.  Be sure to include latkes as one of the dishes!
            Each food should have a name and a brief description, for example, item: Cranberry Sauce Meatballs description: Tender meatballs simmered in a tangy cranberry sauce, a festive twist on a classic dish.. 
            Return the menu in the following json format: { \\"menu\\":[{\\"item\\": \\"string\\", \\"description:\\": \\"string\\"}].  Return only json in the specified, valid format.
        """;

}
