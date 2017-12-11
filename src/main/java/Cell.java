import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** The single object of life. */
public class Cell {

    /** Is this cell alive? */
    public boolean isAlive;

    /** Zero or more neighbors that are dead or alive. */
    public List<Cell> neighbors;

    /** In a two-dimensional grid a cell has <em>max</em> neighbors. */
    protected long max = 8;

    /** Construct a cell with neighbors. */
    protected Cell(boolean isAlive, List<Cell> neighbors) {
        assert(neighbors.size() <= max);
        this.isAlive = isAlive;
        this.neighbors = neighbors;
    }

    /** Factory for a cell with no neighbors. */
    public static Cell fromBoolean(boolean isAlive) {
        return new Cell(isAlive, new ArrayList<>());
    }

    /** Singleton of one live cell. */
    public static Cell live = fromBoolean(true);

    /** Singleton of one dead cell. */
    public static Cell dead = fromBoolean(false);

    /** Factory for a cell surrounded by 8 cells. */
    public static Cell fromBoolean(boolean isAlive,
                       Cell c1, Cell c2, Cell c3,
                       Cell c4, /* c0 */ Cell c5,
                       Cell c6, Cell c7, Cell c8) {

        Cell c0 = fromBoolean(isAlive);
        return c0.addAll(
            Arrays.asList(c1.add(c2).add(c4).add(c0),
                          c2.add(c1).add(c3).add(c4).add(c0).add(c5),
                          c3.add(c2).add(c0).add(c5),
                          c4.add(c1).add(c2).add(c0).add(c6).add(c7),
                          c5.add(c2).add(c3).add(c0).add(c7).add(c8),
                          c6.add(c4).add(c0).add(c7),
                          c7.add(c4).add(c0).add(c5).add(c6).add(c8),
                          c8.add(c0).add(c5).add(c7)
            )
        );
    }

    /** Factory for a dead cell surrounded by 8 cells. */
    public static Cell dead(Cell c1, Cell c2, Cell c3,
                            Cell c4, /* c0 */ Cell c5,
                            Cell c6, Cell c7, Cell c8) {
        return fromBoolean(false,
                           c1, c2, c3,
                           c4,     c5,
                           c6, c7, c8);
    }

    /** Factory for a live cell surrounded by 8 cells. */
    public static Cell live(Cell c1, Cell c2, Cell c3,
                            Cell c4, /* c0 */ Cell c5,
                            Cell c6, Cell c7, Cell c8) {
        return fromBoolean(true,
                           c1, c2, c3,
                           c4,     c5,
                           c6, c7, c8);
    }

    /** Add a neighboring cell. */
    public Cell add(Cell cell) {
        List<Cell> newNeighbors = new ArrayList<>(neighbors);
        newNeighbors.add(cell); // Mutation!
        return new Cell(isAlive, newNeighbors);
    }

    /** Add neighboring cells. */
    public Cell addAll(List<Cell> cells) {
        List<Cell> newNeighbors = new ArrayList<>(neighbors);
        newNeighbors.addAll(cells); // Mutation!
        return new Cell(isAlive, newNeighbors);
    }

    /** Number of neighbors that are alive. */
    protected long neighborsAlive() {
        return neighbors.stream()       // long neighborsAlive = 0;
            .limit(max)                 // for (Cell n: neighbors)
            .filter(n -> n.isAlive)     //     if (n.isAlive)
            .count();                   //       neighborsAlive++;
                                        // return neighborsAlive;
    }

    /** Will this cell live in the next generation?  */
    protected boolean survives() {
        long neighborsAlive = neighborsAlive();
        return isAlive && neighborsAlive == 2 || neighborsAlive == 3;
    }

    /** Run step on neighboring cells. */
    protected List<Cell> stepNeighbors() {
        return neighbors.stream()
            .map(n -> n.step())
            .collect(Collectors.toList());
    }

    /** Cell in the next generation. */
    public Cell step() {
        return new Cell(survives(), stepNeighbors());
    }
}
