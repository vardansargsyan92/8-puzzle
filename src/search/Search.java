package search;

public interface Search {

    Node findSolution(Node rootNode, GoalTest goalTest);

    int getTotalNumberOfNodesDuringSearch();

}
