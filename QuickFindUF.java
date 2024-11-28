//This code is not good because it is too slow being a quadratic algorithm
//Quick Find is an eager approach to the union-find problem that maintains an array where each index represents an element, 
//and its value represents the component id, updating all connected elements during a union operation.
public class QuickFindUF {
	private int[] id;

	public QuickFindUF(int N) {
		id = new int[N];
		for(int i=0; i < N; i++) {
			id[i]=i;
		}
	}
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for(int i = 0; i < id.length; i++) {
			if(id[i]==pid) id[i] = qid;
		}
	}
}
