import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class SILab2Test {

    @Test
    void testNullItems() {
        // Testiranje na slucajot koga listata na predmeti e null
        RuntimeException ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertEquals("allItems list can't be null!", ex.getMessage());
    }

    @Test
    void testValidItems() {
        // Testiranje za validni predmeti i razlicni scenarija
        List<Item> items = new ArrayList<>();

        // Slucaj 1: Predmet so validno ime, barkod i bez popust
        items.add(new Item("Phone", "0123456789", 650, 0.0f));

        // Slucaj 2: Predmet so prazno ime, validen barkod i bez popust
        items.add(new Item("", "0123456789", 400, 0.0f));

        // Slucaj 3: Predmet so validno ime, barkod i popust
        items.add(new Item("PC", "1121231231", 800, 0.3f));

        // Slucaj 4: Predmet so validen barkod koj zapocnuva so '0', popust i cena nad 300
        items.add(new Item("TV", "012345", 500, 0.2f));

        // Proverka dali vkupnata suma e pomala ili ednakva na plakjanjeto
        assertTrue(SILab2.checkCart(items, 2500));

        // Promena na plakjanjeto, za testiranje sprotiven slucaj
        assertFalse(SILab2.checkCart(items, 100));
    }
}
