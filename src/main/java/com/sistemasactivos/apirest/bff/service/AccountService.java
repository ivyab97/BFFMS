package com.sistemasactivos.apirest.bff.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemasactivos.apirest.bff.interfaces.IAccountService;
import com.sistemasactivos.apirest.bff.model.AccountRequest;
import com.sistemasactivos.apirest.bff.model.AccountResponse;
import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import com.sistemasactivos.apirest.bff.resources.exception.BusinessException;
import com.sistemasactivos.apirest.bff.resources.exception.HTTPError;
import java.io.Serializable;
import java.time.Duration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * @author Ivan Andres Brestt
 */

@Service
public class AccountService extends BaseService<AccountResponse, AccountRequest, Integer> implements IAccountService{

    @Autowired
    @Qualifier("getWebClientAccount")
    WebClient webClient;
    

    @Override
    public Mono<PagedResponse<AccountResponse>> findAllByStatusEquals(Boolean status, Integer page, Integer size) {
        
        ParameterizedTypeReference<PagedResponse<AccountResponse>> responseType = new ParameterizedTypeReference<>() {};

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("")
                    .queryParam("status", status)
                    .queryParam("page", page)
                    .queryParam("size", size)
                    .build())
                .retrieve()
                .bodyToMono(responseType)
                .onErrorMap(WebClientResponseException.class, ex -> {
                    try{
                        HTTPError errorResponse = new ObjectMapper().readValue(ex.getResponseBodyAsString(), HTTPError.class);
                        return new BusinessException(HttpStatus.valueOf(ex.getRawStatusCode()), errorResponse.getMessage());
                    } catch(JsonProcessingException e){
                        return new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor, intente más tarde...");
                    }
                })
                .timeout(Duration.ofMillis(10_000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontro el recurso")));
    }
    

    @Override
    public Mono<AccountResponse> findByIdActive(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/{id}")
                    .build(id))
                .retrieve()
                .bodyToMono(AccountResponse.class)
                .onErrorMap(WebClientResponseException.class, ex -> {
                    try{
                        HTTPError errorResponse = new ObjectMapper().readValue(ex.getResponseBodyAsString(), HTTPError.class);
                        return new BusinessException(HttpStatus.valueOf(ex.getRawStatusCode()), errorResponse.getMessage());
                    } catch(JsonProcessingException e){
                        return new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor, intente más tarde...");
                    }
                })
                .timeout(Duration.ofMillis(10_000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontro el recurso")));
    }
     

    @Override
    public Mono<AccountResponse> findById(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/{id}/admin")
                    .build(id))
                .retrieve()
                .bodyToMono(AccountResponse.class)
                .onErrorMap(WebClientResponseException.class, ex -> {
                    try{
                        HTTPError errorResponse = new ObjectMapper().readValue(ex.getResponseBodyAsString(), HTTPError.class);
                        return new BusinessException(HttpStatus.valueOf(ex.getRawStatusCode()), errorResponse.getMessage());
                    } catch(JsonProcessingException e){
                        return new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor, intente más tarde...");
                    }
                })
                .timeout(Duration.ofMillis(10_000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontro el recurso")));
    }
    

    @Override
    public Mono<AccountResponse> save(AccountRequest request) {
        return webClient.post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), AccountRequest.class)
                .retrieve()
                .bodyToMono(AccountResponse.class)
                .onErrorMap(WebClientResponseException.class, ex -> {
                    try{
                        HTTPError errorResponse = new ObjectMapper().readValue(ex.getResponseBodyAsString(), HTTPError.class);
                        return new BusinessException(HttpStatus.valueOf(ex.getRawStatusCode()), errorResponse.getMessage());
                    } catch(JsonProcessingException e){
                        return new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor, intente más tarde...");
                    }
                })
                .timeout(Duration.ofMillis(10_000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontro el recurso")));
    }
    

    @Override
    public Mono<AccountResponse> update(Integer id, AccountRequest request) {
        return webClient.put()
                .uri("/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), AccountRequest.class)
                .retrieve()
                .bodyToMono(AccountResponse.class)
                .onErrorMap(WebClientResponseException.class, ex -> {
                    try{
                        HTTPError errorResponse = new ObjectMapper().readValue(ex.getResponseBodyAsString(), HTTPError.class);
                        return new BusinessException(HttpStatus.valueOf(ex.getRawStatusCode()), errorResponse.getMessage());
                    } catch(JsonProcessingException e){
                        return new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor, intente más tarde...");
                    }
                })
                .timeout(Duration.ofMillis(10_000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontro el recurso")));
    }
    
    

    @Override
    public Mono<AccountResponse> activate(Integer id) {
        return webClient.put()
                .uri(uriBuilder -> uriBuilder
                    .path("/{id}/activate")
                    .build(id))
                .retrieve()
                .bodyToMono(AccountResponse.class)
                .onErrorMap(WebClientResponseException.class, ex -> {
                    try{
                        HTTPError errorResponse = new ObjectMapper().readValue(ex.getResponseBodyAsString(), HTTPError.class);
                        return new BusinessException(HttpStatus.valueOf(ex.getRawStatusCode()), errorResponse.getMessage());
                    } catch(JsonProcessingException e){
                        return new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor, intente más tarde...");
                    }
                })
                .timeout(Duration.ofMillis(10_000))
                .switchIfEmpty(Mono.error(new RuntimeException("No se encontro el recurso")));
    }
    
    
    @Override
    public Mono<?> softDelete(Integer id) {
        return webClient.delete()
            .uri("/" + id)
                .retrieve()
                .bodyToMono(AccountResponse.class)
                .onErrorMap(WebClientResponseException.class, ex -> {
                    try{
                        
                        HTTPError errorResponse = new ObjectMapper().readValue(ex.getResponseBodyAsString(), HTTPError.class);
                        return new BusinessException(HttpStatus.valueOf(ex.getRawStatusCode()), errorResponse.getMessage());
                        
                    } catch(JsonProcessingException e){
                        return new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor, intente más tarde...");
                    }
                })
                .timeout(Duration.ofMillis(10_000))
                .switchIfEmpty(Mono.error(new BusinessException(HttpStatus.NO_CONTENT, "Eliminado con exito.")));
    }

}
