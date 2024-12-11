package io.arrogantprogrammer.thanksgivingai.api;

import java.util.List;

public record CreateMenuCommand(String email, List<String> stateCodes) {
}
