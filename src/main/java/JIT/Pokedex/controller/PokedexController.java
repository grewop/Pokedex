package JIT.Pokedex.controller;

import JIT.Pokedex.model.Pokedex;
import JIT.Pokedex.services.PokedexServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pokedex")
public class PokedexController {

    @Autowired
    PokedexServices pokedexServices;

    @GetMapping("/getAll")
    public Page<Pokedex> getAllPokemons(@RequestParam Integer page) {
        return pokedexServices.getPokemons(page);
    }

    @GetMapping("/getbyID/{id}")
    public Optional<Pokedex> getPokemonsByID(@PathVariable("id") long id) {
        return pokedexServices.getPokemonsByID(id);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable("id") long id) {
        try {
            pokedexServices.deletePokemon(id);
        } catch (Exception ex) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    @PostMapping("/Add/{name}/{type}/{description}")
    public void addNewPokemon(@PathVariable("name") String name, @PathVariable("type") String type, @PathVariable("description") String description) {
        Pokedex pokemon = new Pokedex(name, type, description);
        pokedexServices.addPokemon(pokemon);
    }

    @PostMapping("/Update/{id}/{name}/{type}/{description}")
    public void updatePokemon(@PathVariable("id") long id, @PathVariable("name") String name, @PathVariable("type") String type, @PathVariable("description") String description) {
        pokedexServices.updatePokemon(id, name, type, description);
    }

    @GetMapping("/getbyName/{name}")
    public List<Pokedex> getPokemonByName(@PathVariable("name") String name) {
        return pokedexServices.getPokemonByName(name);
    }

    @GetMapping("/getbyType/{type}/{page}")
    public Page<Pokedex> getPokemonByType(@PathVariable("type") String type, @PathVariable("page") Integer page) {
        return pokedexServices.getPokemonByType(type, page);
    }
}
