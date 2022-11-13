package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    Ingredient ingredient;
    Ingredient ingredient_2;
    @Before
    public  void createNewIngredient() {
        ingredient = new Ingredient(SAUCE,"Black bun", 100f );
    }

    @Test
    public void getPriceTest() {
        assertEquals("Возвращается неверная цена",100F, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        assertEquals("Возвращается неверное имя", "Black bun", ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        ingredient_2 = new Ingredient(FILLING,"cutlet", 100f );
        assertEquals("Возвращается неверный тип ингридиента", SAUCE, ingredient.getType());
        assertEquals("Возвращается неверный тип ингридиента", FILLING, ingredient_2.getType());
    }
}