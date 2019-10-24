package moj_spring2.recipe_api.WEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
    public class RecipeUpdater {

        private final RecipeRepository recipeRepository;

        @Autowired
        public RecipeUpdater(RecipeRepository recipeRepository) {
            this.recipeRepository = recipeRepository;
        }

        public Recipe update(String id, Recipe recipeToUpdate){
            Recipe recipe = recipeRepository.findById(Integer.parseInt(id))
                    .orElseThrow(()->{
                        throw new NoSuchElementException(id);
                    });
            if (recipeToUpdate.getName() != null) {
                recipe.setName(recipeToUpdate.getName());
            }
            if(recipeToUpdate.getDescription() != null) {
                recipe.setDescription(recipeToUpdate.getDescription());
            }
            if (recipeToUpdate.getCalories() != 0) {
                recipe.setCalories(recipeToUpdate.getCalories());
            }
            if (recipeToUpdate.getDuration() != 0) {
                recipe.setDuration(recipeToUpdate.getDuration());
            }
            if (recipeToUpdate.getNumberofPeople() != 0) {
                recipe.setNumberofPeople(recipeToUpdate.getNumberofPeople());
            }
            recipeRepository.save(recipe);
            return recipe;
        }

    }
