//This is the Weighted Quick Union, an improvement from the Quick Union
public class WQuickUnionUF {
    private int[] id;
    private int[] size; 

    public WQuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;  
        }
    }

    private int root(int i) {
        while (i != id[i]) {
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

        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;         
            size[rootQ] += size[rootP]; 
        } else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }
}
