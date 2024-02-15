package com.sistemasactivos.apirest.bff.controller;

import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.CustomerRequest;
import com.sistemasactivos.apirest.bff.model.CustomerResponse;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import com.sistemasactivos.apirest.bff.resources.exception.HTTPError;
import com.sistemasactivos.apirest.bff.service.BaseService;
import com.sistemasactivos.apirest.bff.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ivan Andres Brestt
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/bff/customer")
public class CustomerController extends BaseController<CustomerResponse, CustomerRequest, CustomerService>{
    
    @Autowired
    CustomerService customerService;
    
    @Override
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CustomerResponse.class)))
        public Mono<CustomerResponse> getRecordById(@PathVariable Integer id) {
        return super.getRecordById(id);
    }
        
        
    @Override
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CustomerResponse.class)))
    public Mono<CustomerResponse> getRecordByActiveId(@PathVariable Integer id) {
        return super.getRecordByActiveId(id);
    }
    
    
    @Override
    @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = CustomerResponse.class)))
    public Mono<ResponseEntity<CustomerResponse>> save(@RequestBody CustomerRequest request) {
        return super.save(request);
    }
    
    
    @Override
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CustomerResponse.class)))
    public Mono<CustomerResponse> update(@PathVariable Integer id, @RequestBody CustomerRequest request) {
        return super.update(id, request);
    }
}