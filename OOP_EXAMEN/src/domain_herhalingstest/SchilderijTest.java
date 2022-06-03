package domain_herhalingstest;

import static org.junit.Assert.*;

public class SchilderijTest {
    private Schilderij schilderij;

    @org.junit.Before
    public void setUp() throws Exception  {
        schilderij = new Schilderij("Klaprozen","Claude Monet",50,65.3,125125);
    }

    @org.junit.Test(expected = DomainException.class)
    public void test_setWaarde_Met_negatieve_waarde_Gooit_DomainException() {
        schilderij.setWaarde(-25);
    }

    @org.junit.Test(expected = DomainException.class)
    public void test_setWaarde_Met_nul_als_waarde_Gooit_DomainException() {
        schilderij.setWaarde(0);
    }

    @org.junit.Test
    public void test_setWaarde_Met_positieve_waarde_Verandert_de_waarde() {
        schilderij.setWaarde(250000);
        assertEquals(250000,schilderij.getWaarde(),0.01);
    }

    @org.junit.Test
    public void test_setWaarde_Met_1_als_waarde_Verandert_de_waarde() {
        schilderij.setWaarde(1);
        assertEquals(1,schilderij.getWaarde(),0.01);
    }
}