package io.arrogantprogrammer.thanksgivingai.api;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "thanksgivingMenu")
public record ThanksgivingMenuRecord(String email, List<ThanksgivingMenuItemRecord> mains, List<ThanksgivingMenuItemRecord> sides, List<ThanksgivingMenuItemRecord> desserts) {
}
