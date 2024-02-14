package com.sistemasactivos.apirest.bff.controller;

import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.CustomerRequest;
import com.sistemasactivos.apirest.bff.model.CustomerResponse;
import com.sistemasactivos.apirest.bff.service.BaseService;
import com.sistemasactivos.apirest.bff.service.CustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan Andres Brestt
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/bff/customer")
public class CustomerController extends BaseController<CustomerResponse, CustomerRequest, CustomerService>{

}
