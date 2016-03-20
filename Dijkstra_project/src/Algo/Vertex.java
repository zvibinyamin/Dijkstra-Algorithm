package Algo;

import java.util.Vector;

class Vertex implements Comparable<Vertex> {

    public final String name;
    //public Edge[] adjacencies;
    public Vector<Edge> adjacencies;
    public float minDistance = Float.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String argName) {
        name = argName;
        adjacencies = new Vector<Edge>();
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
