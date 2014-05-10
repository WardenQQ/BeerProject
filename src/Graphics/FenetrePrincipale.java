package Graphics;

import gestionBiere.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import bdd.BaseDonnee;

public class FenetrePrincipale extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel menu = new JPanel();
	private JTable affichage = new JTable();
	private JPanel menuLateral = new JPanel();
	private JPanel barreRecherche = new JPanel();
	private JTextField champRecherche = new JTextField("Tapez ici votre recherche");
	private String[] nomBoutons = {"Ajout","Suppression","Quitter"};
	private String[] choixMenu = {"Breuvage","Bouteille","Brasserie","Lieu origine","Commentaire"};
	private String[] entete = {"Id", "Nom", "Nom Brasserie", "Couleur"
			,"Fermentation","Provenance","Lieu d'origine","Pays d'origine"}; 
	private JButton[] tabBoutons = new JButton[nomBoutons.length];
	private Dimension dimBouton = new Dimension(130,40);
	private Dimension dimTab = new Dimension(900,500);
	private Dimension dimPanMenuLateral = new Dimension(140,500);
	private Dimension dimPanRecherche = new Dimension(900,40);
	private Dimension dimRecherche = new Dimension(250,30);
	private String nomFichier = "breuvage.bdd";
	private BaseDonnee bdd = new BaseDonnee(nomFichier);
	private JComboBox choixListe = initComboBox(choixMenu);
	private String selectionActuelle = "Breuvage";
	private JLabel label = new JLabel("Recherche : ");
	private JButton okButton = new JButton ("OK");
	
	public FenetrePrincipale()
	{
		// Initialisation de la Fenetre
		this.setTitle("Gestion de base de données de Bières");
		this.setSize(1080,720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		initMenuPrincipal();
		
		this.setContentPane(menu);
		this.setVisible(true);
	}
	
	private void initMenuPrincipal()
	{
		ArrayList<Breuvage> breuvage = bdd.getListeBreuvage();
		
		menuLateral.setPreferredSize(dimPanMenuLateral);
		
		barreRecherche.setPreferredSize(dimPanRecherche);
		
		choixListe.setPreferredSize(dimBouton);
		choixListe.addActionListener(new changementSelectionMenu());
		
		affichage = new JTable(breuvageTab(breuvage), entete);
		affichage.setPreferredSize(dimTab);
		
		champRecherche.setPreferredSize(dimRecherche);
		
		label.setPreferredSize(dimBouton);
		
		okButton.addActionListener(new BoutonRecherche());
		
		for(int i = 0; i < nomBoutons.length ; i++)
		{
			tabBoutons[i] = new JButton(nomBoutons[i]);
			tabBoutons[i].setPreferredSize(dimBouton);
			switch(i)
			{
				case 0 :
					tabBoutons[i].addActionListener(new BoutonAjout());
					menuLateral.add(tabBoutons[i]);
					break;
				case 1 :
					tabBoutons[i].addActionListener(new BoutonDelete());
					menuLateral.add(tabBoutons[i]);
					break;
				case 2 :
					tabBoutons[i].addActionListener(new BoutonQuitter());
					menuLateral.add(tabBoutons[i]);
					break;
				default :
					break;
			}
		}
		
		JScrollPane sp = new JScrollPane(affichage);
		sp.setPreferredSize(new Dimension(dimTab));
		barreRecherche.add(label,BorderLayout.WEST);
		barreRecherche.add(champRecherche,BorderLayout.WEST);
		barreRecherche.add(okButton,BorderLayout.WEST);
		menuLateral.add(choixListe,BorderLayout.SOUTH);
		menu.add(barreRecherche, BorderLayout.NORTH);
		menu.add(sp,BorderLayout.WEST);
		menu.add(menuLateral, BorderLayout.EAST);
	}
	
	private JComboBox initComboBox(String[] choix)
	{
		JComboBox choixBox = new JComboBox();
		for(int i = 0;i < choix.length;i++)
		{
			choixBox.addItem(choix[i]);
		}
		return choixBox;
	}
	
	private Object[][] breuvageTab(ArrayList<Breuvage> aL)
	{
		Object[][] oL = new Object[aL.size()][8];
		Iterator<Breuvage> ite = aL.iterator();
		Breuvage elem = new Breuvage();
		int i = 0;
		for(i = 0; ite.hasNext() != false ; i++)
		{
			elem = ite.next();
			oL[i][0] = elem.getIdentifiant();
			oL[i][1] = elem.getNom();
			oL[i][2] = elem.getBrasserie().getNom();
			oL[i][3] = elem.getCouleur();
			oL[i][4] = elem.getFermentation();
			oL[i][5] = elem.getProvenance();
			oL[i][6] = elem.getBrasserie().getLieuOrigine().getNom();
			oL[i][7] = elem.getBrasserie().getLieuOrigine().getPaysAppartenance();
		}
		return oL;
	}
	
	class BoutonRecherche implements ActionListener
	{
		public void actionPerformed(ActionEvent act)
		{
			
		}
	}
	
	class BoutonAjout implements ActionListener
	{
		public void actionPerformed(ActionEvent act)
		{
			
		}
	}
	
	class BoutonDelete implements ActionListener
	{
		public void actionPerformed(ActionEvent act)
		{
			
		}
	}
	
	class BoutonQuitter implements ActionListener
	{
		public void actionPerformed(ActionEvent act)
		{
			dispose();
		}
	}
	
	class changementSelectionMenu implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
}
