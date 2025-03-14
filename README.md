# ```DsVendas-API```

Este projeto é uma aplicação para gerenciar vendas de produtos, com funcionalidades de cadastro de produtos, clientes e realização de vendas. O sistema é dividido em duas partes: o back-end (API) e o front-end (interface do usuário).

## ``Estrutura do Projeto``

- **Back-end:** Responsável pelo gerenciamento de dados, API e lógica de negócios.
- **Front-end:** Responsável pela interface do usuário e interação com a API, segue o link para o Front-end -> https://github.com/0tavioPascoal/dsvendas .

## ``Funcionalidades``

- **Cadastro de Produtos:** O sistema permite o cadastro, visualização, atualização e exclusão de produtos.
- **Cadastro de Clientes:** O sistema permite o cadastro, visualização, atualização e exclusão de clientes.
- **Realização de Vendas:** O sistema permite a realização de vendas, com o controle de itens vendidos e valores totais.
- **Geração de Relatórios:** O sistema permite a geração de relatórios.
  
## ``Tecnologias Utilizadas``

### Back-end

- **Linguagem:** Java
- **Framework:** [Spring, JasperReports]
- **Banco de Dados:** PostgreSQL

 ## ``Autenticação``

A autenticação é realizada através do front-end, utilizando o login OAuth2 via GitHub. O sistema permite que os usuários se autentiquem usando suas credenciais do GitHub para acessar a aplicação.



## ``Documentação da API``

### Produtos.

- Rotas para Modificação, criação, exclusão e listagem de produtos.

##

``http
  POST /products
``

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `string` | Nome do Produto. |
| `sku`      | `string` | indetificador do produto. |
| `price`      | `BigDecimal` | Preço do produto. |
| `description`      | `String` | Descrição do produto. |

##
``http
  GET /products
``

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
|             |            |Retorna todos os produtos. |

``http
  GET /products
``

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` | **Obrigatório** Id do Produto. |


##
``http
  DEL /products
``

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` | **Obrigatório** Id do Produto. |

##
``http
  PUT /products
``


| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório** Id do Produto. |

| Corpo   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name`      | `string` | Nome do Produto. |
| `sku`      | `string` | indetificador do produto. |
| `price`      | `BigDecimal` | Preço do produto. |
| `description`      | `String` | Descrição do produto. |


### Clientes

- Rotas para criação, alteração e deleção de Clientes na aplicação.

##

``http
  GET /clients
``
- Busca todos os autores com o nome ou nacionalidade passada por parâmetro.
  
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `name`      | `string` | Clientes com esse nome ou letra. |
| `cpf`| `string` | Clientes com o cpf. |

##
``http
  GET /clients
``
- Busca Cliente por id.

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` | **Obrigatório** Id do cliente. |

##
``http
  POST /clients
``

| Corpo         | Tipo       | Descrição                                   |
| :----------   | :--------- | :------------------------------------------ |
| `name`        | `string` | **Obrigatório** nome do cliente. |
| `birthday` | `date` | **Obrigatório** Obrigatorio a data de nascimento do cliente. |
| `email`   | `string` | **Obrigatório** email do Autor. |
| `address`   | `string` | **Obrigatório** endereço do Autor. |
| `phone`   | `string` | **Obrigatório** telefone do Autor. |
| `cpf`   | `string` | **Obrigatório** CPF do Autor. |

##
``http
  PUT /clients
``

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` | **Obrigatório** Id do cliente. |

| Corpo         | Tipo       | Descrição                                   |
| :----------   | :--------- | :------------------------------------------ |
| `name`        | `string` | **Obrigatório** nome do cliente. |
| `birthday` | `date` | **Obrigatório** Obrigatorio a data de nascimento do cliente. |
| `email`   | `string` | **Obrigatório** email do Autor. |
| `address`   | `string` | **Obrigatório** endereço do Autor. |
| `phone`   | `string` | **Obrigatório** telefone do Autor. |
| `cpf`   | `string` | **Obrigatório** CPF do Autor. |

##
``http
  DEL /clients
``
- Somente Admins.

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `long` | **Obrigatório** Id do Autor. |


### Vendas

- Rotas para criação de Vendas.

##

``http
  POST /sell
``

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cLient`      | `Client` | **Obrigatório** Cliente da venda. |
| `itens`      | `List<Products>` |**Obrigatório** Todos os produtos. |
| `total`      | `bigDecimal` |**Obrigatório** Preço total da venda. |
| `payment`      | `string` |**Obrigatório** Tipo de pagamento -> (CREDIT, PIX, CASH...). |




## Relatorios

``http
  GET /reports
``
- Gera um relatorio de vendas pelo cliente.
  
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `idClient`      | `long` | **Obrigatório** Id do cliente. |
| `startDate`| `string` |**Obrigatório** Data de inicio da pesquisa. |
| `finalDate`| `string` |**Obrigatório** Data final da pesquisa. |

## Dashboard

``http
  GET /dashboard
``
- retorna os dados para a construção de um dashboard.
  
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `products` | `long` | Retorna a somatoria de produtos. |
| `clients`| `long` |Retorna a somatoria dos clientes. |
| `sells`| `long` | Retorna todas as vendas. |

- [@OtavioPascoal](https://github.com/0tavioPascoal)
