package com.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int nRows = matrix.length;
        int nColumns = matrix[0].length;
        int size = nRows*nColumns;
        int x = 0;
        int y = 0;
        int dx = 1;
        int dy = 0;
        List<Integer> res = new ArrayList<>();

        for (int i=0; i<size; i++) {

            res.add(matrix[y][x]);

            matrix[y][x] = -101;

            // check if next position is invalid and switch directions if true
            if ( !(0 <= x+dx && x+dx < nColumns) || !(0 <= y+dy && y+dy < nRows) || (matrix[y+dy][x+dx] == -101)) {
                int temp = dx;
                dx = -dy;
                dy = temp;
            }

            x += dx;
            y += dy;

        }

        return res;

    }
}
