package search;

public class DepthFirstTreeSearch {
    public static Node findSolution(State initialConfiguration, GoalTest goalTest) {
        Frontier frontier = new DepthFirstFrontier();
        frontier.addNode(new Node(null, null, initialConfiguration));

        while (!frontier.isEmpty()) {
            Node node = null;
            try {
                node = frontier.removeNode();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (goalTest.isGoal(node.state))
                return node;
            else
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    frontier.addNode(new Node(node, action, newState));
                }


        }
        return null;
    }
}
