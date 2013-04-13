package test.java;

import main.java.tictactoetomek.TicTacToeTomek;
import org.junit.Test;

public class TicTacToeTomekTest {

    @Test
    public void runExampleTest() {
        TicTacToeTomek t = new TicTacToeTomek();
        t.createBoards("src/test/resources/examle.in");
        t.solveBoards("src/test/resources/example.out");
    }

    @Test
    public void runLargeTest() {
        TicTacToeTomek t = new TicTacToeTomek();
        t.createBoards("src/test/resources/A-large.in");
        t.solveBoards("src/test/resources/A-large.out");
    }

    @Test
    public void runSmallTest() {
        TicTacToeTomek t = new TicTacToeTomek();
        t.createBoards("src/test/resources/A-small-attempt0.in");
        t.solveBoards("src/test/resources/A-small-attempt0.out");
    }
}

