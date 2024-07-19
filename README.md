# ENCURTAA - Encurtador de URL

![GitHub repo size](https://img.shields.io/github/repo-size/andre-xizto/encurtador-url?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/andre-xizto/encurtador-url?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/andre-xizto/encurtador-url?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/andre-xizto/encurtador-url?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/andre-xizto/encurtador-url?style=for-the-badge)

> Este projeto é uma API que encurta uma dada URL

### Ajustes e melhorias

O projeto foi desenvolvido com o intuito de ser uma resolução de um desafio do [Backend-br](https://github.com/backend-br/desafios/tree/master). Sinta-se a vontade para refatorar ou adicionar novas funcionalidades

- [x] Trocar os DTOs de classes para records
- [x] Criar uma exception para URL expirada
- [ ] Criar uma lógica própria para gerar a URL curta

## 💻 Pré-requisitos

Caso queira rodar este projeto na sua própria máquina, veja os requisitos abaixo:

- Java `21`

## 🚀 Instalando

Para instalar o Encurtaa, siga estas etapas:

1. Clone o repositório: 
```
https://github.com/andre-xizto/encurtador-url.git
```

2. Entre na pasta raiz do projeto

3. Execute o projeto com **Maven** ou **Gradle**
 - Maven:
   - ```mvn spring-boot:run```
 - Gradle:
   - ```gradle bootRun```
## ☕ Documentação Encurtaa

#### Retorna a URL encurtada

```http
  POST /api
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `url` | `string` | **Obrigatório**. URL a ser encurtada |

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="#" title="GitHub de André Xisto">
        <img src="https://avatars.githubusercontent.com/u/35929740" width="100px;" alt="Foto do André Xisto no GitHub"/><br>
        <sub>
          <b>André Xisto</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

## 📝 Licença

Esse projeto está sob licença. Veja o arquivo [LICENÇA](LICENSE.md) para mais detalhes.