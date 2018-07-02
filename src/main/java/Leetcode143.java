public class Leetcode143 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {

        if (head==null || head.next==null) return;
        //Find the middle point
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (slowNode!=null&&fastNode!=null&&fastNode.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode midNode  = slowNode;

        //Reverse the second half
        ListNode prev = midNode;
        ListNode post = midNode.next;
        prev.next     = null;
        while (post!=null){
            ListNode tmp = post.next;
            post.next = prev;
            prev = post;
            post = tmp;
        }

        //Combine two queues
        ListNode node1 = head;
        ListNode node2 = prev;
        while (node2!=null){
            ListNode tmpnode1 = node1.next==midNode?null:node1.next;
            ListNode tmpnode2 = node2.next;
            node1.next   = node2;
            if (tmpnode1==null) break;
            node2.next   = tmpnode1;
            node1        = tmpnode1;
            node2        = tmpnode2;
        }

    }
}
