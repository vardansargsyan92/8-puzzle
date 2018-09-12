package search;

import java.util.HashSet;

public class GraphSearch implements Search {

    private Frontier frontier;
    private int totalNumberOfNodesDuringSearch;

    public GraphSearch(Frontier frontier) {
        this.frontier = frontier;
    }


    // In order to find solution we should add extra hash set in order
    // to indicate  if the state has already considered or no
    @Override
    public Node findSolution(Node rootNode, GoalTest goalTest) {
        totalNumberOfNodesDuringSearch = 0;
        if (!frontier.isEmpty()) {
            frontier.clear();
        }


        HashSet<State> openHash = new HashSet<>();

        frontier.addNode(rootNode);
        totalNumberOfNodesDuringSearch++;

        while (!frontier.isEmpty()) {
            Node node = null;
            try {
                node = frontier.removeNode();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (goalTest.isGoal(node.state))
                return node;
            else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    boolean notConsidered = openHash.add(newState);
                    if (notConsidered) {
                        frontier.addNode(new Node(node, action, newState));
                        totalNumberOfNodesDuringSearch++;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int getTotalNumberOfNodesDuringSearch() {
        return totalNumberOfNodesDuringSearch;
    }
}
