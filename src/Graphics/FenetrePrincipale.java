package Graphics;

import gestionBiere.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import modele.BouteilleModele;

import bdd.BaseDonnee;

public class FenetrePrincipale extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel interfaceGraphique = new JPanel();
	private JPanel menu = new JPanel();
	private JPanel menuAjout = new JPanel();
	private JTable affichage = new JTable();
	private String[] nomBoutons = {"Ajout","Suppression","Sauvegarder","Quitter"};
	private String[] choixMenu = {"Breuvage","Bouteille","Brasserie","Lieu origine","Commentaire"}; 
	private Dimension dimFormulaire = new Dimension(400,500);
	private Dimension dimBouton = new Dimension(130,40);
	private Dimension dimTab = new Dimension(900,600);
	private Dimension dimPanMenuLateral = new Dimension(140,600);
	private Dimension dimPanRecherche = new Dimension(900,40);
	private Dimension dimRecherche = new Dimension(250,30);
	private String nomFichier = "breuvage.bdd";
	private BaseDonnee bdd = new BaseDonnee(nomFichier);
	private String selectionActuelle = "Breuvage";
	private CardLayout layout = new CardLayout();
	private String[] listePanel = {"Principal", "Ajout", "Modification"};
	private JComboBox choixListe = initComboBox(choixMenu);
	private breuvageModele breuvage = new breuvageModele();
	private brasserieModele brasserie = new brasserieModele();
	private LieuOrigineModele lieuOrigine = new LieuOrigineModele();
	private BouteilleModele bouteille = new BouteilleModele(bdd.getListeBouteille());
	private enum Choix {
	    Breuvage;
	}
	
	public FenetrePrincipale()
	{
		// Initialisation de la Fenetre
		this.setTitle("Gestion de base de données de Bières");
		this.setSize(1080,720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		initInterface();
		
		this.setContentPane(interfaceGraphique);
		this.setVisible(true);
	}
	
	private void initInterface()
	{
		initPagePrincipale();
		initPageAjout();
		interfaceGraphique.setLayout(layout);
		interfaceGraphique.add(menu, listePanel[0]);
		interfaceGraphique.add(menuAjout, listePanel[1]);
	}
	
	private void initPagePrincipale()
	{
		
		JPanel menuLateral = new JPanel();
		JPanel barreRecherche = new JPanel();
		JLabel label = new JLabel("Recherche : ");
		JButton okButton = new JButton ("OK");
		JButton[] tabBoutons = new JButton[nomBoutons.length];
		JTextField champRecherche = new JTextField("Tapez ici votre recherche");
		
		menuLateral.setPreferredSize(dimPanMenuLateral);
		
		barreRecherche.setPreferredSize(dimPanRecherche);
		
		choixListe.setPreferredSize(dimBouton);
		choixListe.addActionListener(new choixAffichage());
		
		affichage = new JTable(this.breuvage);
		affichage.setAutoCreateRowSorter(true);
		affichage.setPreferredSize(dimTab);
		
		champRecherche.setPreferredSize(dimRecherche);
		
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
					tabBoutons[i].addActionListener(new boutonQuitter());
					menuLateral.add(tabBoutons[i]);
					break;
				case 3 :
					tabBoutons[i].addActionListener(new boutonQuitter());
					menuLateral.add(tabBoutons[i]);
				default :
					break;
			}
		}
		
		JScrollPane sp = new JScrollPane(affichage);
		sp.setPreferredSize(new Dimension(dimTab));
		barreRecherche.add(label,BorderLayout.WEST);
		barreRecherche.add(champRecherche,BorderLayout.WEST);
		barreRecherche.add(okButton,BorderLayout.WEST);
		
		menu.add(barreRecherche, BorderLayout.NORTH);
		menu.add(sp,BorderLayout.SOUTH);
		menu.add(menuLateral, BorderLayout.EAST);
	}
	
	private void initPageAjout()
	{
		JPanel formulaire = new JPanel();
		JPanel panBouton = new JPanel();
		GridLayout gl = new GridLayout(10,1);
		formulaire.setPreferredSize(dimFormulaire);
		formulaire.setLayout(gl);
		panBouton.setPreferredSize(dimPanRecherche);
		Choix choix = Choix.valueOf(selectionActuelle); // surround with try/catch
		switch(choix)
		{
		case Breuvage :
			JLabel labelNom = new JLabel("Nom :");
			JTextField champNom = new JTextField("Nom");
			JLabel labelTaux = new JLabel("Taux D'alcool : ");
			JTextField champTaux = new JTextField("TauxAlcool");
			JLabel labelAnnee = new JLabel("Annee Origine : ");
			JTextField champAnnee = new JTextField("Annee Origine");
			JComboBox choixFermentation = initComboBoxBuffer(bdd.getListeFermentation());
			JComboBox choixTypeFermentation = initComboBoxBuffer(bdd.getListeTypeFermentation());
			JComboBox choixProvenance = initComboBoxBuffer(bdd.getListeProvenance());
			JComboBox choixCouleur = initComboBoxBuffer(bdd.getListeCouleur());
			formulaire.add(labelNom);
			formulaire.add(champNom);
			formulaire.add(labelTaux);
			formulaire.add(champTaux);
			formulaire.add(labelAnnee);
			formulaire.add(champAnnee);
			formulaire.add(choixFermentation);
			formulaire.add(choixTypeFermentation);
			formulaire.add(choixProvenance);
			formulaire.add(choixCouleur);
			
			JButton ajoutButton = new JButton("Ajouter");
			JButton cancelButton = new JButton("Annuler");
			cancelButton.addActionListener(new boutonAjoutCancel());
			ajoutButton.addActionListener(new boutonAjoutOk());
			panBouton.add(ajoutButton);
			panBouton.add(cancelButton);
			break;
		default :
			break;
		}
		menuAjout.add(formulaire, BorderLayout.NORTH);
		menuAjout.add(panBouton, BorderLayout.SOUTH);
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
	
	class boutonCancel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			layout.show(interfaceGraphique, listePanel[0]);
		}
	}
	
	class boutonQuitter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}
	}
	
	class boutonRech implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
		}
	}
	
	class boutonSupr implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class boutonAjoutCancel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			layout.show(interfaceGraphique, listePanel[0]);
		}
	}
	
	class boutonAjoutOk implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class boutonAjout implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			layout.show(interfaceGraphique, listePanel[1]);
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
			else if (selectionActuelle.compareTo("Commentaire") == 0)
			{
				
			}
			else if (selectionActuelle.compareTo("Bouteille") == 0)
			{
				affichage.setModel(bouteille);
				affichage.repaint();
			}
		}
	}
	
	class breuvageModele extends AbstractTableModel
	{
		/**
		 * 
		 */
		private String[] enteteBreuvage = {"Id", "Nom", "Nom Brasserie", "Couleur"
				,"Fermentation","Provenance","Lieu d'origine","Pays d'origine"};
		private static final long serialVersionUID = 1L;
		private final List<Breuvage> breuvage = new ArrayList<Breuvage>();
		
		public breuvageModele()
		{
			super();
			breuvage.addAll(bdd.getListeBreuvage());
		}
		
		public int getRowCount() 
		{
	        return breuvage.size();
	    }
		
		public int getColumnCount()
		{
	        return enteteBreuvage.length;
	    }
		
		public String getColumnName(int columnIndex) 
		{
	        return enteteBreuvage[columnIndex];
	    }
		
		public Object getValueAt(int rowIndex, int columnIndex) 
		{
	        switch(columnIndex){
	            case 0:
	                return breuvage.get(rowIndex).getIdentifiant();
	            case 1:
	                return breuvage.get(rowIndex).getNom();
	            case 2:
	                return breuvage.get(rowIndex).getBrasserie().getNom();
	            case 3:
	                return breuvage.get(rowIndex).getCouleur();
	            case 4:
	                return breuvage.get(rowIndex).getFermentation();
	            case 5:
	                return breuvage.get(rowIndex).getProvenance();
	            case 6:
	                return breuvage.get(rowIndex).getLieuOrigine().getNom();
	            case 7:
	                return breuvage.get(rowIndex).getLieuOrigine().getPaysAppartenance();
	            default:
	                return null; 
	        }
	    }
		public void addBreuvage(Breuvage newB) 
		{
	        breuvage.add(newB);
	 
	        fireTableRowsInserted(breuvage.size() -1, breuvage.size() -1);
	    }
		public void removeAmi(int rowIndex) {
	        breuvage.remove(rowIndex);
	 
	        fireTableRowsDeleted(rowIndex, rowIndex);
	    }
	}
	
	class brasserieModele extends AbstractTableModel
	{
		/**
		 * 
		 */
		private String[] enteteBrasserie = {"Id","Nom","Nom Brasserie"};
		private static final long serialVersionUID = 1L;
		private final List<Brasserie> brasserie = new ArrayList<Brasserie>();
		
		public brasserieModele()
		{
			super();
			brasserie.addAll(bdd.getListeBrasserie());
		}
		
		public int getRowCount() 
		{
	        return brasserie.size();
	    }
		
		public int getColumnCount() 
		{
	        return enteteBrasserie.length;
	    }
		
		public String getColumnName(int columnIndex) 
		{
	        return enteteBrasserie[columnIndex];
	    }
		
		public Object getValueAt(int rowIndex, int columnIndex) 
		{
	        switch(columnIndex){
	            case 0:
	                return brasserie.get(rowIndex).getIdentifiant();
	            case 1:
	                return brasserie.get(rowIndex).getNom();
	            case 2:
	                return brasserie.get(rowIndex).getLieuOrigine().getNom();
	            case 3:
	                return brasserie.get(rowIndex).getLieuOrigine().getPaysAppartenance();
	            default:
	                return null; 
	        }
	    }
		public void addBrasserie(Brasserie newB) 
		{
	        brasserie.add(newB);
	 
	        fireTableRowsInserted(brasserie.size() -1, brasserie.size() -1);
	    }
		public void removeBrasserie(int rowIndex) {
	        brasserie.remove(rowIndex);
	 
	        fireTableRowsDeleted(rowIndex, rowIndex);
	    }
	}
	
	class LieuOrigineModele extends AbstractTableModel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final List<LieuOrigine> lieuOrigine = new ArrayList<LieuOrigine>();
		private String[] enteteLieuOrigine = {"Nom","Pays appartenance"};
		
		public LieuOrigineModele()
		{
			super();
			lieuOrigine.addAll(bdd.getListeLieuOrigine());
		}
		
		public int getRowCount() 
		{
	        return lieuOrigine.size();
	    }
		
		public int getColumnCount() 
		{
	        return enteteLieuOrigine.length;
	    }
		
		public String getColumnName(int columnIndex) 
		{
	        return enteteLieuOrigine[columnIndex];
	    }
		
		public Object getValueAt(int rowIndex, int columnIndex) 
		{
	        switch(columnIndex){
	            case 0:
	                return lieuOrigine.get(rowIndex).getNom();
	            case 1:
	                return lieuOrigine.get(rowIndex).getPaysAppartenance();
	            default:
	                return null; 
	        }
	    }
		public void addLieuOrigine(LieuOrigine newB) 
		{
	        lieuOrigine.add(newB);
	 
	        fireTableRowsInserted(lieuOrigine.size() -1, lieuOrigine.size() -1);
	    }
		public void removeLieuOrigine(int rowIndex) 
		{
			lieuOrigine.remove(rowIndex);
	 
	        fireTableRowsDeleted(rowIndex, rowIndex);
	    }
	}
}
