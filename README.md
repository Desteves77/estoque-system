#Sistema de Gerenciamento de Estoque

##Descrição Geral
Sistema de gerenciamento de estoque desenvolvido em Java, utilizando arquitetura em camadas (Model, DAO, Service e Menu). O projeto implementa operações de CRUD e simula um fluxo real de gerenciamento de produtos e insumos.

##Objetivo do Projeto
O projeto foi criado com os seguintes objetivos:

- Pratica de CRUD utilizando banco de dados MySQL;
- Consolidar conceitos de Programação Orientada a Objetos (POO) em Java;
- Exercitar organização de código e arquitetura em camadas;
- Praticar versionamento de código utilizando Git e GitHub;
- Utilizar Maven para gerenciamento de dependências em um projeto Java.

##Arquitetura de Sistema
A aplicação utiliza uma arquitetura em camadas:

- **Model**: Representa as entidades do sistema, contendo atributos e estrutura dos dados.
- **DAO **: Responsável pela comunicação com o banco de dados utilizando JDBC. Executa as operações de CRUD.
- **Service**: Camada que concentra as regras de negócio, validações e a integração entre Menu e DAO.
- **Menu**: Gerencia a interação com o usuário via console, exibindo opções e recebendo entradas.
- **Main**: Ponto de entrada da aplicação, iniciando o sistema e chamando o menu principal.
 
##Execução 
1. Configure o banco   
2. Ajuste a conexão  
3. Execute o Main  
4. Use o menu 

##Funcionalidades

O sistema permite realizar operações completas de CRUD para **produtos** e **insumos**, incluindo:

- **Cadastrar** novos registros;  
- **Consultar** itens existentes;  
- **Atualizar** informações cadastradas;  
- **Remover** registros do banco de dados;  
- **Listar** todos os itens cadastrados.

##Explicação das camadas
### **Model**
A camada Model representa as entidades do sistema, como potes e insumos.  
Cada classe contém seus atributos (id, nome, quantidade) e construtores utilizados para criar ou carregar objetos.  
Os Models são responsáveis apenas por armazenar dados, sem regras de negócio.

---

### **DAO**
O DAO é responsável pela comunicação com o banco de dados utilizando JDBC.  
Cada DAO executa operações de CRUD através de PreparedStatement, usando comandos SQL (INSERT, SELECT, UPDATE, DELETE).  
A conexão com o banco é centralizada em uma classe própria, que gerencia URL, usuário e senha.  
Essa camada recebe objetos Model e persiste seus dados no banco, retornando resultados para o Service.

---

### **Service**
A camada Service implementa as regras de negócio do sistema.  
Ela valida entradas do usuário (ex: nome não pode ser vazio, quantidade não pode ser negativa) e decide se uma operação deve ser concluída.  
Também integra Menu e DAO: recebe dados do Menu, aplica validações e chama o DAO para executar o CRUD.

---

### **Menu**
O Menu é responsável pela interação com o usuário via console.  
Exibe opções, recebe entradas digitadas e direciona cada ação para os métodos da camada Service.  
Cada menu (potes e insumos) possui seu próprio conjunto de operações.

---

### **Main**
A classe Main é o ponto de entrada da aplicação.  
Inicia a conexão com o banco de dados (se necessário) e chama o menu principal para iniciar o fluxo do sistema.

##Tecnologias utilizadas:
- JAVA 17 
- MAVEN 
- JDBC 
- MYSQL

##Evoluções Futuras
- Migrar para Spring boot 
- Incluir testes unitários 
- Criar interface web 
- Criar API REST.