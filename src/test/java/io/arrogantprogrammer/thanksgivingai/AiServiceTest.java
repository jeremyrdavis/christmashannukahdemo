package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.ai.AiService;
import io.arrogantprogrammer.thanksgivingai.api.*;
import io.arrogantprogrammer.thanksgivingai.rest.OpenAIService;
import io.quarkus.logging.Log;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@QuarkusTest
public class AiServiceTest {

    @InjectMock
    OpenAIService openAIService;

    @Inject
    AiService aiService;

    @BeforeEach
    public void setup(){
        Mockito.when(openAIService.chat(any(String.class))).thenReturn(MockObjects.thanksgivingMenu());
        Log.infof("Mocked OpenAIService");
    }

    @Test
    public void testCreateMenu() {
        MenuRecord menuRecord = aiService.createMenu(new CreateMenuCommand("jeremy.davis@redhat.com", List.of("None")));
        assertNotNull(menuRecord);
        assertEquals(menuRecord.email(), "jeremy.davis@redhat.com");
        assertTrue(menuRecord.mains().size() >= 1);
        assertTrue(menuRecord.sides().size() >= 2);
        assertTrue(menuRecord.desserts().size() >= 1);
        verifyDescriptions(menuRecord.mains());
        verifyDescriptions(menuRecord.sides());
        verifyDescriptions(menuRecord.desserts());
    }

    @Test
    public void testCreateInvitation() {
        CreateInvitationCommand createInvitationCommand = MockObjects.createInvitationCommand();
        Invitation invitation = aiService.createInvitation(createInvitationCommand);
        assertNotNull(invitation.menuRecord());
        assertEquals(invitation.menuRecord().email(), MockObjects.EMAIL);
        assertEquals(invitation.menuRecord().mains().size(), MockObjects.mains().size());
        assertEquals(invitation.menuRecord().sides().size(), MockObjects.sides().size());
        assertEquals(invitation.menuRecord().desserts().size(), MockObjects.desserts().size());
        verifyDescriptions(invitation.menuRecord().mains());
        verifyDescriptions(invitation.menuRecord().sides());
        verifyDescriptions(invitation.menuRecord().desserts());
    }

    private void verifyDescriptions(List<MenuItemRecord> items){
        for(MenuItemRecord item : items){
            assertNotNull(item.description());
            assertFalse(item.description().isBlank());
        }
    }
}
