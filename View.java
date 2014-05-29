/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProjetoSenac;

import javax.swing.*;
import java.awt.Event;
import java.awt.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Patricio JP
 */
public class View{
    JFrame janela;
    private JLabel lbnome;
    private JLabel lbendereco;
    private JLabel lbdata;
    private JLabel lbx;
    private JTextField tfnome;
    private JTextField tfendereco;
    private JFormattedTextField tfdata;
    private JButton btsalvar;
    private JButton btcancelar;
    private ImageIcon imgsalvar;
    private ImageIcon imgcancelar;
    private MaskFormatter mask;
    public View(){
        innit();
        defEvent();
    }
    public void innit(){
        janela = new JFrame("Alunos");
        imgsalvar = new ImageIcon("C:\\salvar.png");
        imgcancelar = new ImageIcon("C:\\cancelar.png");
        imgsalvar.setImage(imgsalvar.getImage().getScaledInstance(80, 70, 100));  
        imgcancelar.setImage(imgcancelar.getImage().getScaledInstance(80, 70, 100));  
        lbnome = new JLabel("Nome");
        lbendereco = new JLabel("Endereco");
        lbdata = new JLabel("Data de Nasc.");
        lbx = new JLabel(".");
        lbx.setForeground(Color.white);
        
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
        
        janela.setSize(395, 290);
        janela.setResizable(false);
        janela.setLocation(400, 150);
        janela.setVisible(true);
        
        lbnome.setBounds(20, 0, 50, 100);
        lbendereco.setBounds(20, 30, 100, 100);
        lbdata.setBounds(20, 60, 100, 100);
        lbx.setBounds(20, 100, 50, 100);
        lbx.setBounds(20, 150, 50, 100);
        
        tfnome.setBounds(67, 38, 300, 25);
        tfendereco.setBounds(90, 68, 277, 25);
        tfdata.setBounds(110, 98, 130, 25);
        
        btsalvar.setBounds(110, 150, 80, 70);
        btsalvar.setBorderPainted(false);
        btsalvar.setBackground(janela.getBackground());
        btcancelar.setBounds(210, 150, 80, 70);
        btcancelar.setBorderPainted(false);
        btcancelar.setBackground(janela.getBackground());
        
        janela.add(btsalvar);
        janela.add(btcancelar);
        
        janela.add(tfnome);
        janela.add(tfendereco);
        janela.add(tfdata);
        
        janela.add(lbnome);
        janela.add(lbendereco);
        janela.add(lbdata);
        janela.add(lbx);
                
    }
    public void defEvent(){
        
    }
}
