package exemplo_swing.view;

/**
 *
 * @author Jv Loreti
 */

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AreaDeFormulario extends JPanel implements ActionListener{
    //Aula 7
    JLabel lblNome;
    JLabel lblOcupacao;
    JTextField txtNome;
    JTextField txtOcupacao;
    JButton btnOk;
    //Aula 8
    JLabel lblIdade;
    JList lstIdade;
    JLabel lblSituacao;
    JComboBox cmbSituacao;
    JLabel lblEstrangeiro;
    JCheckBox chkEstrangeiro;
    JLabel lblPassaporte;
    JTextField txtPassaporte;
    JLabel lblGenero;
    JRadioButton rbtnMasculino;
    JRadioButton rbtnFeminino;
    ButtonGroup grpGenero;
    
    FormularioListener fl;
    
    public AreaDeFormulario(){
        //Redefine as dimensões do painel
        Dimension d = getPreferredSize(); //Dimensões iniciais recomendadas
        d.width = 250;
        setPreferredSize(d);
        
        //Define as bordas do painel
        Border bordaExterna = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border bordaInterna = BorderFactory.createTitledBorder("Adicionar pessoas");
        setBorder(BorderFactory.createCompoundBorder(bordaExterna, bordaInterna));
        
        //Rotula os componentes no painel
        //Aula 7
        lblNome = new JLabel("Nome: ");
        lblOcupacao = new JLabel("Ocupação: ");
        txtNome = new JTextField(10);
        txtOcupacao = new JTextField(10);
        btnOk = new JButton("OK");
        //Aula 8
        lblIdade = new JLabel("Idade: ");
        lblSituacao = new JLabel("Situação: ");
        lblEstrangeiro = new JLabel("Estrangeiro? ");
        chkEstrangeiro = new JCheckBox();
        lblPassaporte = new JLabel("Passaporte: ");
        txtPassaporte = new JTextField(10);
        lblGenero = new JLabel("Gênero: ");
        rbtnFeminino = new JRadioButton("Feminino");
        rbtnMasculino = new JRadioButton("Masculino");
        
        //Define as opções da lista idade
        lstIdade = new JList();
        DefaultListModel modeloListaIdade = new DefaultListModel();
        modeloListaIdade.addElement("Menor de 18 anos");
        modeloListaIdade.addElement("Entre 18 e 65 anos");
        modeloListaIdade.addElement("Maior de 65 anos");
        //Implementa a lista idade
        lstIdade.setModel(modeloListaIdade);
        lstIdade.setBorder(BorderFactory.createEtchedBorder()); //Define as bordas da lista
        
        //Define as opções do combo situação
        cmbSituacao = new JComboBox();
        DefaultComboBoxModel modeloComboSituacao = new DefaultComboBoxModel();
        cmbSituacao.setModel(modeloComboSituacao);
        modeloComboSituacao.addElement("Empregado");
        modeloComboSituacao.addElement("Autônomo");
        modeloComboSituacao.addElement("Desempregado");
        cmbSituacao.setSelectedIndex(2);
        
        //Disponibiliza os campos de passaporte somente caso marque verdadeiro a check box estrangeiro
        lblPassaporte.setEnabled(false);
        txtPassaporte.setEnabled(false);
        chkEstrangeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                boolean estado = chkEstrangeiro.isSelected();
                lblPassaporte.setEnabled(estado);
                txtPassaporte.setEnabled(estado);
            }
        });
        
        //Agrupa as opções de gênero
        grpGenero = new ButtonGroup();
        grpGenero.add(rbtnFeminino);
        grpGenero.add(rbtnMasculino);
        //Define o retorno para cada opção
        rbtnFeminino.setActionCommand("Feminino");
        rbtnMasculino.setActionCommand("Masculino");
        
        btnOk.addActionListener(this);
        
        //Define o posicionamento dos componentes no painel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //Posicionamentos iniciais
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.CENTER;
        
        //Posicionamento nome
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblNome, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(txtNome, gc);
        
        //Posicionamento idade
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblIdade, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lstIdade, gc);
        
        //Posicionamento gênero
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblGenero, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(rbtnFeminino, gc);
        gc.gridy++;
        add(rbtnMasculino, gc);
        
        //Posicionamento situação
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblSituacao, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(cmbSituacao, gc);
        
        //Posicionamento ocupação
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblOcupacao, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(txtOcupacao, gc);
        
        //Posicionamento estrangeiro
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblEstrangeiro, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(chkEstrangeiro, gc);
        
        //Posicionamento passaporte
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblPassaporte, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(txtPassaporte, gc);
        
        //Posicionamento botão OK
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.PAGE_START;
        gc.gridwidth = 2;
        gc.insets = new Insets(13, 5, 0, 5);
        add(btnOk, gc);
    }
    
    //Implementa a interface FormularioListener
    public void setFormularioListener(FormularioListener f){
        this.fl = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Recupera os valores digitados no formulário
        String n = this.txtNome.getText();
        String o = this.txtOcupacao.getText();
        String i = (String) this.lstIdade.getSelectedValue();
        String s = (String) this.cmbSituacao.getSelectedItem();
        boolean estr = this.chkEstrangeiro.isSelected();
        String p = this.txtPassaporte.getText();
        String g = this.grpGenero.getSelection().getActionCommand();
        
        this.fl.enviarFormulario(n, o, i, s, estr, p, g); //Retorna os valores
        
        //Limpa os campos do formulário após clicar em OK
        this.txtNome.setText("");
        this.txtOcupacao.setText("");
        this.txtPassaporte.setText("");
    }
}
