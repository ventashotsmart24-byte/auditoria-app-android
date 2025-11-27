package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    @CheckForNull
    public transient Node<K, V> head;
    /* access modifiers changed from: private */
    public transient Map<K, KeyList<K, V>> keyToKeyList;
    /* access modifiers changed from: private */
    public transient int modCount;
    /* access modifiers changed from: private */
    public transient int size;
    /* access modifiers changed from: private */
    @CheckForNull
    public transient Node<K, V> tail;

    public class DistinctKeyIterator implements Iterator<K> {
        @CheckForNull
        Node<K, V> current;
        int expectedModCount;
        @CheckForNull
        Node<K, V> next;
        final Set<K> seenKeys;

        private DistinctKeyIterator() {
            this.seenKeys = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.next = LinkedListMultimap.this.head;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.next != null) {
                return true;
            }
            return false;
        }

        @ParametricNullness
        public K next() {
            Node<K, V> node;
            checkForConcurrentModification();
            Node<K, V> node2 = this.next;
            if (node2 != null) {
                this.current = node2;
                this.seenKeys.add(node2.key);
                do {
                    node = this.next.next;
                    this.next = node;
                    if (node == null || this.seenKeys.add(node.key)) {
                    }
                    node = this.next.next;
                    this.next = node;
                    break;
                } while (this.seenKeys.add(node.key));
                return this.current.key;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            boolean z10;
            checkForConcurrentModification();
            if (this.current != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.removeAllNodes(this.current.key);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }
    }

    public static class KeyList<K, V> {
        int count = 1;
        Node<K, V> head;
        Node<K, V> tail;

        public KeyList(Node<K, V> node) {
            this.head = node;
            this.tail = node;
            node.previousSibling = null;
            node.nextSibling = null;
        }
    }

    public static final class Node<K, V> extends AbstractMapEntry<K, V> {
        @ParametricNullness
        final K key;
        @CheckForNull
        Node<K, V> next;
        @CheckForNull
        Node<K, V> nextSibling;
        @CheckForNull
        Node<K, V> previous;
        @CheckForNull
        Node<K, V> previousSibling;
        @ParametricNullness
        V value;

        public Node(@ParametricNullness K k10, @ParametricNullness V v10) {
            this.key = k10;
            this.value = v10;
        }

        @ParametricNullness
        public K getKey() {
            return this.key;
        }

        @ParametricNullness
        public V getValue() {
            return this.value;
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V v10) {
            V v11 = this.value;
            this.value = v10;
            return v11;
        }
    }

    public class NodeIterator implements ListIterator<Map.Entry<K, V>> {
        @CheckForNull
        Node<K, V> current;
        int expectedModCount;
        @CheckForNull
        Node<K, V> next;
        int nextIndex;
        @CheckForNull
        Node<K, V> previous;

        public NodeIterator(int i10) {
            this.expectedModCount = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(i10, size);
            if (i10 < size / 2) {
                this.next = LinkedListMultimap.this.head;
                while (true) {
                    int i11 = i10 - 1;
                    if (i10 <= 0) {
                        break;
                    }
                    next();
                    i10 = i11;
                }
            } else {
                this.previous = LinkedListMultimap.this.tail;
                this.nextIndex = size;
                while (true) {
                    int i12 = i10 + 1;
                    if (i10 >= size) {
                        break;
                    }
                    previous();
                    i10 = i12;
                }
            }
            this.current = null;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.next != null) {
                return true;
            }
            return false;
        }

        public boolean hasPrevious() {
            checkForConcurrentModification();
            if (this.previous != null) {
                return true;
            }
            return false;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void remove() {
            boolean z10;
            checkForConcurrentModification();
            if (this.current != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "no calls to next() since the last call to remove()");
            Node<K, V> node = this.current;
            if (node != this.next) {
                this.previous = node.previous;
                this.nextIndex--;
            } else {
                this.next = node.next;
            }
            LinkedListMultimap.this.removeNode(node);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        public void setValue(@ParametricNullness V v10) {
            boolean z10;
            if (this.current != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10);
            this.current.value = v10;
        }

        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        public Node<K, V> next() {
            checkForConcurrentModification();
            Node<K, V> node = this.next;
            if (node != null) {
                this.current = node;
                this.previous = node;
                this.next = node.next;
                this.nextIndex++;
                return node;
            }
            throw new NoSuchElementException();
        }

        @CanIgnoreReturnValue
        public Node<K, V> previous() {
            checkForConcurrentModification();
            Node<K, V> node = this.previous;
            if (node != null) {
                this.current = node;
                this.next = node;
                this.previous = node.previous;
                this.nextIndex--;
                return node;
            }
            throw new NoSuchElementException();
        }

        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Node<K, V> addNode(@ParametricNullness K k10, @ParametricNullness V v10, @CheckForNull Node<K, V> node) {
        Node<K, V> node2 = new Node<>(k10, v10);
        if (this.head == null) {
            this.tail = node2;
            this.head = node2;
            this.keyToKeyList.put(k10, new KeyList(node2));
            this.modCount++;
        } else if (node == null) {
            Node<K, V> node3 = this.tail;
            Objects.requireNonNull(node3);
            node3.next = node2;
            node2.previous = this.tail;
            this.tail = node2;
            KeyList keyList = this.keyToKeyList.get(k10);
            if (keyList == null) {
                this.keyToKeyList.put(k10, new KeyList(node2));
                this.modCount++;
            } else {
                keyList.count++;
                Node<K, V> node4 = keyList.tail;
                node4.nextSibling = node2;
                node2.previousSibling = node4;
                keyList.tail = node2;
            }
        } else {
            KeyList keyList2 = this.keyToKeyList.get(k10);
            Objects.requireNonNull(keyList2);
            keyList2.count++;
            node2.previous = node.previous;
            node2.previousSibling = node.previousSibling;
            node2.next = node;
            node2.nextSibling = node;
            Node<K, V> node5 = node.previousSibling;
            if (node5 == null) {
                keyList2.head = node2;
            } else {
                node5.nextSibling = node2;
            }
            Node<K, V> node6 = node.previous;
            if (node6 == null) {
                this.head = node2;
            } else {
                node6.next = node2;
            }
            node.previous = node2;
            node.previousSibling = node2;
        }
        this.size++;
        return node2;
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    private List<V> getCopy(@ParametricNullness K k10) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(k10)));
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* access modifiers changed from: private */
    public void removeAllNodes(@ParametricNullness K k10) {
        Iterators.clear(new ValueForKeyIterator(k10));
    }

    /* access modifiers changed from: private */
    public void removeNode(Node<K, V> node) {
        Node<K, V> node2 = node.previous;
        if (node2 != null) {
            node2.next = node.next;
        } else {
            this.head = node.next;
        }
        Node<K, V> node3 = node.next;
        if (node3 != null) {
            node3.previous = node2;
        } else {
            this.tail = node2;
        }
        if (node.previousSibling == null && node.nextSibling == null) {
            KeyList remove = this.keyToKeyList.remove(node.key);
            Objects.requireNonNull(remove);
            remove.count = 0;
            this.modCount++;
        } else {
            KeyList keyList = this.keyToKeyList.get(node.key);
            Objects.requireNonNull(keyList);
            keyList.count--;
            Node<K, V> node4 = node.previousSibling;
            if (node4 == null) {
                Node<K, V> node5 = node.nextSibling;
                Objects.requireNonNull(node5);
                keyList.head = node5;
            } else {
                node4.nextSibling = node.nextSibling;
            }
            Node<K, V> node6 = node.nextSibling;
            if (node6 == null) {
                Node<K, V> node7 = node.previousSibling;
                Objects.requireNonNull(node7);
                keyList.tail = node7;
            } else {
                node6.previousSibling = node.previousSibling;
            }
        }
        this.size--;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    public /* bridge */ /* synthetic */ boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.AsMap(this);
    }

    public Set<K> createKeySet() {
        return new Sets.ImprovedAbstractSet<K>() {
            public boolean contains(@CheckForNull Object obj) {
                return LinkedListMultimap.this.containsKey(obj);
            }

            public Iterator<K> iterator() {
                return new DistinctKeyIterator();
            }

            public boolean remove(@CheckForNull Object obj) {
                return !LinkedListMultimap.this.removeAll(obj).isEmpty();
            }

            public int size() {
                return LinkedListMultimap.this.keyToKeyList.size();
            }
        };
    }

    public Multiset<K> createKeys() {
        return new Multimaps.Keys(this);
    }

    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness K k10, @ParametricNullness V v10) {
        addNode(k10, v10, (Node) null);
        return true;
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return super.remove(obj, obj2);
    }

    public int size() {
        return this.size;
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private LinkedListMultimap(int i10) {
        this.keyToKeyList = Platform.newHashMapWithExpectedSize(i10);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i10) {
        return new LinkedListMultimap<>(i10);
    }

    public List<Map.Entry<K, V>> createEntries() {
        return new AbstractSequentialList<Map.Entry<K, V>>() {
            public ListIterator<Map.Entry<K, V>> listIterator(int i10) {
                return new NodeIterator(i10);
            }

            public int size() {
                return LinkedListMultimap.this.size;
            }
        };
    }

    public List<V> createValues() {
        return new AbstractSequentialList<V>() {
            public ListIterator<V> listIterator(int i10) {
                final NodeIterator nodeIterator = new NodeIterator(i10);
                return new TransformedListIterator<Map.Entry<K, V>, V>(this, nodeIterator) {
                    public void set(@ParametricNullness V v10) {
                        nodeIterator.setValue(v10);
                    }

                    @ParametricNullness
                    public V transform(Map.Entry<K, V> entry) {
                        return entry.getValue();
                    }
                };
            }

            public int size() {
                return LinkedListMultimap.this.size;
            }
        };
    }

    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    public List<V> get(@ParametricNullness final K k10) {
        return new AbstractSequentialList<V>() {
            public ListIterator<V> listIterator(int i10) {
                return new ValueForKeyIterator(k10, i10);
            }

            public int size() {
                KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(k10);
                if (keyList == null) {
                    return 0;
                }
                return keyList.count;
            }
        };
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean putAll(@ParametricNullness Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @CanIgnoreReturnValue
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @CanIgnoreReturnValue
    public List<V> replaceValues(@ParametricNullness K k10, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k10);
        ValueForKeyIterator valueForKeyIterator = new ValueForKeyIterator(k10);
        Iterator<? extends V> it = iterable.iterator();
        while (valueForKeyIterator.hasNext() && it.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.set(it.next());
        }
        while (valueForKeyIterator.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.remove();
        }
        while (it.hasNext()) {
            valueForKeyIterator.add(it.next());
        }
        return copy;
    }

    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    public class ValueForKeyIterator implements ListIterator<V> {
        @CheckForNull
        Node<K, V> current;
        @ParametricNullness
        final K key;
        @CheckForNull
        Node<K, V> next;
        int nextIndex;
        @CheckForNull
        Node<K, V> previous;

        public ValueForKeyIterator(@ParametricNullness K k10) {
            Node<K, V> node;
            this.key = k10;
            KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(k10);
            if (keyList == null) {
                node = null;
            } else {
                node = keyList.head;
            }
            this.next = node;
        }

        public void add(@ParametricNullness V v10) {
            this.previous = LinkedListMultimap.this.addNode(this.key, v10, this.next);
            this.nextIndex++;
            this.current = null;
        }

        public boolean hasNext() {
            if (this.next != null) {
                return true;
            }
            return false;
        }

        public boolean hasPrevious() {
            if (this.previous != null) {
                return true;
            }
            return false;
        }

        @ParametricNullness
        @CanIgnoreReturnValue
        public V next() {
            Node<K, V> node = this.next;
            if (node != null) {
                this.current = node;
                this.previous = node;
                this.next = node.nextSibling;
                this.nextIndex++;
                return node.value;
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        @ParametricNullness
        @CanIgnoreReturnValue
        public V previous() {
            Node<K, V> node = this.previous;
            if (node != null) {
                this.current = node;
                this.next = node;
                this.previous = node.previousSibling;
                this.nextIndex--;
                return node.value;
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void remove() {
            boolean z10;
            if (this.current != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10, "no calls to next() since the last call to remove()");
            Node<K, V> node = this.current;
            if (node != this.next) {
                this.previous = node.previousSibling;
                this.nextIndex--;
            } else {
                this.next = node.nextSibling;
            }
            LinkedListMultimap.this.removeNode(node);
            this.current = null;
        }

        public void set(@ParametricNullness V v10) {
            boolean z10;
            if (this.current != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            Preconditions.checkState(z10);
            this.current.value = v10;
        }

        public ValueForKeyIterator(@ParametricNullness K k10, int i10) {
            int i11;
            Node<K, V> node;
            Node<K, V> node2;
            KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(k10);
            if (keyList == null) {
                i11 = 0;
            } else {
                i11 = keyList.count;
            }
            Preconditions.checkPositionIndex(i10, i11);
            if (i10 < i11 / 2) {
                if (keyList == null) {
                    node = null;
                } else {
                    node = keyList.head;
                }
                this.next = node;
                while (true) {
                    int i12 = i10 - 1;
                    if (i10 <= 0) {
                        break;
                    }
                    next();
                    i10 = i12;
                }
            } else {
                if (keyList == null) {
                    node2 = null;
                } else {
                    node2 = keyList.tail;
                }
                this.previous = node2;
                this.nextIndex = i11;
                while (true) {
                    int i13 = i10 + 1;
                    if (i10 >= i11) {
                        break;
                    }
                    previous();
                    i10 = i13;
                }
            }
            this.key = k10;
            this.current = null;
        }
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }
}
