import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeOfIntsTest {

    @Test
    public void testPutAndGetValues() {
        BinaryTreeOfInts binaryTree = new BinaryTreeOfInts();
        binaryTree.put(5);
        binaryTree.put(2);
        binaryTree.put(8);
        binaryTree.put(1);
        binaryTree.put(3);

        Assertions.assertTrue(binaryTree.hasValue(5));
        Assertions.assertTrue(binaryTree.hasValue(2));
        Assertions.assertTrue(binaryTree.hasValue(8));
        Assertions.assertTrue(binaryTree.hasValue(1));
        Assertions.assertTrue(binaryTree.hasValue(3));
        Assertions.assertFalse(binaryTree.hasValue(10));
    }

    @Test
    public void testGetSumOfAllValues() {
        BinaryTreeOfInts binaryTree = new BinaryTreeOfInts();
        binaryTree.put(5);
        binaryTree.put(2);
        binaryTree.put(8);
        binaryTree.put(1);
        binaryTree.put(3);

        int sum = binaryTree.getSumOfAllValues();
        Assertions.assertEquals(19, sum);
    }

    @Test
    public void testGetValuesInOrder() {
        BinaryTreeOfInts binaryTree = new BinaryTreeOfInts();
        binaryTree.put(5);
        binaryTree.put(2);
        binaryTree.put(8);
        binaryTree.put(1);
        binaryTree.put(3);

        int[] values = binaryTree.getValuesInOrder();
        int[] expectedValues = {8, 5, 3, 2, 1};
        Assertions.assertArrayEquals(expectedValues, values);
    }
}
