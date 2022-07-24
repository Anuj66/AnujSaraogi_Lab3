import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Problem_2 {

    static Node root = null;

    // Inserting element in a BST
    static Node insert(Node root, int element) {
        Node newNode = new Node(element, null, null);
        if (root == null) {
            root = newNode;
            return root;
        }
        Node temp = root;
        Node pTemp = null;
        while (temp != null) {
            pTemp = temp;
            if (temp.val >= element) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (pTemp.val >= element) pTemp.left = newNode;
        else pTemp.right = newNode;
        return root;
    }

    // Displaying BST in order
    static void displayInOrder(Node root) {
        if (root != null) {
            displayInOrder(root.left);
            System.out.print(root.val + ", ");
            displayInOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size, sum = 0;


        try {
            System.out.println("Enter the size of the tree : ");
            size = sc.nextInt();

            System.out.println("Enter the values : ");
            for(int i=0;i<size;i++) {
                int element = sc.nextInt();
                root = Problem_2.insert(root, element);
            }

            System.out.println("Enter the Sum : ");
            sum = sc.nextInt();
        } catch (Exception ex) {
            System.out.println("Invalid Inputs : Please check the values!");
            return;
        }

        System.out.println("In Order Traversal : ");
        Problem_2.displayInOrder(root);
        System.out.println("");

        List<Integer> bstList = new ArrayList<>();
        bstList = treeToList(root, bstList);

        pairCheck(bstList, sum);
    }

    public static List<Integer> treeToList(Node root, List<Integer> arr) {
        if(root != null) {
            treeToList(root.left, arr);
            arr.add(root.val);
            treeToList(root.right, arr);
        }
        return arr;
    }

    public static void pairCheck(List<Integer> arr, int sum) {
        int start = 0;
        int end = arr.size() - 1;
        while(start < end) {
            if((arr.get(start) + arr.get(end)) == sum){
                System.out.println("Pair is (" + arr.get(start) + ", " + arr.get(end) + ")");
                return;
            }
            if((arr.get(start) + arr.get(end)) > sum) {
                end--;
            }
            if((arr.get(start) + arr.get(end)) < sum) {
                start++;
            }
        }
        System.out.println("Nodes are not found");
    }

}
