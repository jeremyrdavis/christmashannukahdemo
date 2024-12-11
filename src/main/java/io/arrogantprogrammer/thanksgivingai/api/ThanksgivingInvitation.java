package io.arrogantprogrammer.thanksgivingai.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;

public record ThanksgivingInvitation(String url, @JsonProperty("thanksgivingMenu") ThanksgivingMenuRecord thanksgivingMenuRecord) {
}
