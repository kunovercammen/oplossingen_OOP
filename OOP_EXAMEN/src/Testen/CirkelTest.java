package Testen;

import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.Random;

import static org.junit.Assert.*;

public class CirkelTest {
    private Point2D.Double geldigMiddelpunt, puntInCirkel, puntBuitenCirkel;
    private double geldigestraal;
    private Cirkel cirkel;
    private Point2D.Double puntOpRand;

    @org.junit.Before
    public void setUp() throws Exception {
        this.geldigMiddelpunt = new Point2D.Double(10,15);
        puntInCirkel = new Point2D.Double(12,13);
        puntBuitenCirkel = new Point2D.Double(20,30);
        puntOpRand = new Point2D.Double(19,15);
        this.geldigestraal = 9;
        cirkel = new Cirkel(geldigMiddelpunt,geldigestraal);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Cirkel_Met_negatieve_straal_Gooit_exception(){
        double straal = -1 * Math.abs(new Random().nextDouble());
        while (straal == 0){
            straal = -1 * Math.abs(new Random().nextDouble());
        }
        new Cirkel(geldigMiddelpunt, straal);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Cirkel_Met_nul_als_straal_Gooit_exception(){
        new Cirkel(geldigMiddelpunt, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Cirkel_Met_null_als_middelpunt_Gooit_exception(){
        new Cirkel(null, geldigestraal);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Cirkel_Met_straal_groter_dan_x_van_middelpunt_Gooit_exception(){
        new Cirkel(geldigMiddelpunt, this.geldigMiddelpunt.getX()+0.1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_Cirkel_Met_straal_groter_dan_y_van_middelpunt_Gooit_exception(){
        new Cirkel(geldigMiddelpunt, this.geldigMiddelpunt.getY()+0.1);
    }

    @Test
    public void test_Cirkel_Met_geldige_waarde_Maakt_cirkel_object(){
        Cirkel cirkel = new Cirkel(geldigMiddelpunt,geldigestraal);
        assertEquals(geldigestraal,cirkel.getStraal(),0.01);
        assertEquals(geldigMiddelpunt,cirkel.getMiddelpunt());

    }

    @Test
    public void test_Cirkel_Met_straal_gelijk_aan_kleinste_x_en_y_van_middelpunt_Maakt_cirkel_object(){
        Cirkel cirkel = new Cirkel(geldigMiddelpunt,10);
        assertEquals(10,cirkel.getStraal(),0.01);
        assertEquals(geldigMiddelpunt,cirkel.getMiddelpunt());
    }

    @Test
    public void test_Oppervlakte_Berekent_oppervlakte(){
        assertEquals(Math.PI * geldigestraal * geldigestraal, cirkel.oppervlakte(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_LigtInCirkel_Met_null_als_parameter_Gooit_exception(){
        cirkel.ligtInCirkel(null);
    }

    @Test
    public void test_LigtInCirkel_Met_punt_gelijk_aan_middelpunt_Geeft_true(){
        assertTrue(cirkel.ligtInCirkel(geldigMiddelpunt));
    }


    @Test
    public void test_LigtInCirkel_Met_punt_in_cirkel_Geeft_true(){
        assertTrue(cirkel.ligtInCirkel(puntInCirkel));
    }

    @Test
    public void test_LigtInCirkel_Met_punt_buiten_cirkel_Geeft_false(){
        assertFalse(cirkel.ligtInCirkel(puntBuitenCirkel));
    }

    @Test
    public void test_LigtInCirkel_Met_punt_op_rand_cirkel_Geeft_false(){
        assertFalse(cirkel.ligtInCirkel(puntOpRand));
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_VergrootStraal_Met_negatieve_factor_Gooit_exception(){
        double factor = -1 * Math.abs(new Random().nextDouble());
        while (factor == 0){
            factor = -1 * Math.abs(new Random().nextDouble());
        }
        cirkel.vergrootstraal(factor);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_VergrootStraal_Met_nul_als_factor_Gooit_exception(){
        cirkel.vergrootstraal(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_VergrootStraal_Met_factor_te_groot_Gooit_Exception(){
        cirkel.vergrootstraal(1.2);
    }

    @Test
    public void test_VergrootStraal_Met_factor_ok_Vergroot_cirkel(){
        cirkel.vergrootstraal(1.1);
        assertEquals(geldigMiddelpunt,cirkel.getMiddelpunt());
        assertEquals(1.1*geldigestraal,cirkel.getStraal(),0.01);
    }




}
