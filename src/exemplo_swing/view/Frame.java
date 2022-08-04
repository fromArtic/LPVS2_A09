package exemplo_swing.view;

/**
 *
 * @author Jv Loreti
 */

import exemplo_swing.controller.ControllerPessoa;
import exemplo_swing.model.Pessoa;
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
    Menu menu;
    AreaDeFormulario areaDeFormulario;
    JFileChooser escolhaArquivo;
    ControllerPessoa cp;
    
    public Frame(){
        //Define as dimensões
        super.setSize(900, 500);
        
        //Define o layout
        super.setLayout(new BorderLayout());
        
        //Chama o método criarMenu
        super.setJMenuBar(criarMenu());
        //Inicializa o JFileChooser escolhaArquivo
        escolhaArquivo = new JFileChooser();
        
        //Inicializa a área de texto
        areaDeTexto = new AreaDeTexto();
        //Define a posição da área de texto
        super.add(areaDeTexto, BorderLayout.EAST);
        
        //Inicializa o menu (Salvar/Carregar)
        menu = new Menu();
        //Define a posição do menu
        super.add(menu, BorderLayout.PAGE_START);
        
        //Imprime as saídas do menu (Salvar/Carregar) na área de texto
        menu.setTextoListener(new TextoListener(){
            @Override
            public void enviarTexto(String t){
                switch(t){
                    case "Salvar":
                        if(escolhaArquivo.getSelectedFile() == null){ //Salvando o arquivo pela primeira vez
                            int ret = escolhaArquivo.showSaveDialog(Frame.this);
                            if(ret == JFileChooser.APPROVE_OPTION){
                                System.out.println(escolhaArquivo.getSelectedFile());
                                salvarPessoas();
                            }
                        }else{ //Salvando o arquivo pelas vezes subsequentes
                            salvarPessoas();
                        }
                        break;
                    case "Carregar":
                        if(escolhaArquivo.getSelectedFile() == null){
                            int ret = escolhaArquivo.showOpenDialog(Frame.this);
                            if(ret == JFileChooser.APPROVE_OPTION){
                                System.out.println(escolhaArquivo.getSelectedFile());
                                carregarPessoas();
                            }
                        }else{
                            carregarPessoas();
                        }
                        break; 
                }
            }
        });
        
        //Inicializa a área de formulário
        areaDeFormulario = new AreaDeFormulario();
        //Implementa a área de formulário
        super.add(areaDeFormulario);
        
        //Inicializa o ControllerPessoa (serve p/ comunicação com a classe Pessoa)
        cp = new ControllerPessoa();
        
        //Comunicação entre a área de formulário e de texto
        areaDeFormulario.setFormularioListener(new FormularioListener(){
            @Override
            public void enviarFormulario(String n, String o, String i, String s, boolean estr, String p, String g){
                
                cp.adicionarPessoa(n, o, i, s, estr, p, g); //Envia os parâmetros para ControllerPessoa
                
              /*if(!n.isEmpty() && !o.isEmpty()){ //Valida se os campos do formulário não estão vazios    
                  areaDeTexto.escreverTexto(n + " - " + i + " - " +  g + " - " + s + " - " + o + " - " + p + "\n"); //Imprime as informações da área de cadastro
              }*/
            }
        });
        
        //Exibe o JFrame
        super.setVisible(true);
        //Encerra a operação ao fechar o JFrame
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    //Configurações da barra de menu
    private JMenuBar criarMenu(){
        JMenuBar menuBar = new JMenuBar();
        
        JMenu arquivo = new JMenu("Arquivo");
        JMenuItem importarArquivo = new JMenuItem("Importar arquivo ...");
        JMenuItem exportarArquivo = new JMenuItem("Exportar arquivo ...");
        JMenuItem sair = new JMenuItem("Sair");
        arquivo.add(importarArquivo);
        arquivo.add(exportarArquivo);
        arquivo.addSeparator(); //Linha de separação
        arquivo.add(sair);
        
        //Importar arquivo
        importarArquivo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int ret = escolhaArquivo.showOpenDialog(Frame.this);
                
                if(ret == JFileChooser.APPROVE_OPTION){
                    System.out.println(escolhaArquivo.getSelectedFile());
                    carregarPessoas();
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
                    salvarPessoas();
                }
            }
        });
        
        //Encerrar o programa
        sair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int ret = JOptionPane.showConfirmDialog(Frame.this, "Realmente deseja sair?", "Confirmação de saída", JOptionPane.OK_CANCEL_OPTION);
                
                if(ret == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });
        
        JMenu janela = new JMenu("Janela");
        JMenu exibir = new JMenu("Exibir");
        JCheckBoxMenuItem chkFormulario = new JCheckBoxMenuItem("Formulário");
        janela.add(exibir);
        exibir.add(chkFormulario);
        chkFormulario.setSelected(true);
        
        //Exibir ou ocultar a área de formulário
        chkFormulario.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JCheckBoxMenuItem chk = (JCheckBoxMenuItem) e.getSource();
                areaDeFormulario.setVisible(chk.isSelected());
            }
        });
        
        //Determina as teclas de atalho
        arquivo.setMnemonic(KeyEvent.VK_A);
        sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        chkFormulario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        
        menuBar.add(arquivo);
        menuBar.add(janela);
        
        return menuBar;
    }
    
    //Método para salvar arquivo
    private void salvarPessoas(){
        try{
            cp.salvarArquivo(escolhaArquivo.getSelectedFile().getAbsolutePath());
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(Frame.this, "Não foi possível salvar o arquivo.", "Erro ao salvar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Método para abrir arquivo
    private void carregarPessoas(){
        try{
            Pessoa[] p = cp.carregarArquivo(escolhaArquivo.getSelectedFile().getAbsolutePath());
            for(int i = 0; i < p.length; i++){
                if(p[i] != null){
                    areaDeTexto.escreverTexto(p[i].toString());
                    areaDeTexto.escreverTexto("\n");
                }
            }
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(Frame.this, "Não foi possível carregar o arquivo.", "Erro ao carregar arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }
}
