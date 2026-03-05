package combat.sports;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class KarateTest {
    @Test
    void testAttack() {
        Karate karate = new Karate("Ken", 80, 100);
        Fighter opponent = new Karate("Ryu", 70, 100);
        int initialStamina = opponent.stamina;
        int initialFatigue = karate.fatigue;
        karate.attack(opponent);
        int expectedDamage = karate.strength + karate.skillBonus();
        assertEquals(initialStamina - expectedDamage, opponent.stamina);
        assertEquals(initialFatigue + 8, karate.fatigue);
    }
    @Test
    void testCounterAttack() {
        Karate karate = new Karate("Ken", 80, 100);
        Fighter opponent = new Karate("Ryu", 70, 100);
        int initialStamina = opponent.stamina;
        karate.counterAttack(opponent);
        int expectedDamage = (karate.strength + karate.skillBonus()) / 2 + 3;
        assertEquals(initialStamina - expectedDamage, opponent.stamina);
    }
    @Test
    void testCriticalHit() {
        Karate karate = new Karate("Ken", 80, 100);
        Fighter opponent = new Karate("Ryu", 70, 100);
        karate.criticalHit(opponent);
        assertTrue(opponent.stamina == 0 || opponent.stamina == 100);
    }
    @Test
    void testBleedingDamage() {
        Karate karate = new Karate("Ken", 80, 100);
        int initialStamina = karate.stamina;
        karate.BleedingDamage();
        int expectedLoss = (int) (initialStamina * 0.07);
        assertEquals(initialStamina - expectedLoss, karate.stamina);
    }
    @Test
    void testRest() {
        Karate karate = new Karate("Ken", 80, 100);
        karate.fatigue = 30;
        karate.rest();
        assertEquals(20, karate.fatigue); // 30 - 10
    }
    @Test
    void testRecover() {
        Karate karate = new Karate("Ken", 80, 50);
        karate.recover();
        assertEquals(65, karate.stamina); // 50 + 15
    }
}