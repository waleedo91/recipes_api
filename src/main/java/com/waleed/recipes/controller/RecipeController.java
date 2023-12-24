package com.waleed.recipes.controller;

import com.waleed.recipes.dto.RecipeDto;
import com.waleed.recipes.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;

    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto){
        RecipeDto savedRecipe = recipeService.addTodo(recipeDto);
        return new ResponseEntity<>(savedRecipe, HttpStatus.CREATED);
    }

}
