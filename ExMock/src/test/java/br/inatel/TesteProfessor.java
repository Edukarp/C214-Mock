package br.inatel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TesteProfessor {

    ProfessorService service;
    BuscaProfessor buscaProfessor;

    @Before
    public void setup(){
        service = new MockProfessorService();
        buscaProfessor = new BuscaProfessor(service);
    }

    @Test
    public void testBuscarPorfessorChris(){


        Professor chris = buscaProfessor.buscaProfessor(1);
        ArrayList<String> predio = new ArrayList<>(Arrays.asList("2"));

        assertEquals("Chris", chris.getNome());
        assertEquals("17:30", chris.getHorario());
        assertEquals("noturno", chris.getPeriodo());
        assertEquals(7, chris.getSala());
        assertEquals(predio, chris.getPredio());


    }
}
