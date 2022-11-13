package praktikum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun testBun;
    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Before
    public void createNewBun() {
        testBun = new Bun(bunName, bunPrice);
    }

    @Parameterized.Parameters(name = "Тестовые данные: Название булочки [{0}], Цена булочки [{1}]")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"black bun", 100f},
                {"white bun", 200f},
                {"red bun", 300f}
        };
    }

    @Test
    public void getNameBunTest() {
        assertEquals("Название булочки не совпадает с ожидаемым", bunName, testBun.getName());
    }

    @Test
    public void getPriceBunTest() {
        assertEquals("Цена булочки не совпадает с ожидаемой", bunPrice, testBun.getPrice(), 0.0);
    }
}