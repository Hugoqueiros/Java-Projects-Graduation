package fila;

import java.util.NoSuchElementException;
import javax.swing.*;

public class Fila {
    Object[] elementos = new Object[5];
    int inicio = 0;
    int fim = -1;
    int tamanho = 0;
    
    boolean isEmpty(){
        return tamanho == 0;
    }
    int size(){
        System.out.println("Quantidade de elementos " + tamanho);
        return tamanho;
    }
    
    boolean add(Object valor){
        if(tamanho== elementos.length){
            throw new IllegalArgumentException();
        }
        else{
            if(fim == elementos.length - 1){
                fim = -1;
            }
            fim ++;
            elementos[fim]= valor;
            tamanho ++;
            return true;
        }
    }
    Object poll(){
        if(!isEmpty()){
            Object temp = elementos[inicio];
            elementos[inicio]= null;
            inicio ++;
            if(inicio == elementos.length){
                inicio = 0;   
            }
            tamanho --;
            return temp;
        }
        else{
            return null;
        }
    }
    Object remove(){
        if(!isEmpty()){
            Object temp = elementos[inicio];
            elementos[inicio]= null;
            inicio ++;
            if(inicio == elementos.length){
                inicio = 0;   
            }
            tamanho --;
            return temp;
        }
        else{
            throw new NoSuchElementException();
        }
    }
    
    Object element(){
        if(!isEmpty()){
            return elementos[inicio];
        }
        else{
            throw new NoSuchElementException();
        }
    }
    
    Object peek(){
        if(!isEmpty()){
            return elementos[inicio];
        }
        else{
            return null;
        }
    }
       
    void imprimir(){
        for (int i = 0; i < tamanho ; i++){
            System.out.println(element()+ "");
            add(remove());
        }
        System.out.println();
    }
}
