// Nous nous sommes inspiré de ce site internet pour l'algorithme BFS:
// https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/

package Maze;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/** TODO
 ** Implement BFS algorithm to solve the maze.
 */
public class BFSMaze {
    private static Counter counter;
    /** TODO
     * Returns the distance of the shortest path within the maze
     * @param maze 2D table representing the maze
     * @return Distance of the shortest path within the maze, null if not solvable
     */
    public static Integer findPath(ArrayList<ArrayList<Tile>> maze) {
        counter = new Counter();

        if (maze.isEmpty())
            return null;

        // Avoir le nombre total de rangées et de colonnes.
        int totalRows = maze.size();
        int totalColumns = maze.get(0).size();

        // Vérifier la source et la destination du labyrinthe.
        ArrayList<Cell> exits = new ArrayList<>();
        for (int i = 0; i < totalRows; i++)
            for (int j = 0; j < totalColumns; j++)
                if (maze.get(i).get(j) == Tile.Exit)
                    exits.add(new Cell(i, j));

        // Vérification qu'il y a bien 2 sorties.
        if (exits.size() != 2)
            return null;

        // Création du tableau des noeuds visités
        int [][]visited = new int [totalRows][totalColumns];

        Cell source = new Cell(exits.get(0).row, exits.get(0).col);
        Cell destination = new Cell(exits.get(1).row, exits.get(1).col);
        
        visited[source.row][source.col] = 1;
        Queue<queueNode> queue = new LinkedList<>();
        
        queueNode src = new queueNode(source, 0);
        queue.add(src);

        while (!queue.isEmpty())
        {
            queueNode currentNode = queue.peek();

            //Pour partie 2.1 pour voir le nombre de Tile traversées!
            counter.totalNodesTraversed++;
            System.out.println("Nombre de Tile traversees: " + counter.totalNodesTraversed + "  Distance est: " + currentNode.distance );

            //Pour partie 2.2 pour voir le nombre de Tile ajoutées dans la pile!
            counter.stackedNodes = queue.size();
            System.out.println("Nombre de Tile ajoutees dans la pile: " + counter.stackedNodes);

            counter.maxStackSize = Math.max(counter.maxStackSize, counter.stackedNodes);

            Cell cell = currentNode.cell;

            // Si la destination est trouvée, renvoie la distance.
            if (cell.row == destination.row && cell.col == destination.col)
                return currentNode.distance;

            queue.remove();


            for (int i = 0; i < 4; i++)
            {
                Cell neighbor = currentNode.cell.direction(i);
                int row = neighbor.row;
                int col = neighbor.col;

                if (isNodeValid(row, col, totalRows, totalColumns) &&
                        ( maze.get(row).get(col) == Tile.Floor || maze.get(row).get(col) == Tile.Exit )
                        && visited[row][col] != 1)
                {
                    visited[row][col] = 1;
                    queueNode otherNeighbors = new queueNode(new Cell(row, col), currentNode.distance + 1 );
                    queue.add(otherNeighbors);

                    counter.stackedNodes++;
                    counter.maxStackSize = Math.max(counter.maxStackSize, queue.size());
                }
            }
            //Pour partie 2.1 pour voir les noeud visitées!
            //printVisitedNodes(visited, totalRows, totalColumns);
        }

        return null;
    }

    static void printVisitedNodes(int sol[][], int row, int col)
    {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }


    // Une classe Cell qui représente une cellule du labyrinthe représentée par les colonnes (col) et les rangées (row)
    public static class Cell {
        final int row;
        final int col;
        int haut = 0; int bas = 1; int gauche = 2; int droite = 3;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        // La direction est déterminée à partir des Cellules (Cell).
        // Haut, Bas, Gauche, Droite en ordre.
        Cell direction(int d) {
            if (d == haut)
                return new Cell(row - 1, col);
            else if (d == bas)
                return new Cell(row + 1 , col);
            else if (d == gauche)
                return new Cell(row, col - 1);
            else if (d == droite)
                return new Cell(row, col + 1);
            else
                return this;
        }
    }

    // Une classe qui représente un noeud dans une queue.
    // La distance est celle de la source à la cellule.
    private static class queueNode
    {
        Cell cell;
        int distance;

        public queueNode(Cell cell, int distance)
        {
            this.cell = cell;
            this.distance = distance;
        }
    };

    // Vérification si le noeud est valide ou non
    private static boolean isNodeValid(int row, int col, int totalRows, int totalColumns)
    {
        return (row >= 0) && (col >= 0) && (row < totalRows)  && (col < totalColumns);
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }
}