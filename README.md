# API-REST

## Descrição

>Sistema (API REST) de usuários e departamentos, com os seguintes casos de uso:

* Buscar todos usuários
* Buscar um usuário pelo seu id
* Inserir um novo usuário


## Diagrama de classes

![dominio](https://user-images.githubusercontent.com/57409786/156440390-0e1bbab4-1415-41e1-9a57-0484407ef7ed.png)

![objetos](https://user-images.githubusercontent.com/57409786/156440466-f653c5b2-efdd-42c4-af60-89af7b75a397.png)

## Instruções para build e execução

### execute o sistema e após isso é recomendado o uso do postman para acessar os end points.

* 1º passo: Usando o método get acesse a url (localhost:8080/user),  será retornado todos os usuários cadastrados no sistema.
* 2º passo: Usando o método get acesse a url (localhost:8080/user/id), onde no lugar de "id" deve ser colocado o número correspondente ao id do usuário que se quer o retorno. 
* 3º passo: Usando o método post acesse a url (localhost:8080/user), deve ser passando no body os dados do usuário em formato JSON para que seja adicionado ao sistema.

### Exemplo de dados do usuário em JSON:

```
}
    "name": "Jeff",
    "email": "Jeff@gmail.com",
    "department": {
        "id": 2,
    }
}
```
## Tecnologias usadas:
<!--ts-->
   * JAVA
   * Spring Boot
   * JPA
   * Hipernate
   * H2 console
<!--te-->
