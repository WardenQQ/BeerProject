package Graphics;

import modele.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



import modele.BouteilleModele;

import bdd.BaseDonnee;

public class FenetrePrincipale extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel menu = new JPanel();
	private JTable affichage = new JTable();
	private String[] nomBoutons = {"Ajout","Suppression","Sauvegarder","Quitter"};
	private String[] choixMenu = {"Breuvage","Bouteille","Brasserie","Lieu origine","Couleur",
			"Fermentation","Provenance","Type Bouteille","Type Fermentation","Bouchon"}; 
	private Dimension dimBouton = new Dimension(130,40);
	private Dimension dimTab = new Dimension(1050,650);
	private Dimension dimPanMenuLateral = new Dimension(170,600);
	private Dimension dimPanRecherche = new Dimension(1000,40);
	private Dimension dimText = new Dimension(200,40);
	private String nomFichier = "breuvage.bdd";
	private BaseDonnee bdd = new BaseDonnee(nomFichier);
	private String selectionActuelle = "Breuvage";
	private JComboBox choixListe = initComboBox(choixMenu);
	private BreuvageModele breuvage = new BreuvageModele(bdd.getListeBreuvage());
	private BrasserieModele brasserie = new BrasserieModele(bdd.getListeBrasserie());
	private LieuOrigineModele lieuOrigine = new LieuOrigineModele(bdd.getListeLieuOrigine());
	private CouleurModele couleur = new CouleurModele(bdd.getListeCouleur());
	private FermentationModele fermentation = new FermentationModele(bdd.getListeFermentation());
	private TypeBouteilleModele typeB = new TypeBouteilleModele(bdd.getListeTypeFermentation());
	private ProvenanceModele provenance = new ProvenanceModele(bdd.getListeProvenance());
	private TypeFermentationModele typeF = new TypeFermentationModele(bdd.getListeTypeFermentation());
	private BouteilleModele bouteille = new BouteilleModele(bdd.getListeBouteille());
	private BouchonModele bouchon = new BouchonModele(bdd.getListeBouchon());
	
	public FenetrePrincipale()
	{
		// Initialisation de la Fenetre
		this.setTitle("Gestion de base de données de Bières");
		this.setSize(1280,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		initInterfaceGraphique();
		
		this.setContentPane(menu);
		this.setVisible(true);
                
                couleur.ajoutObserver(breuvage);
	}
	
	private void initInterfaceGraphique()
	{
		
		JPanel menuLateral = new JPanel();
		JPanel barreRecherche = new JPanel();
		JLabel label = new JLabel("Cliquez ici pour effectuer une recherche : ");
		JButton okButton = new JButton ("Recherche");
		JButton[] tabBoutons = new JButton[nomBoutons.length];
		
		menuLateral.setPreferredSize(dimPanMenuLateral);
		
		barreRecherche.setPreferredSize(dimPanRecherche);
		
		label.setPreferredSize(dimText);
		
		choixListe.setPreferredSize(dimBouton);
		choixListe.addActionListener(new choixAffichage());
		
		affichage = new JTable(this.breuvage);
		affichage.setAutoCreateRowSorter(true);
		affichage.setPreferredSize(dimTab);
		
		label.setPreferredSize(dimBouton);
		
		okButton.addActionListener(new boutonRech());
		
		menuLateral.add(choixListe,BorderLayout.NORTH);
		for(int i = 0; i < nomBoutons.length ; i++)
		{
			tabBoutons[i] = new JButton(nomBoutons[i]);
			tabBoutons[i].setPreferredSize(dimBouton);
			switch(i)
			{
				case 0 :
					tabBoutons[i].addActionListener(new boutonAjout());
					menuLateral.add(tabBoutons[i]);
					break;
				case 1 :
					tabBoutons[i].addActionListener(new boutonSupr());
					menuLateral.add(tabBoutons[i]);
					break;
				case 2 :
					tabBoutons[i].addActionListener(new boutonSave());
					menuLateral.add(tabBoutons[i]);
					break;
				case 3 :
					tabBoutons[i].addActionListener(new boutonQuitter());
					menuLateral.add(tabBoutons[i]);
					break;
				default :
					break;
			}
		}
		
		JScrollPane sp = new JScrollPane(affichage);
		sp.setPreferredSize(new Dimension(dimTab));
		barreRecherche.add(okButton,BorderLayout.CENTER);
		
		menu.add(barreRecherche, BorderLayout.NORTH);
		menu.add(sp,BorderLayout.SOUTH);
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
	
	@SuppressWarnings("unused")
	private JComboBox initComboBoxBuffer(ArrayList<StringBuffer> aL)
	{
		JComboBox choixBox = new JComboBox();
		Iterator<StringBuffer> ite = aL.iterator();
		StringBuffer elem = null;
		for(;ite.hasNext();)
		{
			elem = ite.next();
			choixBox.addItem(elem);
		}
		choixBox.addItem("Inconnu");
		return choixBox;
	}
	
	class boutonSave implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			bdd.sauvegarder(nomFichier);
		}
	}
	
	class boutonQuitter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			bdd.sauvegarder(nomFichier);
			dispose();
		}
	}
	
	class boutonRech implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			TableRowSorter<BreuvageModele> sorter = new TableRowSorter<BreuvageModele>();
			sorter.setModel(breuvage);
			String regex = JOptionPane.showInputDialog("Recherche dans la base : ");	 
	        sorter.setRowFilter(RowFilter.regexFilter(regex, 0, 1));		
		}
	}
	
	class boutonSupr implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int aSupprimer = affichage.getSelectedRow();
			couleur.suppressionCouleur(aSupprimer);
		}
	}
	
	class boutonAjout implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			selectionActuelle = choixListe.getSelectedItem().toString();
			if (selectionActuelle.compareTo("Brasserie") == 0)
			{
				brasserie.ajoutBrasserie();
			}
			else if (selectionActuelle.compareTo("Breuvage") == 0)
			{
				breuvage.ajoutBreuvage();
			}
			else if (selectionActuelle.compareTo("Lieu origine") == 0)
			{
				lieuOrigine.ajoutLieuOrigine();
			}
			else if (selectionActuelle.compareTo("Fermentation") == 0)
			{
				fermentation.ajoutFermentation();
			}
			else if (selectionActuelle.compareTo("Bouteille") == 0)
			{
				bouteille.ajoutBouteille();
			}
			else if (selectionActuelle.compareTo("Type Bouteille") == 0)
			{
				typeB.ajoutTypeBouteille();
			}
			else if (selectionActuelle.compareTo("Type Fermentation") == 0)
			{
				typeF.ajoutTypeFermentation();
			}
			else if (selectionActuelle.compareTo("Provenance") == 0)
			{
				provenance.ajoutProvenance();
			}
			else if (selectionActuelle.compareTo("Couleur") == 0)
			{
				couleur.ajoutCouleur();
			}
			else if (selectionActuelle.compareTo("Bouchon") == 0)
			{
				bouchon.ajoutBouchon();
			}
		}
	}
	
	class choixAffichage implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			selectionActuelle = choixListe.getSelectedItem().toString();
			if (selectionActuelle.compareTo("Brasserie") == 0)
			{
				affichage.setModel(brasserie);
				affichage.repaint();
			}
			else if (selectionActuelle.compareTo("Breuvage") == 0)
			{
				affichage.setModel(breuvage);
				affichage.repaint();
			}
			else if (selectionActuelle.compareTo("Lieu origine") == 0)
			{
				affichage.setModel(lieuOrigine);
				affichage.repaint();
			}
			else if (selectionActuelle.compareTo("Fermentation") == 0)
			{
				affichage.setModel(fermentation);
				affichage.repaint();
			}
			else if (selectionActuelle.compareTo("Bouteille") == 0)
			{
				affichage.setModel(bouteille);
				affichage.repaint();
			}
			else if (selectionActuelle.compareTo("Type Bouteille") == 0)
			{
				affichage.setModel(typeB);
				affichage.repaint();
			}
			else if (selectionActuelle.compareTo("Type Fermentation") == 0)
			{
				affichage.setModel(typeF);
				affichage.repaint();
			}
			else if (selectionActuelle.compareTo("Provenance") == 0)
			{
				affichage.setModel(provenance);
				affichage.repaint();
			}
			else if (selectionActuelle.compareTo("Couleur") == 0)
			{
				affichage.setModel(couleur);
				affichage.repaint();
			}
			else if (selectionActuelle.compareTo("Bouchon") == 0)
			{
				affichage.setModel(bouchon);
				affichage.repaint();
			}
		}
	}
	
}
