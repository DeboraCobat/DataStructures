import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTree<K extends Comparable<V>, V> {

    @Test
    public void testPutAndGetValues() {
        BinaryTree<String, Integer> binaryTree = new BinaryTree<>();
        binaryTree.put("apple", 5);
        binaryTree.put("banana", 2);
        binaryTree.put("cherry", 8);
        binaryTree.put("date", 1);
        binaryTree.put("elderberry", 3);

        Assertions.assertTrue(binaryTree.hasKey("apple"));
        Assertions.assertTrue(binaryTree.hasKey("banana"));
        Assertions.assertTrue(binaryTree.hasKey("cherry"));
        Assertions.assertTrue(binaryTree.hasKey("date"));
        Assertions.assertTrue(binaryTree.hasKey("elderberry"));
        Assertions.assertFalse(binaryTree.hasKey("grape"));
    }

    @Test
    public void testGetValByKey() {
        BinaryTree<String, Integer> binaryTree = new BinaryTree<>();
        binaryTree.put("apple", 5);
        binaryTree.put("banana", 2);
        binaryTree.put("cherry", 8);
        binaryTree.put("date", 1);
        binaryTree.put("elderberry", 3);

        int value = binaryTree.getValByKey("cherry");
        Assertions.assertEquals(8, value);
    }

    @Test
    public void testGetValByKeyNotFound() {
        BinaryTree<String, Integer> binaryTree = new BinaryTree<>();
        binaryTree.put("apple", 5);
        binaryTree.put("banana", 2);
        binaryTree.put("cherry", 8);

        Assertions.assertThrows(RuntimeException.class, () -> binaryTree.getValByKey("grape"));
    }

    @Test
    public void testGetKeysInOrder() {
        BinaryTree<String, Integer> binaryTree = new BinaryTree<>();
        binaryTree.put("apple", 5);
        binaryTree.put("banana", 2);
        binaryTree.put("cherry", 8);
        binaryTree.put("date", 1);
        binaryTree.put("elderberry", 3);

        String[] keys = binaryTree.getKeysInOrder();
        String[] expectedKeys = {"apple", "banana", "cherry", "date", "elderberry"};
        Assertions.assertArrayEquals(expectedKeys, keys);
    }

    @SuppressWarnings("unchecked")
    public K[] getKeysInOrder() {
        List<K> keysList = new ArrayList<>();
        collectKeysInOrder(root, keysList);
        K[] keysArray = (K[]) new Comparable[keysList.size()];
        keysList.toArray(keysArray);
        return keysArray;
    }

    private void collectKeysInOrder(Node<K, V> node, List<K> keysList) {
        if (node != null) {
            collectKeysInOrder(node.left, keysList);
            keysList.add(node.key);
            collectKeysInOrder(node.right, keysList);
        }
    }
}

