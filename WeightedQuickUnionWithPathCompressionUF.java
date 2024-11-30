//An improvement to the algorithm Weighted Quick Union
//Weighted Quick Union with Path Compression is an enhanced union-find algorithm that combines tree size balancing with path compression, 
//flattening the structure by making nodes point directly to the root during find operations for faster queries.
public class WeightedQuickUnionWithPathCompressionUF {
    private int[] id;
    private int[] size;

    public WeightedQuickUnionWithPathCompressionUF(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];  // Path Compression: apunta a su abuelo, aplanando el árbol
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP == rootQ) return;

        // Weighted Union
        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
}
