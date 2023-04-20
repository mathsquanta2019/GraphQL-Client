package com.safemtech.graphqlclient.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;

public record Country(

  @Id
  Integer id,
  String code,
  String currency,
  String emoji,
  String name,
  String phone
) {
}
