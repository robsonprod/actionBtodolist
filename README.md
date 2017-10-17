## Projeto de treinamento ToDoList.

## Clone Projeto
git clone https://github.com/robsonprod/actionBtodolist.git

## Configurando o projeto e banco de dados.
- Por padrão o projeto está configurado para o banco MySQL.

### Os passos básicos são:
>
    1. Importe o projeto para o Eclipse Java EE IDE for Web Dvelopers (Neon) ou superior;
    2. Adicione o driver Mysql-connector-java-5.1.42-bin.jar no diretório /webcontent/WEB-INF/lib;
    3. Adicione também as libs
        javax.servlet.jsp.jstl-1.2.1.jar
        javax.servlet.jsp.jstl-api-1.2.1.jar
        taglibs-standard-impl-1.2.1.jar
	junit-4.12.jar
	mockito-all-1.9.5.jar
    4. Importe a base de dados *todolist.sql* no MySQL Workbench;
    5. Insira um novo usuário para poder entrar na aplicação;
    6. Abra e edite o arquivo *ConnectionFactory.java* em /Java Resources/src/br.todolist.dao/
         para sua configuração do banco MySql;
    7. Faça o deploy no Apache Tomcat 7.X e inicie o servidor;
>
