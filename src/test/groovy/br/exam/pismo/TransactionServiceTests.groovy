package br.exam.pismo

import br.exam.pismo.model.Accounts
import br.exam.pismo.model.OperationType
import br.exam.pismo.service.TransactionService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TransactionServiceTests {

    @Autowired
    private TransactionService transactionService

    @Test()
    void checkAmount() {
        Accounts accounts = new Accounts(1L, 1L)
        OperationType operationType = new OperationType(1L, 'unit Test', true)
        Assertions.assertThatThrownBy( {
            transactionService.save(accounts, operationType, -100, new Date())
        }
        ).hasMessage('Amount not corresponding to a operation type.')
    }
}
