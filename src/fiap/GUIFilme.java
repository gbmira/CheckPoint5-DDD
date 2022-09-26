/*
 * Vinicius de Oliveira - 93613
 * Gabriel Mira - 95694
 */

package fiap;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class GUIFilme extends JPanel{
	private JList<String> liFotos;
	private ImageIcon imagem1;
	private JScrollPane sp;
	private JLabel lbImagem, lbCodigo, lbTitulo, lbProdutora, lbGenero;
	private JTextField tfCodigo, tfTitulo;
	private ButtonGroup buttonGroup;
	private JRadioButton rbWarner, rbFox, rbDisney, rbUniversal;
	private JList<String> liFilmes;
	private JButton btSalvar, btCancelar;
	
	public GUIFilme() {
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes() {
		setLayout(null);
		
		tfCodigo = new JTextField();
		tfTitulo = new JTextField();
		lbCodigo = new JLabel("Codigo:");
		lbTitulo = new JLabel("Titulo:");
		lbProdutora = new JLabel("Produtora:");
		rbWarner = new JRadioButton("Warner");
		rbFox = new JRadioButton("Fox");
		rbDisney = new JRadioButton("Disney");
		rbUniversal = new JRadioButton("Universal");
		buttonGroup = new ButtonGroup();
		lbGenero = new JLabel("Genero:");
		btSalvar = new JButton("Salvar");
		btCancelar = new JButton("Cancelar");
		
		buttonGroup.add(rbWarner);
		buttonGroup.add(rbFox);
		buttonGroup.add(rbDisney);
		buttonGroup.add(rbUniversal);
		
		lbCodigo.setBounds(10, 15, 50, 25);
		tfCodigo.setBounds(60, 15, 50, 25);
		lbTitulo.setBounds(10, 60, 50, 25);
		tfTitulo.setBounds(60, 60, 230, 25);
		lbProdutora.setBounds(10, 120, 75, 25);
		rbWarner.setBounds(15, 140, 120, 25);
		rbFox.setBounds(15, 165, 120, 25);
		rbDisney.setBounds(15, 190, 120, 25);
		rbUniversal.setBounds(15, 215, 120, 25);
		lbGenero.setBounds(375, 20, 50, 25);
		btSalvar.setBounds(100, 300, 100, 25);
		btCancelar.setBounds(350, 300, 100, 25);
		
		String[] filmes = {"Fantasia", "Infantil", "Medieval", "Nordico", "Terror"};		
		liFilmes = new JList<String>(filmes);
		sp = new JScrollPane(liFilmes);
		sp.setBounds(375, 60, 120, 120);
		
		imagem1 = new ImageIcon();
		lbImagem = new JLabel(imagem1);
		lbImagem.setBounds(450, 60, 300, 300);
		
		
		add(lbCodigo);
		add(tfCodigo);
		add(lbTitulo);
		add(tfTitulo);
		add(lbProdutora);
		add(rbWarner);
		add(rbFox);
		add(rbDisney);
		add(rbUniversal);
		add(lbGenero);
		add(sp);
		add(lbImagem);
		add(btSalvar);
		add(btCancelar);
	}
	
	private void definirEventos() {
		liFilmes.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                imagem1 = new ImageIcon(
                        getClass().getResource("Imagens/"
                                + liFilmes.getSelectedValue() + ".png"));
                lbImagem.setIcon(imagem1);
            }
        });
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String produtora = "";
				if (rbWarner.isSelected()) {
					produtora = "Warner";
				} else if (rbFox.isSelected()) {
					produtora = "Fox";
				} else if (rbDisney.isSelected()) {
					produtora = "Disney";
				}else if (rbUniversal.isSelected()) {
					produtora = "Universal";
				}
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Filme Selecionado:\nTitulo: " + tfTitulo.getText() + 
												"\nCódigo: " + tfCodigo.getText() + 
												"\nProdutora: " + produtora, "Filme", JOptionPane.INFORMATION_MESSAGE, imagem1);
			}
		});
	}
}
