package atividade.model;

/**
 *
 * @author Jv Loreti
 */

public class Cadastro{
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String sexo;
    private boolean LPVS2;
    private boolean POOS3;
    private boolean DSIS4;
    
    public Cadastro(String nome, String endereco, String cidade, String estado, 
                    String sexo, boolean LPVS2, boolean POOS3, boolean DSIS4){
        
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.sexo = sexo;
        this.LPVS2 = LPVS2;
        this.POOS3 = POOS3;
        this.DSIS4 = DSIS4;
    }
    
    //Getters/Setters
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getCidade(){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getSexo(){
        return sexo;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    public boolean isLPVS2(){
        return LPVS2;
    }
    public void setLPVS2(boolean LPVS2){
        this.LPVS2 = LPVS2;
    }
    public boolean isPOOS3(){
        return POOS3;
    }
    public void setPOOS3(boolean POOS3){
        this.POOS3 = POOS3;
    }
    public boolean isDSIS4(){
        return DSIS4;
    }
    public void setDSIS4(boolean DSIS4){
        this.DSIS4 = DSIS4;
    }
    
    //Impressão
    public String toString(){
        return nome + ";" + endereco + ";" + cidade + ";" + estado + ";" + sexo + ";" + LPVS2 + ";" + POOS3 + ";" + DSIS4 + ";";
    }
}
