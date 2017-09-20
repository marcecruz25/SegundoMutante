package com.example.mutanteMarceloCruz.services;

import com.example.mutanteMarceloCruz.services.impl.MutanteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by marce on 9/19/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class MutanteServiceImplTest {

    @Configuration
    static class MutanteServiceImplTestContextConfiguration {
        @Bean
        public MutanteService mutanteService() {
            return new MutanteServiceImpl();
        }
    }

    @Autowired
    private MutanteServiceImpl mutanteService;

    @Before
    public void setup() {

    }

    @Test
    public void isMutanteMatriz() {
        String[] input = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean isMutante = mutanteService.isMutante(input);
        assertEquals(true, isMutante);
    }

    @Test
    public void isNotMutanteMatriz() {
        String[] input = {"ATGCGA","CACTGC","TTATGT","AGACGG","CCTCTA","TCACTG"};
        boolean isMutante = mutanteService.isMutante(input);
        assertEquals(false, isMutante);
    }

    @Test
    public void findHorizontalSequence() {
        /*Ejemplo de como es la Matriz
        *   ATGCGA
            CACTGC
            TTTTGT
            AGACGG
            CCTCTA
            TCACTG */
        String[] input = {"ATGCGA","CACTGC","TTTTGT","AGACGG","CCTCTA","TCACTG"};
        StringBuilder cadena =new StringBuilder();

        for (String in : input) {
            cadena.append(in.toString());
        }

        String[] matriz = cadena.toString().split("");
        boolean horizontalSequence = mutanteService.findHorizontalSequence(2, 6, 12, 36, matriz);
        assertEquals(true, horizontalSequence);
    }

    @Test
    public void findVerticalSequence() {
        String[] input = {"ATGCGA","CACTGC","TTTTGT","TGACGG","TCTCTA","TCACTG"};
        StringBuilder cadena =new StringBuilder();

        for (String in : input) {
            cadena.append(in.toString());
        }

        String[] matriz = cadena.toString().split("");
        boolean verticalSequence = mutanteService.findVerticalSequence(6, 12, 36, matriz);
        assertEquals(true, verticalSequence);
    }

    @Test
    public void findLeftObliqueSequence() {
        String[] input = {"ATGCGA","CACTAC","TTTAGT","AGACGG","CCTCTA","TCACTG"};
        StringBuilder cadena =new StringBuilder();

        for (String in : input) {
            cadena.append(in.toString());
        }

        String[] matriz = cadena.toString().split("");
        boolean leftObliqueSequence = mutanteService.findLeftObliqueSequence(0, 6, 5, 36, matriz);
        assertEquals(true, leftObliqueSequence);
    }

    @Test
    public void findRightObliqueSequence() {
        String[] input = {"ATGCGA","CACTAC","TTTAGT","AGATGG","CCTCTA","TCACTT"};
        StringBuilder cadena =new StringBuilder();

        for (String in : input) {
            cadena.append(in.toString());
        }

        String[] matriz = cadena.toString().split("");
        boolean rightObliqueSequence = mutanteService.findRightObliqueSequence(2, 6, 14, 36, matriz);
        assertEquals(true, rightObliqueSequence);
    }
}
