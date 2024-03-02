package com.sistemasactivos.apirest.bff.interfaces;

import com.sistemasactivos.apirest.bff.model.CreditCardRequest;
import com.sistemasactivos.apirest.bff.model.CreditCardResponse;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

public interface ICreditCardService extends IBaseService<CreditCardResponse, CreditCardRequest, Long>{
    public Mono<CreditCardResponse> save (Long accountId, CreditCardRequest request);
}
