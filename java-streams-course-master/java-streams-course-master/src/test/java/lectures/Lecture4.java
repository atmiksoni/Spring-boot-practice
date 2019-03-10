package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class Lecture4 {

  @Test
  public void distinct() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

    List<Integer> distinctNumbers = numbers.stream()
        .distinct()
        .collect(Collectors.toList());

    assertThat(distinctNumbers).hasSize(9);

    System.out.println(distinctNumbers);

  }

  @Test
  public void distinctWithSet() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

    Set<Integer> distinctNumbers = numbers.stream()
        .collect(Collectors.toSet());

    assertThat(distinctNumbers).hasSize(9);

    System.out.println(distinctNumbers);
  }


  @Test
  public void findOutTotalDuplicateNoPresentInList(){
    final List<Integer> numbers =ImmutableList.of(1,1,2,2,3,3,4,4,5,5,6,6);

   long uniqueNo=  numbers.stream().distinct().count();
   System.out.println("uniqueNo::"+uniqueNo);
   System.out.println("original size:"+numbers.size());
   long differnce= numbers.size() -uniqueNo;
   assertThat(differnce).isEqualTo(6);

  }

  @Test
  public void checkListIsNullSafe(){
    List<String> list=new ArrayList<>();

    System.out.print("List Size::"+list.size());


  }
}
