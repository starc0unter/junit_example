package junit.example;


import org.junit.jupiter.api.*;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public final class TestFixtures {
    @BeforeAll
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeAll");
    }

    @AfterAll
    public static void runOnceAfterClass() {
        System.out.println("@AfterAll");
    }

    @BeforeEach
    public void runBeforeTestMethod() {
        System.out.println("@BeforeEach");
    }

    @AfterEach
    public void runAfterTestMethod() {
        System.out.println("@AfterEach");
    }

    @Test
    public void test_1() {
        System.out.println("@Test - tes_1");
    }

    @Test
    public void test_2() {
        System.out.println("@Test - test_2");
    }
}
