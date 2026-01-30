package com.pie.account.controller;

import com.pie.account.model.AccountDTO;
import com.pie.account.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value="/v1")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService=accountService;
    }

    @GetMapping(value="/hello")
    // @PreAuthorize("hasAuthority('USER_ROLE')")
    //@PreAuthorize("hasRole('USER_ROLE')")
    public ResponseEntity<String> getHello(){
        return new ResponseEntity<String>("Hello from Account Service", HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",  description = "Found the Customer"),
            @ApiResponse(responseCode = "400", description = "Invalid id customerId"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Unauthorized"),
            @ApiResponse(responseCode = "404", description = "Customer not Found"),
            @ApiResponse(responseCode = "405", description = "Method not Allowed"),
            @ApiResponse(responseCode = "406", description = "Not Acceptable"),
            @ApiResponse(responseCode = "429", description = "Too many Requests"),
            @ApiResponse(responseCode = "500", description = "Internal Server errors",
                    content = @Content) })

    @GetMapping(value="/getAccountById/{accountId}")
   // @PreAuthorize("hasAuthority('USER_ROLE')")
    //@PreAuthorize("hasRole('USER_ROLE')")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable("accountId") String accountId ){
        return new ResponseEntity<AccountDTO>(accountService.getAccountById(accountId), HttpStatus.OK);
    }
    @GetMapping(value="/getAccount/{accountId}")
    // @PreAuthorize("hasAuthority('USER_ROLE')")
    //@PreAuthorize("hasRole('USER_ROLE')")
    public ResponseEntity<AccountDTO> getAccountWithId(@RequestParam String accountId){
        return new ResponseEntity<AccountDTO>(accountService.getAccountById(accountId), HttpStatus.OK);
    }

    @PostMapping(value="/openAccount")
    public ResponseEntity<AccountDTO> openAccount(@RequestBody AccountDTO dto)
    {
        return new ResponseEntity<AccountDTO>(accountService.openAccount(dto),HttpStatus.CREATED);
    }

    @GetMapping(value="/getAccount")
    public ResponseEntity<AccountDTO> getAccount(){
        return  ResponseEntity.ok().body(accountService.getAccount("1"));
    }

    @PutMapping(value="/updateAccount/{accountId}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable("accountId") String accountId ,@RequestParam String amount){
        return new ResponseEntity<AccountDTO>(accountService.updateAccount(accountId,amount), HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteAccount/{accountId}")
    public  ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable("accountId") String accountId ){
        return new ResponseEntity<Map<String, Boolean>>(accountService.deleteAccount(accountId), HttpStatus.OK);

    }
}
