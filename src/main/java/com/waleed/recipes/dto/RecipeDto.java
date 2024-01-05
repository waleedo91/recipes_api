package com.waleed.recipes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {

    private Long id;
    private String recipeName;
    private int cookTime;
    private int prepTime;
    private String recipeDescription;
    private String recipeImage;

}
