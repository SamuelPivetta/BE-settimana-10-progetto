package it.film.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import it.film.entity.Film;

public class FilmDao implements IFilmDao {

	private EntityManager em = EntityManagerHelper.getEntityManager();

	@Override
	public void save(Film f) {
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();

	}



	@Override
	public Film find(int id) {
		Film f = em.find(Film.class, id);
		return f;
	}
	
	/**
     *  Ricerca dei film per Regista
     * 
     *  @author Samuel Pivetta
     *  @param  nome del regista
     *  @return ritorna List<Film>
     */
	@Override
	public List<Film> findByRegista(String regista) {
		Query q = em.createQuery("SELECT f FROM Film f WHERE f.regista = '" + regista + "'");
		List<Film> listaFilmRegista = q.getResultList();
		return listaFilmRegista;
	}

	@Override
	public void delete(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Film.class, id));
		em.getTransaction().commit();
	}

	@Override
	public List<Film> findAll() {
		Query q = em.createNamedQuery("findAll");
		List<Film> listaFilm = q.getResultList();
		return listaFilm;
	}

}