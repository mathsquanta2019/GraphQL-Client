package com.safemtech.graphqlclient.service;

import com.safemtech.graphqlclient.model.Continent;
import com.safemtech.graphqlclient.model.Country;
import com.safemtech.graphqlclient.model.Language;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GenericService {
  private final HttpGraphQlClient httpGraphQlClient;


  public GenericService() {
    WebClient webClient = WebClient
      .builder()
      .baseUrl("https://countries.trevorblades.com")
      .build();

    httpGraphQlClient = HttpGraphQlClient
      .builder(webClient)
      .build();
  }

  public Mono<List<Country>> getCountries(){
    String document = """
      query Query {
          countries {
            code
            currency
            emoji
            emojiU
            name
            phone
          }
      }

      """;

    return httpGraphQlClient
      .document(document)
      .retrieve("countries")
      .toEntityList(Country.class);
  }

  public Mono<List<Language>> getLanguages(){
    String languageDocument = """
      query{
        languages {
                code
                name
                native
              }
            }
      """;

    return httpGraphQlClient
      .document(languageDocument)
      .retrieve("languages")
      .toEntityList(Language.class);

  }

  public Mono<List<Continent>> getContinents(){
    String continentDocument = """
      query{
         continents {
            code
            name
          }
      }
      """;


    return httpGraphQlClient
      .document(continentDocument)
      .retrieve("continents")
      .toEntityList(Continent.class);
  }
}
