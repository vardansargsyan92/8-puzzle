package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier {

    private Queue<Node> fifoQueue;
    private int maxNumberOfNodes;

    public BreadthFirstFrontier() {
        fifoQueue = new LinkedList<>();
        maxNumberOfNodes = 0;
    }

    @Override
    public void addNode(Node node) {
        fifoQueue.add(node);
        int size = fifoQueue.size();
        maxNumberOfNodes = Math.max(maxNumberOfNodes, size);
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

    @Override
    public int getMaxNumberOfNodes() {
        return maxNumberOfNodes;
    }
}
