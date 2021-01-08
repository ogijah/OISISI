package gui;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dijalog.BrisanjePredmeta;
import dijalog.IzmenaProfesora;
import dijalog.BrisanjeProfesora;
import dijalog.BrisanjeStudenta;
import dijalog.DodavanjePredmeta;
import dijalog.DodavanjeProfesora;
import dijalog.DodavanjeStudenta;
import dijalog.IzmenaPredmeta;
import dijalog.IzmenaStudenta;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.TabelaPredmeta;
import view.TabelaProfesora;
import view.TabelaStudenata;

public class TrakaSaAlatkama extends JToolBar {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -5707394191276063225L;
	int red;
	int redPredmeta;
	
	private static TrakaSaAlatkama instance = null;

	public static TrakaSaAlatkama getInstance() {
		if (instance == null) {
			instance = new TrakaSaAlatkama();
		}
		return instance;
	}
	
	public Student getStudent(int red) {
		return BazaStudenata.getInstance().getStudenti().get(TabelaStudenata.getInstance().getTabelaStudenata().convertRowIndexToModel(red));
	}
	
	public Profesor getProfesor(int red) {
		return BazaProfesora.getInstance().getProfesori().get(TabelaProfesora.getInstance().getTabelaProfesora().convertRowIndexToModel(red));
	}
	
	public Predmet getPredmet(int red) {
		return BazaPredmeta.getInstance().getPredmeti().get(TabelaPredmeta.getInstance().getTabelaPredmeta().convertRowIndexToModel(red));
	}
	
	public int getRed() {
		return red;
	}
	
	public int getSelectovanRed() {
		
		return red = TabelaStudenata.getInstance().getTabelaStudenata().getSelectedRow();
			
	}
	
	public int getSelectovanRedProfesori() {
		
		return red = TabelaProfesora.getInstance().getTabelaProfesora().getSelectedRow();
			
	}
	
	public int getSelektovanRedPredmeta() {
		
		return redPredmeta = TabelaPredmeta.getInstance().getTabelaPredmeta().getSelectedRow();
		
	}

	public void setRed(int red) {
		this.red = red;
	}


		public TrakaSaAlatkama() {
			// u konstruktor nadklase, tj klase JToolbar prosledjuje
			// se orijentacija toolbar-a, moguca i sa konstantom: SwingConstants.VERTICAL
			
			super(SwingConstants.HORIZONTAL);
			
			JButton btnNew = new JButton();
			btnNew.setToolTipText("New");
			btnNew.setIcon(new ImageIcon("new_22x22.png"));
			btnNew.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(GlavniProzor.getInstance().getIndeks() == 0) {
						DodavanjeStudenta dialog = new DodavanjeStudenta(GlavniProzor.getInstance(), "Dodavanje studenta", true);
						dialog.setVisible(true);
					}
					else if(GlavniProzor.getInstance().getIndeks() == 1) {
						DodavanjeProfesora dialog1 = new DodavanjeProfesora(GlavniProzor.getInstance(), "Dodavanje profesora", true);
						dialog1.setVisible(true);
					}
					else if (GlavniProzor.getInstance().getIndeks() == 2) {
						
						DodavanjePredmeta dialog2 = new DodavanjePredmeta(GlavniProzor.getInstance(), "Dodavanje predmeta", true);
						dialog2.setVisible(true);
						
					}
				}
			});
			
			add(btnNew);

			addSeparator();

			JButton btnEdit = new JButton();
			btnEdit.setToolTipText("Edit");
			btnEdit.setIcon(new ImageIcon("pencil1_22x22.png"));
			btnEdit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					if(GlavniProzor.getInstance().getIndeks() == 0) {
						
						red = TabelaStudenata.getInstance().getTabelaStudenata().getSelectedRow();
						setRed(red);
						if(red != -1) {
							IzmenaStudenta dialog0 = new IzmenaStudenta(GlavniProzor.getInstance(), "Izmena studenta", true);
							dialog0.setVisible(true);
						}
					} else if (GlavniProzor.getInstance().getIndeks() == 1) {
						red = TabelaProfesora.getInstance().getTabelaProfesora().getSelectedRow();
						setRed(red);
						if(red != -1) {
							
							IzmenaProfesora dialog1 = new IzmenaProfesora(GlavniProzor.getInstance(), "Izmena profesora", true);
							dialog1.setVisible(true);
							
						}
					} else if (GlavniProzor.getInstance().getIndeks() == 2) { 
						
						red = TabelaPredmeta.getInstance().getTabelaPredmeta().getSelectedRow();
						setRed(red);
						if(red != -1) {
							
							IzmenaPredmeta dialog2 = new IzmenaPredmeta(GlavniProzor.getInstance(), "Izmena predmeta", true);
							dialog2.setVisible(true);
							
						}
					}
					
				}
				
			});
			add(btnEdit);

			addSeparator();

			JButton btnDelete = new JButton();
			btnDelete.setToolTipText("Delete");
			btnDelete.setIcon(new ImageIcon("delete_22x22.png"));
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if(GlavniProzor.getInstance().getIndeks() == 0) {
						
						red = TabelaStudenata.getInstance().getTabelaStudenata().getSelectedRow();
						setRed(red);
						if(red != -1) {
							
							BrisanjeStudenta dialog0 = new BrisanjeStudenta(GlavniProzor.getInstance(), "Brisanje studenta", true);
							dialog0.setVisible(true);
							
						} 
					}else if (GlavniProzor.getInstance().getIndeks() == 1) {
						
						red = TabelaProfesora.getInstance().getTabelaProfesora().getSelectedRow();
						setRed(red);
						
						if(red != -1) {
							
							BrisanjeProfesora dialog1 = new BrisanjeProfesora(GlavniProzor.getInstance(), "Brisanje profesora", true);
							dialog1.setVisible(true);
							
						}
					}else if (GlavniProzor.getInstance().getIndeks() == 2) {
						red = TabelaPredmeta.getInstance().getTabelaPredmeta().getSelectedRow();
						setRed(red);
					
						if(red != -1) {
						
						BrisanjePredmeta dialog2 = new BrisanjePredmeta(GlavniProzor.getInstance(), "Brisanje predmeta", true);
						dialog2.setVisible(true);
						
						}
					}
					
				}
				
				
				
			});
			add(btnDelete);
			
			addSeparator();
			
			add(Box.createHorizontalStrut(800));
			JTextField textBox = new JTextField();
			add(textBox);
			addSeparator();
			
			JButton btnSearch = new JButton();
			btnSearch.setToolTipText("Search");
			btnSearch.setIcon(new ImageIcon("loop_22x22.png"));
			btnSearch.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(GlavniProzor.getInstance().getIndeks() == 0) {
						TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(TabelaStudenata.getInstance().getTabelaStudenata().getModel());
						TabelaStudenata.getInstance().getTabelaStudenata().setRowSorter(rowSorter);
						if(textBox.getText() == "") {
							rowSorter.setRowFilter(null);
						}
						else {
							StringTokenizer tokens = new StringTokenizer(textBox.getText());
							String prvaRec = "";
							String drugaRec = "";
							String trecaRec = "";
							int n = 0;
							
							while(tokens.hasMoreTokens())
							{
								n++;
							    if(n == 1) {
							    	prvaRec = tokens.nextToken();
							    }
							    else if(n == 2) {
							    	drugaRec = tokens.nextToken();
							    }
							    else if(n == 3) {
							    	trecaRec = tokens.nextToken();
							    }
							   
							}
								
							for(int i = 0; i < BazaStudenata.getInstance().getStudenti().size(); i++) {
								
								if(BazaStudenata.getInstance().getStudenti().get(i).getPrezime().toLowerCase().contains(prvaRec.toLowerCase())) {
									Student student = BazaStudenata.getInstance().getStudenti().get(i);
									rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + prvaRec));
									if(!drugaRec.equals("")) {
										if(student.getIme().toLowerCase().contains(drugaRec.toLowerCase())) {
											rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + drugaRec));
											if(!trecaRec.equals("")) {
												if(student.getBrojIndeksa().toLowerCase().contains(trecaRec.toLowerCase())) {
													rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + trecaRec));
												}
												else {
													rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + trecaRec));
												}
											}
											else {
												rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + drugaRec));
											}
										}
										else {
											rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + drugaRec));
										}
									}
									else {
										rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + prvaRec));
									}									
								}
								else {
									rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + prvaRec));								
								}
							}
							
						}
						
						
					}else if(GlavniProzor.getInstance().getIndeks() == 1) {
						TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(TabelaProfesora.getInstance().getTabelaProfesora().getModel());
						TabelaProfesora.getInstance().getTabelaProfesora().setRowSorter(rowSorter);
						if(textBox.getText() == "") {
							rowSorter.setRowFilter(null);
						}
						else {
							StringTokenizer tokens = new StringTokenizer(textBox.getText());
							String prvaRec = "";
							String drugaRec = "";
							int n = 0;
							
							while(tokens.hasMoreTokens())
							{
								n++;
							    if(n == 1) {
							    	prvaRec = tokens.nextToken();
							    }
							    else if(n == 2) {
							    	drugaRec = tokens.nextToken();
							    }
							   
							   
							}
								
							for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
								
								if(BazaProfesora.getInstance().getProfesori().get(i).getPrezime().toLowerCase().contains(prvaRec.toLowerCase())) {
									Profesor profesor = BazaProfesora.getInstance().getProfesori().get(i);
									rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + prvaRec));
									if(!drugaRec.equals("")) {
										if(profesor.getIme().toLowerCase().contains(drugaRec.toLowerCase())) {
											rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + drugaRec));
											
										}
										else {
											rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + drugaRec));
										}
									}
									else {
										rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + prvaRec));
									}									
								}
								else {
									rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + prvaRec));								
								}
							}
							
						}
					}else if(GlavniProzor.getInstance().getIndeks() == 2) {
						TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(TabelaPredmeta.getInstance().getTabelaPredmeta().getModel());
						TabelaPredmeta.getInstance().getTabelaPredmeta().setRowSorter(rowSorter);
						if(textBox.getText() == "") {
							rowSorter.setRowFilter(null);
						}
						else {			
							for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
								
								if(BazaPredmeta.getInstance().getPredmeti().get(i).getNaziv().toLowerCase().contains(textBox.getText())) {
									
									rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + textBox.getText()));
																	
								}
								else {
									rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + textBox.getText()));								
								}
							}
							
						}
					}
					
				}
			});
			add(btnSearch);
			addSeparator();
			

			// toolbar je pokretljiv, probati i sa staticnim toolbarom
			setFloatable(false);
			

		}

	}

	

