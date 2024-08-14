# Trabalho 1 TTPE

## Alunos

| Nome  | Matrícula  | 
| :--:  | :-------:  | 
| Breno | 20/2015984 | 
| Daniel | 19/0104821 | 
| Wengel | 19/0118555 |

| [<img src="https://avatars.githubusercontent.com/u/81342329?v=4" width=50><br><sub>Breno Henrique</sub>](https://github.com/bhsouza) | [<img src="https://avatars.githubusercontent.com/u/71887425?v=4" width=50><br><sub>Daniel</sub>](https://github.com/DanRocha18 ) | [<img src="https://avatars.githubusercontent.com/u/88208512?v=4" width=50><br><sub>Wengel</sub>](https://github.com/Wengel-Rodrigues)|
| :---: | :---: | :---: |

## Metodologia
### Test-Driven Development (TDD)
#### Definição:

Test-Driven Development (Desenvolvimento Orientado a Testes) é uma técnica de desenvolvimento de software onde os testes são escritos antes do código funcional. Este processo é iterativo e segue um ciclo específico.

#### Ciclo TDD:

 1. Red (Escrever o Teste): Escreva um teste automatizado que define uma pequena melhoria ou nova funcionalidade. Inicialmente, o teste deve falhar, pois a funcionalidade ainda não foi implementada.
 2. Green (Escrever o Código): Escreva o código mínimo necessário para fazer o teste passar. O foco é apenas na implementação do que é estritamente necessário para que o teste seja bem-sucedido.
 3. Refactor (Refatorar): Com o teste passando, refatore o código para melhorar sua estrutura e qualidade, mantendo todos os testes passando. Este passo foca na remoção de duplicações e na melhoria do design do código.

#### Benefícios do TDD:

 * Qualidade do Código: A prática de escrever testes primeiro força os desenvolvedores a pensar nos requisitos e design antes de implementar a funcionalidade.
 * Refatoração Segura: Como há uma suíte de testes robusta, refatorar o código torna-se mais seguro, pois qualquer erro introduzido será - detectado rapidamente pelos testes.
 * Documentação Viva: Os testes servem como uma forma de documentação viva do comportamento esperado do sistema.
 * Feedback Rápido: O ciclo curto de escrever um teste, implementar a funcionalidade e refatorar proporciona um feedback rápido sobre a correção do código.
 * Menor Incidência de Bugs: A prática contínua de testes reduz a probabilidade de introdução de bugs no código.

#### Desvantagens do TDD:

 * Curva de Aprendizado: Desenvolvedores precisam se acostumar com a disciplina de escrever testes antes do código funcional, o que pode ser desafiador no início.
 * Tempo Inicial: Pode parecer que o desenvolvimento inicial é mais lento, pois o tempo é investido na criação de testes antes da funcionalidade.
 * Manutenção de Testes: À medida que o código evolui, os testes também precisam ser mantidos e atualizados, o que pode adicionar um esforço extra.

 ## Enunciado

 Utilizando as técnicas de TDD, crie um programa que seja capaz de realizar as seguintes ações:

 * Cadastrar clientes dos três diferentes tipos (padrão, especial e prime), com seus endereços de entrega em diferentes regiões do pais. Por simplicidade, considere apenas o estado e informe se o endereço é na capital ou no interior.
 * Cadastrar diferentes tipos de produtos. Para cada produto deverá ser informado:
     - Codigo do item
     - Descricao
     - Valor de venda
     - Unidade (peça, unidade, metro, cm3, etc...)
 * Realizar a venda de itens para os clientes. A venda consiste em uma data, cliente, itens vendidos e método de pagamento. Além disso serão calculados, para cada venda em específico, o valor do frente e os descontos (caso haja), além dos impostos ICMS e municipal. Se for uma venda para um cliente prime, este poderá utilizar seu saldo de cashback para abater na compra.
 * Calcular o valor das vendas do ultimo mês para cada cliente e verificar se ele é elegível para ser considerado como um cliente especial.
 * Calcular o saldo de cashback para clientes-prime.
 * Cada um desses itens deve ser desenvolvido através de TDD de modo que deve haver pelo menos um caso de teste para cada. No caso de haver mais de um caso de teste para cada item, os casos de testes que o implementam deverão estar agrupados em uma suíte de testes.

 # Trabalho 2 e 3 TTPE

## Alunos

| Nome  | Matrícula  | 
| :--:  | :-------:  | 
| Breno | 20/2015984 | 
| Daniel | 19/0104821 | 
| Wengel | 19/0118555 |

| [<img src="https://avatars.githubusercontent.com/u/81342329?v=4" width=50><br><sub>Breno Henrique</sub>](https://github.com/bhsouza) | [<img src="https://avatars.githubusercontent.com/u/71887425?v=4" width=50><br><sub>Daniel</sub>](https://github.com/DanRocha18 ) | [<img src="https://avatars.githubusercontent.com/u/88208512?v=4" width=50><br><sub>Wengel</sub>](https://github.com/Wengel-Rodrigues)|
| :---: | :---: | :---: |

## Metodologia
#### Refatoração

A segunda parte do trabalho consiste na aplicação de operações de Refatoração no código entregue pelos grupos na primeira parte. Todos os grupos aplicarão as mesmas operações de Refatoração em seus trabalhos. As operações serão aplicadas nas classes / métodos indicados pelo professor para cada grupo. Ao final das operações de Refatoração, os grupos deverão apresentar como comentários no código uma descrição detalhada dos efeitos da operação de refatoração no código.

#### Código Refatorado

| Operação de Refatoração  | Classe / Método  | 
| :-------:  | :-------:  |
| Extrair Método | NotaFiscal::gerarNotaFiscal() | 
| Extrair classe | Venda |
| Substituir método por objeto-método | Venda::calcularFrete() |

## Relatório do TP3

A ultima parte do trabalho consiste em um relatório modelo PDF seguindo o que foi proposto no enunciado.

### Enunciado

#### Descrição

Desenvolvedores, em suas funções, realizam atividades de projeto de código, como classes, objetos e estruturas de dados. Essas pequenas contribuições vão sendo incorporadas ao projeto do software na medida em que são desenvolvidas. Em escala ascendente, os níveis de projeto de software são:

* funções: nível mais elementar das atividades de projeto, mas não menos importante. Se as rotinas são projetadas sem cuidado todo o sistema será impactado. Uma vez definido quais são as funções necessárias, trabalha-se na implementação interna, definindo algoritmos e o fluxo de execução.

* classes e tipos de dados: após a definição das funções, as atividades de codificação que resultam em alterações no projeto concentram-se nas definições de interfaces para utilização dessas funções. Nesse nível busca-se projetar interfaces que sejam representem o conjunto das funções encapsuladas. Isso se dá, no contexto de orientação a objetos, por meio da definição de classes e interfaces.

* módulos e componentes: o passo seguinte é organizar as classes desenvolvidas em conjunto de classes, compreensíveis, que guardem alguma relação de similaridade ou proximidade entre si. Costuma-se chamar esses agrupamentos de módulos ou componentes, contudo, é necessário atentar-se ao que se entende por módulos. Por exemplo, pode ser considerado como um conjunto de classes em linguagens orientadas por objetos ou como bibliotecas em linguagens procedurais. Nesse ponto do projeto o que se busca é a definição de interfaces publicadas, as quais deverão ser estáveis pois desempenham o papel de contratos entre os módulos e entre as equipes que trabalham nelas.

* arquitetura do sistema: nesse ponto observa-se o sistema e seus subsistemas como um todo. O projeto arquitetural desempenha forte influência no desempenho e nas características do sistema como um todo.

O projeto de software é a base sobre a qual todo o software será construído, uma vez que essa base é bem projetada e estruturada aumentam-se as chances do software construído ter qualidade. São características de um bom projeto de software:

* fácil de escrever;
* fácil de entender;
* fácil de manter;
* menos provável de ter bugs e, por fim,
* mais resiliente à mudanças.

Tudo isso exposto, conclui-se que ter um projeto de software correto, principalmente desde o início, é muito importante. É possível pensar em características de bom projeto em nível micro, durante a codificação, de modo que as boas práticas se acumularão e terão impactos no projeto do software como um todo. Vários desses princípios guardam estreita relação com as operações de refatoração de modo que é possível realizar melhorias em projetos de código existentes aplicando uma ou uma sequência de operações. Em linhas gerais, os princípios de um bom projeto de código são:

* simplicidade;
* elegância;
* modularidade;
* boas interfaces;
* extensibilidade;
* evitar duplicação;
* portabilidade;
* código deve ser idiomático e bem documentado.

#### Questões

Com base na descrição acima, cada grupo de trabalho deverá responder as seguintes perguntas:

- 1 Para cada um dos princípios de bom projeto de código mencionados acima, apresente sua definição e relacione-o com os maus-cheiros de código apresentados por Fowler em sua obra.

- 2 Identifique quais são os maus-cheiros que persistem no trabalho prático 2 do grupo, indicando quais os princípios de bom projeto ainda estão sendo violados e indique quais as operações de refatoração são aplicáveis. Atenção: não é necessário aplicar as operações de refatoração, apenas indicar os princípios violados e operações possíveis de serem aplicadas.

#### Link do PDF

Aqui está o [Relatório TP3 do Grupo 2](files/TP3-Grupo2.pdf)




