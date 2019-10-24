package moj_spring2.recipe_api.WEB;

import org.springframework.stereotype.Component;

import java.util.stream.Stream;
@Component
public class RecipeTransformer  {


    public RecipeDTO toDto(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO(recipe.getName(),
                recipe.getDescription());
        return recipeDTO;
    }
}

