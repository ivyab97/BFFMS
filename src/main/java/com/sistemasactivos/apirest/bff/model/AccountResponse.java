package com.sistemasactivos.apirest.bff.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ivan Andres Brestt
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse extends BaseDTO{
    
    @Schema(description = "Identifier attribute", example = "10")
    private Integer Id;
    
    @Schema(description = "Status of soft delete")
    private Boolean enabled;
    
    @Schema(description = "Date of creation")
    private Date createdAt;
    
    @Schema(description = "Date of update")
    private Date updatedAt;
    
    @Schema(description = "Account CBU", minLength = 22, maxLength = 22)
    private String cbu;
    
    @Schema(description = "Account Alias", minLength = 6, maxLength = 20)
    private String alias;
    
    @Schema(description = "Bank name", minLength = 10, maxLength = 40)    
    private String bank;
    
    @Schema(description = "Customer Id", minLength = 1, maxLength = 9)    
    private Integer customerId;
    
    @Schema(description = "List of credit cards associated with this account")
    private List<CreditCardResponse> creditCards = new ArrayList();
    
}
