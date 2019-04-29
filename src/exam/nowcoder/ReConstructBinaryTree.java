package exam.nowcoder;
import java.util.HashMap;
import java.util.Map;

class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
}

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null){
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }

        return preIn(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }

    public TreeNode preIn(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map map){
        if(preStart > preEnd){
            return null;
        }

        TreeNode head = new TreeNode(pre[preStart]);
        int index = (int) map.get(pre[preStart]);
        head.left = preIn(pre, preStart+1, preStart+index-inStart, in, inStart, index-1, map);
        head.right = preIn(pre, preStart+index-inStart+1, preEnd, in, index+1, inEnd, map);

        return head;
    }

    public static void preOrderRec(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public static void main(String[] args){
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};

        ReConstructBinaryTree tree = new ReConstructBinaryTree();
        TreeNode root = tree.reConstructBinaryTree(pre, in);
        preOrderRec(root);
    }
}
