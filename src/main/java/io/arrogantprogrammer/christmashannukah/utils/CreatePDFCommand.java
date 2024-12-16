package io.arrogantprogrammer.christmashannukah.utils;

import io.arrogantprogrammer.christmashannukah.api.MenuRecord;

import java.util.UUID;

public record CreatePDFCommand(String email, MenuRecord menuRecord, UUID uuid, String url) {
}
