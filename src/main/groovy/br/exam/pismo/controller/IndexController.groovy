package br.exam.pismo.controller

import br.exam.pismo.service.AccountsService
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

    @RequestMapping(value = '/', method = RequestMethod.GET)
    @ApiOperation(value = 'Hello world')
    String index(){
        accountsService.salvar('123', 123L)
        'Hello World!'
    }

}
