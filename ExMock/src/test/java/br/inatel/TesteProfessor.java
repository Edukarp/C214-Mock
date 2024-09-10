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

    //Cenarios de Sucesso

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

    @Test
    public void testBuscarPorfessorRenzo(){
        Professor renzo = buscaProfessor.buscaProfessor(2);
        ArrayList<String> predio = new ArrayList<>(Arrays.asList("1"));

        assertEquals("Renzo", renzo.getNome());
        assertEquals("15:30", renzo.getHorario());
        assertEquals("diurno", renzo.getPeriodo());
        assertEquals(3, renzo.getSala());
        assertEquals(predio, renzo.getPredio());
    }

    @Test
    public void testBuscarPorfessorMarcelo(){
        Professor marcelo = buscaProfessor.buscaProfessor(3);
        ArrayList<String> predio = new ArrayList<>(Arrays.asList("4"));

        assertEquals("Marcelo", marcelo.getNome());
        assertEquals("13:30", marcelo.getHorario());
        assertEquals("diurno", marcelo.getPeriodo());
        assertEquals(16, marcelo.getSala());
        assertEquals(predio, marcelo.getPredio());
    }

    @Test
    public void testCriandoNovoProfessor(){
        Professor soned = new Professor("Soned", "15:30","diurno", 21);
        ArrayList<String> predio = new ArrayList<>(Arrays.asList("6"));

        assertEquals("Soned", soned.getNome());
        assertEquals("15:30", soned.getHorario());
        assertEquals("diurno", soned.getPeriodo());
        assertEquals(21, soned.getSala());
        assertEquals(predio, soned.getPredio());
    }

    @Test
    public void testIncrementoDePredio(){
        Professor soned = new Professor("Soned", "15:30","diurno", 21);

        assertNotNull(soned.getPredio());
    }

    @Test
    public void testQuantidadeDePredioCorreta(){
        Professor soned = new Professor("Soned", "15:30","diurno", 21);

        assertEquals(1, soned.getPredio().size());
    }

    @Test
    public void testMudarSalaComPredioAutomatico(){
        Professor soned = new Professor("Soned", "15:30","diurno", 21);

        ArrayList<String> predio = new ArrayList<>(Arrays.asList("6"));
        assertEquals(predio, soned.getPredio());

        soned.setSala(2);
        predio.clear();
        predio.add("1");
        assertEquals(predio, soned.getPredio());
    }

    @Test
    public void testDisponibilidade(){
        Professor renzo = buscaProfessor.buscaProfessor(2);

        assertTrue(renzo.isDisponivel());
    }

    @Test
    public void testMarcarHorario(){
        Professor soned = new Professor("Soned", "15:30","diurno", 21);

        soned.marcarHorario();
        assertFalse(soned.isDisponivel());
    }

    @Test
    public void TestLiberarHorario(){
        Professor chris = buscaProfessor.buscaProfessor(1);
        chris.marcarHorario();
        chris.liberarHoario();
        assertTrue(chris.isDisponivel());
    }

    //Cenarios de Falha

    @Test(expected = IndexOutOfBoundsException.class)
    public void testBuscarProfessorInvalido(){
        Professor invalido = buscaProfessor.buscaProfessor(10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSalaInvalida(){
        Professor soned = new Professor("Soned", "15:30","diurno", -4);
    }

    @Test
    public void testNomeIncorreto(){
        Professor renzo = buscaProfessor.buscaProfessor(2);

        assertNotEquals("Chris", renzo.getNome());
    }

    @Test
    public void testHorarioIncorreto(){
        Professor chris = buscaProfessor.buscaProfessor(1);

        assertNotEquals("17:20", chris.getHorario());
    }

    @Test
    public void testPeriodoIncorreto(){
        Professor renzo = buscaProfessor.buscaProfessor(2);

        assertNotEquals("noturno", renzo.getPeriodo());
    }

    @Test
    public void testSalaIncorreta(){
        Professor marcelo = buscaProfessor.buscaProfessor(3);

        assertNotEquals(12, marcelo.getSala());
    }

    @Test
    public void testPredioIncorreto(){
        Professor marcelo = buscaProfessor.buscaProfessor(3);
        ArrayList<String> predio = new ArrayList<>(Arrays.asList("6"));

        assertNotEquals(predio, marcelo.getPredio());
    }

    @Test(expected = SecurityException.class)
    public void testMudarPredioDiretamente(){
        Professor chris = buscaProfessor.buscaProfessor(1);
        ArrayList<String> predio = new ArrayList<>(Arrays.asList("6"));
        chris.setPredio(predio);
    }

    @Test(expected = SecurityException.class)
    public void testMarcarHorarioSemVaga(){
        Professor chris = buscaProfessor.buscaProfessor(1);
        chris.marcarHorario();
        chris.marcarHorario();
    }

    @Test(expected = SecurityException.class)
    public void testLiberarHorarioComVaga(){
        Professor renzo = buscaProfessor.buscaProfessor(2);
        renzo.liberarHoario();

    }

}
