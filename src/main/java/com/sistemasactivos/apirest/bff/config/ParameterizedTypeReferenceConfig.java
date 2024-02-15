package com.sistemasactivos.apirest.bff.config;

import com.sistemasactivos.apirest.bff.model.AccountRequest;
import com.sistemasactivos.apirest.bff.model.AccountResponse;
import com.sistemasactivos.apirest.bff.model.CreditCardRequest;
import com.sistemasactivos.apirest.bff.model.CreditCardResponse;
import com.sistemasactivos.apirest.bff.model.CustomerRequest;
import com.sistemasactivos.apirest.bff.model.CustomerResponse;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;

/**
 * @author Ivan Andres Brestt
 */

@Configuration
public class ParameterizedTypeReferenceConfig {
    
    //Account Type Config
    @Bean
    public ParameterizedTypeReference<PagedResponse<AccountResponse>> pagedAccountResponseType() {
        return new ParameterizedTypeReference<PagedResponse<AccountResponse>>() {};
    }

    @Bean
    public ParameterizedTypeReference<AccountResponse> accountResponseType() {
        return new ParameterizedTypeReference<AccountResponse>() {};
    }

    @Bean
    public ParameterizedTypeReference<AccountRequest> accountRequestType() {
        return new ParameterizedTypeReference<AccountRequest>() {};
    }
    
    //CreditCard Type Config
    @Bean
    public ParameterizedTypeReference<PagedResponse<CreditCardResponse>> pagedCreditCardResponseType() {
        return new ParameterizedTypeReference<PagedResponse<CreditCardResponse>>() {};
    }

    @Bean
    public ParameterizedTypeReference<CreditCardResponse> creditCardResponseType() {
        return new ParameterizedTypeReference<CreditCardResponse>() {};
    }

    @Bean
    public ParameterizedTypeReference<CreditCardRequest> creditCardRequestType() {
        return new ParameterizedTypeReference<CreditCardRequest>() {};
    }
    
    //Customer Type Config
    @Bean
    public ParameterizedTypeReference<PagedResponse<CustomerResponse>> pagedCustomerResponseType() {
        return new ParameterizedTypeReference<PagedResponse<CustomerResponse>>() {};
    }

    @Bean
    public ParameterizedTypeReference<CustomerResponse> customerResponseType() {
        return new ParameterizedTypeReference<CustomerResponse>() {};
    }

    @Bean
    public ParameterizedTypeReference<CustomerRequest> CustomerRequestRequestType() {
        return new ParameterizedTypeReference<CustomerRequest>() {};
    }
}
