package ProjetoSenac;

import java.awt.Color;
import javax.swing.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author Patricio JP
 */
import java.util.List;
public class View{
    JFrame janela;
    private JLabel lbnome, lbnome2;
    private JLabel lbendereco;
    private JLabel lbdata, lbmatricula, lbmatricula2;
    private JLabel lbx;
    private JTextField tfnome, tfnome2, tfmatricula, tfmatricula2;
    private JTextField tfendereco;
    private JFormattedTextField tfdata;
    private JButton btsalvar, btcancelar, btlistar, btpesquisar, btexcluir;
    private ImageIcon imgsalvar, imgcancelar, imgpesquisar, imglistar, imgexcluir;
    private MaskFormatter mask;
    private JTabbedPane tpabas;
    private JPanel painel1, painel2;
    private Controle controleBD;
    
    public View(){
        innit();
        defEvent();
    }
    public void innit(){
        janela = new JFrame("Alunos");
        painel1 = new JPanel(null);
        painel2 = new JPanel(null);
        
        //PAINEL 1
        imgsalvar = new ImageIcon("C:\\salvar.png");
        imgcancelar = new ImageIcon("C:\\cancelar.png");
        imgpesquisar = new ImageIcon("C:\\lupa.png");
        imglistar = new ImageIcon("C:\\listar.png");
        imgexcluir = new ImageIcon("C:\\excluir.png");
        imgsalvar.setImage(imgsalvar.getImage().getScaledInstance(80, 70, 100));    
        imgcancelar.setImage(imgcancelar.getImage().getScaledInstance(80, 70, 100));  
        imgpesquisar.setImage(imgpesquisar.getImage().getScaledInstance(80, 70, 100));
        imglistar.setImage(imglistar.getImage().getScaledInstance(80, 70, 100));
        imgexcluir.setImage(imgexcluir.getImage().getScaledInstance(80, 70, 100));
        lbnome = new JLabel("Nome");
        lbendereco = new JLabel("Endereco");
        lbdata = new JLabel("Data de Nasc.");
        lbx = new JLabel(".");
        lbx.setForeground(Color.white);
        lbmatricula = new JLabel("Matric.");
        try {
            mask = new MaskFormatter("  ##  /  ##  /  ####");
        } catch (ParseException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btsalvar = new JButton(imgsalvar);
        btcancelar = new JButton(imgcancelar);
        
        tfnome = new JTextField();
        tfendereco = new JTextField();
        tfdata = new JFormattedTextField(mask);
        tfmatricula = new JTextField();
        
        janela.setSize(395, 290);
        janela.setResizable(false);
        janela.setLocation(400, 150);
        janela.setVisible(true);
        
        lbnome.setBounds(20, -25, 50, 100);
        lbendereco.setBounds(20, 10, 100, 100);
        lbdata.setBounds(20, 45, 100, 100);
        lbmatricula.setBounds(227, 45, 100, 100);
        lbx.setBounds(20, 100, 50, 100);
        
        tfnome.setBounds(67, 14, 300, 25);
        tfendereco.setBounds(90, 49, 277, 25);
        tfdata.setBounds(110, 82, 100, 25);
        tfmatricula.setBounds(280, 82, 88, 25);
        
        btsalvar.setBounds(105, 140, 80, 70);
        btsalvar.setBorderPainted(false);
        btsalvar.setBackground(janela.getBackground());
        btcancelar.setBounds(215, 140, 80, 70);
        btcancelar.setBorderPainted(false);
        btcancelar.setBackground(janela.getBackground());
        
        //PAINEL 2
        lbnome2 = new JLabel("Nome");
        lbnome2.setBounds(20, -25, 50, 100);
        lbmatricula2 = new JLabel("Matric.");
        lbmatricula2.setBounds(227, 45, 100, 100);
        
        tfnome2 = new JTextField();
        tfnome2.setBounds(67, 14, 300, 25);
        tfmatricula2 = new JTextField();
        tfmatricula2.setBounds(280, 82, 88, 25);
        
        btpesquisar = new JButton(imgpesquisar);
        btpesquisar.setBounds(50, 140, 80, 70);
        btpesquisar.setBorderPainted(false);
        btpesquisar.setBackground(janela.getBackground());
        
        btlistar = new JButton(imglistar);
        btlistar.setBounds(150, 140, 80, 70);
        btlistar.setBorderPainted(false);
        btlistar.setBackground(janela.getBackground());
        
        btexcluir = new JButton(imgexcluir);
        btexcluir.setBounds(250, 140, 80, 70);
        btexcluir.setBorderPainted(false);
        btexcluir.setBackground(janela.getBackground());
        
        //ADCIONAR ITENS
        painel1.add(btsalvar);
        painel1.add(btcancelar);
        
        painel1.add(tfnome);
        painel1.add(tfendereco);
        painel1.add(tfdata);
        painel1.add(tfmatricula);
        
        painel1.add(lbnome);
        painel1.add(lbendereco);
        painel1.add(lbdata);
        painel1.add(lbmatricula);
        painel1.add(lbx);
        
        painel2.add(tfnome2);
        painel2.add(lbnome2);
        painel2.add(btlistar);
        painel2.add(btpesquisar);
        painel2.add(btexcluir);
        painel2.add(tfmatricula2);
        painel2.add(tfmatricula2);
        painel2.add(lbmatricula2);
        painel2.add(lbmatricula2);
        
        tpabas = new JTabbedPane();
        tpabas.add("Cadastrar", painel1);
        tpabas.add("Pesquisar", painel2);
        
        janela.add(tpabas);
        controleBD = new Controle();
    }
    public void defEvent(){
        btsalvar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    onClickSalvar();
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possivel salvar!");
                }
            }
        });
        btcancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                limpartf();
            }
        });
        btlistar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               onClickListar();
           }
        });
        btpesquisar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onClickPesquizar();
            }
        });
        btexcluir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onClickExcluir();
            }
        });
    }
    
    public void limpartf(){
            tfnome.setText("");
            tfendereco.setText("");
            tfmatricula.setText("");
            tfdata.setText("");
            tfnome2.setText("");
            tfmatricula2.setText("");
        }
    
    private void onClickAlterar() {
    }
 
    private void onClickSalvar() throws ParseException {
        if(controleBD.inserirDados(tfnome.getText().toUpperCase(), tfendereco.getText(), Integer.parseInt(tfmatricula.getText())) == 1){
        limpartf();
        }
    }

    private void onClickExcluir() {
        controleBD.excluirDados(Integer.parseInt(tfmatricula2.getText()));
        limpartf();
    }
    private void onClickListar(){
        controleBD.buscarDados();
    }
    private void onClickPesquizar() {
        if(tfmatricula2.equals("")){
            controleBD.buscarPorNome(tfnome2.getText());
        }else{
            controleBD.buscarPorMatricula(Integer.parseInt(tfmatricula2.getText()));
        }
        limpartf();
    }

}