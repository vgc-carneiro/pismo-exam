package br.exam.pismo.repository

import br.exam.pismo.model.Accounts
import org.springframework.data.mongodb.repository.MongoRepository

interface AccountsRepository extends MongoRepository<Accounts, Long> {}