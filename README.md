# Agendador de Meetups
### Bootcamp WoMakersCode

A aplicação consiste em um agendador em que o usuário se cadastra na plataforma e se registra em um meetup já cadastrado. A API foi criada a partir de Testing Driven Development (TDD) ou Desenvolvimento Guiado por Testes que tem por finalidade o desenvolvimento de softwares a partir de ciclos, onde inicialmente se escreve um teste unitário que a princípio irá falhar pois o código ainda não foi implementado; em seguida é criado o código que satisfaça o teste, implementando uma funcionalidade para esse teste; após isso o teste será executado e irá passar.


## Tecnologias utilizadas:

- Spring Web;
- Spring Data;
- H2;
- Lombok;
- Maven;
- Swagger;
- Heroku

## Swagger da Aplicação

![API Swagger](https://github.com/edithpenha20/meetup-endy-wmc/blob/main/img-wmc/img-01.png)

Foram criadas   **3 camadas** Sendo a primeira para criar um evento de Meetup onde um host irá inserir todos os dados referentes ao meetup conforme a imagem abaixo. 

![API Swagger](https://github.com/edithpenha20/meetup-endy-wmc/blob/main/img-wmc/img-02.png)

Nesta camada é possível além de inserir, atualizar, deletar e obter as informações dos meetups já registrados.

![API Swagger](https://github.com/edithpenha20/meetup-endy-wmc/blob/main/img-wmc/img-03.png)

A camada **user** é responsável por cadastrar um usuário na plataforma de Meetup, a partir desse cadastro o usuário poderá acessar todos meetups já cadastrados e se registrar em um evento.

![API Swagger](https://github.com/edithpenha20/meetup-endy-wmc/blob/main/img-wmc/img-04.png)

A partir daí o usuário pode acessar a camada **meetup** e se registrar em um evento.

![API Swagger](https://github.com/edithpenha20/meetup-endy-wmc/blob/main/img-wmc/img-05.png)

## Heroku

Foi realizado o deploy da aplicação na plataforma Heroku e pode ser acessada através do link:
```
https://meetup-endy.herokuapp.com/swagger-ui/index.html
```

## Agradecimentos

Agradeço a WoMakersCode pela oportunidade de fazer parte do Bootcamp; a Mariana Sales pelo apoio e atenção; a Ana Beatriz nossa instrutora principal por compartilhar conhecimentos e experiências conosco; e não poderia deixar de citar a cada speaker que além de compartilhar experiências também nos norteou em nossa nova jornada como Desenvolvedora Java.
