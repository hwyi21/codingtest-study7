package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	class Node{
		private int num ;
		private int x;
		private int y;
		private Node left;
		private Node right;
		
		public Node(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.left = null;
			this.right = null;
		}
		
	}
	
	Node root;
	int idx = 0;
	public Solution() {
		this.root = null;
		int[][] nodeinfo={{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution(nodeinfo);
	}
	
	public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        Node[] arr = new Node[nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++) {
        	arr[i] = new Node((i+1), nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(arr, new Comparator<Node>() {
        	public int compare(Node n1, Node n2) {
                if (n1.y > n2.y) {
                    return -1;
                } else if (n1.y < n2.y) {
                    return 1;
                } else {
                    if (n1.x > n2.x) {
                        return 1;
                    } else if (n1.x < n2.x) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
		});
        
        for(int i=0; i<arr.length; i++) {
        	insert(arr[i]);
        }
        findPre(answer, root);
        idx=0;
        findPost(answer, root);
        return answer;
    }

	public void insert(Node node) {
		if(root==null) { 
			root = node;
		}else {
			Node current = root; 
			Node parent = null;

			while(true) {
				parent = current; 
				if(node.x < parent.x) {
					if(parent.left!=null) { 
						current = current.left;
					}else {
						parent.left=node;
						 return;
					}
				}else { 
					if(parent.right!=null) {
						current = current.right;
					}else {
						parent.right=node;
						 return;
					}
				}

			}
		}
	}
	
	public void findPre(int[][] answer, Node root) {
		if(root != null) {
			answer[0][idx++] = root.num;
			findPre(answer, root.left);
			findPre(answer, root.right);
		}
	}

	public void findPost(int[][] answer, Node root) {
		if(root != null) {
			findPost(answer, root.left);
			findPost(answer, root.right);
			answer[1][idx++] = root.num;
		}
	}
	
	public static void main(String[] args) {
		new Solution();
		
	}

}
