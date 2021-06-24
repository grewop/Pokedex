package JIT.Pokedex.services;

import JIT.Pokedex.model.Pokedex;
import JIT.Pokedex.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokedexServices {

    @Autowired
    PokedexRepository pokedexRepository;

    public Page<Pokedex> getPokemons(Integer page) {
        return pokedexRepository.findAll(PageRequest.of(
                page,
                5,
                Sort.Direction.ASC, "id"));
    }

    public Optional<Pokedex> getPokemonsByID(long id) {
        return pokedexRepository.findById(id);
    }

    public void deletePokemon(long id) {
        pokedexRepository.deleteById(id);
    }

    public void addPokemon(Pokedex pokemon) {
        this.pokedexRepository.save(pokemon);
    }

    public void updatePokemon(long id, String name, String type, String description) {
        this.pokedexRepository.updatePokemon(id, name, type, description);
    }

    public List<Pokedex> getPokemonByName(String name) {
        return pokedexRepository.findByName(name);

    }

    public Page<Pokedex> getPokemonByType(String type, Integer page) {
        return pokedexRepository.findByType(type, PageRequest.of(page, 5));
    }
}
