package br.exam.pismo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PismoApplication {

    static void main(String[] args) {
        SpringApplication.run(PismoApplication, args)
        println 'Server started.....'
    }

}
