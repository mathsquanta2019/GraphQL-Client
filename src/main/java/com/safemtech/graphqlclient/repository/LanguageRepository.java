package com.safemtech.graphqlclient.repository;

import com.safemtech.graphqlclient.model.Language;
import org.springframework.data.repository.ListCrudRepository;

public interface LanguageRepository extends ListCrudRepository<Language, Integer> {
}
