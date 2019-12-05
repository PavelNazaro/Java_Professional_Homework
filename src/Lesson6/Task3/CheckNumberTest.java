package Lesson6.Task3;

import org.junit.*;

public class CheckNumberTest {
    CheckNumber checkNumber;

    @Before
    public void init(){
        System.out.println("Start Test");
        checkNumber = new CheckNumber();
    }

    @After
    public void shutdown(){
        System.out.println("Test End");
    }

    @Test
    public void test1(){
        Assert.assertTrue(checkNumber.zadanie(new int[]{5, 3, 2, 4, 1, 2, 4, 3, 7}));
    }

    @Test
    public void test2(){
        Assert.assertFalse(checkNumber.zadanie(new int[]{5, 3, 2, 4, 4, 2, 4, 3, 7}));
    }

    @Test
    public void test3(){
        Assert.assertTrue(checkNumber.zadanie(new int[]{5, 3, 2, 1, 1, 2, 1, 3, 7}));
    }

    @Test
    public void test4(){
        Assert.assertFalse(checkNumber.zadanie(new int[]{5, 3, 2, 8, 8, 2, 8, 3, 7}));
    }
}