package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {

    private Stack<Node> lifoQueue;
    private int maxNumberOfNodes;

    public DepthFirstFrontier() {
        lifoQueue = new Stack<>();
    }

    @Override
    public void addNode(Node node) {
        lifoQueue.add(node);
        int size = lifoQueue.size();
        maxNumberOfNodes = Math.max(maxNumberOfNodes, size);
    }

    @Override
    public void clear() {
        lifoQueue.clear();
    }

    @Override
    public boolean isEmpty() {
        return lifoQueue.isEmpty();
    }

    @Override
    public Node removeNode() throws Exception {
        if (isEmpty()) {
            throw new Exception("You are not allowed to pop from empty stack");
        }
        return lifoQueue.pop();

    }

    @Override
    public int getMaxNumberOfNodes() {
        return maxNumberOfNodes;
    }
}
