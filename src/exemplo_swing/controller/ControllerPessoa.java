package exemplo_swing.controller;

/**
 *
 * @author Jv Loreti
 */

import exemplo_swing.model.Arquivo;
import exemplo_swing.model.Pessoa;
import java.io.FileNotFoundException;

public class ControllerPessoa{
    Arquivo a;
    
    public ControllerPessoa(){
        a = new Arquivo();
    }
    
    public boolean adicionarPessoa(String n, String o, String i, String s, boolean estr, String p, String g){
        long id = System.currentTimeMillis();
        Pessoa pessoa = new Pessoa(id, n, o, i, s, estr, p, g);
        a.adicionarPessoa(pessoa);
        
        System.out.println("Pessoa adicionada.");
        return true;
    }
    
    public Pessoa[] recuperarPessoas(){
        return a.getPessoas();
    }
    
    public boolean salvarArquivo(String nomeArquivo) throws FileNotFoundException{
        a.salvarArquivo(nomeArquivo);
        return true;
    }
    
    public Pessoa[] carregarArquivo(String nomeArquivo) throws FileNotFoundException{
        return a.carregarArquivo(nomeArquivo);
    }
}
