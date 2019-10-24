package moj_spring2.recipe_api.WEB;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    List<Recipe> findByCalories(int calories);

    Optional<Object> findById(String name);
}

