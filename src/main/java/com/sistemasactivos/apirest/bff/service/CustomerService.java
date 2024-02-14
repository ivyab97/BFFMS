package com.sistemasactivos.apirest.bff.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemasactivos.apirest.bff.interfaces.ICustomerService;
import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.CustomerRequest;
import com.sistemasactivos.apirest.bff.model.CustomerResponse;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import com.sistemasactivos.apirest.bff.resources.exception.BusinessException;
import com.sistemasactivos.apirest.bff.resources.exception.HTTPError;
import java.io.Serializable;
import java.time.Duration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;


/**
 * @author Ivan Andres Brestt
 */

@Service
public class CustomerService extends BaseService<CustomerResponse, CustomerRequest, Integer> implements ICustomerService{
    
    @Autowired
    WebClient webClient;

    @Override
    public Mono<PagedResponse<CustomerResponse>> findAllByStatusEquals(Boolean status, Integer page, Integer size) {
        
        ParameterizedTypeReference<PagedResponse<CustomerResponse>> responseType = new ParameterizedTypeReference<>() {};

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/")
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
    public Mono<CustomerResponse> findByIdActive(Integer id) {
        return webClient.put()
                .uri(uriBuilder -> uriBuilder
                    .path("/{id}")
                    .build(id))
                .retrieve()
                .bodyToMono(CustomerResponse.class)
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
    public Mono<CustomerResponse> findById(Integer id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path("/{id}/admin")
                    .build(id))
                .retrieve()
                .bodyToMono(CustomerResponse.class)
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
    public Mono<CustomerResponse> save(CustomerRequest request) {
        return webClient.post()
                .uri("")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), CustomerRequest.class)
                .retrieve()
                .bodyToMono(CustomerResponse.class)
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
    public Mono<CustomerResponse> update(Integer id, CustomerRequest request) {
        return webClient.put()
                .uri("" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), CustomerRequest.class)
                .retrieve()
                .bodyToMono(CustomerResponse.class)
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
    public Mono<Void> softDelete(Integer id) {
        return webClient.delete()
            .uri("" + id)
                .retrieve()
                .bodyToMono(Void.class)
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
    public Mono<CustomerResponse> activate(Integer id) {
        return webClient.put()
                .uri(uriBuilder -> uriBuilder
                    .path("/{id}/activate")
                    .build(id))
                .retrieve()
                .bodyToMono(CustomerResponse.class)
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

}
