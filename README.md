# Pismo Exam (transactions)

# Infos
Este projeto está utilizando:
1.	Spring Boot
2.	Groovy
3.	MongoDB
4. Docker

Para utilizar este projeto, recomenda-se ir através do <strong>Makefile<strong/>.

- ## Run

### Primeiro build

```bash
make build
```

Caso apresente uma mensagem parecida com: "Build up to date", executar:

```bash
make -B build
```

### Executar projeto apontado para MongoDB Cloud

```bash
make dev
```

### Executar projeto apontado para MongoDB local

```bash
make local
```

Caso queria rodar local, é necessário conectar-se ao mongo e gerar a base inicial.
```bash
mongo mongodb://localhost:21017/
```

E executar o script que se localiza:
```bash
scripts/mongo-script
```

###### Todos os comandos podem ser vistos no arquivo Makefile. 
