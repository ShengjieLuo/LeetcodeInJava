
public class Leetcode138 {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head==null) return null;
        RandomListNode node = head;

        //Insert a backup after current node
        while (node!=null){
            RandomListNode tmp = new RandomListNode(node.label);
            tmp.next = node.next;
            node.next = tmp;
            node = tmp.next;
        }

        //Modify the random
        node = head;
        while (node!=null){
            RandomListNode bak = node.next;
            if (node.random==null) {
                bak.random = null;
            } else {
                bak.random = node.random.next;
            }
            node= node.next.next;
        }

        //Extract the backup node
        node = head;
        RandomListNode result = head.next;
        while (node!=null&&node.next!=null){
            //System.out.printf("node:%d node.next:%d\n",node.label,node.next.label);
            RandomListNode tmp = node.next;
            node.next = node.next.next;
            node = tmp;
        }

        return result;
    }

}
