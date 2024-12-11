package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.ai.AiService;
import io.arrogantprogrammer.thanksgivingai.api.*;
import io.arrogantprogrammer.thanksgivingai.rest.OpenAIService;
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
    }

    @Test
    public void testCreateMenu() {
        ThanksgivingMenuRecord thanksgivingMenuRecord = aiService.createMenu(new CreateMenuCommand("jeremy.davis@redhat.com", List.of("None")));
        assertNotNull(thanksgivingMenuRecord);
        assertEquals(thanksgivingMenuRecord.email(), "jeremy.davis@redhat.com");
        assertTrue(thanksgivingMenuRecord.mains().size() >= 1);
        assertTrue(thanksgivingMenuRecord.sides().size() >= 2);
        assertTrue(thanksgivingMenuRecord.desserts().size() >= 1);
        verifyDescriptions(thanksgivingMenuRecord.mains());
        verifyDescriptions(thanksgivingMenuRecord.sides());
        verifyDescriptions(thanksgivingMenuRecord.desserts());
    }

    @Test
    public void testCreateInvitation() {
        CreateInvitationCommand createInvitationCommand = MockObjects.createInvitationCommand();
        ThanksgivingInvitation thanksgivingInvitation = aiService.createInvitation(createInvitationCommand);
        assertNotNull(thanksgivingInvitation.thanksgivingMenuRecord());
        assertEquals(thanksgivingInvitation.thanksgivingMenuRecord().email(), MockObjects.EMAIL);
        assertEquals(thanksgivingInvitation.thanksgivingMenuRecord().mains().size(), MockObjects.mains().size());
        assertEquals(thanksgivingInvitation.thanksgivingMenuRecord().sides().size(), MockObjects.sides().size());
        assertEquals(thanksgivingInvitation.thanksgivingMenuRecord().desserts().size(), MockObjects.desserts().size());
        verifyDescriptions(thanksgivingInvitation.thanksgivingMenuRecord().mains());
        verifyDescriptions(thanksgivingInvitation.thanksgivingMenuRecord().sides());
        verifyDescriptions(thanksgivingInvitation.thanksgivingMenuRecord().desserts());
    }

    private void verifyDescriptions(List<ThanksgivingMenuItemRecord> items){
        for(ThanksgivingMenuItemRecord item : items){
            assertNotNull(item.description());
            assertFalse(item.description().isBlank());
        }
    }
}
