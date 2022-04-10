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

import fr.ensma.a3.ia.dao.entity.JoueurPartieEntity;

public class JoueurPartiePoiDAO extends AbstractPoiDAO<JoueurPartieEntity> {
	private static Logger LOGGER = Logger.getLogger(JoueurPoiDAO.class.getName());

	@Override
	public Optional<JoueurPartieEntity> getById(int id) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("JoueursParties");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		JoueurPartieEntity joueurpartie = null;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			joueurpartie = new JoueurPartieEntity();
			if (id == (int) ligne.getCell(0).getNumericCellValue()) {
				joueurpartie.setIdJP((int) ligne.getCell(0).getNumericCellValue());
				joueurpartie.setIdPartie((int) ligne.getCell(1).getNumericCellValue());
				joueurpartie.setJoueur((int) ligne.getCell(2).getNumericCellValue());
				joueurpartie.setNbPair((int) ligne.getCell(3).getNumericCellValue());
				trouve = true;
			}
		}
		if (trouve) {
			closeBase(bdd);
			return Optional.of(joueurpartie);
		}
		closeBase(bdd);
		return Optional.empty();
	}

	@Override
	public Optional<JoueurPartieEntity> getByValue(JoueurPartieEntity elem) {
		List<JoueurPartieEntity> listtemp = getAll();
		for (JoueurPartieEntity ad : listtemp) {
			if (ad.equals(elem)) {
				return Optional.of(ad);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<JoueurPartieEntity> getAll() {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("JoueursParties");
		ArrayList<JoueurPartieEntity> listeadr = new ArrayList<JoueurPartieEntity>();
		Iterator<Row> iterator = tableadr.iterator();
		Row ligne = iterator.next();

		while (iterator.hasNext()) {
			ligne = iterator.next();
			JoueurPartieEntity joueurpartie = new JoueurPartieEntity();
			Iterator<Cell> cellIterator = ligne.iterator();

			Cell cellule;
			if (cellIterator.hasNext()) {
				cellule = cellIterator.next();
			} else {
				continue;
			}

			if (ligne.getCell(0) != null) {
				joueurpartie.setIdJP((int) ligne.getCell(0).getNumericCellValue());
			}
			if (ligne.getCell(1) != null) {
				joueurpartie.setIdPartie((int) ligne.getCell(1).getNumericCellValue());
			}
			if (ligne.getCell(2) != null) {
				joueurpartie.setJoueur((int) ligne.getCell(2).getNumericCellValue());
			}
			if (ligne.getCell(3) != null) {
				joueurpartie.setNbPair((int) ligne.getCell(3).getNumericCellValue());
			}

			listeadr.add(joueurpartie);
		}

		closeBase(bdd);
		return listeadr;
	}
	
	@Override
	public int lastId() {
		List<JoueurPartieEntity> all = getAll();
		int id = 1;
		
		for (JoueurPartieEntity jp : all) {
			if (id <= jp.getIdJP()) {
				id = jp.getIdJP() + 1;
			}
		}
		
		return id;
	}

	@Override
	public void create(JoueurPartieEntity elem) {
		if (getByValue(elem).isEmpty()) {
			XSSFWorkbook bdd = openBase();
			Sheet tableadr = bdd.getSheet("Parties");
			
			int lrow = tableadr.getLastRowNum();
			int lid = lastId();
			elem.setIdPartie(lid);
			
			Row ligne = tableadr.createRow(lrow + 1);
			Cell cell = ligne.createCell(0);
			cell.setCellValue(elem.getIdPartie());
			cell = ligne.createCell(1);
			cell.setCellValue(elem.getJoueurId());
			cell = ligne.createCell(2);
			cell.setCellValue(elem.getNbpair());
			cell = ligne.createCell(3);
			writeBase(bdd);
			closeBase(bdd);
		} else {
			// TODO : Prévoir une exception ...
			LOGGER.log(Level.INFO, "Element Deja dans la base ...");
		}
	}

	@Override
	public void update(JoueurPartieEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("JoueursParties");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getIdJP() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				ligne.getCell(1).setCellValue(elem.getIdPartie());
				ligne.getCell(2).setCellValue(elem.getJoueurId());
				ligne.getCell(3).setCellValue(elem.getNbpair());
				writeBase(bdd);
			}
		}
		if (!trouve) {
			// TODO : Prévoir une exception ...
			LOGGER.log(Level.INFO, "Element absent de la base ...");
		}
		closeBase(bdd);
	}

	@Override
	public void delete(JoueurPartieEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tableadr = bdd.getSheet("JoueursParties");
		Iterator<Row> iterator = tableadr.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getIdJP() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				removeRow(tableadr, ligne.getRowNum());
				writeBase(bdd);
			}
		}
		if (!trouve) {
			// TODO : Prévoir une exception ...
			LOGGER.log(Level.INFO, "Element absent de la base ...");
		}
		closeBase(bdd);
	}
}
