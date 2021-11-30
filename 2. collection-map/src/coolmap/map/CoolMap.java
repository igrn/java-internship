package coolmap.map;

import java.util.Objects;

@SuppressWarnings("unchecked")
public class CoolMap<K, V> {
    Node<K, V>[] nodes;

    public CoolMap() {
        nodes = (Node<K, V>[]) new Node[16];
    }

    public void put(K key, V value) {
        int hash = (key != null) ? key.hashCode() : 0;
        int i = (nodes.length - 1) & hash; //вычисляем индекс корзины (первого узла в корзине!)
        if (i < 0 || i > 16) i = 0;

        if (nodes[i] == null) {
            nodes[i] = buildNode(hash, key, value, null); //если коризины с этим индексом нет, создаем новую
        } else {
            Node<K, V> currentNode = nodes[i];
            Node<K, V> nextNode = nodes[i].next;

            while (true) { // иначе проходим циклом по узлам корзины, чтобы найти совпадение
                if (currentNode.hash == hash && Objects.equals(currentNode.key, key)) {
                    currentNode.value = value;
                    break;
                }
                if (nextNode == null) {
                    nodes[i].next = buildNode(hash, key, value, null);
                    break;
                }
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }
    }

    public V get(K key) {
        int hash = (key != null) ? key.hashCode() : 0;
        int i = (nodes.length - 1) & hash;
        if (i < 0 || i > 16) i = 0;

        if (nodes.length > 0 && nodes[i] != null) {
            if (nodes[i].hash == hash && Objects.equals(nodes[i].key, key)) {
                return nodes[i].value;
            }

            Node<K, V> nextNode = nodes[i].next;
            if (nextNode != null) {
                do {
                    if (nextNode.hash == hash && Objects.equals(nextNode.key, key)) {
                        return nextNode.value;
                    }
                    nextNode = nextNode.next;
                } while (nextNode != null);
            }
        }
        return null;
    }

    private Node<K, V> buildNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }
}
