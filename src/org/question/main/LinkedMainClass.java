package org.question.main;

import org.question.linkedlist.LinkedList;

import java.util.Scanner;

public class LinkedMainClass {

    public static void main(String[] args){
        //Linked List Problems
        int n = 0;
        int y = 5;
        LinkedList<Integer> in = new LinkedList<>();
        while(true) {
            n = (int) (Math.random() * 10);
            y = (int) (Math.random() * 50);
            if(n > 5 && y >5){
                break;
            }
        }

        for(int i = n;i < y; i++ ){
            in.add(n*y*i);
        }

        in.printAll(); //Printing all the elements of the linked list

        //1. Finding the middle of the linked list.
        //in.findMiddle();

        //2. deleting a data:
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the data element to be deleted: ");
        //Integer data = sc.nextInt();
        //System.out.println(in.delete(data)?"deleted":"element not found");
        //in.printAll();

        //3.Reversing a Linked List
        //in.reverseList();
        //System.out.println("Reversing the list---------------");
        //in.printAll();

        //4.Finding a loop in the linked list
        //System.out.println(in.isCircular()?"Circular Linked List":"Not a circular Linked List");

        //5. If circular list then  find the head from where the circle start.
        //Integer i = in.circularHeadElement();
        //System.out.println(i != null?i:"Some error occured check your list");

        //6.Palindrom
//        LinkedList<Integer> li = new LinkedList<>();
//        li.add(5);
//        li.add(2);
//        li.add(2);
//        li.add(3);
//        li.add(5);
//        System.out.println(li.isPalindrome()?"given list is palindrome":"Given list is not a palindrome");


        //7.Delete M nodes after N nodes
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Enter after how many nodes you want to delete");
        //int m=sc.nextInt();
        //System.out.println("How Many Nodes you want to delete?");
        //int nn = sc.nextInt();
        //in.deleteMN(m,nn);
        //in.printAll();






    }
}
