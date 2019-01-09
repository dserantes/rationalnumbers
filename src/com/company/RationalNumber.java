package com.company;

public class RationalNumber {

    //Declaring numerator and denominator as attributes
    private Integer p;
    private Integer q;

    //Constructor by default
    RationalNumber(Integer p, Integer q) {
        this.p = p;
        this.q = q;
    }


    //Constructor for a rational number in a p/1 format
    public RationalNumber(Integer p) {
        this.p = p;
        this.q = 1;
    }

    /*
    'add' method will return the result of adding two rational
    numbers.
     */

    RationalNumber add(RationalNumber b){

        int num1=this.getP();
        int num2=b.getP();

        int den1=this.getQ();
        int den2=b.getQ();

        int retnum;
        int retden;

        //Creating the result rational number with no values
        RationalNumber ret = new RationalNumber(null, null);

        /*
        If-else bracket to calculate the result depending on the
        equality of both denominators.
         */

        if(den1==den2)
        {
            retnum=num1+num2;
            retden=den1;

            ret.setP(retnum);
            ret.setQ(retden);

        }else{

            //Calculating new denominator with lcm method
            retden = lcm(den1,den2);
            retnum = ((retden / den1) * num1) + ((retden / den2) * num2);

            ret.setP(retnum);
            ret.setQ(retden);

        }
        return ret;
    }

    /*
    'substraction' method will return the result of substracting two rational
    numbers.
     */

    RationalNumber substraction(RationalNumber b){

        int num1=this.getP();
        int num2=b.getP();

        int den1=this.getQ();
        int den2=b.getQ();

        int retnum;
        int retden;


        //Creating the result rational number with no values
        RationalNumber ret = new RationalNumber(null, null);

        /*
        If-else bracket to calculate the result depending on the
        equality of both denominators.
        */

        if(den1==den2)
        {
            retnum=num1-num2;
            retden=den1;

            ret.setP(retnum);
            ret.setQ(retden);

        }else{

            //Calculating new denominator with lcm method
            retden = lcm(den1,den2);
            retnum = ((retden / den1) * num1) - ((retden / den2) * num2);

            ret.setP(retnum);
            ret.setQ(retden);

        }
        return ret;
    }

    /*
    'multiplication' method will return the result of multiplicating two rational
    numbers.
     */

    RationalNumber multiplication(RationalNumber b){
        int num = this.getP()*b.getP();
        int den = this.getQ()*b.getQ();

        return new RationalNumber(num,den);
    }

    /*
    'division' method will return the result of dividing two rational
    numbers.
     */

    RationalNumber division(RationalNumber b){
        int num = this.getP()*b.getQ();
        int den = this.getQ()*b.getP();

        return new RationalNumber(num,den);
    }

    /*
    'more' method will return true or false depending on if
    the first rational number is greater than the second one.
    */

    boolean more(RationalNumber b){
        int div1;
        int div2;

        div1 = this.getP()/this.getQ();
        div2 = b.getP()/b.getQ();

        return div1 > div2;
    }

    /*
    'negative' method will return the same absolute value of the rational number
    but with the opposite sign.
    */

    RationalNumber negative(){
        int a = this.getP()*-1;
        this.setP(a);
        return this;
    }

    /*
    'equal method will return true or false if the rational numbers are equivalent
    or not.
     */

    boolean equal(RationalNumber b){
        int a=this.getP();
        int c=b.getP();

        int d=this.getQ();
        int e=b.getQ();

        int h=a/d;
        int i=c/e;

        return h == i;
    }

    /* lcm method is used to calculate the lowest common multiple among two numbers
    * for being able to add or substract them.
    */

    private static int lcm(int n1, int n2) {

            int lcm;

            // maximum number between n1 and n2 is stored in lcm
            lcm = (n1 > n2) ? n1 : n2;

            // Always true
            while(true)
            {
                if( lcm % n1 == 0 && lcm % n2 == 0 )
                {
                    return lcm;
                }
                ++lcm;
            }
    }

    //returns the value of P
    private Integer getP() {
        return p;
    }

    //sets the value of P
    private void setP(Integer p) {
        this.p = p;
    }

    //returns the value of Q
    private Integer getQ() {
        return q;
    }

    //sets the value of Q
    private void setQ(Integer q) {
        this.q = q;
    }

    //'toString' will print the selected rational number.
    @Override
    public String toString() {

            //Managing the output depending on the denominator sign
            if(this.getQ()<0) {
                return (-p + "/" + -q);
            }else{
                return (p + "/" + q);
            }


    }
}
