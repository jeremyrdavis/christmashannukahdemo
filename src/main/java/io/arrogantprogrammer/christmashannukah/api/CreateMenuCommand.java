package io.arrogantprogrammer.christmashannukah.api;

import java.util.List;

public record CreateMenuCommand(String email, HOLIDAY holiday, List<String> stateCodes) {
}
