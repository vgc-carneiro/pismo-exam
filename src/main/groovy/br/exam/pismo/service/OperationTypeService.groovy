package br.exam.pismo.service

import br.exam.pismo.model.OperationType
import br.exam.pismo.repository.OperationTypeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OperationTypeService {

    @Autowired
    private OperationTypeRepository operationTypeRepository

    def findAll(){
        operationTypeRepository.findAll()
    }

    def get(operationTypeId){
        operationTypeRepository.findById(operationTypeId)
    }

}
