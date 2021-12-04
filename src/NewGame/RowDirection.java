package NewGame;

/**
 * Its functionality is an interface that takes in a lambda that changes the coordinate in a certain direction.
 */
public interface RowDirection {
    void doChange(int[] coords);
}
