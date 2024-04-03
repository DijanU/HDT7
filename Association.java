/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * HT7, BST
 * 02-04-2024
 */

public class Association<K extends Comparable<K>, T> implements Comparable<Association<K, T>>{
    /*
       Asociasión de pares adecuada para utilizar con árboles bianarios,
       lo que quiere decir que las llaves son comparable.
     */
    public K key;
    public T data;
    public Association(K cKey, T cData){
        this.key = cKey;
        this.data = cData;
    }
    public int compareTo(Association<K, T> other){
        return this.key.compareTo(other.key);
    }
    public String toString(){
        return key.toString() + ":" + data.toString();
    }
}