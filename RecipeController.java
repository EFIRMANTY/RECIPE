package moj_spring2.recipe_api.WEB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequestMapping("/recipe")
@RestController
public class RecipeController {
    RecipeService recipeService;
    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public String addRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
    @GetMapping
    public List<RecipeDTO>getAllShortForm(){
        return recipeService.getAllShortForm();
    }
    @DeleteMapping("/{name}")
    public Recipe remove(@PathVariable Recipe recipe) {
        return recipeService.removeRecipe(name);
    }

}
//    @GetMapping("findByName")
//    public List<Recipe> findByName(@RequestParam String name) {
//        return recipeService.findAll().stream()
//                .filter(recipes -> recipes().equals(name))
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/{id}")
//    public Recipe getById(@PathVariable String id) {
//        return recipeRepository.findById(Integer.parseInt(id))
//                .<NoSuchElementException>orElseThrow(() -> {
//                    throw new NoSuchElementException();
//                });


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