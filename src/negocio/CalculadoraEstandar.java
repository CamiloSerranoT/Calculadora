/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import javax.swing.JOptionPane;

/**
 *
 * @author Jaen Hannier Herreño Rosas
 */
public class CalculadoraEstandar {
    private double num1;
    private double num2;
    private double res;

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getRes() {
        return res;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setRes(double res) {
        this.res = res;
    }
    
    public void sumar(){
        try{
            this.res = this.num1 + this.num2;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void restar(){ 
        try{
            this.res = this.num1 - this.num2;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void multiplicar(){
        try{
            this.res = this.num1 * this.num2;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void dividir(){ 
        try{
            if(num2 != 0){
            this.res = this.num1 / this.num2;
        }else{
           JOptionPane.showMessageDialog(null, "         Error matematico\nEl divisor no puede ser cero");
         }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public double resultado(){
        return res;
    }
}
