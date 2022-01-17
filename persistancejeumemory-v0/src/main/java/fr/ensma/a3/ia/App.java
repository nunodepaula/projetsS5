package fr.ensma.a3.ia;

import java.util.List;
import java.util.Optional;

import fr.ensma.a3.ia.dao.IEntityDAO;
import fr.ensma.a3.ia.dao.JoueurPoiDAO;
import fr.ensma.a3.ia.dao.entity.JoueurEntity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Elements dans la base");
    	IEntityDAO<JoueurEntity> joueurdao=new JoueurPoiDAO();
    	
    	Optional<JoueurEntity> trouve = joueurdao.getById(1);
    	System.out.println("Recherche par id de l'élément : id=1 ");
    	if(trouve.isPresent()) {
    		System.out.println(trouve.get().getPrenom());
    	}
    	List<JoueurEntity> alljoueur = joueurdao.getAll();
    	for(JoueurEntity ad : alljoueur) {
    		System.out.println(ad.getPrenom());
    	}
    }
}
