package br.exam.pismo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = 'transaction')
class Transaction {

    @Id
    ObjectId transactionId
    Accounts accounts
    OperationType operationType
    Double amount
    Date eventDate

    Transaction(accounts, operationType, amount, eventDate){
        transactionId = new ObjectId()
        this.accounts = accounts
        this.operationType = operationType
        this.amount = amount
        this.eventDate = eventDate?: new Date()
    }

    String getTransactionId() {
        return transactionId.toString()
    }
}
