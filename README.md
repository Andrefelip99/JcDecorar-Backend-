# 🏠 JC Decorar Site - Backend

API REST desenvolvida para gerenciamento de projetos da **JC Decorar**, utilizando **Java + Spring Boot** com foco em boas práticas de desenvolvimento backend.

O projeto foi criado para disponibilizar uma estrutura segura e organizada para cadastro, consulta, atualização e remoção de projetos de decoração, servindo como backend para um futuro site institucional.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot 3.5.4
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- Bean Validation
- PostgreSQL
- Maven
- Lombok
- Docker

---

## 📌 Funcionalidades

### Projetos

- ✅ Listagem de todos os projetos
- ✅ Busca de projeto por ID
- ✅ Cadastro de novos projetos
- ✅ Atualização de projetos existentes
- ✅ Remoção de projetos

---

## 🔐 Segurança

O projeto utiliza **Spring Security** para controle de acesso.

Foi implementada uma estrutura inicial de autenticação com:

- Usuário administrador criado automaticamente na inicialização da aplicação
- Senhas protegidas utilizando BCrypt
- Controle de permissões por roles

Usuário padrão criado:
