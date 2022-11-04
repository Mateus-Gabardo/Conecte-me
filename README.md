# Conecte-me
Desenvolvimento de algoritmo de busca em árvore (largura e profunidade) do jogo Conecte-me disponível na PlayStore.

De maneira simplificada, a base do jogo consiste em conectar todos os blocos, movendo-os ou girando-os. Esses blocos são divididos por tipos sendo eles:

•	**Vermelhos** que não podem ser girados ou movidos;
<br><img src="https://raw.githubusercontent.com/Mateus-Gabardo/Conecte-me/master/src/main/resources/images/Tower.png" width="100">

•	 **Verdes** que podem ser se mover, mas não podem ser girados; 
<br><img src="https://raw.githubusercontent.com/Mateus-Gabardo/Conecte-me/master/src/main/resources/images/Walk.png" width="100">

•	**Azuis** que podem apenas ser girados, mas estão fixos; 
<br><img src="https://raw.githubusercontent.com/Mateus-Gabardo/Conecte-me/master/src/main/resources/images/Spin.png" width="100">

•	**Laranja** que podem girar e se mover. 
<br><img src="https://raw.githubusercontent.com/Mateus-Gabardo/Conecte-me/master/src/main/resources/images/SpinWalk.png" width="100">

O usuário escolhe uma fase a partir de um arquivo de texto e seleciona o botão de busca trazendo assim o resultado da fase selecionado.

*Carregando a fase*
<img src="https://raw.githubusercontent.com/Mateus-Gabardo/Conecte-me/master/docs/jogoInicial.png">

Existem dois tipos de busca: Busca por largura – cujo algoritmo percorre um grafo andando pelos arcos de um vértice a outro. Cada arco é percorrido no máximo uma vez; Busca por profundidade – cujo algoritmo realiza uma busca não informada através da expansão do primeiro nó filho da árvore de busca, e se aprofunda cada vez mais até que o alvo da busca seja encontrado.

*Fase resolvida*
<img src="https://raw.githubusercontent.com/Mateus-Gabardo/Conecte-me/master/docs/jogoResolvido.png">

