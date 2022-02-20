package it.film.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.film.dao.FilmDao;
import it.film.dto.FilmDto;
import it.film.entity.Film;

@RequestMapping("/film")
@RestController
@Api(value = "Films Rest Service", tags = "Servizio Film Database")
public class FilmRest {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	private FilmDao filmDao;
	
	public FilmDao getFilmDao() {
		if (filmDao == null) {
			filmDao = new FilmDao();
		}
		return filmDao;
	}
	@ApiOperation(
			value = "Lista di tutti i Film",
			produces = "application/json",
			response = Film.class, responseContainer = "List" )
	@GetMapping
	public ResponseEntity<List<Film>> findAllFilm() {
		try {
			return new ResponseEntity<List<Film>>(getFilmDao().findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.NOT_FOUND);
		}
	
	}
	
	@ApiOperation(value = "Elimina Film")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFilm(@PathVariable int id) {
		try {
			getFilmDao().delete(id);
			return new ResponseEntity<String>("Il Film con id#"+id+" eliminato con successo!", HttpStatus.OK);
			} catch (Exception e) {
			return new ResponseEntity<String>("Il Film con id#"+id+" non eliminato!", HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@PostMapping
	@ApiOperation(
			value = "Inserisci Film",
			consumes = "application/json")
	public ResponseEntity<String> insertFilm(@RequestBody FilmDto fDto) {
		Film f = new Film();
		f.setTitolo(fDto.getTitolo());
		f.setAnno(fDto.getAnno());
		f.setRegista(fDto.getRegista());
		f.setTipo(fDto.getTipo());
		// utilizzo BCrypt per criptare l'incasso come da richiesta della traccia
		String incassoCriptato = BCrypt.hashpw(fDto.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		try {
			getFilmDao().save(f);
			return new ResponseEntity<String>("Il Film "+f+"inserito correttamento !", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Il Film "+f+" non inserito! ", HttpStatus.BAD_REQUEST);
		}
	
	}

	
	@GetMapping("/byregista")
	@ApiOperation(
			value = "Ricerca Film per Regista",
			produces = "application/json",
			response = Film.class, responseContainer = "List")
	public ResponseEntity<List<Film>> ricercaByRegista(@RequestParam String regista) {
		try {
			log.info("Ricerca completata, consulta i risultati!");
			return new ResponseEntity<List<Film>>(getFilmDao().findByRegista(regista), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.NOT_FOUND);
		}
	
	}
	
}
