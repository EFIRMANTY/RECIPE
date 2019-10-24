package moj_spring2.recipe_api.WEB;

import org.springframework.stereotype.Component;


public class RecipeDTO {
    private String name;
    private String description;

    public RecipeDTO() {
    }

    public RecipeDTO(String name, String description) {
        this.name = name;
        this.description = description;

    }

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
}
