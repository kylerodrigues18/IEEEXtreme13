package Protecting_The_Hive;

import java.util.*;
import java.lang.*;
import java.io.*;

public class v1 {

    private static HashMap<String, Cell> cells = new HashMap<>();

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        buildHive(in, in.nextInt(), in.nextInt());
        int cmdNum = in.nextInt();

        // Finish loading data

        for (int i = 0; i < cmdNum; i++) {
            String command = in.next();
            int x = in.nextInt(), y = in.nextInt();

            if (command.equals("a")) {
                cells.get(x + "," + y).setActive(true);
            } else {
                System.out.println(queryActive(cells.get(x + "," + y), new HashSet<>()));
            }
        }
    }

    static void buildHive(Scanner in, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < (cols - i % 2); j++) {
                // System.out.println(in.nextInt() + " @ (" + i + ", " + j + ")");
                cells.put((i + 1) + "," + (j + 1), new Cell((i + 1), (j + 1), in.nextInt() == 1));
                setAdjacent(cells.get((i + 1) + "," + (j + 1)), i % 2 == 0);
            }
        }
    }

    static void setAdjacent(Cell cell, boolean isOdd) {
        Cell adjacentCell;
        if (isOdd) {
            // Add top cells
            if (cells.containsKey((cell.x - 1) + "," + (cell.y - 1))) {
                adjacentCell = cells.get((cell.x - 1) + "," + (cell.y - 1));
                cell.addAdjacentCell(adjacentCell);
                adjacentCell.addAdjacentCell(cell);
            }
            if (cells.containsKey((cell.x - 1) + "," + cell.y)) {
                adjacentCell = cells.get((cell.x - 1) + "," + cell.y);
                cell.addAdjacentCell(adjacentCell);
                adjacentCell.addAdjacentCell(cell);
            }
            // Add bot cells
            if (cells.containsKey((cell.x + 1) + "," + (cell.y - 1))) {
                adjacentCell = cells.get((cell.x + 1) + "," + (cell.y - 1));
                cell.addAdjacentCell(adjacentCell);
                adjacentCell.addAdjacentCell(cell);
            }
            if (cells.containsKey((cell.x + 1) + "," + cell.y)) {
                adjacentCell = cells.get((cell.x + 1) + "," + cell.y);
                cell.addAdjacentCell(adjacentCell);
                adjacentCell.addAdjacentCell(cell);
            }
        } else {
            // Add top cells
            if (cells.containsKey((cell.x - 1) + "," + cell.y)) {
                adjacentCell = cells.get((cell.x - 1) + "," + cell.y);
                cell.addAdjacentCell(adjacentCell);
                adjacentCell.addAdjacentCell(cell);
            }
            if (cells.containsKey((cell.x - 1) + "," + (cell.y + 1))) {
                adjacentCell = cells.get((cell.x - 1) + "," + (cell.y + 1));
                cell.addAdjacentCell(adjacentCell);
                adjacentCell.addAdjacentCell(cell);
            }
            // Add bot cells
            if (cells.containsKey((cell.x + 1) + "," + cell.y)) {
                adjacentCell = cells.get((cell.x + 1) + "," + cell.y);
                cell.addAdjacentCell(adjacentCell);
                adjacentCell.addAdjacentCell(cell);
            }
            if (cells.containsKey((cell.x + 1) + "," + (cell.y + 1))) {
                adjacentCell = cells.get((cell.x + 1) + "," + (cell.y + 1));
                cell.addAdjacentCell(adjacentCell);
                adjacentCell.addAdjacentCell(cell);
            }
        }
        // Add left and right cells
        if (cells.containsKey(cell.x + "," + (cell.y - 1))) {
            adjacentCell = cells.get(cell.x + "," + (cell.y - 1));
            cell.addAdjacentCell(adjacentCell);
            adjacentCell.addAdjacentCell(cell);
        }
        if (cells.containsKey(cell.x + "," + (cell.y + 1))) {
            adjacentCell = cells.get(cell.x + "," + (cell.y + 1));
            cell.addAdjacentCell(adjacentCell);
            adjacentCell.addAdjacentCell(cell);
        }
    }

    static int queryActive(Cell cell, HashSet<Cell> visited) {
        if (!cell.isActive) {
            return 0;
        }

        int result = 6;
        visited.add(cell);

        for (Cell adjacentCell: cell.getAdjacentCells()) {
            // Subtract 1 for each connected edge
            result -= 1;

            // Add one for each adjacent cell that isn't active
            if (!adjacentCell.isActive) {
                result += 1;
            }

            if (!visited.contains(adjacentCell)) {
                result += queryActive(adjacentCell, visited);
            }
        }

        return result;
    }

    static class Cell {
        HashSet<Cell> adjacentCells;
        boolean isActive = false;
        int x, y;

        Cell(int x, int y, boolean isActive) {
            adjacentCells = new HashSet<>();
            this.x = x;
            this.y = y;
            this.isActive = isActive;
        }

        public HashSet<Cell> getAdjacentCells() {
            return adjacentCells;
        }

        public void addAdjacentCell(Cell adjacentCell) {
            adjacentCells.add(adjacentCell);
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
