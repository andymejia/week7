import static org.assertj.core.api.Assertions.assertThat;  
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoTest {

  private TestDemo testDemo;
  TestDemo mockDemo;
  
  @BeforeEach
  void setUp() throws Exception {
    testDemo = new TestDemo();
   
  }

  @ParameterizedTest
  @MethodSource("TestDemoTest#argumentsForAddPositive") 
  void assertThatTwoPositiveNumbersAreAddedCorrectly( 
      int a, int b, int expected, Boolean expectException) {
    if(!expectException) { 
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
      }else {
        assertThatThrownBy(() ->testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class); 
      }
  }
  
  
  static Stream<Arguments> argumentsForAddPositive(){
   // @formatter:off
    return Stream.of(
        arguments(2, 4, 6, false),
        arguments(0, 2, 2, true),
        arguments(-1, 4, 5, false)
        
        );
    // @formatter:on
        
  }
  
  @Test
  
  void assertThatNumberSquaredIsCorrect() {
    mockDemo = spy(testDemo);
    doReturn(5).when(mockDemo).getRandomInt();
    int fiveSquared = mockDemo.randomNumberSquared();
    assertThat(fiveSquared).isEqualTo(25);
  }
  

}
