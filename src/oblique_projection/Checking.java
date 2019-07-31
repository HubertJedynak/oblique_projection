package oblique_projection;

public class Checking {

    protected static double v0; // initial velocity
    protected static double a; //shot angle
    protected static double g; //gravity
    private static boolean isCorrect = true; // is all variables correct

    private static void isPositive() {
        if (v0 > 0) {
            if (a > 0) {
                if (a < 90) {
                    if (g > 0) {

                    } else {

                        WW.tg.setText("9.81");
                        g = 9.81;
                        isCorrect = false;
                    }
                } else {

                    WW.ta.setText("45");
                    a = 45.0;
                    isCorrect = false;
                }
            } else {

                WW.ta.setText("45");
                a = 45.0;
                isCorrect = false;
            }
        } else {

            WW.tv0.setText("20");
            v0 = 20.0;
            isCorrect = false;
        }
    }

    private static void isANumber() {
        String s = "";
        try {
            s = WW.tv0.getText();
            v0 = Double.parseDouble(s);
        } catch (NumberFormatException e) {

            WW.tv0.setText("20");
            v0 = 20.0;
            isCorrect = false;

        }

        try {
            s = WW.ta.getText();
            a = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            WW.ta.setText("45");
            a = 45.0;
            isCorrect = false;

        }
        try {
            s = WW.tg.getText();
            g = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            WW.tg.setText("9.81");
            g = 9.81;
            isCorrect = false;

        }

    }

    private static void load() {
        isCorrect = true;
        isANumber();
        isPositive();

        if (isCorrect == true) {
            WW.lComment.setText("wszystkie dane poprawne");
        } else {
            WW.lComment.setText("niepoprawe dane");
        }

    }

    protected static void check() {
        load();
    }
}
