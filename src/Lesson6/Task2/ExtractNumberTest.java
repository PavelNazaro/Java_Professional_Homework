package Lesson6.Task2;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtractNumberTest {
    ExtractNumber extractNumber;

    @Before
    public void init(){
        System.out.println("Start Test");
        extractNumber = new ExtractNumber();
    }

    @After
    public void shutdown(){
        System.out.println("Test End");
    }

    @Test
    public void test1(){
        Assert.assertArrayEquals(new int[]{3, 7},extractNumber.zadanie(new int[]{5, 3, 2, 4, 1, 2, 4, 3, 7}));
    }

    @Test
    public void test2(){
        Assert.assertArrayEquals(new int[]{1, 2, 8, 3, 7},extractNumber.zadanie(new int[]{5, 3, 2, 4, 1, 2, 8, 3, 7}));
    }

    @Test
    public void test3(){
        assertThrows(RuntimeException.class, () -> {
            extractNumber.zadanie(new int[]{5, 3, 2, 8, 1, 2, 8, 3, 7});
        });
    }

    @Test
    public void test4(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            extractNumber.zadanie(new int[]{5, 3, 2, 8, 1, 2, 8, 3, 7});
        });
    }
}