// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("newtons method test for 0.001") {
    val obtained = 0.001
    val expected = 0.031622
    assertEquals(sqrt(obtained), expected)
  }
}
// Test values
/**
    0.001
    0.1e-20
    1.0e20
    1.0e50
*/