package com.software.mas.model.templates;

public record HomeCard(String providerEmail, long id, String name,String tags, String
        description, String street, String city,String country, boolean stat, double price, String img) {
}
