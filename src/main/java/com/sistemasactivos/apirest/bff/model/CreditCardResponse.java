package com.sistemasactivos.apirest.bff.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.Date;
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
public class CreditCardResponse extends BaseDTO{
    
    @Schema(description = "Identifier attribute", example = "10")
    private Integer Id;
    
    @Schema(description = "Status of soft delete")
    private Boolean active;
    
    @Schema(description = "Date of creation")
    private Date createdAt;
    
    @Schema(description = "Date of update")
    private Date updatedAt;
    
    @Schema(description = "Description", example = "This is a description", minLength = 10, maxLength = 50)
    private String description;
    
    @Schema(description = "Card Number", example = "1111111111111111", minLength = 16, maxLength = 16)
    private String cardNumber;
    
    @Schema(description = "Date the card was issued")
    private LocalDate cardIssueDate;
    
    @Schema(description = "Date the card will expire")
    private LocalDate cardExpirationDate;
    
}
