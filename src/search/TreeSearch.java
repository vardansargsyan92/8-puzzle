package search;

public class TreeSearch implements Search {

    private Frontier frontier;
    private int totalNumberOfNodesDuringSearch;

    // we can pass as a  parameter
    // 1.BreadthFirstFrontier
    // 2.DepthFirstFrontier
    public TreeSearch(Frontier frontier) {
        this.frontier = frontier;
    }

    //In this scenario  it's possible to get stack overflow because number of  applicable actions   are infinitive
    //That means that we have to terminate searching process at some point let's say after 9999999 nodes
    @Override
    public Node findSolution(Node rootNode, GoalTest goalTest) {
        totalNumberOfNodesDuringSearch = 0;
        if (!frontier.isEmpty()) {
            frontier.clear();
        }

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
                    frontier.addNode(new Node(node, action, newState));
                    totalNumberOfNodesDuringSearch++;
                }
            }
            if (totalNumberOfNodesDuringSearch > 9999999) {
                System.out.println("Could not find any solution after 10000000 attempt");
                return null;
            }
        }
        return null;

    }

    @Override
    public int getTotalNumberOfNodesDuringSearch() {
        return totalNumberOfNodesDuringSearch;
    }


}
