package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
        *  Setting output for a result file.
        *  This file will be created in the "rationalnumbers" folder
        *  after its execution.
        *
        *  Every f.append() saves the buffer into the result file.
        */

        StringBuilder f = new StringBuilder();
        File file = new File("result.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));



        //Creation of rational numbers
        RationalNumber a = new RationalNumber(1, 2);
        RationalNumber b = new RationalNumber(2,3);
        RationalNumber c = new RationalNumber(6, 4);
        RationalNumber d = new RationalNumber(2,1);


        //Outputting a,b,c & d
        System.out.println("a: "+a.toString());
        f.append("a: "+a.toString()).append("\n");
        System.out.println("b: "+b.toString());
        f.append("b: "+b.toString()).append("\n");
        System.out.println("c: "+c.toString());
        f.append("c: "+c.toString()).append("\n");
        System.out.println("d: "+d.toString());
        f.append("d: "+d.toString()).append("\n");

        //Testing methods
        System.out.println("a/b + c/d: "+(a.division(b)).add(c.division(d)));
        f.append("a/b + c/d: "+(a.division(b)).add(c.division(d))).append("\n");

        System.out.println("(a*d + b*c)/(b*d): "+((a.multiplication(d)).add(b.multiplication(c))).division(b.multiplication(d)));
        f.append("(a*d + b*c)/(b*d): "+((a.multiplication(d)).add(b.multiplication(c))).division(b.multiplication(d))).append("\n");

        System.out.println("a/b-c/d: "+a.division(b.substraction(c)).division(d));
        f.append("a/b-c/d: "+a.division(b.substraction(c)).division(d)).append("\n");

        System.out.println("(a*d - b*c)/(b*d): "+(a.multiplication(d.substraction(b)).multiplication(c)).division(b.multiplication(d)));
        f.append("(a*d - b*c)/(b*d): "+(a.multiplication(d.substraction(b)).multiplication(c)).division(b.multiplication(d))).append("\n");

        System.out.println("(a/b)/(c/d): "+(a.division(b)).division(c.division(d)));
        f.append("(a/b)/(c/d): "+(a.division(b)).division(c.division(d))).append("\n");

        System.out.println("(a*d)/(c*b): "+(a.multiplication(d)).division(c.multiplication(b)));
        f.append("(a*d)/(c*b): "+(a.multiplication(d)).division(c.multiplication(b))).append("\n");

        System.out.println("-(a/b): "+(a.division(b)).negative());
        f.append("-(a/b): "+(a.division(b)).negative()).append("\n");

        System.out.println("(a/b)>(c/d): "+(a.division(b)).more(c.division(d)));
        f.append("(a/b)>(c/d): "+(a.division(b)).more(c.division(d))).append("\n");

        System.out.println("(a/b)==(c/d): "+a.division(b).equal(c.division(d)));
        f.append("(a/b)==(c/d): "+a.division(b).equal(c.division(d))).append("\n");

        //Outputting the results to the file & closing it
        writer.write(f.toString());
        writer.close();
    }
}
