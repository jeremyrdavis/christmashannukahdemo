package io.arrogantprogrammer.thanksgivingai.domain;

public enum USRegion {

    ATLANTIC("ATLANTIC"),
    CENTRAL("CENTRAL"),
    SOUTHERN("SOUTHERN"),
    WESTPAC("WESTPAC");

    private final String region;

    private USRegion(final String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}