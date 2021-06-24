package JIT.Pokedex.repository;

import JIT.Pokedex.model.Pokedex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PokedexRepository extends JpaRepository<Pokedex, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE POKEDEX SET NAME= :name , TYPE= :type , DESCRIPTION = :description where ID = :id", nativeQuery = true)
    void updatePokemon(@Param("id") long id, @Param("name") String name, @Param("type") String type, @Param("description") String description);

    @Query(value = "SELECT * FROM POKEDEX WHERE NAME LIKE %:name%", nativeQuery = true)
    List<Pokedex> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM POKEDEX WHERE TYPE LIKE %:type% ORDER BY id", nativeQuery = true)
    Page<Pokedex> findByType(@Param("type") String type, Pageable pageable);

}
