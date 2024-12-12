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
public class RestApiCreateMenuTest {

    @InjectMock
    AiService aiService;

    @BeforeEach
    public void setup() {
        // Mock the AiService
        Mockito.when(aiService.createMenu(Mockito.any(CreateMenuCommand.class)))
                .thenReturn(new MenuRecord("jeremy.davis@redhat.com",
                                List.of(new MenuItemRecord("Turkey", "Brined, Oven Roasted"),
                                        new MenuItemRecord("Tofurkey", "Vegan")),
                                List.of(new MenuItemRecord("Mac & Cheese", "Gooey, Cheesy"),
                                        new MenuItemRecord("Green Bean Casserole", "Like Grandma used to make"),
                                        new MenuItemRecord("Green Bean Casserole", "Like Grandma used to make")),
                                List.of(new MenuItemRecord("Pumpkin Pie", "Classic"))));
    }


    @Test
    public void testCreateMenu() {
        String payload =
        """
                {
                    "email": "jeremy.davis@redhat.com",
                    "postCodes" : ["None"]
                }
        """;

        given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/api/ai/menu")
                .then()
                .statusCode(200)
                .body("email", is("jeremy.davis@redhat.com"))
                .body("mains[1].item", is("Tofurkey"));
    }

}
