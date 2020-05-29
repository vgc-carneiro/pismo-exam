package br.exam.pismo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = 'accounts')
class Accounts {

    @Id
    Long accountId
    Long documentNumber
    Date lastUpdated

    Accounts(Long accountId, Long documentNumber){
        this.accountId = accountId
        this.documentNumber = documentNumber
        lastUpdated = new Date()
    }

}
