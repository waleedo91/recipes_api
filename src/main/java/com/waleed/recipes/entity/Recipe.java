package com.waleed.recipes.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "recipe_name")
    private String recipeName;

    @Column(nullable = false, name = "cook_time")
    private int cookTime;

    @Column(nullable = false, name = "prep_time")
    private int prepTime;

    @Column(nullable = false, name = "recipe_description")
    private String recipeDescription;

}
