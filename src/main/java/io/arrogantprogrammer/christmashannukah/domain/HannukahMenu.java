package io.arrogantprogrammer.christmashannukah.domain;

import java.util.List;

public class HannukahMenu {

    public static String createPrompt() {
        return BASIC_PROMPT;
    }

    static final String BASIC_PROMPT = """
            Create a list of finger foods for a Hannukah party. 
            There should be between 3 and 6 savory dishes and 2 or 3 sweet dishes.  Be sure to include latkes as one of the dishes!
            Each food should have a name and a brief description, for example, item: Cranberry Sauce Meatballs description: Tender meatballs simmered in a tangy cranberry sauce, a festive twist on a classic dish.. 
            Return the menu in the following json format: { \\"menu\\":[{\\"item\\": \\"string\\", \\"description:\\": \\"string\\"}].  Return only json in the specified, valid format.
        """;

}
