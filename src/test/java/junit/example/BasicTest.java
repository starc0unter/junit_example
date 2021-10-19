package junit.example;

import org.junit.*;

public final class BasicTest {
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass");
    }

    @Before
    public void runBeforeTestMethod() {
        System.out.println("@Before");
    }

    @After
    public void runAfterTestMethod() {
        System.out.println("@After");
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
