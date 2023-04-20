package com.safemtech.graphqlclient.repository;

import com.safemtech.graphqlclient.model.Continent;
import org.springframework.data.repository.ListCrudRepository;

public interface ContinentRepository extends ListCrudRepository<Continent, Integer> {
}
