package com.sistemasactivos.apirest.bff.controller;

import com.sistemasactivos.apirest.bff.model.AccountRequest;
import com.sistemasactivos.apirest.bff.model.AccountResponse;
import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.CreditCardRequest;
import com.sistemasactivos.apirest.bff.model.CreditCardResponse;
import com.sistemasactivos.apirest.bff.resources.exception.HTTPError;
import com.sistemasactivos.apirest.bff.service.BaseService;
import com.sistemasactivos.apirest.bff.service.CreditCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/bff/creditcards")
public class CreditCardController extends BaseController<CreditCardResponse, CreditCardRequest, CreditCardService>{

    @Autowired
    CreditCardService creditCardService;
    
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
    
    
    @PostMapping("/{accountId}")
    @Operation(
        summary = "Dar de alta un registro con su respectiva información.",
        description = "Dar de alta un registro.",
        responses = {
            @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = CreditCardResponse.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "409", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = HTTPError.class)))
        }
    )
    public Mono<ResponseEntity<CreditCardResponse>> save(@PathVariable Integer accountId, @RequestBody CreditCardRequest request) {
        return creditCardService.save(accountId, request)
                .map(savedEntity -> ResponseEntity.status(HttpStatus.CREATED).body(savedEntity));
    }
    
    
    @Override
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CreditCardResponse.class)))
    public Mono<CreditCardResponse> update(@PathVariable Integer id, @RequestBody CreditCardRequest request) {
        return super.update(id, request);
    }
}
