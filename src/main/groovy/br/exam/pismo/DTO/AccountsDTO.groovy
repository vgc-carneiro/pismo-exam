package br.exam.pismo.DTO

class AccountsDTO {

    String document_number

    def getDocument_number() {
        return document_number.toLong()
    }
}
