package june.bt;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMain {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	static class BinaryTree{
		static  int idx=-1;
		public static Node buildTree(int nodes[]) {
			idx++;
			if(nodes[idx]==-1) {
				return null;
			}
			Node newNode =  new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);
			return newNode;	
		}
	}
	/// preorder CP O(n)
	public static void preOrder(Node root) {
		if(root==null) {
			//System.out.print(-1+" ");
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	/// inOrder CP O(n)
	public static void inOrder(Node root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
		
	}
	/// postOrder CP O(n)
	public static void postOrder(Node root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public static void levelOrderTraversal(Node root){
		if(root==null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node currNode=q.remove();
			if(currNode==null) {
				System.out.println();
				if(q.isEmpty()) {
					break;
				}else {
					q.add(null);
				}
			}else {
				System.out.print(currNode.data+" ");
				if(currNode.left!=null) {
					q.add(currNode.left);
				}
				if(currNode.right!=null) {
					q.add(currNode.right);
				}
				
			}
		}
	}
	// Cp O(n)
	public static int countOfNode(Node root) {
		if(root == null) {
			return 0;
		}
		int leftNode=countOfNode(root.left);
		int rightNode= countOfNode(root.right);
		return leftNode+rightNode+1;
	}
	// sum of tree O(n) 
	public static int sumOfNodes(Node root) {
		if(root == null) {
			return 0;
		} 
		
		int leftNode=sumOfNodes(root.left);
		int rightNode=sumOfNodes(root.right);
		return leftNode+rightNode+root.data;
	}
	// cp O(n) 
	public static int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		} 
		int leftHeight =heightOfTree(root.left);
		int rightHeight =heightOfTree(root.right);
		int myHeight = Math.max(leftHeight, rightHeight) +1;
		return myHeight;
	}
	// Cp O(n^2)
	public static int diameter(Node root) {
		if(root == null) {
			return 0;
		} 
		int diam1=diameter(root.left);
		int diam2=diameter(root.right);
		int diam3=heightOfTree(root.left) + heightOfTree(root.right) +1;
		return Math.max(diam3, Math.max(diam1, diam2));
	}
	
	static class TreeInfo{
		int ht;
		int diam;
		 TreeInfo(int ht,int diam) {
			this.ht=ht;
			this.diam=diam;
		}
	}
	// Cp O(n)
	public static TreeInfo diameter2(Node root) {
		if(root==null) {
			return new TreeInfo(0, 0);
		}
		TreeInfo left = diameter2(root.left);
		TreeInfo right= diameter2(root.right);
		int mHeight= Math.max(left.ht, right.ht) +1;
		int diam1=left.diam;
		int diam2= right.diam;
		
		int diam3= left.ht+right.ht+1;
		int mydiam= Math.max(Math.max(diam1, diam2), diam3);
		TreeInfo myInfo= new TreeInfo(mHeight, mydiam);
		return myInfo;
	}
	
	
	public static void main(String[] args) {
		int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		//BinaryTree tree = new BinaryTree();
		Node root=BinaryTree.buildTree(nodes);
		System.out.println(root.data);
		preOrder(root);
		System.out.println("");
		inOrder(root);
		System.out.println(" ");
		postOrder(root);
		
		System.out.println(" ");
		levelOrderTraversal(root);
		
		System.out.println();
		System.out.println(countOfNode(root));
		System.out.println(sumOfNodes(root));
		
		System.out.println(heightOfTree(root));
		System.out.println(diameter(root));
		System.out.println(diameter2(root).diam);
	}
}
