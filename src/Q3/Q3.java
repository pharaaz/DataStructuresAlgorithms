/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q3;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Owner
 */
public class Q3 {
    public static void main(String args[]){
        
         System.out.println("Hello and welcome to Question 3 " +"\nInput to test: ");
        
         int key = 2;
         Scanner input = new Scanner(System.in);
         String user = input.next();
         
          Stack<Character> stackieee = new Stack<>();
         
         for(int i = 0; i<user.length();i++){
            
             char firsty=user.charAt(i);
             
             //System.out.println(firsty);
             
             if(firsty=='<' ||firsty=='[' ||firsty=='{'|| firsty=='('){
                 
                 stackieee.push(firsty);
                 
                //  System.out.println("is lesh c:" +stackieee.peek());
               
             }else{
                 
                 
                 if(firsty=='>'){
                     if(stackieee.peek()=='<'){
             
                         stackieee.pop();
                     }else{
                     key=3;
                     break;
                     }
                 }
                 if(firsty==']'){
                     if(stackieee.peek()=='['){
             
                         stackieee.pop();
                     }else{
                     key=3;
                     break;
                     }
                 }
                 if(firsty=='}'){
                     if(stackieee.peek()=='{'){   
             
                         stackieee.pop();
                     }else{
                     key=3;
                     break;
                     }
                 }
                 if(firsty==')'){
                     if(stackieee.peek()=='('){
             
                         stackieee.pop();
                     }else{
                     key=3;
                     break;
                     }
                 }
             }
         }
          
         if(stackieee.empty()==false||key==3){
             System.out.println("Did not evaluate successfully");
         }
         else{
             System.out.println("Did evaluate successfully");
         }
    }
}
