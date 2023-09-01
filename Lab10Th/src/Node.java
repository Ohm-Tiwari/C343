class Node implements Comparable<Node> {

    private final int name;
    private int distance = 0;
    private Node path = null;

    Node(int name) {
        this.name = name;
    }

    int getName() {
        return name;
    }

    void setDistance (int distance) { this.distance = distance; }

    int getDistance () { return distance; }

    public void setPath(Node path) {
        this.path = path;
    }

    public Node getPath() {
        return path;
    }

    public int compareTo(Node o) {
        return Integer.compare(distance, o.distance);
    }

    public String toString() {
        return name + "";
    }

    public boolean equals(Object o) {
        if (o instanceof Node) {
            Node that = (Node) o;
            return name == that.getName();
        } else return false;
    }
}