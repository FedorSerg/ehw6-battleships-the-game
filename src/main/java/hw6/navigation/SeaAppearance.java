package hw6.navigation;

public class SeaAppearance {
    public void showTheSea(TheSea myField, TheSea opponentField) {
        String firstField = "", secondField = "";
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
                }
            }

            for (int i = 0; i < 10; i++) {
                switch (opponentField.battlefield[i][j]) {
                    case nearTheShip:
                    case empty:
                        secondField += "_|";
                        break;
                    case ship:
                        secondField += "O|";
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
}
