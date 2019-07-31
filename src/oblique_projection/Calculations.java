package oblique_projection;

import static java.lang.Math.*;

public class Calculations {

    //get "x" for time "t"
    protected static double x(double t) {

        double v0x = (Checking.v0) * cos((Checking.a) * PI / 180.0);
        double B = 1.0;

        double x = v0x * (1.0 - exp(-B * t)) / B;
        // rescaling
        x = 20.0 * x;
        x = x + 8.5; // moving to axis
        return x;
    }

    //get "y" for time "t"
    protected static double y(double t) {

        double B = 1.0;
        double v0y = (Checking.v0) * sin((Checking.a) * PI / 180.0),
                g = Checking.g;
        double y = (v0y / B + g / B) * (1.0 - exp(-B * t)) - g * t / B;
        // rescaling
        y = 20.0 * y;
        y = 287.5 - y; //moving to axis
        return y;
    }

    //length of track
    protected static double l(double v0, double a, double g) {
        return v0 * v0 * sin(2 * a * PI / 180.0) / g; // 
    }

    //the highest point
    protected static double h(double v0, double a, double g) {
        return 2 * v0 * v0 * sin(a * PI / 180.0) * sin(a * PI / 180.0) / (2 * g);
    }

    //flight time
    protected static double t(double v0, double a, double g) {
        return 2 * v0 * sin(a * PI / 180.0) / g;
    }
}
