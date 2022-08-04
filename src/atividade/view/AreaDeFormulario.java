package atividade.view;

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
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AreaDeFormulario extends JPanel implements ActionListener{
    //Nome
    JLabel lblNome;
    JTextField txtNome;
    //Endereço
    JLabel lblEndereco;
    JTextField txtEndereco;
    //Cidade
    JLabel lblCidade;
    JTextField txtCidade;
    //Estado
    JLabel lblEstado;
    JComboBox cmbEstado;
    //Sexo
    JLabel lblSexo;
    JRadioButton rbtnMasculino;
    JRadioButton rbtnFeminino;
    ButtonGroup grpSexo;
    //Opções
    JLabel lblOpcoes;
    JCheckBox chkLPVS2;
    JCheckBox chkPOOS3;
    JCheckBox chkDSIS4;
    JLabel lblLPVS2;
    JLabel lblPOOS3;
    JLabel lblDSIS4;
    //Botões
    JButton btnSalvar;
    JButton btnLimpar;
    
    FormularioListener fl;
    
    public AreaDeFormulario(){
        //Redefine as dimensões do painel
        Dimension d = getPreferredSize(); //Dimensões iniciais recomendadas
        d.width = 250;
        setPreferredSize(d);
        
        //Define as bordas do painel
        Border bordaExterna = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border bordaInterna = BorderFactory.createTitledBorder("");
        setBorder(BorderFactory.createCompoundBorder(bordaExterna, bordaInterna));
        
        //Nome
        lblNome = new JLabel("Nome: ");
        txtNome = new JTextField(30);
        
        //Endereço
        lblEndereco = new JLabel("Endereço: ");
        txtEndereco = new JTextField(25);
        
        //Cidade
        lblCidade = new JLabel("Cidade: ");
        txtCidade = new JTextField(20);
        
        //Estado
        lblEstado = new JLabel("Estado: ");
        cmbEstado = new JComboBox();
        DefaultComboBoxModel modeloCmbEstado = new DefaultComboBoxModel();
        cmbEstado.setModel(modeloCmbEstado);
        modeloCmbEstado.addElement("AL");
        modeloCmbEstado.addElement("CE");
        modeloCmbEstado.addElement("MG");
        modeloCmbEstado.addElement("RJ");
        modeloCmbEstado.addElement("SP");
        modeloCmbEstado.addElement("DF");
        cmbEstado.setSelectedIndex(4);
        
        //Sexo
        lblSexo = new JLabel("Sexo: ");
        rbtnMasculino = new JRadioButton("Masculino");
        rbtnFeminino = new JRadioButton("Feminino");
        grpSexo = new ButtonGroup();
        grpSexo.add(rbtnMasculino);
        grpSexo.add(rbtnFeminino);
        rbtnMasculino.setActionCommand("masculino");
        rbtnFeminino.setActionCommand("feminino");
        
        //Opções
        lblOpcoes = new JLabel("Opções: ");
        chkLPVS2 = new JCheckBox();
        chkPOOS3 = new JCheckBox();
        chkDSIS4 = new JCheckBox();
        lblLPVS2 = new JLabel("LPVS2");
        lblPOOS3 = new JLabel("POOS3");
        lblDSIS4 = new JLabel("DSIS4");
        
        //Botões
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(this);
        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(this);
        
        //Define teclas de atalho para os botões
        btnSalvar.setMnemonic(KeyEvent.VK_S);
        btnLimpar.setMnemonic(KeyEvent.VK_L);
        
        //Define o posicionamento dos componentes no painel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //Posicionamentos iniciais
        gc.insets = new Insets (5, 0, 0, 0);
        gc.weightx = 1;
        gc.weighty = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        
        //Posicionamento nome
        add(lblNome, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(txtNome, gc);
        
        //Posicionamento endereço
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblEndereco, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(txtEndereco, gc);
        
        //Posicionamento cidade
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblCidade, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(txtCidade, gc);
        
        //Posicionamento estado
        gc.gridx = 2;
        gc.anchor = GridBagConstraints.CENTER;
        add(lblEstado, gc);
        gc.gridx = 3;
        add(cmbEstado, gc);
        
        //Posicionamento sexo
        gc.insets = new Insets (20, 0, 0, 0);
        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.CENTER;
        add(lblSexo, gc);
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(rbtnMasculino, gc);
        gc.insets = new Insets (0, 0, 0, 0);
        gc.gridy++;
        add(rbtnFeminino, gc);
        
        //Posicionamento opções
        gc.insets = new Insets (20, 0, 0, 0);
        gc.gridx = 2;
        gc.gridy--;
        gc.anchor = GridBagConstraints.LINE_END;
        add(lblOpcoes, gc);
        gc.gridx = 3;
        gc.anchor = GridBagConstraints.CENTER;
        add(chkLPVS2, gc);
        gc.gridx = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lblLPVS2, gc);
        gc.insets = new Insets (0, 0, 0, 0);
        gc.gridx = 3;
        gc.gridy++;
        gc.anchor = GridBagConstraints.CENTER;
        add(chkPOOS3, gc);
        gc.gridx = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lblPOOS3, gc);
        gc.gridx = 3;
        gc.gridy++;
        gc.anchor = GridBagConstraints.CENTER;
        add(chkDSIS4, gc);
        gc.gridx = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(lblDSIS4, gc);
        
        //Posicionamento botões
        gc.insets = new Insets (50, 0, 0, 0);
        gc.gridx = 1;
        gc.gridy++;
        add(btnSalvar, gc);
        gc.gridx = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(btnLimpar, gc);
    }
    
    //Implementa a interface FormularioListener
    public void setFormularioListener(FormularioListener f){
        this.fl = f;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(fl != null){
            JButton botaoClicado = (JButton)e.getSource(); //Pega o endereço do botão clicado
            
            if(botaoClicado != btnLimpar){
                //Recupera os valores digitados no formulário
                String nome = this.txtNome.getText();
                String endereco = this.txtEndereco.getText();
                String cidade = this.txtCidade.getText();
                String estado = (String) this.cmbEstado.getSelectedItem();
                String sexo = this.grpSexo.getSelection().getActionCommand();
                boolean LPVS2 = this.chkLPVS2.isSelected();
                boolean POOS3 = this.chkPOOS3.isSelected();
                boolean DSIS4 = this.chkDSIS4.isSelected();

                this.fl.enviarFormulario(nome, endereco, cidade, estado, sexo, LPVS2, POOS3, DSIS4); //Retorna os valores
            }

            //Limpa os campos do formulário após clicar em OK
            this.txtNome.setText("");
            this.txtEndereco.setText("");
            this.txtCidade.setText("");
        }
    }
}
