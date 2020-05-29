package br.exam.pismo.controller

//import br.exam.pismo.model.Accounts
//import br.exam.pismo.model.OperationType
import br.exam.pismo.service.AccountsService
import br.exam.pismo.service.OperationTypeService
import br.exam.pismo.service.TransactionService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(value = 'Index')
class IndexController {

    @Autowired
    AccountsService accountsService
    @Autowired
    OperationTypeService operationTypeService
    @Autowired
    TransactionService transactionService

    @RequestMapping(value = '/', method = RequestMethod.GET)
    @ApiOperation(value = 'Hello world')
    String index(){
//        operationTypeService.salvar(1L, 'COMPRA À VISTA', false)
//        operationTypeService.salvar(2L, 'COMPRA PARCELADA', false)
//        operationTypeService.salvar(3L, 'SAQUE', false)
//        operationTypeService.salvar(4L, 'PAGAMENTO', true)
//        accountsService.salvar(123L, 123333333L)
//        transactionService.salvar(accountsService.get(123L).get(), operationTypeService.get(4L).get(), 115.5, null)

        'Hello World!'
    }

}
