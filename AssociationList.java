// Yna Roxas
// CSCI 1913
class AssociationList<Key, Value>
{
    class Node
    {
        private Key key;
        private Value value;
        private Node next;
        private Node(Key key,Value value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Node head;
    public AssociationList()
    {
        head = new Node(null, null, null);
    }

    public void delete(Key key)
    {
        Node left = head;
        Node right = left.next;
        while(right != null)
        {
            if(isEqual(key, right.key))
            {
                left.next = right.next;
                return;
            }
            else
            {
                left = right;
                right = right.next;
            }
        }
        return;
    }

    public Value get(Key key)
    {
        Node where = head.next;
        while(where != null)
        {
            if(isEqual(where.key, key))
            {
                return where.value;
            }
            else
            {
                where = where.next;
            }
        }
        throw new IllegalArgumentException("No Node contains the key param.");
    }

    private boolean isEqual(Key leftKey, Key rightKey)
    {
        if(leftKey == null || rightKey == null)
        {
            return leftKey == rightKey;
        }
        else
        {
            return leftKey.equals(rightKey);
        }
    }

    public boolean isIn(Key key)
    {
        Node where = head.next;
        while(where != null)
        {
            if(isEqual(where.key, key))
            {
                return true;
            }
            else
            {
                where = where.next;
            }
        }
        return false;
    }

    public void put(Key key, Value value)
    {
        Node where = head.next;
        while(where != null)
        {
            if(isEqual(where.key, key))
            {
                where.value = value;
                return;
            }
            else
            {
                where = where.next;
            }
        }
        head.next = new Node(key, value, head.next);
        return;
    }
}
// output from tests10.java
/* false
No null
true
false
true
true
true
false
Lavender
Ginny
null
Wormtail
No Joanne
false
true
null
Ginny
Ginny
Hermione
No Dean */


