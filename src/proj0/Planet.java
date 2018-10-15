package proj0;

import edu.princeton.cs.introcs.StdDraw;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public final static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img  ){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = "C:/Users/Administrator/IdeaProjects/cs61b/src/proj0/images/"+img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos) + (this.yyPos - p.yyPos)*(this.yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p){
        double distance = calcDistance(p);
        double f = G * this.mass * p.mass/(distance * distance);
        return f;
    }

    public double calcForceExertedByX(Planet p){
        double distance = calcDistance(p);
        double f = calcForceExertedBy(p);
        double fx = f * (p.xxPos - this.xxPos) / distance;
        return fx;
    }

    public double calcForceExertedByY(Planet p){
        double distance = calcDistance(p);
        double f = calcForceExertedBy(p);
        double fy = f * (p.yyPos - this.yyPos) / distance;
        return fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double NetForceExertedByX = 0;
        for(Planet p : allPlanets){
            if(!p.equals(this)){
                NetForceExertedByX += calcForceExertedByX(p);
            }
        }
        return NetForceExertedByX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double NetForceExertedByY = 0;
        for(Planet p : allPlanets){
            if(!p.equals(this)){
                NetForceExertedByY += calcForceExertedByY(p);
            }
        }
        return NetForceExertedByY;
    }

    public void update(double dt, double fx, double fy){
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += xxVel * dt;
        yyPos += yyVel *dt;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, imgFileName);
//        StdDraw.show();
//        StdDraw.pause(2000);
    }




}
