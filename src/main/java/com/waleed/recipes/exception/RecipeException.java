package com.waleed.recipes.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class RecipeException extends RuntimeException {

    private HttpStatus state;
    private String message;

}
