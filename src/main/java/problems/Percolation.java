package problems;
import datastructures.unionfind.UF;


/**
 * Check if maze is percolatable.
 */
public class Percolation {

    private int n;
    private UF wq;
    private int virtualTop;
    private int virtualBttom;
    private int numberOfOpenSite = 0;
    private boolean[][] opened;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();

        this.n = n;
        wq = new UF(n * n + 2);
        virtualTop = (n * n);
        virtualBttom = (n * n) + 1;
        opened = new boolean[n][n];
    }

    private int xyTo1D(int x, int y) {
        return n * (x - 1) + (y - 1);
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {

        if (!opened[row - 1][col - 1]) {
            opened[row - 1][col - 1] = true;
            numberOfOpenSite++;
            if (row == 1) {
                wq.union(xyTo1D(row, col), virtualTop);
            }
            if (row == n) {
                wq.union(xyTo1D(row, col), virtualBttom);
            }

            if (row > 1 && (isOpen(row - 1, col))) {
                wq.union(xyTo1D(row, col), xyTo1D(row - 1, col));
            }
            if (row < n && (isOpen(row + 1, col))) {
                wq.union(xyTo1D(row, col), xyTo1D(row + 1, col));
            }

            if (col > 1 && (isOpen(row, col - 1))) {
                wq.union(xyTo1D(row, col), xyTo1D(row, col - 1));
            }
            if (col < n && (isOpen(row, col + 1))) {
                wq.union(xyTo1D(row, col), xyTo1D(row, col + 1));
            }
        }


    }

    public int numberOfOpenSites() {
        return numberOfOpenSite;
    }

    public boolean isOpen(int row, int col) {
        return opened[row - 1][col - 1];
    }


    public boolean isFull(int i, int j) {
        if (0 < i && i <= n && 0 < j && j <= n) {
            if (!isOpen(i, j)) return false;
            else return wq.connected(xyTo1D(i, j), virtualTop);
        } else throw new IndexOutOfBoundsException();
    }


    public boolean percolates() {
        return wq.connected(virtualTop, virtualBttom);
    }

}

