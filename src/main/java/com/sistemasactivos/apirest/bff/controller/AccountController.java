package com.sistemasactivos.apirest.bff.controller;

import com.sistemasactivos.apirest.bff.model.AccountRequest;
import com.sistemasactivos.apirest.bff.model.AccountResponse;
import com.sistemasactivos.apirest.bff.service.AccountService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/bff/account")
public class AccountController extends BaseController<AccountResponse, AccountRequest, AccountService>{

    
    @Override
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = AccountResponse.class)))
        public Mono<AccountResponse> getRecordById(@PathVariable Integer id) {
        return super.getRecordById(id);
    }
        
        
    @Override
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = AccountResponse.class)))
    public Mono<AccountResponse> getRecordByActiveId(@PathVariable Integer id) {
        return super.getRecordByActiveId(id);
    }
    
    
    @Override
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = AccountResponse.class)))
    public Mono<ResponseEntity<AccountResponse>> save(@RequestBody AccountRequest request) {
        return super.save(request);
    }
    
    
    @Override
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = AccountResponse.class)))
    public Mono<AccountResponse> update(@PathVariable Integer id, @RequestBody AccountRequest request) {
        return super.update(id, request);
    }
}
