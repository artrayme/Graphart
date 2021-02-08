package graph;

import java.util.ArrayList;


public class Graph<NodesType, EdgesType> {
    private final ArrayList<ArrayList<EdgesType>> edges = new ArrayList<>();
    private final ArrayList<NodesType> nodes = new ArrayList<>();

    //Todo iterators
//    private class NodesIterator implements Iterator<NodesType> {
//        Iterator<NodesType> iterator = nodes.iterator();
//
//        @Override
//        public boolean hasNext() {
//            return iterator.hasNext();
//        }
//
//        @Override
//        public NodesType next() {
//            return iterator.next();
//        }
//
//        @Override
//        public void remove() {
//            iterator.remove();
//        }
//    }
//
//    private class EdgesIterator implements Iterator<EdgesType> {
//        Iterator<ArrayList<EdgesType>> iterator = edges.iterator();
//        Iterator<EdgesType> currentIterator = iterator.next().iterator();
//
//        @Override
//        public boolean hasNext() {
//            return iterator.hasNext() || currentIterator.hasNext();
//        }
//
//        @Override
//        public EdgesType next() {
//            if (currentIterator.hasNext()) return currentIterator.next();
//            if (iterator.hasNext()) {
//                currentIterator = iterator.next().iterator();
//                return currentIterator.next();
//            }
//            return null;
//        }
//
//        @Override
//        public void remove() {
//            currentIterator.remove();
//        }
//
//    }

    public Graph() {
    }

    public void addNode(NodesType data) {
        ArrayList<EdgesType> newElement = new ArrayList<EdgesType>();
        for (int i = 0; i < nodes.size(); i++) {
            newElement.add(null);
        }
        nodes.add(data);
        edges.add(newElement);
        for (ArrayList<EdgesType> edge : edges) {
            edge.add(null);
        }
    }

    public void addEdge(int pos1, int pos2, EdgesType data) {
        edges.get(pos1).set(pos2, data);
    }

    public void addArc(int pos1, int pos2, EdgesType data) {
        edges.get(pos1).set(pos2, data);
        edges.get(pos2).set(pos1, data);
    }

    public void removeNode(int pos) {
        nodes.remove(pos);
        edges.remove(pos);
        for (ArrayList<EdgesType> edge : edges) edge.remove(pos);
    }

    public void removeEdge(int pos1, int pos2) {
        edges.get(pos1).set(pos2, null);
    }

    public void removeArc(int pos1, int pos2) {
        edges.get(pos1).set(pos2, null);
        edges.get(pos2).set(pos1, null);
    }

    //Debug info
//    public void print() {
//        for (int i = 0; i < nodes.size(); i++) {
//            System.out.print("     " + nodes.get(i));
//        }
//        System.out.println();
//        for (int i = 0; i < edges.size(); i++) {
//            System.out.print(nodes.get(i) + ":  ");
//            for (int j = 0; j < edges.get(i).size(); j++) {
//                System.out.print(edges.get(i).get(j) + "  ");
//            }
//            System.out.println();
//        }
//    }

    public ArrayList<ArrayList<EdgesType>> getEdges() {
        return edges;
    }

    public ArrayList<NodesType> getNodes() {
        return nodes;
    }
}
