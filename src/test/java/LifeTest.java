import org.junit.*;
import static org.junit.Assert.*;

public class LifeTest {

    @Test
    public void testDeadCellStep() {
        assertFalse(Cell.dead.step().isAlive);
    }

    @Test
    public void testLiveCellStep() {
        assertFalse(Cell.live.step().isAlive);
    }

    @Test
    public void testOneDeadCellStep() {
        Cell cell = Cell.dead(
                              Cell.dead, Cell.dead, Cell.dead,
                              Cell.dead,            Cell.dead,
                              Cell.dead, Cell.dead, Cell.dead);
        assertFalse(cell.step().isAlive);
    }

    @Test
    public void testOneLiveCellStep() {
        Cell cell = Cell.live( // !
                              Cell.dead, Cell.dead, Cell.dead,
                              Cell.dead,            Cell.dead,
                              Cell.dead, Cell.dead, Cell.dead);
        assertFalse(cell.step().isAlive);
    }

    @Test
    public void testTwoLiveCellsStep() {
        Cell cell = Cell.live(
                              Cell.dead, Cell.dead, Cell.live, // !
                              Cell.dead,            Cell.dead,
                              Cell.dead, Cell.dead, Cell.dead);
        assertFalse(cell.step().isAlive);
    }

    @Test
    public void testThreeLiveCellsStep() {
        Cell cell = Cell.live(
                              Cell.dead, Cell.dead, Cell.live,
                              Cell.dead,            Cell.live, // !
                              Cell.dead, Cell.dead, Cell.live);
        assertTrue(cell.step().isAlive);
    }

    @Test
    public void testFourLiveCellsStep() {
        Cell cell = Cell.live(
                              Cell.live, Cell.live, Cell.live, // !
                              Cell.dead,            Cell.dead,
                              Cell.dead, Cell.dead, Cell.dead);
        assertTrue(cell.step().isAlive);
        assertTrue(cell.step().neighbors.get(3).isAlive);
    }

    @Test
    public void testOneDeadAndThreeLiveCellsStep() {
        Cell cell = Cell.dead( // !
                              Cell.live, Cell.live, Cell.live,
                              Cell.dead,            Cell.dead,
                              Cell.dead, Cell.dead, Cell.dead);
        assertTrue(cell.step().isAlive);
    }

    @Test
    public void testFiveLiveCellsStep() {
        Cell cell = Cell.live(
                              Cell.live, Cell.live, Cell.live,
                              Cell.dead,            Cell.live, // !
                              Cell.dead, Cell.dead, Cell.dead);
        assertFalse(cell.step().isAlive);
	assertFalse(cell.step().neighbors.get(1).isAlive);
	assertTrue(cell.step().neighbors.get(3).isAlive);
    }
}
