package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.CreateInvitationCommand;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenuRecord;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenuItemRecord;

import java.util.ArrayList;
import java.util.List;

public class MockObjects {

    public static final String EMAIL = "jeremy.davis@redhat.com";

    public static CreateInvitationCommand createInvitationCommand() {
        return new CreateInvitationCommand(MockObjects.thanksgivingMenu());
    }

    public static ThanksgivingMenuRecord thanksgivingMenu() {
        return new ThanksgivingMenuRecord(EMAIL, MockObjects.mains(), MockObjects.sides(), MockObjects.desserts());
    }

    public static List<ThanksgivingMenuItemRecord> mains() {

        return new ArrayList<>(){{
            add(new ThanksgivingMenuItemRecord("Turkey", "Roasted"));
            add(new ThanksgivingMenuItemRecord( "Ham", "Honey Baked"));
            add(new ThanksgivingMenuItemRecord("Tofurkey", "Vegan"));
        }};
    }

    public static List<ThanksgivingMenuItemRecord> sides() {
        return new ArrayList<>(){{
            add(new ThanksgivingMenuItemRecord("Mashed Potatoes", "Creamy"));
            add(new ThanksgivingMenuItemRecord("Green Beans", "Almondine"));
            add(new ThanksgivingMenuItemRecord("Cranberry Sauce", "Homemade"));
            add(new ThanksgivingMenuItemRecord("Mac & Cheese", "Baked"));
        }};
    }

    public static List<ThanksgivingMenuItemRecord> desserts() {
        return List.of(new ThanksgivingMenuItemRecord("Pumpkin Pie", "Traditional"));
    }
}
