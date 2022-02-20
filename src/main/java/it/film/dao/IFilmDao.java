package it.film.dao;

import java.util.List;

import it.film.entity.Film;


public interface IFilmDao {
	
	public void save(Film f);
	public Film find(int id);
	public List<Film> findByRegista(String nomeRegista);
	public void delete(int id);
	public List<Film> findAll();

}