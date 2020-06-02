package br.exam.pismo.service

import br.exam.pismo.exceptions.IllegalTransactionException
import br.exam.pismo.model.Accounts
import br.exam.pismo.repository.AccountsRepository
import com.mongodb.DuplicateKeyException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository

    def save(accountId, documentNumber, creditLimit){
        accountsRepository.save(new Accounts(accountId, documentNumber, creditLimit))
    }

    def update(accounts){
        accountsRepository.save(accounts)
    }

    def findAll(){
        accountsRepository.findAll()
    }

    def get(accountId){
        accountsRepository.findById(accountId)
    }

    def calculateCredit(accounts, operationType, amount){
        if(operationType.increaseValue){
            accounts.availableCreditLimit += amount
        }else{
            amount = Math.abs(amount)
            if(accounts.availableCreditLimit >= amount){
                accounts.availableCreditLimit -= amount
            }else{
                throw new IllegalTransactionException('No credit available for this transaction.')
            }
        }
        return accounts
    }

}
