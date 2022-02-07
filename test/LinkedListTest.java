import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    void getHead() {
        LinkedList list = new LinkedList();
        assertEquals(null,list.getHead());
    }

    @org.junit.jupiter.api.Test
    void setHead() {
        LinkedList list = new LinkedList();
        Node node = new Node(1);
        list.setHead(node);
        assertEquals(1,list.getHead().getValue());
    }

    @org.junit.jupiter.api.Test
    void addNodeToEmptyList() {
        LinkedList list = new LinkedList();
        list.addNode(2);
        assertEquals(2,list.getHead().getValue());
    }

    @org.junit.jupiter.api.Test
    void addNodeBeforeCurrentHead() {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(1);
        assertEquals(1,list.getHead().getValue());
    }

    @org.junit.jupiter.api.Test
    void addNodeToTheEnd() {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(1);
        list.addNode(0);
        list.addNode(5);
        Node currentNode = list.getHead();
        // loops and returns the last element
        while(currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        assertEquals(5,currentNode.getValue());
    }

    @org.junit.jupiter.api.Test
    void addNodeInBetween() {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(1);
        list.addNode(0);
        list.addNode(5);
        list.addNode(3);
        Node currentNode = list.getHead();
        // loops and returns the last element
        while(currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            if (currentNode.getValue() == 3){
                break;
            }
        }

        assertEquals(5,currentNode.getNext().getValue());
    }


    @org.junit.jupiter.api.Test
    void removeNodeListEmpty() {
        LinkedList list = new LinkedList();
        assertThrows(NodeNotFoundExeception.class, () -> {
            list.removeNode(2);
        });
    }

    @org.junit.jupiter.api.Test
    void removeHeadWithSingleElement() {
        LinkedList list = new LinkedList();
        list.addNode(2);
        try{
            list.removeNode(2);
        }catch (NodeNotFoundExeception e){
            System.out.println("Exception occured: "+e);
        }
        assertEquals(null,list.getHead());
    }

    @org.junit.jupiter.api.Test
    void removeNodeFromTheEnd() {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(1);
        list.addNode(0);
        list.addNode(5);
        try{
            list.removeNode(5);
        }catch (NodeNotFoundExeception e){
            System.out.println("Exception occured: "+e);
        }
        Node currentNode = list.getHead();
        // loops and returns the last element
        while(currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        assertEquals(2,currentNode.getValue());
    }

    @org.junit.jupiter.api.Test
    void removeNodeFromTheMiddle() {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(1);
        list.addNode(0);
        list.addNode(5);
        list.addNode(3);
        try{
            list.removeNode(2);
        }catch (NodeNotFoundExeception e){
            System.out.println("Exception occured: "+e);
        }
        Node currentNode = list.getHead();
        // loops and returns the last element
        while(currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            if (currentNode.getValue() == 1){
                break;
            }
        }

        assertEquals(3,currentNode.getNext().getValue());
    }

    @org.junit.jupiter.api.Test
    void findValueNotInList() {
        LinkedList list = new LinkedList();
        assertThrows(NodeNotFoundExeception.class, () -> {
            list.findValue(1);
        });

    }

    @org.junit.jupiter.api.Test
    void findValueHead() {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(1);
        list.addNode(0);
        list.addNode(5);
        list.addNode(3);
        Node foundNode = null;
        try{
            foundNode = list.findValue(0);
        }catch (NodeNotFoundExeception e){
            System.out.println("Exception occured: "+e);
        }

        assertEquals(0,foundNode.getValue());

    }
}