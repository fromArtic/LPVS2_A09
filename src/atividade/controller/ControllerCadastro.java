package atividade.controller;

/**
 *
 * @author Jv Loreti
 */

import atividade.model.Arquivo;
import atividade.model.Cadastro;
import java.io.FileNotFoundException;

public class ControllerCadastro{
    Arquivo a;
    
    public ControllerCadastro(){
        a = new Arquivo();
    }
    
    //Adiciona cadastro ao vetor ao enviar formulário (comunicação com classe arquivo)
    public boolean adicionarCadastro(String nome, String endereco, String cidade, String estado, 
                                    String sexo, boolean LPVS2, boolean POOS3, boolean DSIS4){
        
        Cadastro cadastro = new Cadastro(nome, endereco, cidade, estado, sexo, LPVS2, POOS3, DSIS4);
        a.adicionarCadastro(cadastro);
        
        System.out.println("Cadastro efetuado.");
        return true;
    }
    
    //Método para exportar arquivo (comunicação com classe arquivo)
    public boolean salvarArquivo(String nomeArquivo) throws FileNotFoundException{
        a.salvarArquivo(nomeArquivo);
        return true;
    }
    
    //Método para importar arquivo (comunicação com classe arquivo)
    public Cadastro[] carregarArquivo(String nomeArquivo) throws FileNotFoundException{
        return a.carregarArquivo(nomeArquivo);
    }
    
    //Recupera cadastros através do Getter da classe Arquivo
    public Cadastro[] recuperarCadastros(){
        return a.getCadastros();
    }
}
