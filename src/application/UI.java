package application;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001b[0m";
    public static final String ANSI_BLACK = "\u001b[30m";
    public static final String ANSI_RED = "\u001b[31m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_BLUE = "\u001b[34m";
    public static final String ANSI_PURPLE = "\u001b[35m";
    public static final String ANSI_CYAN = "\u001b[36m";
    public static final String ANSI_WHITE = "\u001b[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001b[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001b[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001b[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001b[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001b[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001b[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001b[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001b[47m";

    public static void clearScreen() {

        System.out.print("\033[h\033[2j");
        System.out.flush();
    }

    public static void click(int x, int y) throws AWTException {
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading chessPosition. Valid values are from a1 to h8.");
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces[i].length; j++) {
                printPiece(pieces[i][j]);
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    private static void printPiece(ChessPiece piece) {
        if (piece == null) {
            System.out.print("-");
        } else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_BLACK + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }
}