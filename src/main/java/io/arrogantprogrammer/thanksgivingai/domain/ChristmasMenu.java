package io.arrogantprogrammer.thanksgivingai.domain;

import io.arrogantprogrammer.thanksgivingai.api.MenuRecord;
import io.arrogantprogrammer.thanksgivingai.utils.StateCodeUtility;
import io.arrogantprogrammer.thanksgivingai.utils.StateCodeMapping;

import java.util.ArrayList;
import java.util.List;

public class ChristmasMenu {

    public static String createPrompt(List<String> states) {
        if (states != null && states.size() == 0) {
            return NONE_PROMPT;
        } else {
            List<StateCodeMapping> stateCodeMappings = new ArrayList<>(states.size());
            states.forEach(state -> {
                stateCodeMappings.add(StateCodeUtility.getStateCodeMapping(state));
            });
            if (stateCodeMappings.size() == 1) {
                StateCodeMapping stateCodeMapping = stateCodeMappings.get(0);
                return String.format(SINGLE_PROMPT, stateCodeMapping.stateName(), stateCodeMapping.stateName(), stateCodeMapping.region(), stateCodeMapping.postCode());
            }
        }
        return NONE_PROMPT;
    }

    static final String NONE_PROMPT = """
            Create a list of finger foods for a Christmas party. 
            Each food should have a name and a brief description, for example, item: Cranberry Sauce Meatballs description: Tender meatballs simmered in a tangy cranberry sauce, a festive twist on a classic dish.. 
            Return the menu in the following json format: { \\"menu\\":[{\\"item\\": \\"string\\", \\"description:\\": \\"string\\"}].  Return only json in the specified, valid format.
        """;

    static final String SINGLE_PROMPT = """
                Create a list of finger foods for a Christmas party. 
                Each food should have a name and a brief description, for example, item: Cranberry Sauce Meatballs description: Tender meatballs simmered in a tangy cranberry sauce, a festive twist on a classic dish.. 
                Return the menu in the following json format: { \\"menu\\":[{\\"item\\": \\"string\\", \\"description:\\": \\"string\\"}].  Return only json in the specified, valid format.
            """;

    static final String IMAGE_PROMPT = """
        Create a visual only invitation for a Christmas party. Do not include any text.  Use traditional Christmas imagery along with any or all of the following finger foods that will be served at the party:
        """;

    public static String createInvitationPrompt(MenuRecord menuRecord) {
        StringBuilder stringBuilder = new StringBuilder(IMAGE_PROMPT)
                .append("\nMains");
        menuRecord.items().forEach(item -> {
            stringBuilder.append("\n- ").append(item.item());
            stringBuilder.append("\n  ").append(item.description());
        });
        stringBuilder.append("\nDo not include any text in the image.  Ignore the \"Revised Prompt\"");
        return stringBuilder.toString();
    }
}
