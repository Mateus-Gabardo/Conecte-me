/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.MostraStatusConsole;
import busca.Nodo;
import busca.Status;
import core.ConectMe;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import View.GameBoard;
import View.GameResultPanel;
import model.PieceModel;
import model.SpinModel;
import model.SpinWalkModel;
import model.TowerModel;
import model.WalkModel;


public class GameBoardController {
    private int countLinhas;
    private int countColunas;
    private GameBoard gameBoard;
    private int[][] state;
    private GameResultPanel gameResult;

    public GameBoardController(int countLinhas, int countColunas) {
        this.countLinhas = countLinhas;
        this.countColunas = countColunas;
        this.state = new int[countLinhas][countColunas];
        this.gameBoard = new GameBoard(this);
        this.gameResult = inicialGameResult();
    }
    
    public int[][] getState(){
        return this.state;
    }
    
    public void setNewState(int[][] newState){
        this.state = newState;
    }
    
    public GameBoard getGameBoard(){
        return this.gameBoard;
    }
    
    private GameResultPanel inicialGameResult(){
       GameResultPanel resul = new GameResultPanel("Selecione sua forma de busca");
       return resul;
    }
    
    public GameResultPanel getGameResult(){
        return this.gameResult;
    }
    
    
    /**
     * Avalia se vai retornar algum valor ou não
     * @param linha
     * @param coluna
     * @return 
     */
    public boolean hasElementAt(int linha, int coluna, int[][] state){
        if(state[linha][coluna] == 0){
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Retorna o objeto a partir do valor da matriz
     * @return PieceModel
     */
    public PieceModel getElementAt(int valor){
        String obj = String.valueOf(valor);
        int tipo = Integer.parseInt(obj.substring(0, 1));
        
        switch(tipo){
            case 1:
                return new TowerModel(String.valueOf(valor));
            case 2:
                return new SpinModel(String.valueOf(valor));
            case 3:
                return new WalkModel(String.valueOf(valor));
            case 4:
                return new SpinWalkModel(String.valueOf(valor));
            default:
                return null;
        }
    }
    
    public int getRowCount(){
        return this.countLinhas;
    }
    
    public int getColumnCount(){
        return this.countColunas;
    }
    
    public void carregar(){
        JFileChooser diretorio = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Selecione a fase inicial do jogo",
                "txt"
        );
        int retorno = diretorio.showOpenDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION){
            File file = diretorio.getSelectedFile();
            int[][] state = this.getMatrizByList(this.trataFile(file));
            this.setNewState(state);
            this.getGameBoard().refresh();
        }
    }
    
    public void buscarLargura(){
        ConectMe inicial = new ConectMe(this.state, "Inicio");
        MostraStatusConsole ms = new MostraStatusConsole(new Status());
        Nodo n = new BuscaLargura<ConectMe>(ms).busca(inicial);
        String msg;
        if (n == null) {
            System.out.println("sem solucao!");
            msg = "Método de largura sem solução!";
        } else {
            System.out.println(n.getProfundidade());
            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
            msg = "Método de Largura. Largura: " + n.getProfundidade() + " Duração: " + getTimer(ms.getStatus().getTempoDecorrido()) + ".\nNodos Visitados: " + ms.getStatus().getVisitados();
            if(n.getEstado() instanceof ConectMe ){
                ConectMe newEstado = (ConectMe) n.getEstado();
                this.setNewState(newEstado.getBoard());
                                
            }
        }
        this.getGameBoard().refresh();
        this.atualizaStatus(msg);
    }
    
    public void buscarProfundidade() throws Exception{
        ConectMe inicial = new ConectMe(this.state, "Inicio");
        MostraStatusConsole ms = new MostraStatusConsole(new Status());
        Nodo n = new BuscaProfundidade<ConectMe>(ms).busca(inicial);
        String msg;
        if (n == null) {
            System.out.println("sem solucao!");
            msg = "Método de profundidade sem solução!";
        } else {
            System.out.println(n.getProfundidade());
            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
            msg = "Método de profundidade. Profundidade: " + n.getProfundidade() + " Duração: " + getTimer(ms.getStatus().getTempoDecorrido())  + ".\nNodos Visitados: " + ms.getStatus().getVisitados();
            if(n.getEstado() instanceof ConectMe ){
                ConectMe newEstado = (ConectMe) n.getEstado();
                this.setNewState(newEstado.getBoard());
            }
        }
        this.getGameBoard().refresh();
        this.atualizaStatus(msg);
    }
    
    String getTimer(long tempo){
        Date date = new Date(tempo);
        DateFormat formatter = new SimpleDateFormat("mm:ss:SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }
    
    public void sobre(){
        String sobre;
        sobre = "<html><center>Alunos:<br>Daniel Larion Klug<br>Mateus Gabardo Lemos</center></html>";
        JOptionPane.showMessageDialog(null, sobre, "Sobre", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Realiza o status do painel aós a resolução do game
     * @param status 
     */
    private void atualizaStatus(String status){
        this.getGameResult().setStatus(status);
        this.getGameResult().refresh();
    }
    
    /**
     * Converte um arquivo txt para uma lista de inteiros
     * @param file
     * @return 
     */
    private List<Integer> trataFile(File file){
        List<Integer> list = new ArrayList<>();
        try{
           FileReader reader = new FileReader(file);
              BufferedReader buffer = new BufferedReader(reader);
              String line = buffer.readLine();
              while (line != null) {
                  String[] split = line.split(",");
                  for (String word : split) {
                      if(word.trim().length() > 0 && !"".equals(word.trim()))
                      list.add(Integer.parseInt(word));
                  }
                  line = buffer.readLine();
              }
              reader.close();         
        }catch(IOException e){
             System.err.printf("Erro na abertura do arquivo: %s.\n",
             e.getMessage());
        }

        return list;
    }
    
    int[][] getMatrizByList(List<Integer> lista){
        int countList = 0;
        int[][] matriz = new int[this.getRowCount()][this.getColumnCount()];
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                int valor = lista.get(countList);
                matriz[i][j] = valor;
                countList++;
            }   
        }
        return matriz;
    }
}
