package edu.deakin.sit333;

import java.util.Random;

import edu.deakin.sit333.DateUtil;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = null;
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = null;
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void test1A2000_1_1ShouldIncrementTo2000_1_2() {
        DateUtil date = new DateUtil(1, 1, 2000);
        System.out.println("2000_1_1ShouldIncrementTo2000_1_2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2, date.getDay());
    }

    @Test
    public void test2A2000_1_28ShouldIncrementTo2000_1_29() {
        DateUtil date = new DateUtil(28, 1, 2000);
        System.out.println("2000_1_28ShouldIncrementTo2000_1_29 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test3A2000_1_29ShouldIncrementTo2000_1_30() {
        DateUtil date = new DateUtil(29, 1, 2000);
        System.out.println("2000_1_29ShouldIncrementTo2000_1_30 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(30, date.getDay());
    }

    @Test
    public void test4A2000_1_30ShouldIncrementTo2000_1_31() {
        DateUtil date = new DateUtil(30, 1, 2000);
        System.out.println("2000_1_30ShouldIncrementTo2000_1_31 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    @Test
    public void test5A2000_1_31ShouldIncrementTo2000_2_1() {
        DateUtil date = new DateUtil(31, 1, 2000);
        System.out.println("2000_1_31ShouldIncrementTo2000_2_1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test6A2000_2_1ShouldIncrementTo2000_2_2() {
        DateUtil date = new DateUtil(1, 2, 2000);
        System.out.println("2000_2_1ShouldIncrementTo2000_2_2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2, date.getDay());
    }

    @Test
    public void test7A2000_2_28ShouldIncrementTo2000_2_29() {
        DateUtil date = new DateUtil(28, 2, 2000);
        System.out.println("2000_2_28ShouldIncrementTo2000_2_29 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test8A2000_2_29ShouldIncrementTo2000_3_1() {
        DateUtil date = new DateUtil(29, 2, 2000);
        System.out.println("2000_2_29ShouldIncrementTo2000_3_1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test9A2000_2_30ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(30, 2, 2000));
    }

    @Test
    public void test10A2000_2_31ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(31, 2, 2000));
    }

    @Test
    public void test11A2000_6_1ShouldIncrementTo2000_6_2() {
        DateUtil date = new DateUtil(1, 6, 2000);
        System.out.println("2000_6_1ShouldIncrementTo2000_6_2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2, date.getDay());
    }

    @Test
    public void test12A2000_6_28ShouldIncrementTo2000_6_29() {
        DateUtil date = new DateUtil(28, 6, 2000);
        System.out.println("2000_6_28ShouldIncrementTo2000_6_29 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test13A2000_6_29ShouldIncrementTo2000_6_30() {
        DateUtil date = new DateUtil(29, 6, 2000);
        System.out.println("2000_6_29ShouldIncrementTo2000_6_30 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(30, date.getDay());
    }

    @Test
    public void test14A2000_6_30ShouldIncrementTo2000_7_1() {
        DateUtil date = new DateUtil(30, 6, 2000);
        System.out.println("2000_6_30ShouldIncrementTo2000_7_1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test15A2000_6_31ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(31, 6, 2000));
    }

    @Test
    public void test16A2001_1_1ShouldIncrementTo2001_1_2() {
        DateUtil date = new DateUtil(1, 1, 2001);
        System.out.println("2001_1_1ShouldIncrementTo2001_1_2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2, date.getDay());
    }

    @Test
    public void test17A2001_1_28ShouldIncrementTo2001_1_29() {
        DateUtil date = new DateUtil(28, 1, 2001);
        System.out.println("2001_1_28ShouldIncrementTo2001_1_29 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test18A2001_1_29ShouldIncrementTo2001_1_30() {
        DateUtil date = new DateUtil(29, 1, 2001);
        System.out.println("2001_1_29ShouldIncrementTo2001_1_30 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(30, date.getDay());
    }

    @Test
    public void test19A2001_1_30ShouldIncrementTo2001_1_31() {
        DateUtil date = new DateUtil(30, 1, 2001);
        System.out.println("2001_1_30ShouldIncrementTo2001_1_31 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    @Test
    public void test20A2001_1_31ShouldIncrementTo2001_2_1() {
        DateUtil date = new DateUtil(31, 1, 2001);
        System.out.println("2001_1_31ShouldIncrementTo2001_2_1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test21A2001_2_1ShouldIncrementTo2001_2_2() {
        DateUtil date = new DateUtil(1, 2, 2001);
        System.out.println("2001_2_1ShouldIncrementTo2001_2_2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2, date.getDay());
    }

    @Test
    public void test22A2001_2_28ShouldIncrementTo2001_3_1() {
        DateUtil date = new DateUtil(28, 2, 2001);
        System.out.println("2001_2_28ShouldIncrementTo2001_3_1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test23A2001_2_29ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(29, 2, 2001));
    }

    @Test
    public void test24A2001_2_30ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(30, 2, 2001));
    }

    @Test
    public void test25A2001_2_31ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(31, 2, 2001));
    }

    @Test
    public void test26A2001_6_1ShouldIncrementTo2001_6_2() {
        DateUtil date = new DateUtil(1, 6, 2001);
        System.out.println("2001_6_1ShouldIncrementTo2001_6_2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2, date.getDay());
    }

    @Test
    public void test27A2001_6_28ShouldIncrementTo2001_6_29() {
        DateUtil date = new DateUtil(28, 6, 2001);
        System.out.println("2001_6_28ShouldIncrementTo2001_6_29 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test28A2001_6_29ShouldIncrementTo2001_6_30() {
        DateUtil date = new DateUtil(29, 6, 2001);
        System.out.println("2001_6_29ShouldIncrementTo2001_6_30 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(30, date.getDay());
    }

    @Test
    public void test29A2001_6_30ShouldIncrementTo2001_7_1() {
        DateUtil date = new DateUtil(30, 6, 2001);
        System.out.println("2001_6_30ShouldIncrementTo2001_7_1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test30A2001_6_31ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(31, 6, 2001));
    }

    @Test
    public void test1B2000_1_1ShouldDecrementTo1999_12_31() {
        DateUtil date = new DateUtil(1, 1, 2000);
        System.out.println("2000_1_1ShouldDecrementTo1999_12_31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1999, date.getYear());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    @Test
    public void test2B2000_1_28ShouldDecrementTo2000_1_27() {
        DateUtil date = new DateUtil(28, 1, 2000);
        System.out.println("2000_1_28ShouldDecrementTo2000_1_27 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(27, date.getDay());
    }

    @Test
    public void test3B2000_1_29ShouldDecrementTo2000_1_28() {
        DateUtil date = new DateUtil(29, 1, 2000);
        System.out.println("2000_1_29ShouldDecrementTo2000_1_28 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(28, date.getDay());
    }

    @Test
    public void test4B2000_1_30ShouldDecrementTo2000_1_29() {
        DateUtil date = new DateUtil(30, 1, 2000);
        System.out.println("2000_1_30ShouldDecrementTo2000_1_29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test5B2000_1_31ShouldDecrementTo2000_1_30() {
        DateUtil date = new DateUtil(31, 1, 2000);
        System.out.println("2000_1_31ShouldDecrementTo2000_1_30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(30, date.getDay());
    }

    @Test
    public void test6B2000_2_1ShouldDecrementTo2000_1_31() {
        DateUtil date = new DateUtil(1, 2, 2000);
        System.out.println("2000_2_1ShouldDecrementTo2000_1_31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    @Test
    public void test7B2000_2_28ShouldDecrementTo2000_2_27() {
        DateUtil date = new DateUtil(28, 2, 2000);
        System.out.println("2000_2_28ShouldDecrementTo2000_2_27 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(27, date.getDay());
    }

    @Test
    public void test8B2000_2_29ShouldDecrementTo2000_2_28() {
        DateUtil date = new DateUtil(29, 2, 2000);
        System.out.println("2000_2_29ShouldDecrementTo2000_2_28 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(28, date.getDay());
    }

    @Test
    public void test9B2000_2_30ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(30, 2, 2000));
    }

    @Test
    public void test10B2000_2_31ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(31, 2, 2000));
    }

    @Test
    public void test11B2000_6_1ShouldDecrementTo2000_5_31() {
        DateUtil date = new DateUtil(1, 6, 2000);
        System.out.println("2000_6_1ShouldDecrementTo2000_5_31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    @Test
    public void test12B2000_6_28ShouldDecrementTo2000_6_27() {
        DateUtil date = new DateUtil(28, 6, 2000);
        System.out.println("2000_6_28ShouldDecrementTo2000_6_27 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(27, date.getDay());
    }

    @Test
    public void test13B2000_6_29ShouldDecrementTo2000_6_28() {
        DateUtil date = new DateUtil(29, 6, 2000);
        System.out.println("2000_6_29ShouldDecrementTo2000_6_28 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(28, date.getDay());
    }

    @Test
    public void test14B2000_6_30ShouldDecrementTo2000_6_29() {
        DateUtil date = new DateUtil(30, 6, 2000);
        System.out.println("2000_6_30ShouldDecrementTo2000_6_29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test15B2000_6_31ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(31, 6, 2000));
    }

    @Test
    public void test16B2001_1_1ShouldDecrementTo2000_12_31() {
        DateUtil date = new DateUtil(1, 1, 2001);
        System.out.println("2001_1_1ShouldDecrementTo2000_12_31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2000, date.getYear());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    @Test
    public void test17B2001_1_28ShouldDecrementTo2001_1_27() {
        DateUtil date = new DateUtil(28, 1, 2001);
        System.out.println("2001_1_28ShouldDecrementTo2001_1_27 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(27, date.getDay());
    }

    @Test
    public void test18B2001_1_29ShouldDecrementTo2001_1_28() {
        DateUtil date = new DateUtil(29, 1, 2001);
        System.out.println("2001_1_29ShouldDecrementTo2001_1_28 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(28, date.getDay());
    }

    @Test
    public void test19B2001_1_30ShouldDecrementTo2001_1_29() {
        DateUtil date = new DateUtil(30, 1, 2001);
        System.out.println("2001_1_30ShouldDecrementTo2001_1_29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test20B2001_1_31ShouldDecrementTo2001_1_30() {
        DateUtil date = new DateUtil(31, 1, 2001);
        System.out.println("2001_1_31ShouldDecrementTo2001_1_30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(30, date.getDay());
    }

    @Test
    public void test21B2001_2_1ShouldDecrementTo2001_1_31() {
        DateUtil date = new DateUtil(1, 2, 2001);
        System.out.println("2001_2_1ShouldDecrementTo2001_1_31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    @Test
    public void test22B2001_2_28ShouldDecrementTo2001_2_27() {
        DateUtil date = new DateUtil(28, 2, 2001);
        System.out.println("2001_2_28ShouldDecrementTo2001_2_27 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(27, date.getDay());
    }

    @Test
    public void test23B2001_2_29ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(29, 2, 2001));
    }

    @Test
    public void test24B2001_2_30ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(30, 2, 2001));
    }

    @Test
    public void test25B2001_2_31ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(31, 2, 2001));
    }

    @Test
    public void test26B2001_6_1ShouldDecrementTo2001_5_31() {
        DateUtil date = new DateUtil(1, 6, 2001);
        System.out.println("2001_6_1ShouldDecrementTo2001_5_31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    @Test
    public void test27B2001_6_28ShouldDecrementTo2001_6_27() {
        DateUtil date = new DateUtil(28, 6, 2001);
        System.out.println("2001_6_28ShouldDecrementTo2001_6_27 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(27, date.getDay());
    }

    @Test
    public void test28B2001_6_29ShouldDecrementTo2001_6_28() {
        DateUtil date = new DateUtil(29, 6, 2001);
        System.out.println("2001_6_29ShouldDecrementTo2001_6_28 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(28, date.getDay());
    }

    @Test
    public void test29B2001_6_30ShouldDecrementTo2001_6_29() {
        DateUtil date = new DateUtil(30, 6, 2001);
        System.out.println("2001_6_30ShouldDecrementTo2001_6_29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2001, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test30B2001_6_31ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(31, 6, 2001));
    }
}
