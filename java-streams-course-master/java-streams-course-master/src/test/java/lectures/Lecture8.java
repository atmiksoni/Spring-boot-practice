package lectures;


import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    Map<String, List<Car>> grouping = MockData.getCars()
        .stream()
        .collect(Collectors.groupingBy(Car::getMake));

    grouping.forEach((make, cars) -> {
      System.out.println(make);
      cars.forEach(System.out::println);
    });
  }

  @Test
  public void peopleGroupingByAge() throws IOException{
    Map<Integer, List<Person>> collect = MockData.getPeople()
        .stream()
        .collect(Collectors.groupingBy(Person::getAge));
     collect.forEach((age,people) ->
         System.out.println("Age::"+age+"::People::"+people));
  }

  @Test
  public  void countPeopleWithSameAge() throws  IOException{
    //First way
    List<Integer> listOfAge = MockData.getPeople()
        .stream()
        .map(Person::getAge)
        .collect(Collectors.toList());

    Map<Integer, Long> mapList = listOfAge.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    mapList
    .forEach((age,count) -> System.out.println("Age:"+age+"::value::"+count));

    //Second way
    Map<Integer, Long> peopleList = MockData.getPeople()
        .stream()
        .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

    peopleList.forEach((age,count)-> System.out.println("Second way::--> Age:"+age+"::value::"+count));

    System.out.println(mapList.equals(peopleList));

  }

  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );

    Map<String, Long> counting = names.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    counting.forEach((name, count) -> System.out.println(name + " > " + count));
  }

}