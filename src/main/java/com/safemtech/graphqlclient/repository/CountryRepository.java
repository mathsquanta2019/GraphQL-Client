package com.safemtech.graphqlclient.repository;

import com.safemtech.graphqlclient.model.Country;
import org.springframework.data.repository.ListCrudRepository;

public interface CountryRepository extends ListCrudRepository<Country, Integer> {
}
