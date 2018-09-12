package npuzzle;

import search.*;

public class BFTS_Demo {
    public static void main(String[] args) {
        System.out.println("This is a demonstration of breadth-first tree search on 8-puzzle");
        System.out.println();

        Tiles initialConfiguration = new Tiles(new int[][]{
                {7, 4, 2},
                {8, 1, 3},
                {5, 0, 6}
        });


        GoalTest goalTest = new TilesGoalTest();
        Node rootNode = new Node(null, null, initialConfiguration);

        //breadth-first tree search
        System.out.print("............................\n");
        System.out.print("breadth-first tree search \n");
        System.out.print(".............................");
        System.out.println();
        System.out.println();
        Frontier BFTSFrontier = new BreadthFirstFrontier();
        Search BFTSearch = new TreeSearch(BFTSFrontier);
        Node BFTSSolution = BFTSearch.findSolution(rootNode, goalTest);
        System.out.print(String.format("Total Nodes=%s", BFTSearch.getTotalNumberOfNodesDuringSearch())+"\n");
        System.out.print(String.format("Max Nodes=%s", BFTSFrontier.getMaxNumberOfNodes()));
        System.out.println();
        System.out.println();
       // new NPuzzlePrinting().printSolution(BFTSSolution);
        System.out.println();

         //breadth-first graph search
        System.out.print("............................\n");
        System.out.print("breadth-first graph search \n");
        System.out.print(".............................");
        System.out.println();
        System.out.println();
        Frontier BFGSFrontier = new BreadthFirstFrontier();
        Search BFGSearch = new GraphSearch(BFGSFrontier);
        Node BFGSSolution = BFGSearch.findSolution(rootNode, goalTest);
        System.out.print(String.format("Total Nodes=%s", BFGSearch.getTotalNumberOfNodesDuringSearch())+"\n");
        System.out.print(String.format("Max Nodes=%s", BFGSFrontier.getMaxNumberOfNodes()));
        System.out.println();
        System.out.println();
        //new NPuzzlePrinting().printSolution(BFGSSolution);
        System.out.println();


        //depth-first tree search
        System.out.print("............................\n");
        System.out.print("depth-first tree search \n");
        System.out.print(".............................");
        System.out.println();
        System.out.println();
        Frontier DFTSFrontier = new DepthFirstFrontier();
        Search DFTSearch = new TreeSearch(DFTSFrontier);
        Node DFTSSolution = DFTSearch.findSolution(rootNode, goalTest);
        System.out.print(String.format("Total Nodes=%s", DFTSearch.getTotalNumberOfNodesDuringSearch())+"\n");
        System.out.print(String.format("Max Nodes=%s", DFTSFrontier.getMaxNumberOfNodes()));
        System.out.println();
        System.out.println();
        //new NPuzzlePrinting().printSolution(DFTSSolution);
        System.out.println();


        //depth-first graph search
        System.out.print("............................\n");
        System.out.print("depth-first graph search\n");
        System.out.print(".............................");
        System.out.println();
        System.out.println();
        Frontier DFGSFrontier = new DepthFirstFrontier();
        Search DFGSearch = new GraphSearch(DFGSFrontier);
        Node DFGSSolution = DFGSearch.findSolution(rootNode, goalTest);
        System.out.print(String.format("Total Nodes=%s", DFGSearch.getTotalNumberOfNodesDuringSearch())+"\n");
        System.out.print(String.format("Max Nodes=%s", DFGSFrontier.getMaxNumberOfNodes()));
        System.out.println();
        System.out.println();
        //new NPuzzlePrinting().printSolution(DFGSSolution);
        System.out.println();

    }
}
