package br.exam.pismo.repository

import br.exam.pismo.model.Sequence
import org.springframework.data.mongodb.repository.MongoRepository

interface SequenceRepository extends MongoRepository<Sequence, String> {}