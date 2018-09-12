package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier {

    private Queue<Node> fifoQueue;

    public BreadthFirstFrontier() {
        fifoQueue = new LinkedList<>();
    }

    @Override
    public void addNode(Node node) {
        fifoQueue.add(node);
    }

    @Override
    public void clear() {
        fifoQueue.clear();
    }

    @Override
    public boolean isEmpty() {
        return fifoQueue.isEmpty();
    }

    @Override
    public Node removeNode() throws Exception {
        if (fifoQueue.isEmpty()) throw new Exception("You are not allowed remove from empty queue");
        else return fifoQueue.remove();
    }
}
