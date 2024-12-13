package io.arrogantprogrammer.thanksgivingai.api;

import io.arrogantprogrammer.thanksgivingai.ai.AiService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class CreateInvitationTest {

    @InjectMock
    AiService aiService;
    String invitationPayload = """
            {
              "menuRecord": {
                "email": "jeremy.davis@redhat.com",
                "mains": [
                  {
                    "item": "Turkey",
                    "description": "Brined, Oven Roasted"
                  },
                  {
                    "item": "Tofurkey",
                    "description": "Vegan"
                  }
                ],
                "sides": [
                  {
                    "item": "Mac & Cheese",
                    "description": "Gooey, Cheesy"
                  },
                  {
                    "item": "Green Bean Casserole",
                    "description": "Like Grandma used to make"
                  },
                  {
                    "item": "Green Bean Casserole",
                    "description": "Like Grandma used to make"
                  },
                  {
                    "item": "Squash",
                    "description": "Roasted"
                  }
                ],
                "desserts": [
                  {
                    "item": "Pumpkin Pie",
                    "description": "Traditional"
                  }
                ]
              }
            }
            """;

    @BeforeEach
    public void setup() {
        // Mock the AiService
        Mockito.when(aiService.createInvitation(Mockito.any(CreateInvitationCommand.class)))
                .thenReturn(new Invitation("http://localhost:8080/static/thanksgiving-menu-01.png",
                        new MenuRecord("jeremy.davis@redhat.com",
                                List.of(new MenuItemRecord("Turkey", "Brined, Oven Roasted"),
                                        new MenuItemRecord("Tofurkey", "Vegan")))));
    }

    @Test
    public void testCreateInvitation() {
        given()
                .header("Content-Type", "application/json")
                .body(invitationPayload)
                .when()
                .post("/api/ai/invitation")
                .then()
                .statusCode(200)
                .body("thanksgivingMenu.email", is("jeremy.davis@redhat.com"))
                .body("thanksgivingMenu.mains[0].item", is("Turkey"));

    }
}
