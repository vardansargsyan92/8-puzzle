package search;

public class BreadthFirstTreeSearch {
    public static Node findSolution(State initialConfiguration, GoalTest goalTest) {
        Frontier frontier = new BreadthFirstFrontier();
        frontier.addNode(new Node(null, null, initialConfiguration));
        while (!frontier.isEmpty()) {
            Node node = null;
            try {
                node = frontier.removeNode();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.print(e.getMessage());
            }
            if (goalTest.isGoal(node.state))
                return node;
            else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    frontier.addNode(new Node(node, action, newState));
                }
            }
        }
        return null;
    }
}
