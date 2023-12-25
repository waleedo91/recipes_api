package com.waleed.recipes.service;

import com.waleed.recipes.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    RecipeDto addRecipe(RecipeDto recipeDto);

    RecipeDto getRecipe(Long id);

    List<RecipeDto> getAllRecipes();

    RecipeDto updateRecipe(Long id, RecipeDto recipeDto);

    void deleteRecipe(Long id);

}
