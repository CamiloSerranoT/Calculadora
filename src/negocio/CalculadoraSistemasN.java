/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import vista.Transformacion;

/**
 *
 * @author CAMILO
 */
public class CalculadoraSistemasN {

    Nodo raiz = new Nodo();
    Nodo cola = new Nodo();
    private double baseInicial;
    private String ValorInicial;
    private double baseFinal;
    private double posicion;
    private int rangoInicial;
    private int rangoFinal;
    Transformacion transformar = new Transformacion();
    CalculadoraSistemasN cal = new CalculadoraSistemasN();

    public double getBaseInicial() {
        return baseInicial;
    }

    public void setBaseInicial(double baseInicial) {
        this.baseInicial = baseInicial;
    }

    public String getValorInicial() {
        return ValorInicial;
    }

    public void setValorInicial(String ValorInicial) {
        this.ValorInicial = ValorInicial;
    }

    public double getBaseFinal() {
        return baseFinal;
    }

    public void setBaseFinal(double baseFinal) {
        this.baseFinal = baseFinal;
    }

    public double getPosicion() {
        return posicion;
    }

    public void setPosicion(double cantidad) {
        this.posicion = cantidad;
    }

    public int getRangoInicial() {
        return rangoInicial;
    }

    public void setRangoInicial(int rangoInicial) {
        this.rangoInicial = rangoInicial;
    }

    public int getRangoFinal() {
        return rangoFinal;
    }

    public void setRangoFinal(int rangoFinal) {
        this.rangoFinal = rangoFinal;
    }

    public CalculadoraSistemasN() {
        raiz = null;
        cola = null;
        posicion = 0;
    }

    public void agregar(double dato) {
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevo;
            cola = nuevo;
        } else {
            cola.setSig(nuevo);
            nuevo.setAnt(cola);
            cola = nuevo;
        }
    }

    public double eliminarCola() {
        double valor = 0;
        valor = cola.getDato();

        if (raiz == cola) {
            raiz = null;
            cola = null;
        } else {
            cola = cola.getAnt();
            cola.getSig().setAnt(null);
            cola.setSig(null);
        }
        return valor;
    }

    public void rango() {
        setRangoInicial(tamaño((int) getBaseInicial()));
        setRangoFinal(tamaño((int) getBaseFinal()));
    }

    private int tamaño(int valor) {
        int aux = 0;
        if (valor >= 2 && valor <= 3) {
            aux = 2;
        } else {
            if (valor >= 4 && valor <= 7) {
                aux = 3;
            } else {
                aux = 4;
            }
        }
        return aux;
    }

    //Metodo principal
    public int[] pasar(int[] arreglo) {
        int[] inicial = new int[getRangoInicial() * getValorInicial().length()];
        double[] aux = new double[ValorInicial.length()];
        aux = conversion(aux);
        inicial = pasarInicial(inicial, aux);
        return arreglo;
    }

    private double[] conversion(double[] aux) {
        for (int i = 0; i < ValorInicial.length(); i++) {
            aux[i] = poderTransformar(ValorInicial.charAt(i));
        }
        return aux;
    }

    //Metodo para pasar valores de tipo char a tipo double
    private double poderTransformar(char valor) {
        double var = 0;
        double transInt = valor - 48;

        if (transInt >= 0 && transInt <= 9) {
            var = transInt;
        } else {
            if (transInt == 17 || transInt == 49) {
                var = 10;
            } else {
                if (transInt == 18 || transInt == 50) {
                    var = 11;
                } else {
                    if (transInt == 19 || transInt == 51) {
                        var = 12;
                    } else {
                        if (transInt == 20 || transInt == 52) {
                            var = 13;
                        } else {
                            if (transInt == 21 || transInt == 53) {
                                var = 14;
                            } else {
                                if (transInt == 22 || transInt == 54) {
                                    var = 15;
                                }
                            }
                        }
                    }
                }
            }
        }
        return var;
    }

    private int[] pasarInicial(int[] inicial, double[] aux) {
        for (int i = 0; i < aux.length; i++) {
            inicial = trasformarAUnaBase((int) aux[i], inicial);
        }
        return inicial;
    }

    private int[] trasformarAUnaBase(int valor, int[] inicial) {
        boolean comprobar = false;
        double nuevo = 0;
        double dividendo = valor;
        int cont = 0;

        do {
            if (dividendo >= 0 && dividendo < 2) {
                nuevo = dividendo % 2;
                agregar(nuevo);
                dividendo = dividendo / 2;
                cont++;
            } else {
                comprobar = true;
            }
        } while (comprobar != true);
        agregar(dividendo);
        cont++;

        comprobar = false;
        do {
            if (cont < rangoInicial) {
                agregar(0);
                cont++;
            } else {
                comprobar = true;
            }
        } while (comprobar != true);

        inicial = pasarVal(inicial);
        return inicial;
    }

    private int[] pasarVal(int[] inicial) {
        for (int i = 0; i < rangoInicial; i++) {
            inicial[(int) posicion] = (int) eliminarCola();
            posicion++;
        }
        return inicial;
    }

}
