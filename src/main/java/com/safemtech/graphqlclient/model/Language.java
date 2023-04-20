package com.safemtech.graphqlclient.model;

import org.springframework.data.annotation.Id;

public record Language(
  @Id
  Integer id,
  String code,
  String name,

  Integer rtl
) {
}
