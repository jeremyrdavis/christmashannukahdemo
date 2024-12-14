package io.arrogantprogrammer.christmashannukah.domain;

import io.arrogantprogrammer.christmashannukah.api.MenuRecord;

public class FestivusMenu {

    public static String createPrompt() {
        return NONE_PROMPT;
    }

    static final String NONE_PROMPT = """
            Create a list of dishes foods for a Festivus party. 
            Each food should have a name and a brief description, for example, item: Festivus Meatloaf description: Meatloaf served over a bed of romaine lettuce. 
            The menu should include Festivus Meatloaf and Pepperidge Farm Cake with M&M's.  You can add 2 or 3 other dishes.
            Return the menu in the following json format: { \\"menu\\":[{\\"item\\": \\"string\\", \\"description:\\": \\"string\\"}].  Return only json in the specified, valid format.
        """;

    public static String createInvitationPrompt(MenuRecord menuRecord) {
        StringBuilder stringBuilder = new StringBuilder(IMAGE_PROMPT)
                .append("\nMains");
        menuRecord.items().forEach(item -> {
            stringBuilder.append("\n- ").append(item.item());
            stringBuilder.append("\n  ").append(item.description());
        });
        stringBuilder.append("\nDo not include any text or words in the image.  Ignore the \"Revised Prompt\"");
        return stringBuilder.toString();
    }

    private static final String IMAGE_PROMPT = """
        Create a visual to be used in an invitation to a Festivus party. Do not include any text; visuals only.  Incorporate Festivus imagery like the Festivus pole, a plain silver pole and feats of strength along with any or all of the following finger foods that will be served at the party:
        """;

}
