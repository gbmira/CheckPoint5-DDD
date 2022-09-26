/*
 * Vinicius de Oliveira - 93613
 * Gabriel Mira - 95694
 */

package fiap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame {
	
	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnCadastro;
	private JMenuItem miSair, miFilmes;
	
	public GUIPrincipal() {
		inicializarElementos();
		definirEventos();
	}
	
	public void inicializarElementos() {
		setTitle("Filmes");
		setBounds(0, 0, 800, 600);
		contentPane = getContentPane();
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnCadastro = new JMenu("Cadastro");
		mnCadastro.setMnemonic('C');
		miSair = new JMenuItem("Sair", new ImageIcon(getClass().getResource("sair.png")));
		miFilmes = new JMenuItem("Filmes");
		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnCadastro);
		mnArquivo.add(miSair);
		mnCadastro.add(miFilmes);
	}
	
	public void definirEventos() {
		miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		miFilmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIFilme filme = new GUIFilme();
				contentPane.removeAll();
				contentPane.add(filme);
				contentPane.validate();
			}
		});
	}
	
	public void abrir() {
		GUIPrincipal frame = new GUIPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((tela.width - frame.getSize().width) / 2,
							(tela.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}

}
