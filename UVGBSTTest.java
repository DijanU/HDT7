/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * HT7, BST
 * 02-04-2024
 */

 import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UVGBSTTest {

    @Test
    public void testAdd() {
        UVGBST<String> tree = new UVGBST<>();
        tree.add("apple", "manzana");
        tree.add("banana", "plátano");
        tree.add("orange", "naranja");
        assertEquals("apple", tree.getRoot().value);
        assertEquals("banana", tree.getRoot().rightChild.value);
        assertEquals("orange", tree.getRoot().rightChild.rightChild.value);
    }

    @Test
    public void testAddNode() {
        UVGBST<String> tree = new UVGBST<>();
        tree.add("banana", "plátano");
        tree.getRoot().addNode("apple", "manzana");
        tree.getRoot().addNode("orange", "naranja");
        assertEquals("apple", tree.getRoot().leftChild.value);
        assertEquals("orange", tree.getRoot().rightChild.value);
    }

    @Test
    public void testGet() {
        UVGBST<String> tree = new UVGBST<>();
        tree.add("apple", "manzana");
        tree.add("banana", "plátano");
        tree.add("orange", "naranja");
        assertEquals("manzana", tree.get("apple"));
        assertEquals("plátano", tree.get("banana"));
        assertEquals("naranja", tree.get("orange"));
        assertNull(tree.get("grape"));
    }

    @Test
    public void testGetNode() {
        UVGBST<String> tree = new UVGBST<>();
        tree.add("apple", "manzana");
        tree.add("banana", "plátano");
        tree.add("orange", "naranja");
        assertEquals("apple", tree.getRoot().getNode("apple").value);
        assertEquals("plátano", tree.getRoot().getNode("banana").value);
        assertEquals("naranja", tree.getRoot().getNode("orange").value);
        assertNull(tree.getRoot().getNode("grape"));
    }
}
