package Entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Andrei on 10/17/2016.
 */
public class SarcinaTest {
    private Sarcina sarcina;
    private Sarcina sarcinaSetId;
    private Sarcina sarcinaSetDescriere;

    @Before
    public void setUp() throws Exception {
        sarcina = new Sarcina(1,"fulltime");
        sarcinaSetId = new Sarcina(1,"fulltime");
        sarcinaSetDescriere = new Sarcina(1,"fulltime");
    }

    @After
    public void tearDown() throws Exception {
        sarcina = null;
    }

    @Test
    public void setIdSarcina() throws Exception {
        assertEquals(sarcina.getId(), new Integer(1));
    }

    @Test
    public void setDescriereSarcina() throws Exception {

    }

    @Test
    public void getIdSarcina() throws Exception {

    }

    @Test
    public void getDescriereSarcina() throws Exception {
        assertEquals("fulltime",sarcina.getDescriereSarcina());
    }

}