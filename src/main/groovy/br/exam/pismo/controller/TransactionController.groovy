package br.exam.pismo.controller

import br.exam.pismo.DTO.TransactionDTO
import br.exam.pismo.exceptions.PropertyNotFoundException
import br.exam.pismo.model.Transaction
import br.exam.pismo.service.AccountsService
import br.exam.pismo.service.OperationTypeService
import br.exam.pismo.service.TransactionService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(value = 'Transactions')
class TransactionController {

    @Autowired
    TransactionService transactionService
    @Autowired
    AccountsService accountsService
    @Autowired
    OperationTypeService operationTypeService

    @RequestMapping(value = '/transactions', method = RequestMethod.POST)
    @ApiOperation('Create Transactions')
    ResponseEntity<Transaction> create(@RequestBody TransactionDTO payload){
        def opAcc = accountsService.get(payload.account_id)
        def opType = operationTypeService.get(payload.operation_type_id)

        if(opAcc.isEmpty()){
            throw new PropertyNotFoundException('Account not found.')
        }
        if(opType.isEmpty()){
            throw new PropertyNotFoundException('Operation Type not found.')
        }

        new ResponseEntity<Transaction>(transactionService.save(opAcc.get(), opType.get(), payload.amount, new Date()), HttpStatus.CREATED)
    }

}
