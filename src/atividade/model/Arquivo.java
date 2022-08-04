package atividade.model;

/**
 *
 * @author Jv Loreti
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Arquivo{
    private int MAX = 100;
    private Cadastro[] cadastrosArquivo;
    
    public Arquivo(){
        this.cadastrosArquivo = new Cadastro[MAX];
    }
    
    //Adiciona cadastro ao vetor ao enviar formulário
    public boolean adicionarCadastro(Cadastro c){
        for(int i = 0; i < MAX; i++){
            if(cadastrosArquivo[i] == null){
                cadastrosArquivo[i] = c;
                return true;
            }
        }
        return false;
    }
    
    //Método para exportar arquivo
    public boolean salvarArquivo(String nomeArquivo) throws FileNotFoundException{
        File f = new File(nomeArquivo + ".csv"); //Nome do arquivo + extensão
        PrintWriter pw = new PrintWriter(f);
        
        for(int i = 0; i < MAX; i++){
            if(cadastrosArquivo[i] != null){
                System.out.println(cadastrosArquivo[i].toString());
                pw.println(cadastrosArquivo[i].toString());
            }
        }
        
        pw.close();
        return true;
    }
    
    //Método para importar arquivo
    public Cadastro[] carregarArquivo(String nomeArquivo) throws FileNotFoundException{
        File f = new File(nomeArquivo);
        Scanner sc = new Scanner(f);
        
        this.cadastrosArquivo = new Cadastro[MAX];
        
        while(sc.hasNextLine()){
            String linha = sc.nextLine();
            String[] cadastroArquivo = linha.split(";");
            
            Cadastro c = new Cadastro(cadastroArquivo[0], 
                    cadastroArquivo[1], 
                    cadastroArquivo[2], 
                    cadastroArquivo[3],
                    cadastroArquivo[4], 
                    Boolean.parseBoolean(cadastroArquivo[5]),
                    Boolean.parseBoolean(cadastroArquivo[6]),
                    Boolean.parseBoolean(cadastroArquivo[7]));
            
            this.adicionarCadastro(c);
        }
        
        return cadastrosArquivo;
    }
    
    //Getter
    public Cadastro[] getCadastros(){
        return this.cadastrosArquivo;
    }
}
