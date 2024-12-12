package io.arrogantprogrammer.thanksgivingai.api;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "menu")
public record MenuRecord(String email, List<MenuItemRecord> items) {
}
