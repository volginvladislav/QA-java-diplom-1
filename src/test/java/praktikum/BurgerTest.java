package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient_2;

    @Before
    public void createNewBurger(){
        burger = new Burger();
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        int i = burger.ingredients.size();
        assertEquals("Ингредиенты должны совпадать", ingredient, burger.ingredients.get(i - 1));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Количество ингредиентов не совпадает",0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient_2);
        burger.moveIngredient(1, 0);
        assertEquals("Неправильный ингредиент",ingredient_2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals("Неверная стоимость бургера",300f, burger.getPrice(), 0.0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        String actualResult = burger.getReceipt();
        String expectedResult = "(==== black bun ====)" + System.lineSeparator() +"= filling cutlet =" + System.lineSeparator() + "(==== black bun ====)" + System.lineSeparator() + System.lineSeparator() + "Price: 300,000000" + System.lineSeparator();
        assertEquals("Неверный рецепт",expectedResult, actualResult);
    }
}