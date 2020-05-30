package br.exam.pismo.DTO

import br.exam.pismo.model.Transaction

class TransactionDTO {

    Long account_id
    Long operation_type_id
    Double amount

    TransactionDTO(){}

    TransactionDTO(Long account_id, Long operation_type_id, Double amount) {
        this.account_id = account_id
        this.operation_type_id = operation_type_id
        this.amount = amount
    }

    def transactionToDTO(Transaction transaction){
        return new TransactionDTO(transaction.accounts.accountId, transaction.operationType.operationTypeId, transaction.amount)
    }

}
