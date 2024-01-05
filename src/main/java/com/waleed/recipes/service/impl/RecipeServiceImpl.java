package com.waleed.recipes.service.impl;

import com.waleed.recipes.dto.RecipeDto;
import com.waleed.recipes.entity.Recipe;
import com.waleed.recipes.exception.ResourceNotFoundException;
import com.waleed.recipes.repository.RecipeRepository;
import com.waleed.recipes.service.RecipeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    private ModelMapper modelMapper;

    @Override
    public RecipeDto addRecipe(RecipeDto recipeDto) {

        Recipe recipe = modelMapper.map(recipeDto, Recipe.class);

        Recipe savedRecipe = recipeRepository.save(recipe);

        return modelMapper.map(savedRecipe, RecipeDto.class);
    }

    @Override
    public RecipeDto getRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recipe Not Found with ID: " + id)
        );
        return modelMapper.map(recipe, RecipeDto.class);
    }

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map(
                (recipe) -> modelMapper.map(recipe, RecipeDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public RecipeDto updateRecipe(Long id, RecipeDto recipeDto) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recipe Not Found with ID: " + id)
        );
        recipe.setRecipeName(recipeDto.getRecipeName());
        recipe.setCookTime(recipeDto.getCookTime());
        recipe.setPrepTime(recipeDto.getPrepTime());
        recipe.setRecipeDescription(recipeDto.getRecipeDescription());
        recipe.setRecipeImage(recipeDto.getRecipeImage());
        
        Recipe updatedRecipe = recipeRepository.save(recipe);
        
        return modelMapper.map(updatedRecipe, RecipeDto.class);
    }

    @Override
    public void deleteRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recipe Not Found with ID: " + id)
        );

        recipeRepository.deleteById(id);
    }
}
