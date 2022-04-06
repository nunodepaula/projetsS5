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

import fr.ensma.a3.ia.dao.entity.PartieEntity;

public class PartiePoiDAO extends AbstractPoiDAO<PartieEntity>{
	private static Logger LOGGER = Logger.getLogger(JoueurPoiDAO.class.getName());
	@Override
	public Optional<PartieEntity> getById(int id) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Parties");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		PartieEntity partie = null;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			partie = new PartieEntity();
			if (id == (int)ligne.getCell(0).getNumericCellValue()) {
				partie.setIdPartie((int)ligne.getCell(0).getNumericCellValue());
				partie.setTaille((int)ligne.getCell(1).getNumericCellValue());
				partie.setDifficulte((int)ligne.getCell(2).getNumericCellValue());
				trouve = true;
			}
		}
		if (trouve) {
			closeBase(bdd);
			return Optional.of(partie);
		}
		closeBase(bdd);
		return Optional.empty();		
	}
	@Override
	public Optional<PartieEntity> getByValue(PartieEntity elem) {
		List<PartieEntity> listtemp = getAll();
		for (PartieEntity ad : listtemp) {
			if (ad.equals(elem)) {
				return Optional.of(ad);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<PartieEntity> getAll() {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Parties");
		ArrayList<PartieEntity> listeadr = new ArrayList<PartieEntity>();
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		while (iterator.hasNext()) {
			Row ligne = iterator.next();
			PartieEntity partie = new PartieEntity();
			Iterator<Cell> cellIterator = ligne.iterator();
			Cell cellule = cellIterator.next();
			partie.setIdPartie((int)ligne.getCell(0).getNumericCellValue());
			partie.setTaille((int)ligne.getCell(1).getNumericCellValue());
			partie.setDifficulte((int)ligne.getCell(2).getNumericCellValue());
			listeadr.add(partie);
		}
		closeBase(bdd);
		return listeadr;
	}
	@Override
	public void create(PartieEntity elem) {
		if (getByValue(elem).isEmpty()) {
			XSSFWorkbook bdd = openBase();
			Sheet tableadr = bdd.getSheet("Parties");
			int lrow = tableadr.getLastRowNum();
			int lid = (int) tableadr.getRow(lrow).getCell(0).getNumericCellValue();
			elem.setIdPartie(lid + 1);
			Row ligne = tableadr.createRow(lrow + 1);
			Cell cell = ligne.createCell(0);
			cell.setCellValue(elem.getId());
			cell = ligne.createCell(1);
			cell.setCellValue(elem.getTaille());
			cell = ligne.createCell(2);
			cell.setCellValue(elem.getDifficulte());
			cell = ligne.createCell(3);
			writeBase(bdd);
			closeBase(bdd);
		} else {
			//TODO : Prévoir une exception ...
			LOGGER.log(Level.INFO,"Element Deja dans la base ...");
		}
	}

	@Override
	public void update(PartieEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Parties");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getId() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				ligne.getCell(1).setCellValue(elem.getId());
				ligne.getCell(2).setCellValue(elem.getTaille());
				ligne.getCell(3).setCellValue(elem.getDifficulte());
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
	public void delete(PartieEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("Parties");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getId() == (int) ligne.getCell(0).getNumericCellValue()) {
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
