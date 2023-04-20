package com.safemtech.graphqlclient;

import com.safemtech.graphqlclient.model.Continent;
import com.safemtech.graphqlclient.model.Country;
import com.safemtech.graphqlclient.model.Language;
import com.safemtech.graphqlclient.repository.ContinentRepository;
import com.safemtech.graphqlclient.repository.CountryRepository;
import com.safemtech.graphqlclient.repository.LanguageRepository;
import com.safemtech.graphqlclient.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class GraphQlClientApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(GraphQlClientApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(GraphQlClientApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(GenericService genericService,
                                      CountryRepository countryRepository,
                                      LanguageRepository languageRepository,
                                      ContinentRepository continentRepository){
    return args -> {
      Mono<List<Country>> countries = genericService.getCountries();

      countries.subscribe(countryRepository::saveAll);

      Mono<List<Continent>> continents = genericService.getContinents();

      continents.subscribe(continentRepository::saveAll);

      Mono<List<Language>> languages = genericService.getLanguages();
      languages.subscribe(languageRepository::saveAll);
    };
  }

}
