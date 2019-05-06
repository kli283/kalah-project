package kalah;

import com.qualitascorpus.testsupport.IO;

public class UI {
    public void drawBoard (IO io, Player p1, Player p2){
        io.println("+----+-------+-------+-------+-------+-------+-------+----+");

//        io.println("| P2 | 6[ 4] | 5[ 4] | 4[ 4] | 3[ 4] | 2[ 4] | 1[ 4] |  0 |");

        io.print("| P2 ");
        int i = 6;
        for (House house : p2.getHouses()) {
            int count = house.getSeeds().size();
            io.print(String.format("| %d[%2d] ", i, count));
            i--;
        }
        io.println(String.format("| %2d |", p1.getScore()));

        io.println("|    |-------+-------+-------+-------+-------+-------|    |");

        io.print(String.format("| %2d ", p2.getScore()));
        int j = 1;
        for (House house : p2.getHouses()) {
            int count = house.getSeeds().size();
            io.print(String.format("| %d[%2d] ", j, count));
            j++;
        }
        io.println("| P1 |");
//        io.println("|  0 | 1[ 4] | 2[ 4] | 3[ 4] | 4[ 4] | 5[ 4] | 6[ 4] | P1 |");
        io.println("+----+-------+-------+-------+-------+-------+-------+----+");
//        io.println(String.format("Player %d's turn - Specify house number or 'q' to quit: ", ));
    }


//    void run
}
