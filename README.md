# Central de Senhas · gRPC — projeto básico

Ponto de partida da aula de gRPC (Sistemas Paralelos e Distribuídos,
CEULP/ULBRA): o totem pede uma senha a uma Central, por uma única chamada
`PegarSenha`. Sem nenhum trabalho de grupo acrescentado ainda — é o mesmo
código dos passos 1 a 8 da aula.

## Rodar

**Sem usar o Git**, baixando o ZIP:

1. Nesta página do GitHub, botão verde **Code** → **Download ZIP**.
2. Extraia o ZIP. Vai criar uma pasta chamada
   `central-senhas-grpc-base-main` — **abra os projetos de dentro dela**,
   não a pasta em si.
3. No NetBeans: `File › Open Project…`, selecione a pasta
   `ServidorAtendimentoRPC` (dentro da pasta extraída) e repita para
   `ClienteAtendimentoRPC`.
4. `Clean and Build` em cada um (primeira vez baixa as dependências do
   gRPC, precisa de internet), depois `Run` no `ServidorAtendimentoRPC` e
   `Run` no `ClienteAtendimentoRPC`.

## Onde cada grupo acrescenta o seu trabalho

Os dois pontos exatos estão marcados no código com um comentário
`ACRESCENTE AQUI...`:

- `ServidorAtendimentoRPC/.../AtendimentoServiceImpl.java`, dentro do
  método `pegarSenha`, antes de numerar.
- `ClienteAtendimentoRPC/.../TelaTotem.java`, dentro de
  `btnPegarSenhaActionPerformed`, antes do `try`.

Se der erro de versão do Java no build, troque `maven.compiler.release`
pela versão do JDK instalado, nos dois `pom.xml`.
