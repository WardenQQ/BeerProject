package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;


public class FenetrePrincipale extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel menu = new JPanel();
	private JLabel affichage = new JLabel();
	String[] nomBoutons = {"Ajout","Suppression","Quitter"};
	JButton[] tabBoutons = new JButton[nomBoutons.length];
	private Dimension dim = new Dimension(100,40);
	
	
	public FenetrePrincipale()
	{
		// Initialisation de la Fenetre
		this.setTitle("Gestion de base de données de Bières");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		initMenuPrincipal();
		
		this.setContentPane(menu);
		this.setVisible(true);
	}
	
	private void initMenuPrincipal()
	{
		JPanel menuLateral = new JPanel();
		menuLateral.setPreferredSize(new Dimension(120,450));
		JLabel affichageBiere = new JLabel();
		affichageBiere.setPreferredSize(new Dimension(600,450));
		JLabel barreRecherche = new JLabel();
		barreRecherche.setPreferredSize(new Dimension(720,100));
		JTable affichageTable = new JTable();
		affichageTable.setPreferredSize(new Dimension(550,400));
		
		
		for(int i = 0; i < nomBoutons.length ; i++)
		{
			tabBoutons[i] = new JButton(nomBoutons[i]);
			tabBoutons[i].setPreferredSize(dim);
			switch(i)
			{
				case 2 :
					tabBoutons[i].addActionListener(new BoutonQuitter());
					menuLateral.add(tabBoutons[i]);
					break;
				default :
					break;
			}
		}
		
		menuLateral.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		affichageBiere.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		menu.add(barreRecherche, BorderLayout.NORTH);
		menu.add(affichageBiere, BorderLayout.WEST);
		menu.add(menuLateral, BorderLayout.EAST);
	}
	
	
	
	class BoutonQuitter implements ActionListener
	{
		public void actionPerformed(ActionEvent act)
		{
			dispose();
		}
	}
}
