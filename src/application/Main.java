package application;

import model.Partida;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static Partida p;
    public static void main(String[] args) {
        p = new Partida();

        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                p.jugar1(generarNumeroAleatorio());
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            p.setAcabaJugador1(true);
        }).start();

        new Thread( () -> {
            for(int i = 0 ; i < 10; i++){
                p.jugar2(generarNumeroAleatorio());
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            p.setAcabaJugador2(true);
            verificarGanador();
        }).start();





    }


    //verifico que jugador gano con más puntos
    public static void verificarGanador() {
        if (p.isAcabaJugador2() && p.isAcabaJugador1()) {
            System.out.println("----------------------------");
            System.out.println("Jugador 1: " + p.getPuntosJugador1());
            System.out.println("Jugador 2: " + p.getPuntosJugador2());
            System.out.println("----------------------------");
            //verifico que jugador gano con más puntos
            if (p.getPuntosJugador1() > p.getPuntosJugador2()) {
                System.out.println("Gano el jugador 1");
            } else if (p.getPuntosJugador1() < p.getPuntosJugador2()) {
                System.out.println("Gano el jugador 2");
            } else {
                System.out.println("Empate");
            }

        }
    }
    /**
     * Método que genera un número aleatorio entre 1 y 5
     */
    public static Integer generarNumeroAleatorio() {
        return ThreadLocalRandom.current().nextInt(1, 5);
    }
}