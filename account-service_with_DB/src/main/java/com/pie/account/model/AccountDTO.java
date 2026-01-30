package com.pie.account.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Generated
//@Builder(toBuilder = true)
//@Getter
//@ToString
public class AccountDTO {

    @JsonProperty(value="AccountNo")
    private String accountNo;
    @JsonProperty(value="AccountType")
    private String 	accountType;
    @JsonProperty(value="OpeningDate")
    private LocalDate  openingDate;
    @JsonProperty(value="Balance")
    private double balance;
    @JsonProperty(value="link")
    private String link;
}
