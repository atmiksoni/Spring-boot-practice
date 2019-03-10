package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;
import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {

    System.out.println("for i");

    for (int i = 0; i <= 10; i++) {
      System.out.println(i);
    }

    System.out.println("exclusive");

    IntStream.range(0, 10).forEach(System.out::println);

    System.out.println("inclusive");

    IntStream.range(0, 10).forEach(System.out::println);

  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();

    IntStream.range(0, people.size())
        .forEach(index -> {
          Person person = people.get(index);
          System.out.println(person);
        });

  }

  @Test
  public void intStreamIterate() throws Exception {
      IntStream.iterate(0, operand -> operand + 1)
          .filter(number -> number % 2 == 0)
          .limit(20)
          .forEach(System.out::println);
  }

  @Test
  public  void findOutMaxNO(){

    List<Integer> integerList = ImmutableList.of(1,10,4,999,45,563,1,4,7,3487,24,67788,23);
            //first way
            int maxNo=  integerList.stream().max((num1,num2) ->num1>num2?1:-1).get();
            System.out.println("first way -> Max no::"+maxNo);
            // Second way
            int maxNo1= integerList.stream().max(Comparator.naturalOrder()).get();

            assertThat(maxNo1).isEqualTo(maxNo);

            //find out min no
            int minNo= integerList.stream().min(Comparator.naturalOrder()).get();
            System.out.println("MIn No::"+minNo);
            assertThat(minNo).isEqualTo(1);
  }
}
