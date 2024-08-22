package modele;

/*
 * Repr�sente une �quation du 1er degr�.
 *
 */
public class Equation1Degre
{

    private double a,b,x;	//a.x+b=0
    private int nbSol; //0, 1 ou 2 (2 infinit�)
    private boolean resolue;

    public static final int INFINITE_SOLUTIONS = 2;
    public static final int ZERO_SOLUTIONS = 0;
    public static final int UNE_SOLUTIONS = 1;

    public Equation1Degre()
    {
        a = b = 0;
        resolue = false;
    }
    public Equation1Degre(double a, double b)
    {
        this.a = a;
        this.b = b;
        resolue = false;
    }
    public boolean isResolue()
    {
        return resolue;
    }

    public double getA()
    {
        return a;
    }

    public double getB()
    {
        return b;
    }

    public double getX()
    {
        return x;
    }

    public int getNbSol()
    {
        return nbSol;
    }

    public void setA(double A)
    {
        if (a!=A)
            resolue = false;
        a = A;
    }

    public void setB(double B)
    {
        if (b!=B)
            resolue = false;
        b = B;
    }

    public void resoudre()
    {
        if (a!=0)
        {
            x = -b/a;
            nbSol = UNE_SOLUTIONS;
        }
        else
        if (b==0)
            nbSol = INFINITE_SOLUTIONS;
        else
            nbSol = ZERO_SOLUTIONS;
        resolue = true;
    }
}