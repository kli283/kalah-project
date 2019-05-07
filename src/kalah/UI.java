package kalah;

import com.qualitascorpus.testsupport.IO;

public class UI {
    public void drawBoard (IO io, Manager manager){
        io.println("+----+-------+-------+-------+-------+-------+-------+----+");

//        io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");
        Player p1 = manager.getP1();
        Player p2 = manager.getP2();

        io.print("| P2 ");
//        int i = 6;
        for (int i = 6; i > 0; i--) {
            int count = p2.getHouse(i-1).getSeeds();
            io.print(String.format("| %d[%2d] ", i, count));
        }

        io.println(String.format("| %2d |", p1.getScore()));

        io.println("|    |-------+-------+-------+-------+-------+-------|    |");

        io.print(String.format("| %2d ", p2.getScore()));
        for (int i = 0; i < 6; i++) {
            int count =  p1.getHouse(i).getSeeds();
            io.print(String.format("| %d[%2d] ", i + 1, count));
        }
        io.println("| P1 |");
//        io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
        io.println("+----+-------+-------+-------+-------+-------+-------+----+");
//        io.println(String.format("Player %d's turn - Specify house number or 'q' to quit: ", ));
    }

    public void gameOver(IO io) {
        io.println("Game over");
    }

    public void emptyHouse(IO io) {
        io.println("House is empty. Move again.");
    }
    public void printFinal(IO io, Manager manager) {
        int p1Score = manager.getP1().getScore();
        int p2Score = manager.getP1().getScore();
        io.println("\tplayer 1:" + p1Score);
        io.println("\tplayer 2:" + p2Score);
        if (p1Score == p2Score){
            io.println("A tie!");
        } else if (p1Score > p2Score){
            io.println("Player 1 wins!");
        } else {
            io.println("Player 2 wins!");
        }
    }


//    void run
}
