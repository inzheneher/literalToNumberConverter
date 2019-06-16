package converter;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ConverterTest {

    private Converter converter;

    @Before
    public void setUp() {
        converter = new Converter();
    }

    @Test
    public void shouldReturnTrueWhenInputIsNumber() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method method = Converter.class.getDeclaredMethod("numberDetector", String.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(converter, "7"));
        assertFalse((boolean) method.invoke(converter, "a"));
    }

    @Test
    public void shouldReturnTrueWhenInputIsLiteral() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method method = Converter.class.getDeclaredMethod("literalDetector", String.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(converter, "g"));
        assertFalse((boolean) method.invoke(converter, "l"));
        assertFalse((boolean) method.invoke(converter, "4"));
    }

    @Test
    public void shouldReturnInputString() {
        assertEquals("10272129562935", converter.convertAlphaNumericCodeToNumber("ARRT56TZ"));
    }

}
