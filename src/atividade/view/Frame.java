package atividade.view;

/**
 *
 * @author Jv Loreti
 */

import atividade.controller.ControllerCadastro;
import atividade.model.Cadastro;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class Frame extends JFrame{
    AreaDeTexto areaDeTexto;
    AreaDeFormulario areaDeFormulario;
    MenuArquivo menu;
    ControllerCadastro cd;
    JFileChooser escolhaArquivo;
    
    public Frame(){
        //Define as dimensões
        super.setSize(1200, 500);
        
        //Define o layout
        super.setLayout(new BorderLayout());
        
        //Chama o método criarMenu
        super.setJMenuBar(criarMenu());
        
        //Inicializa a área de texto
        areaDeTexto = new AreaDeTexto();
        //Define a posição da área de texto
        super.add(areaDeTexto, BorderLayout.EAST);
        
        //Inicializa a área de formulário
        areaDeFormulario = new AreaDeFormulario();
        //Implementa a área de formulário
        super.add(areaDeFormulario);
        
        //Inicializa o menu arquivo
        menu = new MenuArquivo();
        //Define a posição do menu arquivo
        super.add(menu, BorderLayout.PAGE_START);
        
        //Inicializa ControllerCadastro (serve p/ comunicação com a classe Cadastro)
        cd = new ControllerCadastro();
        //Inicializa escolhaArquivo (serve p/ se utilizar o arquivo importado)
        escolhaArquivo = new JFileChooser();
        
        //Exportar (Frame -> ControllerCadastro -> Arquivo) e imprimir cadastro na área de texto ao salvar
        areaDeFormulario.setFormularioListener(new FormularioListener(){
            @Override
            public void enviarFormulario(String nome, String endereco, String cidade, String estado, String sexo, boolean LPVS2, boolean POOS3, boolean DSIS4){
                if(!nome.isEmpty() && !endereco.isEmpty() && !cidade.isEmpty() && !estado.isEmpty() && !sexo.isEmpty()){ //Valida se os campos do formulário não estão vazios
                    cd.adicionarCadastro(nome, endereco, cidade, estado, sexo, LPVS2, POOS3, DSIS4); //Envia os parâmetros para ControllerCadastro
                    /*areaDeTexto.escreverTexto("Nome: " + nome + "\n" +
                                           "Endereço: " + endereco + "\n" +
                                           "Cidade: " +  cidade +
                                           ", " + estado + "\n" +
                                           "Sexo: " + sexo);
                                            if(LPVS2 == true){
                                                areaDeTexto.escreverTexto("\nMatriculado(a) em LPVS2.");
                                            }
                                            if(POOS3 == true){
                                                areaDeTexto.escreverTexto("\nMatriculado(a) em POOS3.");
                                            }
                                            if(DSIS4 == true){
                                                areaDeTexto.escreverTexto("\nMatriculado(a) em DSIS4.");
                                            }
                                            areaDeTexto.escreverTexto("\n\n");*/
                }
            }
        });
        
        //Interação do menu arquivo com a área de texto
        menu.setTextoListener(new TextoListener(){
            @Override
            public void enviarTexto(String t){
                switch(t){
                    case "Salvar":
                        if(escolhaArquivo.getSelectedFile() == null){ //Salvando o arquivo pela primeira vez
                            int ret = escolhaArquivo.showSaveDialog(Frame.this);
                            if(ret == JFileChooser.APPROVE_OPTION){
                                System.out.println(escolhaArquivo.getSelectedFile());
                                salvarCadastros();
                            }
                        }else{ //Salvando pelas vezes subsequentes
                            salvarCadastros();
                        }
                        break;
                    case "Carregar":
                        if(escolhaArquivo.getSelectedFile() == null){ //Abrindo o arquivo pela primeira vez
                            int ret = escolhaArquivo.showOpenDialog(Frame.this);
                            if(ret == JFileChooser.APPROVE_OPTION){
                                System.out.println(escolhaArquivo.getSelectedFile());
                                carregarCadastros();
                            }
                        }else{ //Abrindo pelas vezes subsequentes
                            carregarCadastros();
                        }
                        break; 
                }
            }
        });
        
        //Exibe o JFrame
        super.setVisible(true);
        //Encerra a operação ao fechar o JFrame
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    //Configurações da barra de menu
    private JMenuBar criarMenu(){
        //Inicializa a barra de menu
        JMenuBar barraDeMenu = new JMenuBar();
        
        //Registro das opções do menu Arquivo
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem importarArquivo = new JMenuItem("Importar arquivo ...");
        JMenuItem exportarArquivo = new JMenuItem("Exportar arquivo ...");
        JMenuItem sair = new JMenuItem("Sair");
        
        //Implementação do menu Arquivo
        barraDeMenu.add(menuArquivo);
        menuArquivo.add(importarArquivo);
        menuArquivo.add(exportarArquivo);
        menuArquivo.addSeparator(); //Linha de separação
        menuArquivo.add(sair);
        
        //Registro das opções do menu Área de texto
        JMenu menuAreaDeTexto = new JMenu("Área de texto");
        JMenu exibir = new JMenu("Exibir");
        
        //Implementação do menu Área de texto
        barraDeMenu.add(menuAreaDeTexto);
        menuAreaDeTexto.add(exibir);
        
        //Importar arquivo
        importarArquivo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int ret = escolhaArquivo.showOpenDialog(Frame.this);
                
                if(ret == JFileChooser.APPROVE_OPTION){
                    System.out.println(escolhaArquivo.getSelectedFile());
                    carregarCadastros();
                }
            }
        });
        
        //Exportar arquivo
        exportarArquivo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int ret = escolhaArquivo.showSaveDialog(Frame.this);
                
                if(ret == JFileChooser.APPROVE_OPTION){
                    System.out.println(escolhaArquivo.getSelectedFile());
                    salvarCadastros();
                }
            }
        });
        
        //Confirmação de encerramento do programa
        sair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int ret = JOptionPane.showConfirmDialog(Frame.this, "Encerrar operação?", "Confirmação de encerramento", JOptionPane.YES_NO_OPTION);
                
                if(ret == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        
        //Exibir ou ocultar a área de texto
        JCheckBoxMenuItem chkAreaDeTexto = new JCheckBoxMenuItem();
        exibir.add(chkAreaDeTexto);
        chkAreaDeTexto.setSelected(true);
        chkAreaDeTexto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JCheckBoxMenuItem chk = (JCheckBoxMenuItem) e.getSource();
                areaDeTexto.setVisible(chk.isSelected());
            }
        });
        
        //Teclas de atalho
        menuArquivo.setMnemonic(KeyEvent.VK_A); //Alt + A: abrir o menu Arquivo
        importarArquivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK)); //Ctrl + I: importar arquivo
        exportarArquivo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK)); //Ctrl + E: exportar arquivo
        sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK)); //Ctrl + X: encerrar o programa
        chkAreaDeTexto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); //Ctrl + O: exibir ou ocultar a área de texto
        
        return barraDeMenu;
    }
    
    //Abrir arquivo
    private void carregarCadastros(){
        try{
            Cadastro[] c = cd.carregarArquivo(escolhaArquivo.getSelectedFile().getAbsolutePath());
            for(int i = 0; i < c.length; i++){
                if(c[i] != null){
                    areaDeTexto.escreverTexto(c[i].toString());
                    areaDeTexto.escreverTexto("\n");
                }
            }
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(Frame.this, "Não foi possível carregar o arquivo.", "Erro ao carregar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Salvar arquivo
    private void salvarCadastros(){
        try{
            cd.salvarArquivo(escolhaArquivo.getSelectedFile().getAbsolutePath());
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(Frame.this, "Não foi possível salvar o arquivo.", "Erro ao salvar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }
}
