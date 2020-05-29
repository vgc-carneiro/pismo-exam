package br.exam.pismo.service

import br.exam.pismo.model.Accounts
import br.exam.pismo.repository.AccountsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository

    def salvar(accountId, Long documentNumber){
        accountsRepository.save(new Accounts(accountId, documentNumber))
    }

    def findAll(){
        accountsRepository.findAll()
    }

}
