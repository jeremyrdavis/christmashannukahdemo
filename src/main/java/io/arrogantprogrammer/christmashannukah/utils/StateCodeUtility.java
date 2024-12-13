package io.arrogantprogrammer.christmashannukah.utils;

import java.util.HashMap;
import java.util.Map;

public class StateCodeUtility {

    public static StateCodeMapping getStateCodeMapping(final String stateNameToFind) {
        if (stateCodeMappings.get(stateNameToFind) == null) {
            return stateCodeMappings.get("None");
        }
        return stateCodeMappings.get(stateNameToFind);
    }

        static final Map<String, StateCodeMapping> stateCodeMappings = new HashMap<String, StateCodeMapping>() {{
            put("Puerto Rico", new StateCodeMapping("PR", "Puerto Rico", "SOUTHERN"));
            put("Virgin Islands", new StateCodeMapping("VI", "Virgin Islands", "SOUTHERN"));
            put("Massachusetts", new StateCodeMapping("MA", "Massachusetts", "ATLANTIC"));
            put("Rhode Island", new StateCodeMapping("RI", "Rhode Island", "ATLANTIC"));
            put("New Hampshire", new StateCodeMapping("NH", "New Hampshire", "ATLANTIC"));
            put("Maine", new StateCodeMapping("ME", "Maine", "ATLANTIC"));
            put("Vermont", new StateCodeMapping("VT", "Vermont", "ATLANTIC"));
            put("Connecticut", new StateCodeMapping("CT", "Connecticut", "ATLANTIC"));
            put("New York", new StateCodeMapping("NY", "New York", "ATLANTIC"));
            put("New Jersey", new StateCodeMapping("NJ", "New Jersey", "ATLANTIC"));
            put("Pennsylvania", new StateCodeMapping("PA", "Pennsylvania", "ATLANTIC"));
            put("Delaware", new StateCodeMapping("DE", "Delaware", "ATLANTIC"));
            put("Maryland", new StateCodeMapping("MD", "Maryland", "ATLANTIC"));
            put("District of Columbia", new StateCodeMapping("DC", "District of Columbia", "ATLANTIC"));
            put("Virginia", new StateCodeMapping("VA", "Virginia", "ATLANTIC"));
            put("West Virginia", new StateCodeMapping("WV", "West Virginia", "CENTRAL"));
            put("North Carolina", new StateCodeMapping("NC", "North Carolina", "ATLANTIC"));
            put("South Carolina", new StateCodeMapping("SC", "South Carolina", "SOUTHERN"));
            put("Georgia", new StateCodeMapping("GA", "Georgia", "SOUTHERN"));
            put("Tennessee", new StateCodeMapping("TN", "Tennessee", "SOUTHERN"));
            put("Florida", new StateCodeMapping("FL", "Florida", "SOUTHERN"));
            put("Alabama", new StateCodeMapping("AL", "Alabama", "SOUTHERN"));
            put("Kentucky", new StateCodeMapping("KY", "Kentucky", "CENTRAL"));
            put("Mississippi", new StateCodeMapping("MS", "Mississippi", "SOUTHERN"));
            put("Ohio", new StateCodeMapping("OH", "Ohio", "CENTRAL"));
            put("Indiana", new StateCodeMapping("IN", "Indiana", "CENTRAL"));
            put("Michigan", new StateCodeMapping("MI", "Michigan", "CENTRAL"));
            put("Iowa", new StateCodeMapping("IA", "Iowa", "CENTRAL"));
            put("Nebraska", new StateCodeMapping("NE", "Nebraska", "CENTRAL"));
            put("Wisconsin", new StateCodeMapping("WI", "Wisconsin", "CENTRAL"));
            put("Minnesota", new StateCodeMapping("MN", "Minnesota", "CENTRAL"));
            put("North Dakota", new StateCodeMapping("ND", "North Dakota", "CENTRAL"));
            put("South Dakota", new StateCodeMapping("SD", "South Dakota", "WESTPAC"));
            put("Montana", new StateCodeMapping("MT", "Montana", "WESTPAC"));
            put("Illinois", new StateCodeMapping("IL", "Illinois", "CENTRAL"));
            put("Missouri", new StateCodeMapping("MO", "Missouri", "CENTRAL"));
            put("Kansas", new StateCodeMapping("KS", "Kansas", "CENTRAL"));
            put("Louisiana", new StateCodeMapping("LA", "Louisiana", "SOUTHERN"));
            put("Arkansas", new StateCodeMapping("AR", "Arkansas", "SOUTHERN"));
            put("Texas", new StateCodeMapping("TX", "Texas", "SOUTHERN"));
            put("Oklahoma", new StateCodeMapping("OK", "Oklahoma", "SOUTHERN"));
            put("New Mexico", new StateCodeMapping("NM", "New Mexico", "WESTPAC"));
            put("Colorado", new StateCodeMapping("CO", "Colorado", "WESTPAC"));
            put("Wyoming", new StateCodeMapping("WY", "Wyoming", "WESTPAC"));
            put("Idaho", new StateCodeMapping("ID", "Idaho", "WESTPAC"));
            put("Washington", new StateCodeMapping("WA", "Washington", "WESTPAC"));
            put("Utah", new StateCodeMapping("UT", "Utah", "WESTPAC"));
            put("Arizona", new StateCodeMapping("AZ", "Arizona", "WESTPAC"));
            put("Nevada", new StateCodeMapping("NV", "Nevada", "WESTPAC"));
            put("California", new StateCodeMapping("CA", "California", "WESTPAC"));
            put("Hawaii", new StateCodeMapping("HI", "Hawaii", "WESTPAC"));
            put("American Samoa", new StateCodeMapping("AS", "American Samoa", "WESTPAC"));
            put("Guam", new StateCodeMapping("GU", "Guam", "WESTPAC"));
            put("None", new StateCodeMapping("NA", "None", "NONE"));
            put("Northern Mariana Islands", new StateCodeMapping("MP", "Northern Mariana Islands", "WESTPAC"));
            put("None", new StateCodeMapping("MH", "None", "WESTPAC"));
            put("Oregon", new StateCodeMapping("OR", "Oregon", "WESTPAC"));
            put("Alaska", new StateCodeMapping("AK", "Alaska", "WESTPAC"));
        }};
}
