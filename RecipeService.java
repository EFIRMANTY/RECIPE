package moj_spring2.recipe_api.WEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeUpdater recipeUpdater;
    private final RecipeTransformer recipeTransformer;


    @Autowired
    public RecipeService(RecipeRepository recipeRepository,
                         RecipeUpdater recipeUpdater,
                         RecipeTransformer recipeTransformer) {
        this.recipeRepository = recipeRepository;
        this.recipeUpdater = recipeUpdater;
        this.recipeTransformer = recipeTransformer;

    }

    public String addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return "dodano";
    }

    public List<Recipe> getAll() {
        return RecipeRepository.
    }

    public List<RecipeDTO> getAllShortForm() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeTransformer::toDto)
                .collect(Collectors.toList());
    }
    public List<Recipe> findByName(String name) {
        return Arrays.asList(recipeRepository.findById(name)
                .orElseThrow(()-> {
                    throw new NoSuchElementException("");
                }));
    }

    public Recipe removeRecipe(String name) {
        Recipe recipe = (Recipe) recipeRepository.findById(name)
                .orElseThrow(() -> {
                    throw new NoSuchElementException(name);
                });
        recipeRepository.delete(recipe);
        return recipe;
    }
    public Recipe update(String name, Recipe recipeToUpdate) {
        return recipeUpdater.update(name, recipeToUpdate);
    }
}

//    public delete(Recipe recipe) {
//        recipeRepository.delete(recipe);
//    }
//}

//    public List<Recipe> findByName() {
//
//    }
//
//    public Arrays findAll() {
//    }

/*        return recipeRepository.findAll().stream()
                .filter(recipe -> recipe.getId() == Integer.parseInt(id))
                .findAny()
                .<NoSuchElementException>orElseThrow(()->{
                    throw new NoSuchElementException();
                });*/

//    @DeleteMapping("/{id}")
//    public  List<Recipe> delete(@PathVariable String id) {
//recipeRepository.findById(Integer.parseInt(id))
//        .<NoSuchElementException>orElseThrow(()->{
//            throw new NoSuchElementException();
//        });
////        recipeRepository.delete(recipe);
////        return recipeRepository.save();
//    ;
//    @PutMapping ("/{name}")
//    public Recipe update(@PathVariable String name,
//                         @RequestBody Recipe recipeToUpdate) {
//         recipeRepository.findAll().stream()
//                .filter(r -> r.getName().equals(name))
//                .findAny()
//                .orElse(null);
//        recipe.setName(recipeToUpdate.getName());
//        recipe.setDescription(recipeToUpdate.getDescription());
//        return recipe;
//    }
//
//    public RecipeRepository getRecipeRepository() {
//        return recipeRepository;




