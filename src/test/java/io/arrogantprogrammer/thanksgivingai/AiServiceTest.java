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
        Mockito.when(openAIService.createMenu(any(String.class))).thenReturn(MockObjects.thanksgivingMenu());
        Log.infof("Mocked OpenAIService");
    }

    @Test
    public void testCreateMenu() {
        MenuRecord menuRecord = aiService.createMenu(new CreateMenuCommand("jeremy.davis@redhat.com", List.of("None")));
        assertNotNull(menuRecord);
        assertEquals(menuRecord.email(), "jeremy.davis@redhat.com");
    }

    @Test
    public void testCreateInvitation() {
        CreateInvitationCommand createInvitationCommand = MockObjects.createInvitationCommand();
        Invitation invitation = aiService.createInvitation(createInvitationCommand);
        assertNotNull(invitation.menuRecord());
        assertEquals(invitation.menuRecord().email(), MockObjects.EMAIL);
    }

    private void verifyDescriptions(List<MenuItemRecord> items){
        for(MenuItemRecord item : items){
            assertNotNull(item.description());
            assertFalse(item.description().isBlank());
        }
    }
}
