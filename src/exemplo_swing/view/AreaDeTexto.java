package exemplo_swing.view;

/**
 *
 * @author Jv Loreti
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AreaDeTexto extends JPanel{
    JTextArea areaDeTexto;
    
    public AreaDeTexto(){
        setLayout(new BorderLayout());
        
        //Inicializa a área de texto
        areaDeTexto = new JTextArea();
        //Implementa a área de texto
        super.add(new JScrollPane(areaDeTexto));
        //Define as dimensões da área de texto
        areaDeTexto.setPreferredSize(new Dimension(600, 100));
    }
    
    //Substitui append (escreve texto quando chamado)
    public void escreverTexto(String txt){
        areaDeTexto.append(txt);
    }
}
