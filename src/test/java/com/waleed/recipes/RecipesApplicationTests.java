package com.waleed.recipes;

import com.waleed.recipes.entity.Recipe;
import com.waleed.recipes.repository.RecipeRepository;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RecipesApplicationTests {

	@Test
	void contextLoads() {
	}



}