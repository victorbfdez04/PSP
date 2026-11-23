/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.ej7;

/**
 *
 * @author b15-01m
 */
public class Ruleta {
    public void comenzar Juego() throws InterruptedException {

    // Inicializamos la banca
    Banca banca = new Banca();

    // Inicializamos los 4 jugadores
    Jugador [] jugadores = new Jugador [4];
    for (int i = 0; i < 4; i++) {
    jugadores[i] = new Jugador(i+1, banca);

    }
}
