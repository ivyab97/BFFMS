package com.sistemasactivos.apirest.bff.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemasactivos.apirest.bff.interfaces.IBaseService;
import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.CustomerRequest;
import com.sistemasactivos.apirest.bff.model.CustomerResponse;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import com.sistemasactivos.apirest.bff.resources.exception.BusinessException;
import com.sistemasactivos.apirest.bff.resources.exception.HTTPError;
import java.io.Serializable;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

public abstract class BaseService<E extends BaseDTO, R extends BaseDTO, ID extends Serializable> implements IBaseService<E, R, Integer>{

    WebClient webClient;
    ParameterizedTypeReference<PagedResponse<E>> responseTypePaged;
    ParameterizedTypeReference<E> responseTypeE;
    ParameterizedTypeReference<R> responseTypeR;

    
    public BaseService(WebClient webClient, ParameterizedTypeReference<PagedResponse<E>> responseTypePaged, ParameterizedTypeReference<E> responseTypeE, ParameterizedTypeReference<R> responseTypeR) {
        this.webClient = webClient;
        this.responseTypePaged = responseTypePaged;
        this.responseTypeE = responseTypeE;
        this.responseTypeR = responseTypeR;
    }

    @Override
    public Mono<PagedResponse<E>> findAllByStatusEquals(Boolean status, Integer page, Integer size) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("")
                    .queryParam("status", status)
                    .queryParam("page", page)
                    .queryParam("size", size)
                    .build())
                .retrieve()
                .bodyToMono(responseTypePaged)
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
    public Mono<E> findByIdActive(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/{id}")
                    .build(id))
                .retrieve()
                .bodyToMono(responseTypeE)
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
    public Mono<E> findById(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/{id}/admin")
                    .build(id))
                .retrieve()
                .bodyToMono(responseTypeE)
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
    public Mono<E> save(R request) {
        return webClient.post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), CustomerRequest.class)
                .retrieve()
                .bodyToMono(responseTypeE)
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
    public Mono<E> update(Integer id, R request) {
        return webClient.put()
                .uri("/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), responseTypeR)
                .retrieve()
                .bodyToMono(responseTypeE)
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
    public Mono<E> activate(Integer id) {
        return webClient.put()
                .uri(uriBuilder -> uriBuilder
                    .path("/{id}/activate")
                    .build(id))
                .retrieve()
                .bodyToMono(responseTypeE)
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
    public Mono<E> softDelete(Integer id) {
        return webClient.delete()
            .uri("/" + id)
                .retrieve()
                .bodyToMono(responseTypeE)
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
