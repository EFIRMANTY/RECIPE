package moj_spring2.recipe_api.WEB;

import com.sun.xml.fastinfoset.util.StringArray;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {
    @Id
    @Size(min = 2, max = 40)
    @NotEmpty
    private String name;
    @NotNull
    @NotBlank
    @Size(min = 10, max = 100)
    private String description;
    @NotNull
    @Convert(converter = StringArrayToStringConvert.class)
    private List<String> ingredients;
    @Min(15)
    @Max(240)
    private int duration;
    @Max(20000)
    private int calories;
    @Min(1)
    @Max(10)
    private int numberofPeople;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getNumberofPeople() {
        return numberofPeople;
    }

    public void setNumberofPeople(int numberofPeople) {
        this.numberofPeople = numberofPeople;
    }

    public Recipe() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return calories == recipe.calories &&
                numberofPeople == recipe.numberofPeople &&
                duration == recipe.duration &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(description, recipe.description) &&
                Objects.equals(ingredients, recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, ingredients, calories, numberofPeople, duration);
    }

    }

