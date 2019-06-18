package br.com.moraesofia.listaTres.ex2;

public class ProcuraEmArray extends Thread {

    int numThread;

    private int[] array;

    private int desejado;

    private int retorno;

    public ProcuraEmArray(int numThread, int[] array, int desejado) {
        this.numThread = numThread;
        this.array = array;
        this.desejado = desejado;
    }

    @Override
    public void run() {
        this.retorno = procura();
    }

    private int procura() {
        for (int j = 0; j < array.length; j++) {
            if (array[j] == desejado) {
                return j;
            }
        }
        return -1;
    }

    public int getRetorno() {
        return retorno;
    }

    public int getNum() {
        return numThread;
    }

}
