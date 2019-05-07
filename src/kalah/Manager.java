package kalah;

import com.qualitascorpus.testsupport.IO;

public class Manager {
    private Player p1;
    private Player p2;
    private IO gameIO;
    private UI gameUI;
    private Player currentPlayer;
    private Controller gameController;
    private GameBoard board;

    public void init(IO io) {
        p1 = new Player(1, false);
        p2 = new Player(2, true);
        gameIO = io;
        gameUI = new UI();
        currentPlayer = p1;
        board = new GameBoard();
        gameController = new Controller();
        gameController.gameRun(io,this);
    }


    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public IO getGameIO() {
        return gameIO;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player switchPlayer() {
        currentPlayer = otherPlayer();
        return currentPlayer;
    }

    public Player otherPlayer() {
        if (currentPlayer == p1) {
            return p2;
        } else {
            return p1;
        }
    }

    public UI getGameUI() {
        return gameUI;
    }

    public GameBoard getBoard() {
        return board;
    }
}
