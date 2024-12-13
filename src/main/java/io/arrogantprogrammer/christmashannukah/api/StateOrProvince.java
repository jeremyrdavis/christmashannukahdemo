package io.arrogantprogrammer.christmashannukah.api;

public enum StateOrProvince {

    ALABAMA("AL", "Alabama", "SOUTHERN"),
    ALASKA("AK", "Alaska", "WESTPAC"),
    ARIZONA("AZ", "Arizona", "WESTPAC"),
    ARKANSAS("AR", "Arkansas", "SOUTHERN"),
    CALIFORNIA("CA", "California", "WESTPAC"),
    COLORADO("CO", "Colorado", "WESTPAC"),
    CONNECTICUT("CT", "Connecticut", "ATLANTIC"),
    DELAWARE("DE", "Delaware", "ATLANTIC"),
    FLORIDA("FL", "Florida", "SOUTHERN"),
    GEORGIA("GA", "Georgia", "SOUTHERN"),
    HAWAII("HI", "Hawaii", "WESTPAC"),
    IDAHO("ID", "Idaho", "WESTPAC"),
    ILLINOIS("IL", "Illinois", "CENTRAL"),
    INDIANA("IN", "Indiana", "CENTRAL"),
    IOWA("IA", "Iowa", "CENTRAL"),
    KANSAS("KS", "Kansas", "CENTRAL"),
    KENTUCKY("KY", "Kentucky", "CENTRAL"),
    LOUISIANA("LA", "Louisiana", "SOUTHERN"),
    MAINE("ME", "Maine", "ATLANTIC"),
    MARYLAND("MD", "Maryland", "ATLANTIC"),
    MASSACHUSETTS("MA", "Massachusetts", "ATLANTIC"),
    MICHIGAN("MI", "Michigan", "CENTRAL"),
    MINNESOTA("MN", "Minnesota", "CENTRAL"),
    MISSISSIPPI("MS", "Mississippi", "SOUTHERN"),
    MISSOURI("MO", "Missouri", "CENTRAL"),
    MONTANA("MT", "Montana", "WESTPAC"),
    NEBRASKA("NE", "Nebraska", "CENTRAL"),
    NEVADA("NV", "Nevada", "WESTPAC"),
    NEW_HAMPSHIRE("NH", "New Hampshire", "ATLANTIC"),
    NEW_JERSEY("NJ", "New Jersey", "ATLANTIC"),
    NEW_MEXICO("NM", "New Mexico", "WESTPAC"),
    NEW_YORK("NY", "New York", "ATLANTIC"),
    NORTH_CAROLINA("NC", "North Carolina", "ATLANTIC"),
    NORTH_DAKOTA("ND", "North Dakota", "CENTRAL"),
    OHIO("OH", "Ohio", "CENTRAL"),
    OKLAHOMA("OK", "Oklahoma", "SOUTHERN"),
    OREGON("OR", "Oregon", "WESTPAC"),
    PENNSYLVANIA("PA", "Pennsylvania", "ATLANTIC"),
    RHODE_ISLAND("RI", "Rhode Island", "ATLANTIC"),
    SOUTH_CAROLINA("SC", "South Carolina", "SOUTHERN"),
    SOUTH_DAKOTA("SD", "South Dakota", "WESTPAC"),
    TENNESSEE("TN", "Tennessee", "SOUTHERN"),
    TEXAS("TX", "Texas", "SOUTHERN"),
    UTAH("UT", "Utah", "WESTPAC"),
    VERMONT("VT", "Vermont", "ATLANTIC"),
    VIRGINIA("VA", "Virginia", "ATLANTIC"),
    WASHINGTON("WA", "Washington", "WESTPAC"),
    WEST_VIRGINIA("WV", "West Virginia", "CENTRAL"),
    WISCONSIN("WI", "Wisconsin", "CENTRAL"),
    WYOMING("WY", "Wyoming", "WESTPAC"),
    AMERICAN_SAMOA("AS", "American Samoa", "WESTPAC"),
    DISTRICT_OF_COLUMBIA("DC", "District of Columbia", "ATLANTIC"),
    GUAM("GU", "Guam", "WESTPAC"),
    NORTHERN_MARIANA_ISLANDS("MP", "Northern Mariana Islands", "WESTPAC"),
    PUERTO_RICO("PR", "Puerto Rico", "SOUTHERN"),
    UNITED_STATES_MINOR_OUTLYING_ISLANDS("UM", "United States Minor Outlying Islands", "WESTPAC"),
    VIRGIN_ISLANDS("VI", "Virgin Islands", "SOUTHERN");

    private final String code;
    private final String name;
    private final String region;

    private StateOrProvince(String code, String name, String region) {
        this.code = code;
        this.name = name;
        this.region = region;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }
}