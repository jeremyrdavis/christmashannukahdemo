package io.arrogantprogrammer.thanksgivingai.api;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "thanksgivingMenu")
public record MenuRecord(String email, List<MenuItemRecord> mains, List<MenuItemRecord> sides, List<MenuItemRecord> desserts) {
}
