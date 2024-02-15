package com.sistemasactivos.apirest.bff.controller;

import com.sistemasactivos.apirest.bff.model.AccountRequest;
import com.sistemasactivos.apirest.bff.model.AccountResponse;
import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.service.AccountService;
import com.sistemasactivos.apirest.bff.service.BaseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan Andres Brestt
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/bff/account")
public class AccountController extends BaseController<AccountResponse, AccountRequest, AccountService>{

}
