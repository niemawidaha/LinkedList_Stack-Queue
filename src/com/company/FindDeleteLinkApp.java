package com.company;

///////////////////////////////////////////////////////////////////////////////////
// --------------------------------------------------------------------------------
class Link2{

    public int  intData;        // data item (key)
    public double doubleData;   // data item
    public Link next;           // next link in list

    // ----------------------------------------------------------------------------
    // constructor:
    public Link2(int id, double dd){
        intData = id;
        doubleData = dd;
    }

    // ----------------------------------------------------------------------------
    public void displayLink(){
        System.out.println("{" + intData + ", " + doubleData + "}");
    }
} // end class Link

///////////////////////////////////////////////////////////////////////////////////
class LinkList2{

    // reference to first link on list:
    private Link first;

    // ----------------------------------------------------------------------------
    // constructor
    public LinkList2(){

        // on instantiation no links on list yet
        first = null;
    }

    // ----------------------------------------------------------------------------
    // displayList:
    public void displayList(){

        // display the list:
        System.out.println("List (first -> last): ");

        // start at beginning of list
        Link current = first;

        // until end of list:
        while(current != null) {

            // print data:
            current.displayLink();

            // move to next link:
            current = current.next;
        }
        System.out.println("");
    }

    // ----------------------------------------------------------------------------
    // insertFirst:
    public void insertFirst(int id, double dd){

        // make new link:
        Link insertLink = new Link(id, dd);

        // it points to old first link:
        insertLink.next = first;

        // now first points to this
        first = insertLink;
    }

    // ----------------------------------------------------------------------------
    // findLink(): finds link with given key
    public Link find(int key){

        // assumes non-empty list
        // start at first:
        Link current = first;

        // while no match,
        while(current.iData != key){

            // if end of list,
            // didnt find it:
            if(current.next == null){
                return null;
            } else {
                // not end of list,
                // go to the next link
                current = current.next;
            }
        } // ends no match

        // found it:
        return current;
    } // ends find()

    // ----------------------------------------------------------------------------
    // deleteLink(): deletes link with given key
    public Link deleteLink(int key) {

        // assumes non-empty list:
        // search for link:
        Link current = first;
        Link previous = first;


        while(current.iData != key){
            if(current.next == null){
                return null;                // didnt find it:
            } else {

                // go to next link
                previous = current;         // go to next link
                current = current.next;
            }
        }

        if(current == first){
            first = first.next;
        } else
            previous.next = current.next; // by-pass it


        // go to next link
        return current;
    } // ends deleteLink()
}

///////////////////////////////////////////////////////////////////////////////////
public class FindDeleteLinkApp {

    public static void main(String[] args) {

        // make list:
        LinkList2 theList = new LinkList2();

        // insert 4 items:
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88,8.99);

        // display list:
        theList.displayList();

        // find item:
        Link findLink = theList.find(44);

        if(findLink != null){
            System.out.println("");
            System.out.println("Found link to delete  key: " + findLink.iData);
        } else {
            System.out.println("Cant find link. :( ");
        }

        // delete item:
        Link deleteLink = theList.deleteLink(66);

        if(deleteLink != null){
            System.out.println("Found Link with key: " + deleteLink.iData);
        }

        theList.displayList(); // display
    }
} // end FindDeleteLinkApp
