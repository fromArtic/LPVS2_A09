package exemplo_swing.view;

/**
 *
 * @author Jv Loreti
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Menu extends JToolBar implements ActionListener{
    JButton btnSalvar;
    JButton btnCarregar;
    TextoListener tl;
    
    public Menu(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        btnSalvar = new JButton();
        btnSalvar.setIcon(criarIcone("/exemplo_swing/imagens/Diskette_16x16.png"));
        btnSalvar.setToolTipText("Salvar");
        
        btnCarregar = new JButton();
        btnCarregar.setIcon(criarIcone("/exemplo_swing/imagens/Refresh_16x16.png"));
        btnCarregar.setToolTipText("Carregar");
        
        btnSalvar.addActionListener(this);
        btnCarregar.addActionListener(this);
        
        add(btnSalvar);
        add(btnCarregar);
    }
    
    //Definição de ícones
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
