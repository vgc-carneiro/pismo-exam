package br.exam.pismo.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(value = 'Index')
class IndexController {

    @RequestMapping(value = '/', method = RequestMethod.GET)
    @ApiOperation(value = 'Hello world')
    String index(){
        'Hello World!'
    }

}
