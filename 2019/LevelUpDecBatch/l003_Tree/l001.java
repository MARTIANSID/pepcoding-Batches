import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class l001 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void levelOrderSimple(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        while (que.size() != 0) {
            TreeNode rn = que.removeFirst(); // rn : remove Node
            System.out.print(rn.val + " ");

            if (rn.left != null)
                que.addLast(rn.left);
            if (rn.right != null)
                que.addLast(rn.right);
        }
    }

    public static void levelOrderLineWise_M1(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        LinkedList<TreeNode> childQue = new LinkedList<>();

        que.addLast(root);
        int level = 0;
        System.out.print("Level " + level + " : ");
        while (que.size() != 0) {
            TreeNode rn = que.removeFirst(); // rn : remove Node
            System.out.print(rn.val + " ");

            if (rn.left != null)
                childQue.addLast(rn.left);
            if (rn.right != null)
                childQue.addLast(rn.right);

            if (que.size() == 0) {
                System.out.println();
                System.out.print("Level " + (++level) + " : ");

                LinkedList<TreeNode> temp = que;
                que = childQue;
                childQue = temp;
            }

        }
    }

    public static void levelOrderLineWise_M2(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();

        que.addLast(root);
        que.addLast(null);

        int level = 0;
        System.out.print("Level " + level + " : ");
        while (que.size() != 1) {
            TreeNode rn = que.removeFirst(); // rn : remove Node
            System.out.print(rn.val + " ");

            if (rn.left != null)
                que.addLast(rn.left);
            if (rn.right != null)
                que.addLast(rn.right);

            if (que.getFirst() == null) {
                System.out.println();
                System.out.print("Level " + (++level) + " : ");
                que.addLast(que.removeFirst());
            }

        }
    }

    public static void levelOrderLineWise_M3(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();

        que.addLast(root);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            System.out.print("Level " + level + " : ");

            while (size-- > 0) {
                TreeNode rn = que.removeFirst(); // rn : remove Node
                System.out.print(rn.val + " ");

                if (rn.left != null)
                    que.addLast(rn.left);
                if (rn.right != null)
                    que.addLast(rn.right);
            }

            level++;
            System.out.println();
        }
    }

    // 102
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        LinkedList<TreeNode> que = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        que.addLast(root);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();

            while (size-- > 0) {
                TreeNode rn = que.removeFirst(); // rn : remove Node
                if (level == ans.size())
                    ans.add(new ArrayList<>());
                ans.get(level).add(rn.val);

                if (rn.left != null)
                    que.addLast(rn.left);
                if (rn.right != null)
                    que.addLast(rn.right);
            }

            level++;
        }

        return ans;
    }

    public static void leftView(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            System.out.print(que.getFirst().val + " ");
            while (size-- > 0) {
                TreeNode rn = que.removeFirst(); // rn : remove Node

                if (rn.left != null)
                    que.addLast(rn.left);
                if (rn.right != null)
                    que.addLast(rn.right);
            }

            level++;
            System.out.println();
        }
    }

    public static void rightView(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        int level = 0;
        while (que.size() != 0) {
            int size = que.size();
            System.out.print(que.getFirst().val + " ");
            while (size-- > 0) {
                TreeNode rn = que.removeFirst(); // rn : remove Node

                if (rn.right != null)
                    que.addLast(rn.right);
                if (rn.left != null)
                    que.addLast(rn.left);
            }

            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}