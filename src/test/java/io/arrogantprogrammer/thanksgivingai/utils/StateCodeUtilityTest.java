package io.arrogantprogrammer.thanksgivingai.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StateCodeUtilityTest {

    @Test
    public void testFindMapping() {
        StateCodeMapping stateCodeMapping = StateCodeUtility.getStateCodeMapping("Puerto Rico");
        assertNotNull(stateCodeMapping);
        assertEquals("PR", stateCodeMapping.postCode());
        assertEquals("Puerto Rico", stateCodeMapping.stateName());
        assertEquals("SOUTHERN", stateCodeMapping.region());
    }
}
