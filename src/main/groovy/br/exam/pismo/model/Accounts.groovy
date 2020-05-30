package br.exam.pismo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = 'accounts')
class Accounts {

    @Id
    final Long accountId
    final Long documentNumber
    Date lastUpdated

    Accounts(accountId, documentNumber){
        this.accountId = accountId
        this.documentNumber = documentNumber
        lastUpdated = new Date()
    }

}
