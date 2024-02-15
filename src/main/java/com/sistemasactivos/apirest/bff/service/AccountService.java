package com.sistemasactivos.apirest.bff.service;

import com.sistemasactivos.apirest.bff.interfaces.IAccountService;
import com.sistemasactivos.apirest.bff.model.AccountRequest;
import com.sistemasactivos.apirest.bff.model.AccountResponse;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;

/**
 * @author Ivan Andres Brestt
 */

@Service
public class AccountService extends BaseService<AccountResponse, AccountRequest, Integer> implements IAccountService{

    public AccountService(@Qualifier("getWebClientAccount") WebClient webClient, ParameterizedTypeReference<PagedResponse<AccountResponse>> responseTypePaged, ParameterizedTypeReference<AccountResponse> responseTypeE, ParameterizedTypeReference<AccountRequest> responseTypeR) {
        super(webClient, responseTypePaged, responseTypeE, responseTypeR);
    }
    
}
