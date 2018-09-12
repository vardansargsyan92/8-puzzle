package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {

    private Stack<Node> lifoQueue;

    public DepthFirstFrontier() {
        this.lifoQueue = new Stack<>();
    }

    @Override
    public void addNode(Node node) {
        lifoQueue.add(node);
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
}
