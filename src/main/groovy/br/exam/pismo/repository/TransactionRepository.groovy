package br.exam.pismo.repository

import br.exam.pismo.model.Transaction
import org.springframework.data.mongodb.repository.MongoRepository

interface TransactionRepository extends MongoRepository<Transaction, Object> {}