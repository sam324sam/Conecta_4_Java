![Estado](https://img.shields.io/badge/Estado-Acabado-brightgreen?style=plastic)

# Conecta 4

**Conecta4Optimizado** es una implementación del clásico juego Conecta 4 desarrollada en Java. Ofrece dos modos de juego: multijugador local (dos jugadores) y un jugador contra la inteligencia artificial.

---

## Características

1. **Dos modos de juego**:
   - Dos jugadores.
   - Un jugador contra la inteligencia artificial.
2. **Tablero de 6 filas y 7 columnas**.
3. **Sistema de detección de victorias y empates**:
   - Horizontal.
   - Vertical.
   - Diagonal (izquierda y derecha).
4. **Reinicio automático del tablero tras finalizar una partida**.
5. **Control de turnos dinámico**.

---

## Requisitos del sistema

- Java Development Kit (JDK) 8 o superior.

---

## Cómo usar

1. Compila el código utilizando `javac`:
   ```bash
   javac Conecta4Optimizado.java
   ```

2. Ejecuta el programa:
   ```bash
   java Conecta4Optimizado
   ```

3. Selecciona una de las opciones del menú:
   - **1**: Jugar en modo multijugador (dos jugadores).
   - **2**: Jugar contra la inteligencia artificial.
   - **3**: Salir del programa.

4. Durante el juego, introduce el número de la columna (1-7) donde deseas colocar tu ficha.

---

## Funcionalidades principales del código

### 1. Menú principal
Permite elegir entre los modos de juego disponibles o salir del programa.

### 2. Detección de victoria
Comprueba si un jugador ha ganado mediante:
   - Secuencias de cuatro fichas consecutivas en horizontal, vertical o diagonal.

### 3. Detección de empate
Detecta si todas las posiciones están ocupadas sin un ganador claro.

### 4. Inteligencia artificial
Simula un oponente básico que:
   - Prioriza movimientos para ganar o bloquear al jugador humano.
   - Coloca fichas aleatoriamente si no hay movimientos estratégicos disponibles.

### 5. Física del tablero
Gestiona cómo las fichas "caen" dentro de las columnas seleccionadas por los jugadores.

### 6. Impresión del tablero
Muestra el estado actual del tablero después de cada turno.

---

## Estructura del código

1. **Variables globales**:
   - `char[][] dibujo`: Representa el tablero de juego.
   - `int[] Jugador`: Indica el estado de los jugadores (ganador o empate).
   - `int Turno`: Controla el número de turnos.

2. **Funciones principales**:
   - `main`: Punto de entrada del programa. Gestiona el flujo del juego.
   - `Imprimir()`: Muestra el tablero actual.
   - `Fisica(int entrada)`: Gestiona la colocación de fichas en el tablero.
   - `Ganar()`: Comprueba si algún jugador ha ganado.
   - `ColumnaOcupado(int entrada)`: Verifica si una columna está llena.
   - `Jugador(int opcion)`: Gestiona el turno de cada jugador.
   - `Empate()`: Comprueba si el tablero está lleno sin un ganador.
   - `InteligenciaArtificial()`: Implementa los movimientos de la IA.
   - `ReiniciarTablero()`: Restablece el tablero para una nueva partida.

---

## Posibles mejoras

1. **Interfaz gráfica**: Integrar una GUI (por ejemplo, con JavaFX) para mejorar la experiencia del usuario.
2. **Mejora de la inteligencia artificial**: Hacer que la IA utilice algoritmos más avanzados, como el minimax.
3. **Validación de entrada del usuario**: Manejar mejor los casos de entradas inválidas.
4. **Soporte multilingüe**: Permitir que el juego se ejecute en diferentes idiomas.

---

## Créditos

Este programa fue desarrollado como un proyecto educativo en Java para practicar estructuras de control, manejo de matrices y lógica de juego.

