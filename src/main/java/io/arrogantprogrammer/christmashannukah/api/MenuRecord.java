package io.arrogantprogrammer.christmashannukah.api;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value = "menu")
public record MenuRecord(String email, List<MenuItemRecord> items) {
}
