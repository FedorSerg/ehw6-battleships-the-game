package hw6.navigation;

public class SeaAppearance {
    public void showTheSea(TheSea myField, int myLife, TheSea opponentField, int opponentLife) {
        String firstField = "", secondField = "";

        System.out.println("                  " + drawLife(myLife)[0] + "      " + drawLife(opponentLife)[0]);
        System.out.println("                  " + drawLife(myLife)[1] + "      " + drawLife(opponentLife)[1]);
        System.out.println("                  " + drawLife(myLife)[2] + "      " + drawLife(opponentLife)[2]);
        System.out.println("  |A|B|C|D|E|F|G|H|I|J|       |A|B|C|D|E|F|G|H|I|J|");
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                switch (myField.battlefield[i][j]) {
                    case nearTheShip:
                        firstField += "-|";
                        break;
                    case empty:
                        firstField += "_|";
                        break;
                    case ship:
                        firstField += "O|";
                        break;
                    case shot:
                        firstField += "X|";
                        break;
                    case miss:
                        firstField += "*|";
                        break;
                }
            }
            for (int i = 0; i < 10; i++) {
                switch (opponentField.battlefield[i][j]) {
                    case nearTheShip:
                    case empty:
                    case ship:
                        secondField += "_|";
                        break;
                    case miss:
                        secondField += "*|";
                        break;
                    case shot:
                        secondField += "X|";
                        break;
                }
            }

            String space;
            if (j == 9) {
                space = "";
            } else {
                space = " ";
            }
            System.out.println(space + (j + 1) + "|" + firstField + "     " + space + (j + 1) + "|" + secondField);
            firstField = "";
            secondField = "";
        }
    }

    private String[] drawLife(int life) {
        switch (life) {
            case 0:
                return new String[] {
                        "   _ ",
                        "  | |",
                        "  |_|"
                };
            case 1:
                return new String[] {
                        "     ",
                        "   /|",
                        "    |"
                };
            case 2:
                return new String[] {
                        "   _ ",
                        "   _|",
                        "  |__"
                };
            case 3:
                return new String[] {
                        "   _ ",
                        "   _|",
                        "   _|"
                };
            case 4:
                return new String[] {
                        "     ",
                        "  |_|",
                        "    |"
                };
            case 5:
                return new String[] {
                        "   __",
                        "  |_ ",
                        "   _|"
                };
            case 6:
                return new String[] {
                        "   _ ",
                        "  |_ ",
                        "  |_|"
                };
            case 7:
                return new String[] {
                        "   __",
                        "    /",
                        "   | "
                };
            case 8:
                return new String[] {
                        "   _ ",
                        "  |_|",
                        "  |_|"
                };
            case 9:
                return new String[] {
                        "   _ ",
                        "  |_|",
                        "   / "
                };
            case 10:
                return new String[] {
                        "   _ ",
                        "| | |",
                        "| |_|"
                };
            default:
                return new String[] {
                        " _   ",
                        " / | ",
                        " * * "
                };
        }
    }
}
