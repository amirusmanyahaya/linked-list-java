public class LinkedList {
    private Node head;
    public LinkedList(){
        head = null;
    }

    public Node getHead(){
        return head;
    }

    public void setHead(Node head){
        this.head = head;
    }

    public void addNode(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            // the list is empty
            setHead(newNode);
        }else{
            Node currentNode = head;
            while(currentNode != null){
                // handle value less than current
                if(value <= currentNode.getValue()) {
                    newNode.setNext(currentNode);
                    if(currentNode == head){
                        // set new head
                        head = newNode;
                    }
                    break;
                }else{
                    if (currentNode.getNext() == null) {
                        currentNode.setNext(newNode);
                        break;
                    }else{
                        if(currentNode.getNext().getValue() >= value) {
                            newNode.setNext(currentNode.getNext());
                            currentNode.setNext(newNode);
                            break;
                        }
                    }
                }
                currentNode = currentNode.getNext();
            }
        }


    }

    public void removeNode(int value) throws NodeNotFoundExeception{
        // removes the first occurance of a number if it exists
        // if there are no elements in the list, throw an exception
        // if there are elements in the list, iterate over the list unitl you find the element
        // once the element is found, the elemement by setting the next of its parenet to its child
        Node removedNode = null;
        if (head == null) {
            throw new NodeNotFoundExeception("No items in the linked list");
        }

        if (head.getValue() == value) {
            removedNode = head;
            setHead(head.getNext());
            return;
        }
        Node prevNode = getHead();
        Node currentNode = head.getNext();
        while(currentNode != null) {
            if(currentNode.getValue() == value) {
                removedNode = currentNode;
                prevNode.setNext(currentNode.getNext());
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (removedNode == null) {
            // no node has been removed
            throw new NodeNotFoundExeception("Node with value "+value+" was not found");
        }

    }

    public Node findValue(int value) throws NodeNotFoundExeception {
        if (head == null){
            throw new NodeNotFoundExeception("No items in the linked list");
        }
        Node currentNode = head;
        Node foundNode = null;
        while(currentNode != null) {
            if (currentNode.getValue() == value) {
                foundNode = currentNode;
                break;
            }
            currentNode = currentNode.getNext();
        }

        if (foundNode == null) {
            throw new NodeNotFoundExeception(value + " is not found in the linked list");
        }
        return foundNode;
    }

    public void printList(){
        Node currentNode = getHead();
        if (currentNode == null) {
            System.out.println("");
        }else{
            while(currentNode != null){
                System.out.print("Node: "+currentNode.getValue());
                if (currentNode.getNext() != null){
                    System.out.print(" --> ");
                }
                currentNode = currentNode.getNext();
            }
            System.out.println();
        }
    }
}
