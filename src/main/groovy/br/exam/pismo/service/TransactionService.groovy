package br.exam.pismo.service

import br.exam.pismo.exceptions.IllegalTransactionException
import br.exam.pismo.model.Transaction
import br.exam.pismo.repository.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TransactionService {

    @Autowired
    TransactionRepository transactionRepository
    @Autowired
    AccountsService accountsService

    def save(accounts, operationType, amount, eventDate){
        if((operationType.increaseValue && amount > 0) || (!operationType.increaseValue && amount < 0)){
            accounts = accountsService.calculateCredit(accounts, operationType, amount)
            Transaction transaction = transactionRepository.save(new Transaction(accounts, operationType, amount, eventDate))
            accountsService.update(accounts)
            return transaction
        }else{
            throw new IllegalTransactionException('Amount not corresponding to a operation type.')
        }
    }

}