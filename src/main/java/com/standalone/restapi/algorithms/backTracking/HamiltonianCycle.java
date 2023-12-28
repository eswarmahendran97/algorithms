package com.standalone.restapi.algorithms.backTracking;

import java.util.Arrays;
import java.util.stream.IntStream;

class HamiltonianCycle {

    int[][] input;
    int[] output;


    // driver program to test above function
    public static void main(String[] args) {
        HamiltonianCycle hamiltonian =
                new HamiltonianCycle();
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int[][] graph1 = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };

        // Print the solution
        hamiltonian.findHamiltanionPath(graph1, 5);

        int[][] graph2 = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };

        // Print the solution
        hamiltonian.findHamiltanionPath(graph2, 5);
    }

    private void findHamiltanionPath(int[][] graph, int dimension) {
        input = graph;
        output = new int[dimension];
        IntStream.range(0, dimension).forEach(e -> output[e] = -1);
        output[0] = 0;

        if (trackPath(1)) {
            Arrays.stream(output).forEach(System.out::println);
        } else {
            System.out.println("No path found");
        }
    }

    private boolean trackPath(int path) {
        if (path == output.length) {
            return input[output[path - 1]][output[0]] == 1;
        } else {
            for (int i = 1; i < output.length; i++) {
                if (checkConnection(path, i)) {
                    output[path] = i;
                    if (trackPath(path + 1)) {
                        return true;
                    } else {
                        output[path] = -1;
                    }
                }
            }
            return false;
        }
    }

    private boolean checkConnection(int path, int i) {
        return input[output[path - 1]][i] != 0 && Arrays.binarySearch(output, i) <= 0;
    }
}