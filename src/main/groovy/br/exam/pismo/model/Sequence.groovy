package br.exam.pismo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = 'sequences')
class Sequence {

    @Id
    String name
    Long value

    Sequence(name, value){
        this.name = name
        this.value = value
    }

}
