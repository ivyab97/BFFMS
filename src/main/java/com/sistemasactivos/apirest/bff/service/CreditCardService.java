package com.sistemasactivos.apirest.bff.service;

import com.sistemasactivos.apirest.bff.interfaces.ICreditCardService;
import com.sistemasactivos.apirest.bff.model.CreditCardRequest;
import com.sistemasactivos.apirest.bff.model.CreditCardResponse;
import com.sistemasactivos.apirest.bff.model.CustomerRequest;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

@Service
public class CreditCardService extends BaseService<CreditCardResponse, CreditCardRequest, Long> implements ICreditCardService{
    
    @Value("${secondPath}")
    String secondPath;
    
    public CreditCardService(@Qualifier("getWebClientCreditCard") WebClient webClient, ParameterizedTypeReference<PagedResponse<CreditCardResponse>> responseTypePaged, ParameterizedTypeReference<CreditCardResponse> responseTypeE, ParameterizedTypeReference<CreditCardRequest> responseTypeR) {
        super(webClient, responseTypePaged, responseTypeE, responseTypeR);
    }
    
    
    @Override
    public Mono<CreditCardResponse> save(Long accountId, CreditCardRequest request) {
        return handleErrors(
                webClient.post()
                .uri(secondPath + accountId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(request), CustomerRequest.class)
                .retrieve()
                .bodyToMono(responseTypeE)
        );
    }
    
}
