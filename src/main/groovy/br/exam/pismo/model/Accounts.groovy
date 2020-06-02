package br.exam.pismo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = 'accounts')
class Accounts {

    @Id
    final Long accountId
    final Long documentNumber
    Double creditLimit
    Double availableCreditLimit
    Date lastUpdated

    Accounts(accountId, documentNumber, creditLimit){
        creditLimit = creditLimit ?: 0
        this.accountId = accountId
        this.documentNumber = documentNumber
        this.creditLimit = creditLimit
        this.availableCreditLimit = creditLimit
        lastUpdated = new Date()
    }

}
