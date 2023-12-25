package com.waleed.recipes.controller;

import com.waleed.recipes.dto.RecipeDto;
import com.waleed.recipes.service.RecipeService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;

    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto){
        RecipeDto savedRecipe = recipeService.addRecipe(recipeDto);
        return new ResponseEntity<>(savedRecipe, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable("id") Long recipeId){
        RecipeDto recipeDto = recipeService.getRecipe(recipeId);
        return new ResponseEntity<>(recipeDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RecipeDto>> getAllRecipes(){
        List<RecipeDto> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    @PutMapping("{id}")
    public ResponseEntity<RecipeDto> updateRecipe(@PathVariable("id") Long recipeId,
                                                  @RequestBody RecipeDto recipeDto){
        RecipeDto updatedRecipe = recipeService.updateRecipe(recipeId, recipeDto);
        return ResponseEntity.ok(updatedRecipe);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("id") Long recipeId){
        recipeService.deleteRecipe(recipeId);
        return ResponseEntity.ok("Recipe Deleted Successfully!");
    }

}
