package com.company;

class Link{

    // fields:
    public int      iData;      // data item (key)
    public double   dData;      // data item
    public Link     next;       // next link in list

    // ---------------------------------------------------------------------
    // constructor:
    public Link(int id, double dd){

        iData = id;             // initialize data
        dData = dd;             // ('next' is automatically set to null)
    }

    // ---------------------------------------------------------------------
    // displayLink(): display
    public void displayLink(){
        System.out.println("{" + iData + ", " + dData + "}");
    }

} // end class Link

////////////////////////////////////////////////////////////////////////////
// LinkList class:
class LinkList{

    private Link first;          // ref to first link on list

    // ---------------------------------------------------------------------
    // constructor:
    public void LinkList(){

        // no items on list yet
        first = null;
    }

    // ---------------------------------------------------------------------
    // isEmpty():
    public boolean isEmpty(){

        // true if list is empty
        return (first == null);
    }

    // ---------------------------------------------------------------------
    // insertFirst(): inserts a new link at the beginning of the list
    public void insertFirst(int intData, double doubleData){

        // insert at the start of list:
        // make new link:
        Link newLink = new Link(intData, doubleData);

        // newLink --> old First
        newLink.next = first;

        // first --> newLink
        first = newLink;
    }

    // ---------------------------------------------------------------------
    // deleteFirst(): deletes a link at the beginning of the list
    //          - this disconnects the first link by rerouting first to point to the second link
    //          - the second link is found by looking at the next field in the first link
    public Link deleteFirst(){

        // delete first item:
        // assumes list not empty:
        // save reference to link:
        Link temp = first;

        // delete it: first -> old next
        first = first.next;

        // return deleted link:
        return  temp;
    }

    // ---------------------------------------------------------------------
    // displayList():
    // to display the list, you start at first, and follow the chain of references
    // from link to ink. A variable current points to each link in turn. It starts
    // off pointing to first, which holds a reference to the first link.
    public void displayList(){

        // start at beginning of list
        System.out.println("List (first -> last): ");
        Link current = first;       // start @ beginning of list

        // until end of list
        while(current != null){

            // print data
            current.displayLink();

            // move to next Link
            current = current.next;
        }
        System.out.println("");
    } // end displayList()



}




////////////////////////////////////////////////////////////////////////////
// Linked List App
public class LinkedListApp {
    public static void main(String[] args) {

        // make new list:
        LinkList theList = new LinkList();

        // insert four items:
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        // display list:
        theList.displayList();

        // until its empty:
        // delete the link
        // display the link
        while(!theList.isEmpty()){

            // delete link:
            Link deleteLink = theList.deleteFirst();

            // display it:
            System.out.println("Deleted: ");
            deleteLink.displayLink();
            System.out.println("");
        }
        theList.displayList();
    } // end main()
} // end class LinkListApp