/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dog;

public class Dogs {
    
    public static void main(String[] args) {
        
        Dog d1 = new Dog();
        Dog d2= new Dog("doberman","Preto",2, "M" );
        
        d1.setBreed("doberman");
        d1.setSize("big");
        d1.setAge( 5 );
        d1.setColor("black");
               
        System.out.println(d1);
        System.out.println(d2);
        
            
        System.out.println("");
       
        
        d1.print();
         System.out.println("Foram criados " + Dog.getDogCounter() );
        if( d1.sameBreed(d2))
            System.out.println("Mesma Raça");
        else
            System.out.println("Raças diferentes");
    }
}
