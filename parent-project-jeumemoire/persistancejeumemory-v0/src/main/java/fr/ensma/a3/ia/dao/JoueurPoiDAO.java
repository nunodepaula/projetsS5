package fr.ensma.a3.ia.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import fr.ensma.a3.ia.dao.entity.JoueurEntity;

public class JoueurPoiDAO extends AbstractPoiDAO<JoueurEntity>{
	private static Logger LOGGER = Logger.getLogger(JoueurPoiDAO.class.getName());
	
	@Override
	public Optional<JoueurEntity> getById(int id) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Joueurs");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		JoueurEntity joueur = null;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			joueur = new JoueurEntity();
			if (id == (int)ligne.getCell(0).getNumericCellValue()) {
				joueur.setIdJ((int)ligne.getCell(0).getNumericCellValue());
				joueur.setEmail((ligne.getCell(1).getStringCellValue()));
				joueur.setNom(ligne.getCell(2).getStringCellValue());
				joueur.setPrenom(ligne.getCell(3).getStringCellValue());
				joueur.setPseudo(ligne.getCell(4).getStringCellValue());
				trouve = true;
			}
		}
		if (trouve) {
			closeBase(bdd);
			return Optional.of(joueur);
		}
		closeBase(bdd);
		return Optional.empty();		
	}
	
	@Override
	public Optional<JoueurEntity> getByValue(JoueurEntity elem) {
		List<JoueurEntity> listtemp = getAll();
		String email = elem.getEmail();
		for (JoueurEntity ad : listtemp) {
			if(ad.getEmail().compareTo(email)==0) {
				return Optional.of(ad);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<JoueurEntity> getAll() {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Joueurs");
		ArrayList<JoueurEntity> listej = new ArrayList<JoueurEntity>();
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		while (iterator.hasNext()) {
			Row ligne = iterator.next();
			JoueurEntity joueur = new JoueurEntity();
			Iterator<Cell> cellIterator = ligne.iterator();
			Cell cellule = cellIterator.next();
			joueur.setIdJ((int)cellule.getNumericCellValue());
			joueur.setEmail((ligne.getCell(1).getStringCellValue()));
			joueur.setNom(ligne.getCell(2).getStringCellValue());
			joueur.setPrenom(ligne.getCell(3).getStringCellValue());
			joueur.setPseudo(ligne.getCell(4).getStringCellValue());
			listej.add(joueur);
		}
		closeBase(bdd);
		return listej;
	}

	@Override
	public void create(JoueurEntity elem) {
		if (getByValue(elem).isEmpty()) {
			// Initialisation de la base de données
			XSSFWorkbook bdd = openBase();
			Sheet tableadr = bdd.getSheet("Joueurs");
			// Obtention du dernier id
			int lrow = tableadr.getLastRowNum();
			int lid = (int) tableadr.getRow(lrow).getCell(0).getNumericCellValue();
			elem.setIdJ(lid + 1);
			// Ajout du nouveau joueur à la base
			Row ligne = tableadr.createRow(lrow + 1);
			Cell cell = ligne.createCell(0);
			cell.setCellValue(elem.getIdJ());
			cell = ligne.createCell(1);
			cell.setCellValue(elem.getEmail());
			cell = ligne.createCell(2);
			cell.setCellValue(elem.getNom());
			cell = ligne.createCell(3);
			cell.setCellValue(elem.getPrenom());
			cell = ligne.createCell(4);
			cell.setCellValue(elem.getPseudo());
			writeBase(bdd);
			closeBase(bdd);
		} else {
			//TODO : Prévoir une exception ...
			LOGGER.log(Level.INFO,"Element Deja dans la base ...");
		}
	}

	@Override
	public void update(JoueurEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Joueurs");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getIdJ() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				ligne.getCell(1).setCellValue(elem.getEmail());
				ligne.getCell(2).setCellValue(elem.getNom());
				ligne.getCell(3).setCellValue(elem.getPrenom());
				ligne.getCell(4).setCellValue(elem.getPseudo());
				writeBase(bdd);
			}
		}
		if (!trouve) {
			//TODO : Prévoir une exception ...
			LOGGER.log(Level.INFO,"Element absent de la base ...");
			
		}
		closeBase(bdd);
	}

	@Override
	public void delete(JoueurEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Joueurs");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getIdJ() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				removeRow(tableadr, ligne.getRowNum());
				writeBase(bdd);
			}
		}
		if (!trouve) {
			//TODO : Prévoir une exception ...
			LOGGER.log(Level.INFO,"Element absent de la base ...");
		}
		closeBase(bdd);
	}	
}


