package org.question.linkedlist;

import org.omg.CosNaming.BindingIteratorHelper;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    class IteratorHelper implements  Iterator<T>{

        Node<T> current;
        public IteratorHelper(){
            this.current = head;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T data;
            data = hasNext()?current.data:null;
            if(data==null){
                try {
                    throw new NoSuchFieldException();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            current = current.next;
            return data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorHelper();
    }

    public class Node<T>{
        T data;
        Node next;

        Node(){}

        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        Node(T data){
            this.data = data;
        }
    }

    private Node<T> head,tail;
    private int length = 0;

    public boolean add(T data){
        if(head == null){
            head = new Node(data,null);
            tail = head;
            length++;
        }else{
            tail.next = new Node(data,null);
            tail = tail.next;
            length++;
        }
        return true;
    }
    public boolean addHead(T data){
        if(head == null){
            head = new Node(data,null);
            tail = head;
            length++;
        }else{
            Node n = new Node(data,head);
            head = n;
            length++;
        }
        return true;
    }

    public void printAll(){
        if(head == null){
            System.out.println("No data in Linked List to display");
        }else{
            Node n = head;
            while(n!=null){
                System.out.println(n.data);
                n = n.next;
            }
        }
    }

    public int getSize(){
        return  length;
    }

    public void findMiddle(){
        Node p1,p2;
        if(head == null){
            System.out.println("No data in list");
            return;
        }
        int mid = 0;
        p1 = p2 = head;

        while(p1 != null && p1.next != null){
            p1 = p1.next.next;
            p2 = p2.next;
            mid++;

        }
        System.out.println("length= "+(length)+", middle= "+(mid+1));
        System.out.println(p2.data);

    }

    public boolean delete(T data){
        boolean deleted = false;
        if(head == null){
            System.out.println("error no element to delete");
            return deleted;
        }
        Node n = head;
        if(((Comparable<T>)data).compareTo((T)n.data)==0 ){
            if(head == tail){
                head = tail = null;
            }else{
                head = n.next;
            }
            deleted = true;
            length--;
            return  deleted;
        }



        while(n.next != null){
            if(((Comparable<T>) data).compareTo((T) n.next.data) == 0 ){
                Node n2 = n.next;
                n.next = n2.next;
                n2 = null;
                deleted = true;
                length--;
                break;
            }
            n = n.next;
        }

        return deleted;

    }

    public void reverseList(){
        Node p1,p2,p3;
        p2 = p3 = null;
        p1 = head;
        while(p1!=null){

            p3 = p1.next;
            p1.next = p2;
            if(p2 == null){
                p2 = p1;
                tail = p2;
            }
            p2 = p1;
            p1 = p3;
        }
        head = p2;
    }

    public boolean isCircular(){
        boolean isCircle = false;
        Node p1,p2;
        p1 = p2 = head;
        while(p1 != null && p1.next != null){
            p1 = p1.next.next;
            p2 = p2.next;
            if(p1 == p2){
                isCircle = true;
                break;
            }

        }



        return isCircle;
    }

    public T circularHeadElement(){
        boolean circular= false;
        if(head == null){
            System.out.println("Empty List");
            return null;
        }else if(head == tail){
            System.out.println("ciruclar list-only one element");
        }
        Node p1,p2 ;
        p1 = p2 = head;
        while(p1 != null && p1.next !=null){
            p2 = p2.next;
            p1 = p1.next.next;
            if(p1 == p2){
                circular = true;
                break;//break will happen when it is a circular list
            }
        }
        if(!circular){
            System.out.println("Not a circular list");
            return null;
        }
        p2 = head;
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return (T)p1.data;
    }

    public boolean isPalindrome(){
        boolean isPalind = false;

        if(((Comparable<T>)tail.data).compareTo(head.data)!=0){
            return isPalind;
        }

        int n = arrLength();
        Array<T>[] arr = new Array[n];
        int i = 0;

        Node p1,p2;
        p1 = p2 = head;
        while(p1 != null && p1.next != null){
            arr[i] = new Array(p2.data);
            p2 = p2.next;
            p1 = p1.next.next;

            i++;
        }

        i -=1;

        if(length%2 != 0){
            p2 = p2.next;
        }

        while(p2!=null){

            if(((Comparable<T>)p2.data).compareTo(arr[i].data)==0){

                isPalind = true;
            }else{
                isPalind = false;
                break;
            }
            i--;
            p2 = p2.next;

        }
        return isPalind;
    }

    private int arrLength(){
        if(length %2 ==0)
            return  ((length+1)/2);
        else return (length/2)+1;
    }

    class Array<T>{
        public final T data;
        Array(T data){
            this.data = data;
        }
    }

    public void deleteMN(int m, int n){
        if(m>length || n > length){
            System.out.println("Given length is more than the list length, operation not possible");
            return;
        }
        int count = 0;
        Node p1 = head;
        while(p1 !=null){
            if(count == m-1){
                break;
            }
            p1 = p1.next;
            count++;
        }
        count = 0;
        Node p2 = p1;
        while(p2 != null){
            p2 = p2.next;
            if(count == n){
                break;
            }

            count++;
        }
        p1.next = p2;
    }

}
