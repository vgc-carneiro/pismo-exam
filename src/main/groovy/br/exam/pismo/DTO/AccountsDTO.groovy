package br.exam.pismo.DTO

import br.exam.pismo.model.Accounts

class AccountsDTO {

    String document_number
    Double available_credit_limit

    AccountsDTO(){}
    AccountsDTO(documentNumber, available_credit_limit){
        this.document_number = documentNumber
        this.available_credit_limit = available_credit_limit
    }

    def getDocument_number() {
        return document_number.toLong()
    }

    def static accountsToDTO(Accounts accounts){
        return new AccountsDTO(accounts.documentNumber.toString(), accounts.availableCreditLimit)
    }
}
