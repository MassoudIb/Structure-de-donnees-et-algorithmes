// Nous nous sommes inspiré de ce site internet pour l'algorithme DFS:
// https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
// Cependant nous avons utilisé une approche récursive pour tester les 4 côtés de chaque Tile.
// Si le chemin bloque, alors on fait un "backtrack" et nous continuons jusqu'à ce que la sortie est trouvée.
package Maze;

import java.util.*;
import java.util.stream.Collectors;


/** TODO
 ** Implement DFS algorithm to solve the maze.
 */
public class DFSMaze {
    private static Counter counter;
    private static int distance = 0;
    /** TODO
     * Returns the distance of the path within the maze
     * @param maze 2D table representing the maze
     * @return Distance of the path within the maze, null if not solvable
     */
    public static Integer findPath(ArrayList<ArrayList<Tile>> maze) {
        distance = 0;
        counter = new Counter();

        if (maze.isEmpty())
            return null;

        int totalRows = maze.size();
        int totalColumns = maze.get(0).size();

        // Vérifier la source et la destination du labyrinthe.
        ArrayList<Coord> exits = new ArrayList<>();
        for (int i = 0; i < totalRows; i++)
            for (int j = 0; j < totalColumns; j++)
                if (maze.get(i).get(j) == Tile.Exit)
                    exits.add(new Coord(i, j));

        // Vérification qu'il y a bien 2 sorties.
        if (exits.size() != 2)
            return null;

        Coord source = new Coord(exits.get(0).row, exits.get(0).col);
        Coord destination = new Coord(exits.get(1).row, exits.get(1).col);

        int[][] visited = new int[totalRows][totalColumns];
        boolean pathFound = dfs(maze, source, destination, visited);

        //Pour fin de débogage.
        if (pathFound) {
            System.out.println("Chemin trouve");
            printMaze(maze);
            System.out.println("Distance du chemin trouve est: " + distance);
            return distance;
        } else {
            System.out.println("Aucun chemin trouve");
            return null;
        }
    }

    private static boolean dfs(ArrayList<ArrayList<Tile>> maze, Coord current, Coord destination, int[][] visited) {
        if (!isValidMove(maze, current, visited))
            return false;

        visited[current.row][current.col] = 1;

        Stack<Coord> stack = new Stack<>();

        stack.push(current); // Ajouter le point de départ à la pile
        //Pour partie 2.1 pour voir le nombre de Tile traversées!
        counter.totalNodesTraversed++;
        counter.stackedNodes--;
        current = stack.pop();

        System.out.println("Nombre de Tile traversees: " + counter.totalNodesTraversed);

        // pour débogage
        //printSolution(visited,maze.size(), maze.get(0).size());
        //System.out.println(" ");


        if (current.row == destination.row && current.col == destination.col)
            return true;

        for (int d = 0; d < 4; d++) {
            Coord next = current.direction(d);
            distance++;

            //Pour partie 2.2 pour observer le nombre de Tile ajoutés
            if((!stack.contains(next)) && isValidMove(maze, next, visited)) {
                stack.push(next); // Ajouter le point suivant à la pile
                System.out.println("Nombre de Tile ajoutes " + stack.size()); // Affichage de la taille de la pile à chaque itération
                counter.stackedNodes = counter.stackedNodes + stack.size(); // Mettre à jour la taille maximale de la pile
                counter.maxStackSize = Math.max(counter.maxStackSize, counter.stackedNodes);
                System.out.println("Taille maximale de la pile : " + counter.maxStackSize); // Affichage de la taille maximale de la pile
                System.out.println("Nombre actuel de Tile dans la pile: " + counter.stackedNodes);
            }

            if (dfs(maze, next, destination, visited)) {
                maze.get(current.row).set(current.col, Tile.Floor);

                return true;
            }
            distance--;
        }

        // Backtrack si aucun chemin trouvé.
        visited[current.row][current.col] = 0;
        return false;
    }

      //  pour débogage
    static void printSolution(int sol[][], int row, int col)
    {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    // Une classe Coord qui représente une cellule du labyrinthe représentée par les colonnes (col) et les rangées (row)
    private static class Coord {
        final int row;
        final int col;
        int haut = 0; int bas = 1; int gauche = 2; int droite = 3;

        Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }

        // La direction est déterminée à partir des Coord.
        // Haut, Bas, Gauche, Droite en ordre.
        Coord direction(int d) {
            if (d == haut)
                return new Coord(row - 1, col);
            else if (d == bas)
                return new Coord(row + 1 , col);
            else if (d == gauche)
                return new Coord(row, col - 1);
            else if (d == droite)
                return new Coord(row, col + 1);
            else
                return this;
        }
    }

    private static boolean isValidMove(ArrayList<ArrayList<Tile>> maze, Coord current, int visited[][]){
        int totalRows = maze.size();
        int totalColumns = maze.get(0).size();

        return current.row >= 0 && current.row < totalRows &&
                current.col >= 0 && current.col < totalColumns &&
                maze.get(current.row).get(current.col) != Tile.Wall &&
                visited[current.row][current.col] == 0;
    }

    public static void printMaze(ArrayList<ArrayList<Tile>> maze) {
        for (ArrayList<Tile> row : maze) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining("")));
        }
    }
}

