//package Conecta4;

import java.util.Scanner;

public class Conecta4Optimizado {
    static Scanner teclado = new Scanner(System.in);
    static char[][] dibujo = new char[6][7];
    static int[] Jugador = { 0, 0, 0 };
    static int Turno = 1;

    public static void main(String[] args) {
        int opcion;
        do {
            ReiniciarTablero();
            System.out.println("1 Dos jugadores");
            System.out.println("2 Jugar contra la ia");
            System.out.println("3 Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    while (Ganar() && Empate()) {
                        Imprimir();
                        Jugador(opcion);
                        if (Empate() && Ganar()) {
                            Jugador(opcion);
                        }
                    }
                    break;
                case 2:
                    while (Ganar() && Empate()) {
                        Imprimir();
                        Jugador(opcion);
                        if (Empate() && Ganar()) {
                            InteligenciaArtificial();
                        }
                    }
                    break;
            }
            if (Jugador[0] == 1) {
                System.out.println("Gano el jugador 1");
            } else if (Jugador[1] == 1) {
                System.out.println("Gano el jugador 2");
            } else if (Jugador[2] == 1) {
                System.out.println("Empate");
            }
        } while (opcion != 3);
        System.out.println("Fin de programa");
    }

    static public void Imprimir() {
        System.out.println();
        System.out.println("1 2 3 4 5 6 7");
        for (int i = 0; i < dibujo.length; i++) {
            for (int o = 0; o < dibujo[i].length; o++) {
                System.out.print(dibujo[i][o] + " ");
            }
            System.out.println("");
        }
    }

    static public void Fisica(int entrada) {
        char Caracter = ' ';
        entrada--;
        if (Turno % 2 == 0) {
            Caracter = 'V';
        } else {
            Caracter = 'A';
        }
        for (int i = dibujo.length - 1; i >= 0; i--) {
            if (dibujo[i][entrada] != 'A' && dibujo[i][entrada] != 'V' && dibujo[i][entrada] == 'x') {
                dibujo[i][entrada] = Caracter;
                break;
            }
        }
        Turno++;
    }

    static public boolean Ganar() {
        char Caracter = ' ';
        for (int C = 0; C < 2; C++) {
            if (C == 0) {
                Caracter = 'A';
            } else if (C == 1) {
                Caracter = 'V';
            }
            for (int i = 0; i < dibujo.length; i++) {
                for (int o = 0; o < dibujo[i].length - 3; o++) { // Horizontal
                    if (dibujo[i][o] == Caracter && dibujo[i][o + 1] == Caracter && dibujo[i][o + 2] == Caracter
                            && dibujo[i][o + 3] == Caracter) {
                        Jugador[C] = 1;
                        return false;
                    }
                }
            }
            for (int i = 0; i < dibujo.length - 3; i++) {// Vertical
                for (int o = 0; o < dibujo[i].length; o++) {
                    if (dibujo[i][o] == Caracter && dibujo[i + 1][o] == Caracter && dibujo[i + 2][o] == Caracter
                            && dibujo[i + 3][o] == Caracter) {
                        Jugador[C] = 1;
                        return false;
                    }
                }
            }
            for (int i = 0; i < dibujo.length; i++) {// Diagonal Izquierda
                for (int o = 0; o < dibujo[i].length; o++) {
                    if (o + 3 < dibujo[i].length && i + 3 < dibujo.length) {
                        if (dibujo[i][o] == Caracter && dibujo[i + 1][o + 1] == Caracter
                                && dibujo[i + 2][o + 2] == Caracter && dibujo[i + 3][o + 3] == Caracter) {
                            Jugador[C] = 1;
                            return false;
                        }
                    }
                }
            }
            for (int i = 3; i < dibujo.length; i++) {// Diagonal Derecha
                for (int o = 0; o < dibujo[i].length - 3; o++) {
                    if (dibujo[i][o] == Caracter && dibujo[i - 1][o + 1] == Caracter && dibujo[i - 2][o + 2] == Caracter
                            && dibujo[i - 3][o + 3] == Caracter) {
                        Jugador[C] = 1;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static public boolean ColumnaOcupado(int entrada) {
        if (entrada < 1 || entrada > 7) {
            System.out.println("EL valor tiene que estar entre 0 y 7");
            return true;
        } else if (dibujo[0][entrada - 1] == 'V' || dibujo[0][entrada - 1] == 'A') {
            Imprimir();
            System.out.println("Esta columna ya esta llena");
            return true;

        } else {
            return false;
        }
    }

    static public void Jugador(int opcion) {
        int entrada;
        do {
            if (opcion == 1) {
                if (Turno % 2 == 0) {
                    System.out.println("jugador 2 Verde turno " + Turno);
                } else {
                    System.out.println("jugador 1 Azul turno " + Turno);
                }
            } else if (opcion == 2) {
                System.out.println("jugador 1 Azul turno " + Turno);
            }
            entrada = teclado.nextInt();
        } while (ColumnaOcupado(entrada));
        Fisica(entrada);
        Imprimir();
    }

    static public boolean Empate() {
        if (Turno >= 42) {
            Jugador[2]++;
            return false;
        } else
            return true;
    }

    static public void InteligenciaArtificial() {
        int contador = 0;
        if (dibujo[5][3] == 'x') {
            Fisica(4);
            contador++;
        } else if (contador == 0) {
            char Caracter = ' ';
            for (int C = 0; C < 2; C++) {
                if (C == 0) {
                    Caracter = 'V';
                } else if (C == 1) {
                    Caracter = 'A';
                }
                if (contador == 0) {
                    for (int i = 0; i < dibujo.length; i++) { // Para Ganar
                        for (int o = 0; o < dibujo[i].length - 3; o++) { // Horizontal
                            if (dibujo[i][o] == Caracter && dibujo[i][o + 1] == Caracter && dibujo[i][o + 2] == Caracter
                                    && dibujo[i][o + 3] == 'x') {
                                Fisica(o + 4);
                                contador++;
                                break;
                            }
                            if (dibujo[i][o] == Caracter && dibujo[i][o + 1] == Caracter && dibujo[i][o + 2] == 'x'
                                    && dibujo[i][o + 3] == Caracter) {
                                Fisica(o + 3);
                                contador++;
                                break;
                            }
                            if (dibujo[i][o] == Caracter && dibujo[i][o + 1] == 'x' && dibujo[i][o + 2] == Caracter
                                    && dibujo[i][o + 3] == Caracter) {
                                Fisica(o + 2);
                                contador++;
                                break;
                            }
                            if (dibujo[i][o] == 'x' && dibujo[i][o + 1] == Caracter && dibujo[i][o + 2] == Caracter
                                    && dibujo[i][o + 3] == Caracter) {
                                Fisica(o + 1);
                                contador++;
                                break;
                            }
                        }
                    }
                }
                if (contador == 0) {
                    for (int i = 0; i < dibujo.length - 3; i++) {// Vertical
                        for (int o = 0; o < dibujo[i].length; o++) {
                            if (dibujo[i][o] == 'x' && dibujo[i + 1][o] == Caracter && dibujo[i + 2][o] == Caracter
                                    && dibujo[i + 3][o] == Caracter) {
                                Fisica(o + 1);
                                contador++;
                                break;
                            }
                        }
                    }
                }
                if (contador == 0) {
                    for (int i = 0; i < dibujo.length - 3; i++) {// Diagonal Izquierda
                        for (int o = 0; o < dibujo.length - 3; o++) {
                            if (dibujo[i][o] == Caracter && dibujo[i + 1][o + 1] == Caracter
                                    && dibujo[i + 2][o + 2] == Caracter && dibujo[i + 3][o + 3] == 'x') {
                                Fisica(o + 4);
                                contador++;
                                break;
                            }
                            if (dibujo[i][o] == Caracter && dibujo[i + 1][o + 1] == Caracter
                                    && dibujo[i + 2][o + 2] == 'x' && dibujo[i + 3][o + 3] == Caracter) {
                                Fisica(o + 3);
                                contador++;
                                break;
                            }
                            if (dibujo[i][o] == Caracter && dibujo[i + 1][o + 1] == 'x'
                                    && dibujo[i + 2][o + 2] == Caracter && dibujo[i + 3][o + 3] == Caracter) {
                                Fisica(o + 2);
                                contador++;
                                break;
                            }
                            if (dibujo[i][o] == 'x' && dibujo[i + 1][o + 1] == Caracter
                                    && dibujo[i + 2][o + 2] == Caracter && dibujo[i + 3][o + 3] == Caracter) {
                                Fisica(o + 1);
                                contador++;
                                break;
                            }
                        }
                    }
                }
                if (contador == 0) {
                    for (int i = 3; i < dibujo.length; i++) {// Diagonal Derecha
                        for (int o = 0; o < dibujo[0].length - 3; o++) {
                            if (dibujo[i][o] == Caracter && dibujo[i - 1][o + 1] == Caracter
                                    && dibujo[i - 2][o + 2] == Caracter && dibujo[i - 3][o + 3] == 'x') {
                                Fisica(o + 4);
                                contador++;
                                break;
                            }
                            if (dibujo[i][o] == Caracter && dibujo[i - 1][o + 1] == Caracter
                                    && dibujo[i - 2][o + 2] == 'x' && dibujo[i - 3][o + 3] == Caracter) {
                                Fisica(o + 3);
                                contador++;
                                break;
                            }
                            if (dibujo[i][o] == Caracter && dibujo[i - 1][o + 1] == 'x'
                                    && dibujo[i - 2][o + 2] == Caracter && dibujo[i - 3][o + 3] == Caracter) {
                                Fisica(o + 2);
                                contador++;
                                break;
                            }
                            if (dibujo[i][o] == 'x' && dibujo[i - 1][o + 1] == Caracter
                                    && dibujo[i - 2][o + 2] == Caracter && dibujo[i - 3][o + 3] == Caracter) {
                                Fisica(o + 1);
                                contador++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (contador == 0) {
            int LugarRamdon;
            do {
                LugarRamdon = (int) Math.floor(Math.random() * 7 + 1);
            } while (ColumnaOcupado(LugarRamdon));
            Fisica(LugarRamdon);
        }
        Imprimir();
        System.out.println("ia turno " + (Turno - 1));
    }

    static public void ReiniciarTablero() {
        Turno = 1;
        for (int i = 0; i < Jugador.length; i++) {
            Jugador[i] = 0;
        }
        for (int i = 0; i < dibujo.length; i++) {
            for (int o = 0; o < dibujo[i].length; o++) {
                dibujo[i][o] = 'x';
            }
        }
    }
}