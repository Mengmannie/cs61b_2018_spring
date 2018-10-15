package proj0;

import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdDraw;

import java.text.DecimalFormat;
import java.util.Scanner;

public class NBody {
    private static final String ImageToDraw = "C:/Users/Administrator/IdeaProjects/cs61b/src/proj0/images/starfield.jpg";

    public static double readRadius(String s){
        In in = new In(s);
        in.readInt();
        return in.readDouble();
    }



    public static Planet[] readPlanets(String s){
        In in = new In(s);
        int N = in.readInt();
        double R = in.readDouble();
        Planet[] p = new Planet[N];
        for(int i = 0; i < N; i++){
            p[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
        }
        return p;
    }

    public static void main(String[] args) {

//            String T = args[0];
//            double T = Double.parseDouble(args[0]);
//            double dt = Double.parseDouble(args[1]);
//            String filename = args[2];
//            double radius = readRadius(filename);
//            Planet[] planets = readPlanets(filename);
//            String imageToDraw = "advice.png";
        Scanner sc = new Scanner(System.in);
        double T = sc.nextDouble();
        double dt = sc.nextDouble();
        String filename = sc.next();
            double radius = readRadius(filename);
            Planet[] planets = readPlanets(filename);
//            StdDraw.setScale(-radius, radius);
//            StdDraw.picture(0, 75, ImageToDraw);
//            StdDraw.show();
//            StdDraw.pause(2000);
//
//            for(Planet p : planets)
//                p.draw();
        StdDraw.enableDoubleBuffering();
        for(double t = 0; t <= T; t = t + dt){
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for(int i = 0; i < planets.length; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.clear();
//            StdDraw.setCanvasSize();
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0, 75, ImageToDraw);
            for(Planet p : planets)
                p.draw();
            StdDraw.show();
            StdDraw.pause((int) 1e-2);
            StdAudio.play("C:/Users/Administrator/IdeaProjects/cs61b/src/proj0/audio/2001.mid");
        }

        DecimalFormat df = new DecimalFormat("#.0000");
        System.out.println(planets.length);
        System.out.printf("%.2e\n",radius);
        for(Planet p : planets)
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",p.xxPos,p.yyPos,p.xxVel,p.yyVel,p.mass,p.imgFileName);
    }
}
