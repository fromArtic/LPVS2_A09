package atividade.view;

/**
 *
 * @author Jv Loreti
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class MenuArquivo extends JToolBar implements ActionListener{
    JButton btnSalvar;
    JButton btnCarregar;
    TextoListener tl;
    
    public MenuArquivo(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Salvar
        btnSalvar = new JButton();
        btnSalvar.setIcon(criarIcone("/atividade/imagens/Diskette_16x16.png")); //Ícone
        btnSalvar.setToolTipText("Salvar"); //Texto dica
        btnSalvar.addActionListener(this);
        add(btnSalvar);
        
        //Carregar
        btnCarregar = new JButton();
        btnCarregar.setIcon(criarIcone("/atividade/imagens/Refresh_16x16.png")); //Ícone
        btnCarregar.setToolTipText("Carregar"); //Texto dica
        btnCarregar.addActionListener(this);
        add(btnCarregar);
        
        //Teclas de atalho
        btnSalvar.setMnemonic(KeyEvent.VK_S); //Alt + S: salvar arquivo
        btnCarregar.setMnemonic(KeyEvent.VK_C); //Alt + C: carregar arquivo
    }
    
    //Retorna a imagem do ícone
    private ImageIcon criarIcone(String caminho){
        URL url = getClass().getResource(caminho);
        ImageIcon img = new ImageIcon(url);
        
        return img;
    }
    
    public void setTextoListener(TextoListener t){
        this.tl = t;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(tl != null){
            JButton btnClicado = (JButton) e.getSource();

            if(btnClicado == btnSalvar){
                tl.enviarTexto("Salvar");
            }else if(btnClicado == btnCarregar){
                tl.enviarTexto("Carregar");
            }
        }
    }
}
