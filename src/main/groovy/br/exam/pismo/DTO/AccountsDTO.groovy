package br.exam.pismo.DTO

import br.exam.pismo.model.Accounts

class AccountsDTO {

    String document_number

    AccountsDTO(){}
    AccountsDTO(documentNumber){
        this.document_number = documentNumber
    }

    def getDocument_number() {
        return document_number.toLong()
    }

    def static accountsToDTO(Accounts accounts){
        return new AccountsDTO(accounts.documentNumber.toString())
    }
}
