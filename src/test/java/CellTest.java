import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CellTest {

    @Test
    public void testOneDeadCell() {
        Cell cell = Cell.fromBoolean(false);
        assertFalse(cell.step().isAlive);
    }

    @Test
    public void testOneLiveCell() {
        Cell cell = Cell.fromBoolean(true);
        assertFalse(cell.step().isAlive);
    }

    @Test
    public void testTwoLiveCells() {
        Cell cell = new Cell(
            true,
            new ArrayList<Cell>(
                Arrays.asList(
                    Cell.fromBoolean(true) // !
                )
            )
        );
        assertFalse(cell.step().isAlive);
    }

    @Test
    public void testThreeLiveCells() {
        Cell cell = new Cell(
            true,
            Arrays.asList(
               Cell.fromBoolean(true),
               Cell.fromBoolean(true) // !
            )
        );
        assertTrue(cell.step().isAlive);
    }

    @Test
    public void testOneDeadAndThreeLiveCells() {
        Cell cell = new Cell(
            false, // !
            Arrays.asList(
                Cell.fromBoolean(true),
                Cell.fromBoolean(true),
                Cell.fromBoolean(true)
            )
        );
        assertTrue(cell.step().isAlive);
    }

    @Test
    public void testFourLiveCells() {
        Cell cell = new Cell(
            true, // !
            Arrays.asList(
                Cell.fromBoolean(true),
                Cell.fromBoolean(true),
                Cell.fromBoolean(true)
            )
        );
        assertTrue(cell.step().isAlive);
    }

    @Test
    public void testAdd() {
        Cell cell  = Cell.fromBoolean(false);
        Cell cell2 = Cell.fromBoolean(false);
        assertEquals(cell.add(cell2).neighbors.size(), 1);
    }

    @Test
    public void testAddAll() {
        Cell cell  = Cell.fromBoolean(false);
        List<Cell> cells = Arrays.asList(
            Cell.fromBoolean(false)
        );
        assertEquals(cell.addAll(cells).neighbors.size(), 1);
    }
}
