package comp2402a4;

import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class GeometricTree extends BinaryTree<GeometricTreeNode> {

	public GeometricTree() {
		super (new GeometricTreeNode());
	}

	public void inorderDraw() {
		assignLevels();
		// TODO: use your code here instead

		//find root node using method from BinaryTree class
		GeometricTreeNode root = firstNode();

		//loop through tree using indorder traverse given in BinaryTree class
		int i = 0;
		while (root != nil) {
			//give position of node value of i
			root.position.x = i;
			root = nextNode(root);
			i++;
		}


	}


	protected void randomX(GeometricTreeNode u, Random r) {
		if (u == null) return;
		u.position.x = r.nextInt(60);
		randomX(u.left, r);
		randomX(u.right, r);
	}


	/**
	 * Draw each node so that it's x-coordinate is as small
	 * as possible without intersecting any other node at the same level
	 * the same as its parent's
	 */
	public void leftistDraw() {
		assignLevels();

		Queue<GeometricTreeNode> queue = new LinkedList<GeometricTreeNode>();

		//get root node
		GeometricTreeNode p = r;
		//set root position to 0
		p.position.x = 0;
		//add root node to queue
		queue.add(p);

		//loop through tree in breadth first traverse
		while (!queue.isEmpty()) {
			//get current node from queue
			GeometricTreeNode c = queue.remove();

			//if current node is same y, then x must be ++
			c.position.x = (p.position.y == c.position.y) ? p.position.x + 1 : 0;

			//ensure root is at .x = 0
			if (c == r) {
				c.position.x = 0;
			}

			//set parent node to current node
			p = c;

			//add child nodes if not null
			//left then right to follow bfs
			if (c.left != nil) {
				queue.add(c.left);
			}
			if (c.right != nil) {
				queue.add(c.right);
			}
		}

	}

	HashMap<GeometricTreeNode, Integer> map;
	int ref = 0;

	public void balancedDraw() {
		assignLevels();
		//get hashmap with values of sizes
		//redefines reference for x to 0
		ref = 0;

		//initiate HashMap
		map = new HashMap<GeometricTreeNode, Integer>();

		//recursive method for size of node subtree
		nodeSize(r);
		//recursive preorder since we need to compare root before looking at leaves
		coordinate(r, 0, 0);
	}

	public int nodeSize(GeometricTreeNode node) {
		//base case
		if (node == nil) {
			return 0;
		} else {
			//recursive call that adds node as key and size of subtree as value
			map.put(node, 1 + (nodeSize(node.left) + nodeSize(node.right)));
			//returns size of current node and subtree sizes
			return map.get(node);
		}
	}

	public void coordinate(GeometricTreeNode n, int x, int y) {
		//base case
		if (n == nil) {
			return;
		}

		//give x, y to current node
		n.position.x = x;
		n.position.y = y;

		//need to give a reference for x so that it does not overlap subtrees
		if (x > ref) {
			ref = x;
		}

		//check if left node exists and right is null
		if (n.left != nil && n.right == nil) {
			//recurse to left node
			coordinate(n.left, ref + 1, y);
		} else if (n.left != nil && n.right != nil) {
			//compare left and right child node by size
			if (map.get(n.right) < map.get(n.left)) {
				//this goes to smaller node first as assignment has asked
				coordinate(n.right, x, y + 1);
				coordinate(n.left, ref + 1, y);
			} else {
				//other way if left is smaller
				coordinate(n.left, x, y + 1);
				coordinate(n.right, ref + 1, y);
			}
		} else {
			//if left is nil and right is not
			coordinate(n.right, ref + 1, y);
		}
	}


	protected void assignLevels() {
		assignLevels(r, 0);
	}

	protected void assignLevels(GeometricTreeNode u, int i) {
		if (u == null) return;
		u.position.y = i;
		assignLevels(u.left, i+1);
		assignLevels(u.right, i+1);
	}

	public static void main(String[] args) {
		GeometricTree t = new GeometricTree();
		galtonWatsonTree(t, 100);
		System.out.println(t);
		t.inorderDraw();
		System.out.println(t);
	}

}
