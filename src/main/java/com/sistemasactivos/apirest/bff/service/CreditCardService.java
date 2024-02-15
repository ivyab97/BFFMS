package com.sistemasactivos.apirest.bff.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistemasactivos.apirest.bff.interfaces.ICreditCardService;
import com.sistemasactivos.apirest.bff.model.CreditCardRequest;
import com.sistemasactivos.apirest.bff.model.CreditCardResponse;
import com.sistemasactivos.apirest.bff.model.CustomerRequest;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import com.sistemasactivos.apirest.bff.resources.exception.BusinessException;
import com.sistemasactivos.apirest.bff.resources.exception.HTTPError;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

@Service
public class CreditCardService extends BaseService<CreditCardResponse, CreditCardRequest, Integer> implements ICreditCardService{
    
    
    public CreditCardService(@Qualifier("getWebClientCreditCard") WebClient webClient, ParameterizedTypeReference<PagedResponse<CreditCardResponse>> responseTypePaged, ParameterizedTypeReference<CreditCardResponse> responseTypeE, ParameterizedTypeReference<CreditCardRequest> responseTypeR) {
        super(webClient, responseTypePaged, responseTypeE, responseTypeR);
    }
    
    
    @Override
    public Mono<CreditCardResponse> save(Integer accountId, CreditCardRequest request) {
        return handleErrors(
                webClient.post()
                .uri("/" + accountId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), CustomerRequest.class)
                .retrieve()
                .bodyToMono(responseTypeE)
        );
    }
    
}
