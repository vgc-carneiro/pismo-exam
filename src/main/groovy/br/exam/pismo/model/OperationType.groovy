package br.exam.pismo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = 'operation-type')
class OperationType {

    @Id
    Long operationTypeId
    String description
    Boolean increaseValue

    OperationType(operationTypeId, description, increaseValue){
        this.operationTypeId = operationTypeId
        this.description = description
        this.increaseValue = increaseValue
    }

}