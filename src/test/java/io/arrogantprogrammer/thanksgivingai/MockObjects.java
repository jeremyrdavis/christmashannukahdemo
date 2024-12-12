package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.CreateInvitationCommand;
import io.arrogantprogrammer.thanksgivingai.api.MenuRecord;
import io.arrogantprogrammer.thanksgivingai.api.MenuItemRecord;

import java.util.ArrayList;
import java.util.List;

public class MockObjects {

    public static final String EMAIL = "jeremy.davis@redhat.com";

    public static CreateInvitationCommand createInvitationCommand() {
        return new CreateInvitationCommand(MockObjects.thanksgivingMenu());
    }

    public static MenuRecord thanksgivingMenu() {
        return new MenuRecord(EMAIL, MockObjects.mains(), MockObjects.sides(), MockObjects.desserts());
    }

    public static List<MenuItemRecord> mains() {

        return new ArrayList<>(){{
            add(new MenuItemRecord("Turkey", "Roasted"));
            add(new MenuItemRecord( "Ham", "Honey Baked"));
            add(new MenuItemRecord("Tofurkey", "Vegan"));
        }};
    }

    public static List<MenuItemRecord> sides() {
        return new ArrayList<>(){{
            add(new MenuItemRecord("Mashed Potatoes", "Creamy"));
            add(new MenuItemRecord("Green Beans", "Almondine"));
            add(new MenuItemRecord("Cranberry Sauce", "Homemade"));
            add(new MenuItemRecord("Mac & Cheese", "Baked"));
        }};
    }

    public static List<MenuItemRecord> desserts() {
        return List.of(new MenuItemRecord("Pumpkin Pie", "Traditional"));
    }
}
