package io.arrogantprogrammer.thanksgivingai.domain;

import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenuRecord;
import io.arrogantprogrammer.thanksgivingai.utils.StateCodeUtility;
import io.arrogantprogrammer.thanksgivingai.utils.StateCodeMapping;

import java.util.ArrayList;
import java.util.List;

public class ThanksgivingMenu {

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
            Create a Thanksgiving menu that combines traditional dishes with modern American inspired dishes. The menu should have 2 mains, one of which should be turkey, at least 4 side items, and at least 1 dessert. 
            Each main, side, and dessert should have a name and a brief description, for example, name: Turkey description: Citrus Brined and Roasted. 
            Return the menu in the following json format: { \\\"mains\\\":[{\\\"item\\\": \\\"string\\\"}] ,\\\"sides\\\":[{\\\"item\\\":\\\"string\\\",\\\"description\\\":\\\"string\\\"}],\\\"desserts\\\":[{\\\"item\\\":string\\\",\\\"description\\\":\\\"string\\\"}].  Return only json in the specified, valid format.
            Then send this menu by email.
        """;

    static final String SINGLE_PROMPT = """
            Create a Thanksgiving menu that combines traditional dishes with %s inspired dishes. 
            The menu should have 2 mains, one of which should be turkey, at least 4 side items, and at least 1 dessert. Each main, side, and dessert should have a name and a brief description, for example, name: Turkey description: Citrus Brined and Roasted. 
            Example menus should be from the state of %s and/or from the %s region of the US.
            Return the menu in the following json format: { \\\"mains\\\":[{\\\"item\\\": \\\"string\\\"}] ,\\\"sides\\\":[{\\\"item\\\":\\\"string\\\",\\\"description\\\":\\\"string\\\"}],\\\"desserts\\\":[{\\\"item\\\":string\\\",\\\"description\\\":\\\"string\\\"}]. Return only json in the specified, valid format.";
           Then send this menu by email.
        """;

    static final String IMAGE_PROMPT = """
        Create a visual only invitation for a Thanksgiving dinner. Do not include any text.  Use the following menu items when creating the visuals:
        """;

    public static String createInvitationPrompt(ThanksgivingMenuRecord thanksgivingMenuRecord) {
        StringBuilder stringBuilder = new StringBuilder(IMAGE_PROMPT)
                .append("\nMains");
        thanksgivingMenuRecord.mains().forEach(main -> {
            stringBuilder.append("\n- ").append(main.item());
            stringBuilder.append("\n  ").append(main.description());
        });
        thanksgivingMenuRecord.sides().forEach(side -> {
            stringBuilder.append("\n- ").append(side.item());
            stringBuilder.append("\n  ").append(side.description());
        });
        thanksgivingMenuRecord.desserts().forEach(dessert -> {
            stringBuilder.append("\n- ").append(dessert.item());
            stringBuilder.append("\n  ").append(dessert.description());
        });
        stringBuilder.append("\nDo not include any text in the image.  Ignore the \"Revised Prompt\"");
        return stringBuilder.toString();
    }
}
