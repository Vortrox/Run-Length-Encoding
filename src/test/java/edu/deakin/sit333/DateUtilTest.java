package edu.deakin.sit333;

import java.util.Random;

import edu.deakin.sit333.DateUtil;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
    // TODO: CHANGE INDENTATION TO 4X SPACES
    @Test
    public void testStudentIdentity() {
        String studentId = "0";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Vortrox";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        // January max boundary area: max+1
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        // January max boundary area: max-1
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testNominalJanuary() {
        int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
    }

    /*
     * Complete below test cases.
     */

    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        // todo: check message
        System.out.println("january1ShouldIncrementToJanuary2 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2, date.getDay());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        // todo: check message
        System.out.println("january1ShouldDecrementToDecember31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2023, date.getYear());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    /*
     * Write tests for rest months of year 2024.
     */

    @Test
    public void test1A1994_06_01ShouldDecrementTo1994_05_31() {
        DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("1994_06_01ShouldDecrementTo1994_05_31 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(31, date.getDay());
    }

    @Test
    public void test2A1994_06_02ShouldDecrementTo1994_06_01() {
        DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("1994_06_02ShouldDecrementTo1994_06_01 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test3A1994_06_15ShouldDecrementTo1994_06_14() {
        DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("1994_06_15ShouldDecrementTo1994_06_14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test4A1994_06_30ShouldDecrementTo1994_06_29() {
        DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("1994_06_30ShouldDecrementTo1994_06_29 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(29, date.getDay());
    }

    @Test
    public void test5A1994_06_31ShouldBeInvalid() {
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(31, 6, 1994));
    }

    @Test
    public void test6A1994_01_15ShouldDecrementTo1994_01_14() {
        DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("1994_01_15ShouldDecrementTo1994_01_14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test7A1994_02_15ShouldDecrementTo1994_02_14() {
        DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("1994_02_15ShouldDecrementTo1994_02_14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test8A1994_11_15ShouldDecrementTo1994_11_14() {
        DateUtil date = new DateUtil(15, 11, 1994);
        System.out.println("1994_11_15ShouldDecrementTo1994_11_14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test9A1994_12_15ShouldDecrementTo1994_12_14() {
        DateUtil date = new DateUtil(15, 12, 1994);
        System.out.println("1994_12_15ShouldDecrementTo1994_12_14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test10A1700_06_15ShouldIncrementTo1700_06_14() {
        DateUtil date = new DateUtil(15, 6, 1700);
        System.out.println("1700_06_15ShouldIncrementTo1700_06_14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1700, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test11A1701_06_15ShouldIncrementTo1701_06_14() {
        DateUtil date = new DateUtil(15, 6, 1701);
        System.out.println("1701_06_15ShouldIncrementTo1701_06_14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1701, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test12A2023_06_15ShouldIncrementTo2023_06_14() {
        DateUtil date = new DateUtil(15, 6, 2023);
        System.out.println("2023_06_15ShouldIncrementTo2023_06_14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2023, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test13A2024_06_15ShouldIncrementTo2024_06_14() {
        DateUtil date = new DateUtil(15, 6, 2024);
        System.out.println("2024_06_15ShouldIncrementTo2024_06_14 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2024, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(14, date.getDay());
    }

    @Test
    public void test1B1994_06_01ShouldIncrementTo1994_06_02() {
        DateUtil date = new DateUtil(1, 6, 1994);
        System.out.println("1994_06_01ShouldIncrementTo1994_06_02 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2, date.getDay());
    }

    @Test
    public void test2B1994_06_02ShouldIncrementTo1994_06_03() {
        DateUtil date = new DateUtil(2, 6, 1994);
        System.out.println("1994_06_02ShouldIncrementTo1994_06_03 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(3, date.getDay());
    }

    @Test
    public void test3B1994_06_15ShouldIncrementTo1994_06_16() {
        DateUtil date = new DateUtil(15, 6, 1994);
        System.out.println("1994_06_15ShouldIncrementTo1994_06_16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test4B1994_06_30ShouldIncrementTo1994_07_01() {
        DateUtil date = new DateUtil(30, 6, 1994);
        System.out.println("1994_06_30ShouldIncrementTo1994_07_01 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(1, date.getDay());
    }

    @Test
    public void test5B1994_01_15ShouldIncrementTo1994_01_16() {
        DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("1994_01_15ShouldIncrementTo1994_01_16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test6B1994_02_15ShouldIncrementTo1994_02_16() {
        DateUtil date = new DateUtil(15, 2, 1994);
        System.out.println("1994_02_15ShouldIncrementTo1994_02_16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test7B1994_11_15ShouldIncrementTo1994_11_16() {
        DateUtil date = new DateUtil(15, 11, 1994);
        System.out.println("1994_11_15ShouldIncrementTo1994_11_16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test8B1994_12_15ShouldIncrementTo1994_12_16() {
        DateUtil date = new DateUtil(15, 12, 1994);
        System.out.println("1994_12_15ShouldIncrementTo1994_12_16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1994, date.getYear());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test9B1700_06_15ShouldIncrementTo1700_06_16() {
        DateUtil date = new DateUtil(15, 6, 1700);
        System.out.println("1700_06_15ShouldIncrementTo1700_06_16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1700, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test10B1701_06_15ShouldIncrementTo1701_06_16() {
        DateUtil date = new DateUtil(15, 6, 1701);
        System.out.println("1701_06_15ShouldIncrementTo1701_06_16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(1701, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test11B2023_06_15ShouldIncrementTo2023_06_16() {
        DateUtil date = new DateUtil(15, 6, 2023);
        System.out.println("2023_06_15ShouldIncrementTo2023_06_16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2023, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(16, date.getDay());
    }

    @Test
    public void test12B2024_06_15ShouldIncrementTo2024_06_16() {
        DateUtil date = new DateUtil(15, 6, 2024);
        System.out.println("2024_06_15ShouldIncrementTo2024_06_16 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(2024, date.getYear());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(16, date.getDay());
    }
}