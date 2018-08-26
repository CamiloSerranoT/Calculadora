/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

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
    private vista.Transformacion transformar = new vista.Transformacion();

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

    public CalculadoraSistemasN() {
        raiz = null;
        cola = null;
    }

    public void agregar(double dato) {
        Nodo nuevo = new Nodo(dato);
        if (raiz == null) {
            raiz = nuevo;
            cola = nuevo;
        } else {
            nuevo.setAnt(cola);
            cola.setSig(nuevo);
            cola = nuevo;
        }
    }

    public double eliminarPila() {
        double valor = 0;
        valor = raiz.getDato();

        if (raiz == cola) {
            raiz = null;
            cola = null;
        } else {
            raiz = raiz.getSig();
            raiz.getAnt().setSig(null);
            raiz.setAnt(null);
        }
        return valor;
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

    public void pasar() {
        vaciar();
        double cantidad = 0;
        double valorInt = Integer.parseInt(ValorInicial);
        if (baseInicial == baseFinal) {
            agregar(valorInt);
        } else {
            if (baseInicial == 10) {
                trasformarAUnaBase(valorInt);
            } else {
                valorInt = pasarADecimal();
                trasformarAUnaBase(valorInt);
            }
        }
        cantidad = can(cantidad);
        double[] arreglo = new double[(int) cantidad];
        
    }

    private void trasformarAUnaBase(double valorInt) {
        boolean comprobar = false;
        double dividendo = valorInt;
        do {
            if (dividendo >= 0 && dividendo <= baseFinal - 1) {
                agregar(dividendo % baseFinal);
                dividendo = dividendo / baseFinal;
            } else {
                comprobar = true;
            }
        } while (comprobar != true);
        agregar(dividendo);
    }

    private double pasarADecimal() {
        double valor = 0;
        Nodo recorre = raiz;
        for (int i = 0; i < ValorInicial.length(); i++) {
            agregar(poderTransformar(ValorInicial.charAt(i)));
        }

        for (int i = 0; i < ValorInicial.length(); i++) {
            recorre.setDato(Math.pow(recorre.getDato(), ValorInicial.length() - 1 - i));
            recorre = recorre.getSig();
        }
        recorre = raiz;
        for (int i = 0; i < ValorInicial.length(); i++) {
            valor = valor + recorre.getDato();
            recorre = recorre.getSig();
        }
        vaciar();
        return valor;
    }

    private void vaciar() {
        boolean comprobar = false;
        do {
            if (raiz != null) {
                eliminarCola();
            } else {
                comprobar = true;
            }
        } while (comprobar != true);
    }

    private double poderTransformar(char valor) {
        double var = 0;
        double transInt = valor - 48;
        System.out.println(transInt);

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

    private double can(double cantidad) {
        boolean comprobar = false;
        Nodo recorre = raiz;
        do {
            if (recorre.sig == null) {
                comprobar = true;
            } else {
                cantidad++;
            }
        } while (comprobar != true);
        return cantidad;
    }

}
