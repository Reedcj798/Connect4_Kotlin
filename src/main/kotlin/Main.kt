import java.util.*

fun main(args: Array<String>) {
    var board = listOf(
        mutableListOf(" ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " "),
        mutableListOf(" ", " ", " ", " ")
    ) // all board spaces need to maintain certain spacing
    var game: Boolean = false; // game is running tester
    var rounds: Int = 0; // checker for if the game has reached maximum possible moves
    var p: String = "X"; // establishes player
    var game1 = Connect4();
    while (!game) {
        game1.gameRound(p, board);
        rounds += 1;
        game = (game1.winTest(p, board));
        if (rounds == 16) { // Tie testing
            game = true;
            game1.printBoard(board);
            print("Game over! You tie!");
        } else if (game) { // win message
            game1.printBoard(board);
            println("Game over! $p wins!");
        } else if (p == "X") { // shifts player
            p = "O";
        } else if (p == "O") {
            p = "X";
        }
    }
}

    public class Connect4 {

        public fun printBoard(board: List<List<String>>) {
            print(
                "\n    1 | 2 | 3 | 4 \n" +
                        "  -----------------\n" +
                        "  | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " |\n" +
                        "  |---------------|\n" +
                        "  | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " |\n" +
                        "  |---------------|\n" +
                        "  | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " |\n" +
                        "  |---------------|\n" +
                        "  | " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " |\n" +
                        "  -----------------\n"
            );
        }

        // Method for placing either an X or an O on the board in designated position
        private fun placePiece(p: String, board: List<MutableList<String>>) {
            println("$p, please input tile choice(1,2,3 or 4):");
            var place: String = readln(); // receiving inputs
            place = place.replace(" ", ""); //removes spaces for code integrity and simplicity
            // tests space and if its empty then places appropriate player piece
            if (place == "1") {
                if (board[3][0] == " ") {
                    board[3][0] = p
                } else if (board[2][0] == " ") {
                    board[2][0] = p
                } else if (board[1][0] == " ") {
                    board[1][0] = p
                } else if (board[0][0] == " ") {
                    board[0][0] = p
                }
            } else if (place == "2") {
                if (board[3][1] == " ") {
                    board[3][1] = p
                } else if (board[2][1] == " ") {
                    board[2][1] = p
                } else if (board[1][1] == " ") {
                    board[1][1] = p
                } else if (board[0][1] == " ") {
                    board[0][1] = p
                }
            } else if (place == "3") {
                if (board[3][2] == " ") {
                    board[3][2] = p
                } else if (board[2][2] == " ") {
                    board[2][2] = p
                } else if (board[1][2] == " ") {
                    board[1][2] = p
                } else if (board[0][2] == " ") {
                    board[0][2] = p
                }
            } else if (place == "4") {
                if (board[3][3] == " ") {
                    board[3][3] = p
                } else if (board[2][3] == " ") {
                    board[2][3] = p
                } else if (board[1][3] == " ") {
                    board[1][3] = p
                } else if (board[0][3] == " ") {
                    board[0][3] = p
                }
            } else if (place == "1" || place == "2" || place == "3" || place == "4") { // tests if input was valid but not empty
                println("Please choose a valid EMPTY space");
                gameRound(p, board); // Reruns without changing player
            } else { // Prints standard error for incorrect input
                println("Please input a valid space code(i.e. 1, 2, 3 or 4)");
                gameRound(p, board); // Reruns without changing players
            }
        }

        // Tests all possible win conditions
        public fun winTest(p: String, board: List<MutableList<String>>): Boolean {
            if (!(board[0][0] == " ") && (board[0][0] == board[0][1]) && (board[0][0] == board[0][2]) && (board[0][0] == board[0][3])) {
                return true;
            } else if (!(board[1][0] == " ") && (board[1][0] == board[1][1]) && (board[1][0] == board[1][2]) && (board[1][0] == board[1][3])) {
                return true;
            } else if (!(board[2][0] == " ") && (board[2][0] == board[2][1]) && (board[2][0] == board[2][2]) && (board[2][0] == board[2][3])) {
                return true;
            } else if (!(board[3][0] == " ") && (board[3][0] == board[3][1]) && (board[3][0] == board[3][2]) && (board[3][0] == board[3][3])) {
                return true;
            } else if (!(board[0][0] == " ") && (board[0][0] == board[1][0]) && (board[0][0] == board[2][0]) && (board[0][0] == board[3][0])) {
                return true;
            } else if (!(board[0][1] == " ") && (board[0][1] == board[1][1]) && (board[0][1] == board[2][1]) && (board[0][1] == board[3][1])) {
                return true;
            } else if (!(board[0][2] == " ") && (board[0][2] == board[1][2]) && (board[0][2] == board[2][2]) && (board[0][2] == board[3][2])) {
                return true;
            } else if (!(board[0][3] == " ") && (board[0][3] == board[1][3]) && (board[0][3] == board[2][3]) && (board[0][3] == board[3][3])) {
                return true;
            } else if (!(board[0][0] == " ") && (board[0][0] == board[1][1]) && (board[0][0] == board[2][2]) && (board[0][0] == board[3][3])) {
                return true;
            } else if (!(board[0][3] == " ") && (board[0][3] == board[1][2]) && (board[0][3] == board[2][1]) && (board[0][3] == board[3][0])) {
                return true;
            }
            return false;
        }

        // underutilized method for current development though could be more useful in future itterations and versions
        public fun gameRound(p: String, board: List<MutableList<String>>) {
            printBoard(board);
            placePiece(p, board);
        }
    }
