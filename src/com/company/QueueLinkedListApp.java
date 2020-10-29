package com.company;


import java.awt.desktop.QuitEvent;
import java.util.EmptyStackException;
import java.util.Queue;

///////////////////////////////////////////////////////////////////////////////////
class QueueNode{

    // ----------------------------------------------------------------------------
    public String queueString;
    public QueueNode next;

    // ----------------------------------------------------------------------------
    // constructor
    public QueueNode(String qString){

        queueString = qString;
        next = null;
    }

    // ----------------------------------------------------------------------------
    // displayNode()
    public void displayNode(){
        System.out.println("{ " + queueString + " }");
    }
}

///////////////////////////////////////////////////////////////////////////////////
class QueueClassList{
    private QueueNode first;

    // ----------------------------------------------------------------------------
    // constructor
    public QueueClassList () {
        first = null;
    }

    // ----------------------------------------------------------------------------
    // isEmpty()
    public boolean isEmpty(){
        return (first == null);
    }

    // ----------------------------------------------------------------------------
    // getHead(): returns the first node
    public QueueNode getHead(){

        // obtain the first node:
        QueueNode head = first;
        return head;
    }
    // ----------------------------------------------------------------------------
    // insertFirst(string newName)
    public void insertFirst(String newName){

        // add new node to the link:
        QueueNode newQueueNode = new QueueNode(newName);
        newQueueNode.next = first;
        first = newQueueNode;
    }

    // ----------------------------------------------------------------------------
    // deleteFirst()
    public String deleteFirst(){

        // check if list is empty
        if(isEmpty()){
            return null;        // nothing found
        } else {

            QueueNode deleteQueueNode = first;
            first = first.next; // change the reference to the next link
            return deleteQueueNode.queueString;
        }
    } // ends deleteFirst()

    // ----------------------------------------------------------------------------
    // deleteName()
    public QueueNode deleteName(String name){

        if(isEmpty()){
            return null;
        } else {

            // find the node that contains the name first
            QueueNode current = first;
            QueueNode previous = first;

            // checks if the links contain the name or link empty
            while(current.queueString != name){

                if(current.next == null){
                    System.out.println("Sorry, we couldn't find the key you're looking for");
                    System.out.println("We can't remove anything");
                    return null;
                } else {
                    previous = current;
                    current = current.next;
                }
            } // ends check link

            if(current == first){
                first = first.next;
            } else {
                previous.next = current.next; // if found -> bypass it
            }
            return current;
        } // ends if list is empty
    } // ends delete name

    // ----------------------------------------------------------------------------
    // displayList()
    public void displayList(){

        System.out.println("Class list from first -> last");

        QueueNode current = first; // start at the beginning of the list

        while(current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.println("");
    }
} // end QueueClassList


///////////////////////////////////////////////////////////////////////////////////
class QueueList{

    // private members:
    // We're basing our stack on a linked list instead of an array
    private QueueClassList   linkedListQueue;    // list where we store the stack items

    // ----------------------------------------------------------------------------
    //  constructor:
    public QueueList(){

        linkedListQueue = new QueueClassList();
    }

    // ----------------------------------------------------------------------------
    //  dequeue():
    public QueueNode dequeue() throws EmptyStackException {

        // how would we pop from this stack?
        /// remember that you can use methods from ClassList to interact with my queue
        if(linkedListQueue.isEmpty()){
            throw new EmptyLinkQueueException("Cant pop from an empty queue");
        }

        // remove the item from the bottom of the queue, the last added structure:
        // also return the item:

        if(linkedListQueue.getHead() == null)
            return null;

        if(linkedListQueue.getHead().next == null)
            return null;

        // find the second last node
        QueueNode second_last = linkedListQueue.getHead();

        // obtain the second to last node;
        while(second_last.next.next != null){
            second_last = second_last.next;
        }

        // change next of second to last
        // now the second to last element will no longer point to anything
        second_last.next = null;

        return linkedListQueue.getHead();
    }

    // ----------------------------------------------------------------------------
    //  enqueue(String newName):
    public void enqueue(String newName){

        // how would we push to this stack

        // wants to add an item to the top of the stack:
        linkedListQueue.insertFirst(newName);
    }

    // ----------------------------------------------------------------------------
    //  isEmpty():
    public boolean isEmpty(){

        // return true if stack is empty:
        if(linkedListQueue.isEmpty()){
            return true;
        } else {
            return false;
        }
    } // ends isEmpty()

    // ----------------------------------------------------------------------------
    // displayReverseQueue():
    public void displayReverseQueue(QueueNode head){

        // print the stack from top to bottom:
        if(head == null){
            return;
        }

        displayReverseQueue(head.next);

        // print list of head mode:
        System.out.println(head.queueString + " ");
    }

    // ----------------------------------------------------------------------------
    // displayQueue():
    public void displayQueue(){
      displayReverseQueue(linkedListQueue.getHead());
    }

} // end StackList

///////////////////////////////////////////////////////////////////////////////////

class EmptyLinkQueueException extends RuntimeException {

    public EmptyLinkQueueException() {
        this( "Stack is empty" );
    } // end no-argument EmptyLinkQueueException constructor

    // one-argument constructor
    public EmptyLinkQueueException( String exception ) {
        super( exception );
    } // // end one-argument EmptyLinkQueueException constructor
} // end class EmptyLinkQueueException

///////////////////////////////////////////////////////////////////////////////////

public class QueueLinkedListApp {
    public static void main(String[] args) {

        // create linked list:
        // create Queue:
        QueueList queueList = new QueueList();


        // ENQUEUE: 4 strings into the queue
        queueList.enqueue("Catch 22");
        queueList.enqueue("The Lotus & The Pool");
        queueList.enqueue("Linchpin");
        queueList.enqueue("Phantoms in the brain");

        // Print list:
        System.out.println("TEST 1: ENQUEUE - Display everything from Top to Bottom: ");
        queueList.displayQueue();
        System.out.println("");

        // DEQUEUE: 1 string from the list
        System.out.println("Test 2: DEQUEUE - Display everything from bottom -> top after deletion of: ");
        System.out.println("DELETED - CATCH 22");
        queueList.dequeue();
        queueList.displayQueue();

    }
} // ends QueueLinkedListApp
