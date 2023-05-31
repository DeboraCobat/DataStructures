public class BinaryTreeOfInts {

    private class NodeOfInt {
        int value;
        NodeOfInt left, right;
    }

    NodeOfInt root;
    private int nodesCount;

    void put(int value) throws IllegalArgumentException {
    }

    public int getSize() {
        return nodesCount;
    }

    public boolean hasValue(int val) {
        return false;
    }

    public int getSumOfAllValues() {
        return getSumOfThisAndSubNodes(root);
    }

    private int getSumOfThisAndSubNodes(NodeOfInt node) {
        return 0;
    }

    int[] getValuesInOrder() {
        resultArray = new int[nodesCount];
        return resultArray;
    }

    private void collectValuesInOrder(NodeOfInt node) {
    }

    private int[] resultArray;
}
