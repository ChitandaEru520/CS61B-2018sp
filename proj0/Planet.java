public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double x = xxPos - p.xxPos;
        double y = yyPos - p.yyPos;
        return Math.sqrt(x * x + y * y);
    }

    public double calcForceExertedBy(Planet p) {
        return (G * mass * p.mass) / (calcDistance(p) * calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        double x = xxPos - p.xxPos;
        if (x < 0) {
            x = -x;
        }
        return calcForceExertedBy(p) * x / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        double y = yyPos - p.yyPos;
        if (y < 0) {
            y = -y;
        }
        return calcForceExertedBy(p) * y / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double temp,sum = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i].equals(this)) {
                continue;
            }
            if (xxPos > p[i].xxPos) {
                temp = -calcForceExertedByX(p[i]);
            }
            else {
                temp = calcForceExertedByX(p[i]);
            }
            sum = sum + temp;
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double temp,sum = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i].equals(this)) {
                continue;
            }
            if (yyPos > p[i].yyPos) {
                temp = -calcForceExertedByY(p[i]);
            }
            else {
                temp = calcForceExertedByY(p[i]);
            }
            sum = sum + temp;
        }
        return sum;
    }

    public void update(double dt, double x, double y) {
        double xa = x/mass;
        double ya = y/mass;
        this.xxVel += xa * dt;
        this.yyVel += ya * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }
}
