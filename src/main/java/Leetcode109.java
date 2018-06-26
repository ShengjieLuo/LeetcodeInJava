import java.util.List;

public class Leetcode109 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }


    private TreeNode buildBST(List<Integer> nums, int left, int right){
        if (left==right) return null;
        int mid = (right+left)/2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left     = buildBST(nums,left,mid);
        node.right    = buildBST(nums,mid+1,right);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode node = head;
        List<Integer> vals = new ArrayList<>();
        while (node!=null){
            vals.add(node.val);
            node = node.next;
        }
        return buildBST(vals,0,vals.size());
    }
}
