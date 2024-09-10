package br.inatel;

public class MockProfessorService implements ProfessorService {

    @Override
    public String busca(int id) {
        if (id == 1)
            return ProfessorConst.CHRIS;
        else if (id == 2)
            return ProfessorConst.RENZO;
        else if (id == 3)
            return ProfessorConst.MARCELO;
        else
            throw new IndexOutOfBoundsException("ID invalido: " + id);
    }

}
