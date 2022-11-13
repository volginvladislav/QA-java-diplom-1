package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

     private  final IngredientType checkedType;
     private final String expectedIngredientType;

    public IngredientTypeTest(IngredientType checkedType, String expectedIngredientType) {
        this.checkedType = checkedType;
        this.expectedIngredientType = expectedIngredientType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: Тип ингредиента из Enum [{0}], Ожидаемый тип ингредиента [{1}]")
    public static Object[][] getTestData(){
        return new Object[][] {
                {IngredientType.FILLING, "FILLING"},
                {IngredientType.SAUCE, "SAUCE"},
        };
    }

    @Test
    public void checkedEnumIngredientTypeTest() {
        assertEquals("Возвращается неверный тип ингридиента", IngredientType.valueOf(expectedIngredientType), checkedType);
    }
}