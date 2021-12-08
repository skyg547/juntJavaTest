package Tests;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestClass {

    @Test
    public void method() {
        // org.junit.Assert.assertTrue( new ArrayList<>().isEmpty() );
        assertEquals(1, 1);
    }

    
    @Test
    public void method2() {
        // org.junit.Assert.assertTrue( new ArrayList<>().isEmpty() );
        assertEquals(1, 2);
    }
}
