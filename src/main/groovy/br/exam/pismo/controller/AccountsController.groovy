package br.exam.pismo.controller

import br.exam.pismo.DTO.AccountsDTO
import br.exam.pismo.model.Accounts
import br.exam.pismo.service.AccountsService
import br.exam.pismo.service.SequenceService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(value = 'Accounts')
class AccountsController {

    @Autowired
    AccountsService accountsService
    @Autowired
    SequenceService sequenceService

    @RequestMapping(value = '/accounts', method = RequestMethod.POST)
    @ApiOperation(value = 'Create account')
    ResponseEntity<Accounts> create(@RequestBody AccountsDTO payload){
        new ResponseEntity<Accounts>(accountsService.save(sequenceService.getSequenceNextValue(Accounts.class.toString()), payload.document_number), HttpStatus.CREATED)
    }

    @RequestMapping(value = '/accounts/{accountId}', method = RequestMethod.GET)
    @ApiOperation(value = 'Get Account')
    ResponseEntity<AccountsDTO> getAccount(@PathVariable long accountId){
        new ResponseEntity<AccountsDTO>(AccountsDTO.accountsToDTO(accountsService.get(accountId).get()), HttpStatus.OK)
    }

}
