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

    def save(accounts, operationType, amount, eventDate){
        if((operationType.increaseValue && amount > 0) || (!operationType.increaseValue && amount < 0)){
            transactionRepository.save(new Transaction(accounts, operationType, amount, eventDate))
        }else{
            throw new IllegalTransactionException('Amount not corresponding to a operation type.')
        }
    }

}
