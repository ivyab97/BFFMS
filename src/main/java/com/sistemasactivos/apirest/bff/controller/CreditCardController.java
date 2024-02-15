package com.sistemasactivos.apirest.bff.controller;

import com.sistemasactivos.apirest.bff.model.AccountRequest;
import com.sistemasactivos.apirest.bff.model.AccountResponse;
import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.CreditCardRequest;
import com.sistemasactivos.apirest.bff.model.CreditCardResponse;
import com.sistemasactivos.apirest.bff.service.BaseService;
import com.sistemasactivos.apirest.bff.service.CreditCardService;
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
@RequestMapping("/bff/creditcards")
public class CreditCardController extends BaseController<CreditCardResponse, CreditCardRequest, CreditCardService>{

    @Override
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CreditCardResponse.class)))
        public Mono<CreditCardResponse> getRecordById(@PathVariable Integer id) {
        return super.getRecordById(id);
    }
        
        
    @Override
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CreditCardResponse.class)))
    public Mono<CreditCardResponse> getRecordByActiveId(@PathVariable Integer id) {
        return super.getRecordByActiveId(id);
    }
    
    
    @Override
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = CreditCardResponse.class)))
    public Mono<ResponseEntity<CreditCardResponse>> save(@RequestBody CreditCardRequest request) {
        return super.save(request);
    }
    
    
    @Override
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CreditCardResponse.class)))
    public Mono<CreditCardResponse> update(@PathVariable Integer id, @RequestBody CreditCardRequest request) {
        return super.update(id, request);
    }
}
