package com.safemtech.graphqlclient.model;

import org.springframework.data.annotation.Id;


public record Continent(@Id Integer id, String code, String name) {
}
