# API-REST

## Descrição

>Sistema (API REST) de usuários e departamentos, com os seguintes casos de uso:

* Buscar todos usuários
* Buscar usuário filtrando por id
* Buscar usuário filtrando por nome
* Buscar usuário filtrando por salário
* Buscar usuário filtrando por email
* Buscar usuário filtrando por nome do departamento
* Inserir um novo usuário



## Diagrama de classes
![Class Diagram](https://user-images.githubusercontent.com/57409786/156649078-02da2fac-883c-4e31-b8c8-9a4f377768a1.PNG)

![objetos](https://user-images.githubusercontent.com/57409786/156440466-f653c5b2-efdd-42c4-af60-89af7b75a397.png)

## Instruções para build e execução

### execute o sistema e após isso é recomendado o uso do postman para acessar os end points.

* 1º passo: Usando o método get acesse a url (localhost:8080/user),  será retornado todos os usuários cadastrados no sistema.
* 2º passo: Usando o método get acesse a url (localhost:8080/user/id), onde no lugar de "id" deve ser colocado o número correspondente ao id do usuário que se quer o retorno.
* 3º passo: Usando o método get acesse a url (localhost:8080/user/search-salary?minSalary=2000&maxSalary=4000), onde deve ser colocado o valor de minSalary e de maxSalary desejado para realizar o filtro de usuários entre os valores de salários informados. 
* 4º passo: Usando o método get acesse a url (localhost:8080/user/search-department?name=nome_do_departamento), onde no lugar de "nome_do_departamento" deve ser colocado o nome do departamento que se quer filtrar.
* 5º passo: Usando o método get acesse a url (localhost:8080/user/search-email?email=email_user), onde no lugar de "email_user" deve ser colocado o email do usuário que deseja-se filtrar.
* 6º passo: Usando o método post acesse a url (localhost:8080/user), deve ser passando no body os dados do usuário em formato JSON para que seja adicionado ao sistema.

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
