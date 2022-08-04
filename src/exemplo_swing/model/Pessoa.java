package exemplo_swing.model;

/**
 *
 * @author Jv Loreti
 */

public class Pessoa{
    private long id;
    private String nome;
    private String ocupacaoEmprego;
    private String idade;
    private String situacaoEmprego;
    private boolean checkEstrangeiro;
    private String passaporte;
    private String genero;
    
    public Pessoa(long id, String n, String o, String i, String s, boolean estr, String p, String g){
        this.id = id;
        this.nome = n;
        this.ocupacaoEmprego = o;
        this.idade = i;
        this.situacaoEmprego = s;
        this.checkEstrangeiro = estr;
        this.passaporte = p;
        this.genero = g;
    }
    
    //Getters/Setters
    public long getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getOcupacaoEmprego(){
        return ocupacaoEmprego;
    }
    public void setOcupacaoEmprego(String ocupacaoEmprego){
        this.ocupacaoEmprego = ocupacaoEmprego;
    }
    public String getIdade(){
        return idade;
    }
    public void setIdade(String idade){
        this.idade = idade;
    }
    public String getSituacaoEmprego(){
        return situacaoEmprego;
    }
    public void setSituacaoEmprego(String situacaoEmprego){
        this.situacaoEmprego = situacaoEmprego;
    }
    public boolean isCheckEstrangeiro(){
        return checkEstrangeiro;
    }
    public void setCheckEstrangeiro(boolean checkEstrangeiro){
        this.checkEstrangeiro = checkEstrangeiro;
    }
    public String getPassaporte(){
        return passaporte;
    }
    public void setPassaporte(String passaporte){
        this.passaporte = passaporte;
    }
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    //Impressão
    public String toString(){
        return id + ";" + nome + ";" + ocupacaoEmprego + ";" + idade + ";" + situacaoEmprego + ";" + checkEstrangeiro + ";" 
                + passaporte + ";" + genero + ";";
    }
}
