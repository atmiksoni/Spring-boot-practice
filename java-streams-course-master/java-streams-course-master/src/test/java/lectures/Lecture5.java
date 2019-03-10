package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    final Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

    List<Car> carsFiltered = cars.stream()
        .filter(carPredicate)
        .collect(Collectors.toList());

    carsFiltered.forEach(System.out::println);
    System.out.println(carsFiltered.size());
  }


  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    List<PersonDTO> dtos = people.stream()
        .map(PersonDTO::map)
        .collect(Collectors.toList());

    dtos.forEach(System.out::println);

    assertThat(dtos).hasSize(1000);
    System.out.println(dtos.size());

  }

  @Test
  public void extractingFirsNameFromPersonList() throws IOException{
    List<Person> personList = MockData.getPeople();

     List<String> firstNameList = personList.stream().
         map(Person::getFirstName).
         sorted().limit(10)
        .collect(Collectors.toList());
     firstNameList.forEach(System.out::println);
    System.out.println("firstList size::"+firstNameList.size());

  }

  @Test
  public void extractingListToMap() throws IOException{
    List<Person> personList = MockData.getPeople();

    Map<Integer, PersonDTO> personDTOMap = personList.stream()
        .collect(Collectors.toMap(Person::getId, PersonDTO::map));
    personDTOMap.forEach((k,v) -> System.out.println("Key::"+k+"::value::"+v));
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    double average = MockData.getCars()
        .stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);
    System.out.println(average);
  }

  @Test
  public void test() throws Exception {
    MockData.getCars().forEach(System.out::println);
  }
}



