package br.exam.pismo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = 'accounts')
class Accounts {

    @Id
    String accountId;
    Long documentNumber;

    Accounts(String accountId, Long documentNumber){
        this.accountId = accountId
        this.documentNumber = documentNumber
    }

}
