package io.arrogantprogrammer.thanksgivingai.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Invitation(String url, @JsonProperty("menu") MenuRecord menuRecord) {
}
