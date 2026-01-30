package com.pie.account.service;

import com.pie.account.entity.AccountEntity;
import com.pie.account.exception.ResourceNotFoundException;
import com.pie.account.model.AccountDTO;
import com.pie.account.repo.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;
    private ModelMapper mapper;

    public AccountServiceImpl(final AccountRepository accountRepository, final ModelMapper mapper) {
        this.accountRepository=accountRepository;
        this.mapper=mapper;
    }

    @Override
    public AccountDTO getAccountById(String accountId) {
        Optional<AccountEntity> accenity= accountRepository.findById(Long.parseLong(accountId));
        return mapToDTO(accenity.get());
    }

    @Override
    public AccountDTO openAccount(AccountDTO accountDto) {
        AccountEntity accountEntity= mapToEntity(accountDto);
        AccountEntity  accenity= accountRepository.save(accountEntity);
        return mapToDTO(accenity);
    }

    @Override
    public AccountDTO getAccount(String accountId) {
        Optional<AccountEntity> accenity= accountRepository.findById(Long.parseLong(accountId));
        return mapToDTO(accenity.get());
    }

    @Override
    public AccountDTO updateBalance(String accountId, String balance) {
        AccountEntity accountEntity = accountRepository.findById(Long.parseLong(accountId))
                .orElseThrow(() -> new ResourceNotFoundException("Account Number not found patch :: "+ accountId));
        //Optional<AccountEntity> accenity= accountRepository.findById(Long.parseLong(accountId));
        accountEntity.setBalance(Long.parseLong(balance));
        accountEntity=accountRepository.save(accountEntity);
        return mapToDTO(accountEntity);
    }

    @Override
    public AccountDTO updateAccount(String accountId, String balance) {
        AccountEntity accountEntity = accountRepository.findById(Long.parseLong(accountId))
                .orElseThrow(() -> new ResourceNotFoundException("Account Number not found for update :: "+ accountId));
        //Optional<AccountEntity> accenity= accountRepository.findById(Long.parseLong(accountId));
        accountEntity.setAccountType("current");
        accountEntity.setOpeningDate(LocalDate.parse("2023-06-12"));
        accountEntity.setBalance(Long.parseLong(balance));
        accountEntity=accountRepository.save(accountEntity);
        return mapToDTO(accountEntity);
    }

    @Override
    public Map<String, Boolean> deleteAccount(String accountId) {
        AccountEntity accountEntity = accountRepository.findById(Long.parseLong(accountId))
                .orElseThrow(() -> new ResourceNotFoundException("Account Number not found to delete :: "+ accountId));

        accountRepository.delete(accountEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Account No ::"+accountId+":: deleted successfully", Boolean.TRUE);
        return response;


    }

    private AccountDTO mapToDTO(AccountEntity accountEntity){
        AccountDTO accountDto = mapper.map(accountEntity, AccountDTO.class);
        String uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .scheme("http").build().toUriString();
        accountDto.setLink(uri);
        return  accountDto ;
    }
    private AccountEntity mapToEntity(AccountDTO dto){
        AccountEntity accountEntity = mapper.map(dto, AccountEntity.class);
        return  accountEntity;
    }
}
