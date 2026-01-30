package com.pie.account.service;

import com.pie.account.model.AccountDTO;

import java.util.Map;

public interface AccountService {
    AccountDTO getAccountById(String accountId);
    AccountDTO  openAccount(AccountDTO accountDto);

    AccountDTO getAccount(String accountId);
    AccountDTO updateBalance(String accountId,String balance);
    AccountDTO updateAccount(String accountId,String balance);
    Map<String, Boolean> deleteAccount(String accountId);
}
