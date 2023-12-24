package com.waleed.recipes.service.impl;

import com.waleed.recipes.dto.RecipeDto;
import com.waleed.recipes.entity.Recipe;
import com.waleed.recipes.repository.RecipeRepository;
import com.waleed.recipes.service.RecipeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    private ModelMapper modelMapper;

    @Override
    public RecipeDto addTodo(RecipeDto recipeDto) {

        Recipe recipe = modelMapper.map(recipeDto, Recipe.class);

        Recipe savedRecipe = recipeRepository.save(recipe);

        return modelMapper.map(savedRecipe, RecipeDto.class);
    }
}
