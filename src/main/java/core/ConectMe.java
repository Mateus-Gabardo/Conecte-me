
package core;

import busca.Estado;
import java.util.ArrayList;
import java.util.List;


public class ConectMe implements Estado{
    private final int[][] board;
    private final String operacao;
    
    public ConectMe(int[][] board, String operacao){
        this.board = board;
        this.operacao = operacao;
    }
    /**
     * Retorna o boarda do estado
     * @return 
     */
    
    public int[][] getBoard(){
        return this.board;
    }
    

    @Override
    public String getDescricao() {
        return 
            """
           Este problema consiste em ligar os pinos de quatro componente \n
           dispostos em um tabuleiro 4X4. Os componentes são variados podendo ser
           1 - fixo no tabuleiro, 2 - Fixo mas gira sobre o próprio eixo, 3 - Anda para
           horizontal e vertical e 4 - Se movimenta vertical e horizontalmente bem como também gira sobre
           o proprio eixo.
           """;
    }

    @Override
    public boolean ehMeta() {
        for(int i = 0; i <= 3; i++){
           for (int j = 0; j <= 3; j++){
              if(!this.verificaConexaoComponente(i, j)){
                  return false;
              } 
            }
        }
        return true;
    }
    
    /**
     * os indices representam a quantidade de pinos em cada direção 
     * assim temos que 1 - left; 2 - top; 3 - right; 4 - bottom
     * Verificamos na função o left - right e o top com o bottom. Se
     * algum dos elementos não concidirem retornamos falso, caso contrário indica que
     * todos os pinos left e top estão conectados. Não precisamos verifar todos porque caso tenha
     * algum pino embaixo, outro elemento deverá necessariamente ter pinos para cima sobrando o que resultará
     * no resultado final false;
     * @param linha
     * @param coluna
     * @return 
     */
    private boolean verificaConexaoComponente(int linha, int coluna){
        String atual = String.valueOf(board[linha][coluna]);
        int linComp;
        int colComp;
        int indiceAdjacente;
        int v = 1;
        if(board[linha][coluna] > 0){
            while(v < 5){
                // verifica se existem pinos para verificar
                if(Character.getNumericValue(atual.charAt(v)) > 0){
                    linComp = linha;
                    colComp = coluna;
                    if(v % 2 != 0){
                        colComp =  v > 2 ? colComp + 1 : colComp - 1;
                        indiceAdjacente = colComp;
                    } else {
                        linComp = v > 3 ? linComp + 1 : linComp - 1;
                        indiceAdjacente = linComp;
                    }
                     // Comparamos com o elemento adjacente
                    if(indiceAdjacente >= 0 && indiceAdjacente < 4 && board[linComp][colComp] > 0) {
                        String ant = String.valueOf(board[linComp][colComp]);
                        if(atual.charAt(v) != ant.charAt(v > 2 ? v - 2 : v + 2)){
                           return false;
                        }
                    } else {
                        // Não tem nenhum elemento adjacente
                        return false;
                    }
                    
                }
                v++;
            }
            return true;            
        }
        return true;
    }

    @Override
    public int custo() {
        return 1;
    }
    
     /**
     * verifica se um estado e igual a outro
     * (usado para poda)
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof ConectMe) {
            ConectMe e = (ConectMe)o;
            return e.toString().hashCode() == toString().hashCode();
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public List<ConectMe> sucessores() {
        List<ConectMe> succ = new ArrayList<>();
        for(int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
               this.geraSucessor(succ, i, j);
            }
        }
        return succ;
    }
    
    /**
     * Gera uma lista de sucessores dependendo do tipo do componente selecionado em escolha
     * @param succ
     * @param linha
     * @param coluna 
     */
    private void geraSucessor(List<ConectMe> succ, int linha, int coluna){
        String componente = String.valueOf(board[linha][coluna]);
        int tipo = Character.getNumericValue(componente.charAt(0));
        switch(tipo){
            //Tower
            case 1:
                break;
            //Pin
            case 2:
                succPin(succ, componente, linha, coluna);
                break;
            //Walk
            case 3:
                succWalk(succ, linha, coluna);
                break;
            //PinWalk
            case 4:
                succPinWalk(succ, componente, linha, coluna);
                break;
        }
    }
    
    /**
     * Adiciona os sucessores para o componente 2 Pin - apenas possui o movimento de girar para um lado ou outro
     * @param succ
     * @param componente
     * @param linha
     * @param coluna 
     */
    private void succPin(List<ConectMe> succ, String componente, int linha, int coluna){
        // giramos para a esquerda
        String esquerda = giraEsquerda(componente);
        // adicionamos novos sucessores
        this.addSuccEstatico(succ, Integer.parseInt(esquerda), linha, coluna, "Girou para a esquerda");
        // giramos para a Direita
        String direita = giraDireita(componente);
        this.addSuccEstatico(succ, Integer.parseInt(direita), linha, coluna, "Girou para a direita");
    }
    
    /**
     * Adiciona os sucessores para o componente 3 - Walk daquele que se movimenta para os lados
     * @param succ
     * @param componente
     * @param linha
     * @param coluna 
     */
    private void succWalk(List<ConectMe> succ, int linha, int coluna){
        // mover para a esquerda
        if(coluna > 0 && board[linha][coluna - 1] == 0){
          this.addSuccDinamico(succ, linha, coluna, linha, coluna - 1, "Moveu para a esquerda");
        }
        
        // mover para cima
        if(linha > 0 && board[linha - 1][ coluna] == 0){
          this.addSuccDinamico(succ, linha, coluna, linha - 1, coluna, "Moveu para cima");
        }
        
        // mover para a direita
        if(coluna < 3 && board[linha][coluna + 1] == 0){
          this.addSuccDinamico(succ, linha, coluna, linha, coluna + 1, "Moveu para a direita"); 
        }
        
        // mover para baixo
        if(linha < 3 && board[linha + 1][coluna] == 0){
          this.addSuccDinamico(succ, linha, coluna, linha + 1, coluna, "Moveu para baixo"); 
        }
    }
    
    /**
     * Adiciona os sucessores para o componente 4- PinWalk daquele  que se move e gira em 
     * torno do próprio eixo.
     * @param succ
     * @param componente
     * @param linha
     * @param coluna 
     */
    private void succPinWalk(List<ConectMe> succ, String componente, int linha, int coluna){
        // gera os sucessores quanto ao movimento de giro
        succPin(succ, componente, linha, coluna);
        // gera os sucessores quanto ao movimento horizontal e vertical
        succWalk(succ, linha, coluna);
    }
    
    /**
     * Gira um componente para a esquerda
     * Destinado para os objetos do tipo 2 e 4
     * @param atual
     * @return 
     */
    private String giraEsquerda(String atual){
        int indice = 1;
        char[] pecas = atual.toCharArray();
        char[] newPecas = new char[5];
        newPecas[0] = pecas[0];
        while (indice <= 4){
            if(indice != 4){
                newPecas[indice + 1] = pecas[indice];         
            } else {
                newPecas[1] = pecas[4];
            }
            indice++;
        }
        return String.valueOf(newPecas);
    }
    
    /**
     * Gira o componente para a direita
     * Destinado para os componentes 2 e 4
     * @param atual
     * @return 
     */
    private String giraDireita(String atual){
        int indice = 1;
        char[] pecas = atual.toCharArray();
        char[] newPecas = new char[5];
        newPecas[0] = pecas[0];
        while (indice <= 4){
            if(indice != 4){
                newPecas[indice] = pecas[indice + 1];           
            } else {
                newPecas[4] = pecas[1];
            }
            indice++;
        }
        return String.valueOf(newPecas);
    }
    
    /**
     * Adiciona um novo estado na lista de sucessores
     * @param succ
     * @param newComponente
     * @param linha
     * @param coluna
     * @param op 
     */
    private void addSuccEstatico(List<ConectMe> succ, 
                            int newComponente, 
                            int linha, 
                            int  coluna, 
                            String op){
        
        int[][] newBoard = deepCopy();
        newBoard[linha][coluna] = newComponente;
        ConectMe newEstado = new ConectMe(newBoard, op);
        succ.add(newEstado);
    }
    
    /**
     * Adiciona uma copia do estado na lista de sucessores 
     * para os componentes que se movem
     * @param succ
     * @param newComponente
     * @param linha
     * @param coluna
     * @param newLinha
     * @param newColuna
     * @param op 
     */
    private void addSuccDinamico(List<ConectMe> succ,
                                    int linha, 
                                    int coluna,
                                    int newLinha,
                                    int newColuna,
                                    String op){
        int[][] copy = deepCopy();
        copy[linha][coluna] = 0;
        copy[newLinha][newColuna] = board[linha][coluna];
        succ.add(new ConectMe(copy, op));
    }
    
    @Override
    public String toString (){
        String s = "\n " + operacao + "\n";
        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j <= 3; j++){
                s = s + " " + board[i][j];
            }
            s = s + "\n";
        }
        return s;
    }
    
    /**
     * Retorna uma cópia do estado atual a fi de preservar os estados anteriores e 
     * manter uma integridade entre os sucesores
     * @return 
     */
    private int[][] deepCopy(){
        int[][] clone = new int[4][4];
        for(int l = 0; l <= 3; l++){
            for(int c = 0; c <= 3; c++){
                clone[l][c] = board[l][c];
            }
        }
        return clone;
    }
    
}
