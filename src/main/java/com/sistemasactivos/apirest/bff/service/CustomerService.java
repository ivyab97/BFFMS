package com.sistemasactivos.apirest.bff.service;

import com.sistemasactivos.apirest.bff.interfaces.ICustomerService;
import com.sistemasactivos.apirest.bff.model.CustomerRequest;
import com.sistemasactivos.apirest.bff.model.CustomerResponse;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;

/**
 * @author Ivan Andres Brestt
 */

@Service
public class CustomerService extends BaseService<CustomerResponse, CustomerRequest, Long> implements ICustomerService{
    
    
    public CustomerService(@Qualifier("getWebClientCustomer") WebClient webClient, ParameterizedTypeReference<PagedResponse<CustomerResponse>> responseTypePaged, ParameterizedTypeReference<CustomerResponse> responseTypeE, ParameterizedTypeReference<CustomerRequest> responseTypeR) {
        super(webClient, responseTypePaged, responseTypeE, responseTypeR);
    }
 
}
