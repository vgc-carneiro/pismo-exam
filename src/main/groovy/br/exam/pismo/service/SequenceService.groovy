package br.exam.pismo.service

import br.exam.pismo.model.Sequence
import br.exam.pismo.repository.SequenceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SequenceService {

    @Autowired
    SequenceRepository sequenceRepository

    def save(sequenceName){
        if(sequenceRepository.findById(sequenceName).isPresent()){
            throw new Error('Sequence already exists')
        }
        sequenceRepository.save(new Sequence(sequenceName, 1L))
    }

    def getSequenceNextValue(sequenceName){
        def sequence = sequenceRepository.findById(sequenceName)

        if(sequence.isEmpty()){
            save(sequenceName)
            sequence = sequenceRepository.findById(sequenceName)
        }

        def current = sequence.get().value
        sequence.get().with {
            it.value++
            sequenceRepository.save(it)
        }
        current
    }

}
