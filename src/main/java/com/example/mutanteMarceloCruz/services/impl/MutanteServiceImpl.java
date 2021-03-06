package com.example.mutanteMarceloCruz.services.impl;

import com.example.mutanteMarceloCruz.services.MutanteService;
import org.springframework.stereotype.Service;

/**
 * Created by marce on 9/16/17.
 */
@Service
public class MutanteServiceImpl implements MutanteService {

    @Override
    public boolean isMutante(String[] dna) {
        StringBuilder cadena =new StringBuilder();

        for (String in : dna) {
            cadena.append(in.toString());
        }

        String[] matriz = cadena.toString().split("");


        int totalElementos = matriz.length;
        int matrizNxN = (int) Math.sqrt(matriz.length);
        int mutantes = 0;
        boolean isMutante = false;

        for (int i = 0; i < totalElementos; i++) {
            if (mutantes < 2) {
                int fila = i / matrizNxN;
                // Horizontal
                if (findHorizontalSequence(fila, matrizNxN, i, totalElementos, matriz)) {
                    mutantes++;
                }

                // Vertical
                if (findVerticalSequence(matrizNxN, i, totalElementos, matriz)) {
                    mutantes++;
                }

                // Oblicuo derecha
                if (findRightObliqueSequence(fila, matrizNxN, i, totalElementos, matriz)) {
                    mutantes++;
                }

                // Oblicuo izquierda
                if (findLeftObliqueSequence(fila, matrizNxN, i, totalElementos, matriz)) {
                    mutantes++;
                }

            } else {
                isMutante = true;
                break;
            }
        }
        return isMutante;
    }

    public boolean findHorizontalSequence(int fila, int matrizNxN, int i, int totalElementos, String[] matriz) {
        if (((((fila * matrizNxN) + matrizNxN ) - i) > 3) && ((i + 3) < totalElementos) && matriz[i].equals(matriz[i + 3])) {
            if (matriz[i].equals(matriz[i + 2])) {
                if (matriz[i].equals(matriz[i + 1])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findVerticalSequence(int matrizNxN, int i, int totalElementos, String[] matriz) {
        if (((i + (matrizNxN * 3)) < totalElementos) && matriz[i].equals(matriz[(i + (matrizNxN * 3))])) {
            if (matriz[i].equals(matriz[(i + (matrizNxN * 2))])) {
                if (matriz[i].equals(matriz[i + matrizNxN])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findRightObliqueSequence(int fila, int matrizNxN, int i, int totalElementos, String[] matriz) {
        if (((i + 3) < ((fila * matrizNxN) + matrizNxN )) && ((i + (matrizNxN * fila)) < totalElementos) ) {
            // Verify diagonal
            if (matriz[i].equals(matriz[(i + matrizNxN + 1)])) {
                if (matriz[i].equals(matriz[(i + (matrizNxN * 2) + 2)])) {
                    if (matriz[i].equals(matriz[(i + (matrizNxN * 3) + 3)])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean findLeftObliqueSequence(int fila, int matrizNxN, int i, int totalElementos, String[] matriz) {
        if ((i > 3) && ((i - 3) >= (fila * matrizNxN) ) && ((i + (matrizNxN * fila)) < totalElementos) ) {
            // Verify diagonal
            if (matriz[i].equals(matriz[(i + matrizNxN - 1)])) {
                if (matriz[i].equals(matriz[(i + (matrizNxN * 2) - 2)])) {
                    if (matriz[i].equals(matriz[(i + (matrizNxN * 3) - 3)])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
