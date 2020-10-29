package com.company;

import java.awt.print.Book;
import java.util.EmptyStackException;
import java.util.Stack;

///////////////////////////////////////////////////////////////////////////////////
class PersonNode{

    // ----------------------------------------------------------------------------
    public String studentName;
    public PersonNode next;

    // ----------------------------------------------------------------------------
    // constructor
    public PersonNode(String sName){

        studentName = sName;
        next = null;
    }

    // ----------------------------------------------------------------------------
    // displayNode()
    public void displayNode(){
        System.out.println("{ " + studentName + " }");
    }

}

///////////////////////////////////////////////////////////////////////////////////
class ClassList{
    private PersonNode first;

    // ----------------------------------------------------------------------------
    // constructor
    public ClassList () {
        first = null;
    }

    // ----------------------------------------------------------------------------
    // isEmpty()
    public boolean isEmpty(){
        return (first == null);
    }

    // ----------------------------------------------------------------------------
    // getHead(): returns the first node
    public PersonNode getHead(){

        // obtain the first node:
        PersonNode head = first;
        return head;
    }
    // ----------------------------------------------------------------------------
    // insertFirst(string newName)
    public void insertFirst(String newName){

        // add new node to the link:
        PersonNode newPerson = new PersonNode(newName);
        newPerson.next = first;
        first = newPerson;
    }

    // ----------------------------------------------------------------------------
    // deleteFirst()
    public String deleteFirst(){

        // check if list is empty
        if(isEmpty()){
            return null;        // nothing found
        } else {

            PersonNode deletePerson = first;
            first = first.next; // change the reference to the next link
            return deletePerson.studentName;
        }
    } // ends deleteFirst()

    // ----------------------------------------------------------------------------
    // deleteName()
    public PersonNode deleteName(String name){

        if(isEmpty()){
            return null;
        } else {

            // find the node that contains the name first
            PersonNode current = first;
            PersonNode previous = first;

            // checks if the links contain the name or link empty
            while(current.studentName != name){

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

        PersonNode current = first; // start at the beginning of the list

        while(current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.println("");
    }
} // end classlist

///////////////////////////////////////////////////////////////////////////////////
class StackList{

    // private members:
    // We're basing our stack on a linked list instead of an array
    private ClassList   linkedListStack;    // list where we store the stack items

    // ----------------------------------------------------------------------------
    //  constructor:
    public StackList(){

        linkedListStack = new ClassList();
    }

    // ----------------------------------------------------------------------------
    //  pop():
    public PersonNode pop() throws EmptyStackException {

        // how would we pop from this stack?
        /// remember that you can use methods from ClassList to interact with my stack
        if(linkedListStack.isEmpty()){
            throw new EmptyLinkStackException("Cant pop from an empty stack");
        }

        // remove the item from the top of the stack, the last added structure:
        // also return the item:
        String popValue = linkedListStack.deleteFirst();

        return new PersonNode(popValue);
    }

    // ----------------------------------------------------------------------------
    //  push(String newName):
    public void push(String newName){

        // how would we push to this stack

        // wants to add an item to the top of the stack:
        linkedListStack.insertFirst(newName);
    }

    // ----------------------------------------------------------------------------
    //  isEmpty():
    public boolean isEmpty(){

        // return true if stack is empty:
        if(linkedListStack.isEmpty()){
            return true;
        } else {
            return false;
        }
    } // ends isEmpty()

    // ----------------------------------------------------------------------------
    // displayReverseStack():
    public void displayReverseStack(PersonNode head){

        // print the stack from top to bottom:
        if(head == null){
            return;
        }

        displayReverseStack(head.next);

        // print list of head mode:
        System.out.println(head.studentName + " ");
    }


    public void displayEverything() {
        displayReverseStack(linkedListStack.getHead());
    }
} // end StackList

///////////////////////////////////////////////////////////////////////////////////

class EmptyLinkStackException extends RuntimeException {

    public EmptyLinkStackException() {
        this( "Stack is empty" );
    } // end no-argument EmptyLinkStackException constructor

    // one-argument constructor
    public EmptyLinkStackException( String exception ) {
        super( exception );
    } // // end one-argument EmptyLinkStackException constructor
} // end class EmptyLinkStackException

///////////////////////////////////////////////////////////////////////////////////

public class StackLinkedListApp {
    public static void main(String[] args) {

        // create Linked List:
        // create Stack List:
        StackList BookStack = new StackList();

        // PUSH: 4 strings into the stack list:
        BookStack.push("Catch 22");
        BookStack.push("The Lotus & The Pool");
        BookStack.push("Linchpin");
        BookStack.push("Phantoms in the brain");

        // print list:
        System.out.println("Test 1: PUSH - Display everything from bottom -> top ");
        BookStack.displayEverything();
        System.out.println("");

        // POP: 1 strings into the stack list:
        System.out.println("Test 2: POP - Display everything from bottom -> top after deletion of: ");
        System.out.println("DELETED - Phantoms in the brain");
        BookStack.pop(); // this will delete String: Phantoms in the brain
        BookStack.displayEverything();

    }
}

/*
*
Test:

        // create node:
        PersonNode Niema = new PersonNode("Niema");
        Niema.displayNode();

        // create Linked List:
        ClassList BookList = new ClassList();

        // insert 4 strings:
        BookList.insertFirst("Catch 22");
        BookList.insertFirst("The Lotus & The Pool");
        BookList.insertFirst("Linchpin");
        BookList.insertFirst("Phantoms in the brain");

        // print list:
        System.out.println("Test 1: Display everything");
        BookList.displayList();

        // delete first:
        System.out.println("Test 2: Remove head of list - Phantoms in the brain");
        BookList.deleteFirst(); // will remove phantoms in the brain
        BookList.displayList();

        // delete specific key:
        System.out.println("Test 3: Remove specific key - Linchpin  ");
        BookList.deleteName("Linchpin");
        BookList.displayList();

        // delete key not in list:
        System.out.println("Test 4: Remove specific key - The Little Prince  ");
        System.out.println(BookList.deleteName("The Little Prince"));*
*
*
* */
