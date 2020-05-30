package br.exam.pismo.repository

import br.exam.pismo.model.OperationType
import org.springframework.data.mongodb.repository.MongoRepository

interface OperationTypeRepository extends MongoRepository<OperationType, Long> {}