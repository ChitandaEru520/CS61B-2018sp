public class NBody {
    public static double readRadius(String args) {
        In in = new In(args);
        int number = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String args) {
        In in = new In(args);
        int number = in.readInt();
        Planet[] planets = new Planet[number];
        String a  = "a";
        double radius = in.readDouble();
        for (int i = 0; i < number; i++) {
            planets[i] = new Planet(0.0, 0.0, 0.0, 0.0, 0.0, a);
            planets[i].xxPos = in.readDouble();
            planets[i].yyPos = in.readDouble();
            planets[i].xxVel = in.readDouble();
            planets[i].yyVel = in.readDouble();
            planets[i].mass = in.readDouble();
            planets[i].imgFileName = in.readString();
        }
        return planets;
    }
}
