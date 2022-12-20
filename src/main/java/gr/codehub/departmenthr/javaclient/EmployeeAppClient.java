package gr.codehub.departmenthr.javaclient;

import gr.codehub.departmenthr.domain.Employee;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class EmployeeAppClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String uri= "http://localhost:8080/employees";

        {
            long startTime = System.nanoTime();
            List<Employee> employees = restTemplate.getForObject(uri, List.class);
            long endTime = System.nanoTime();
            System.out.println(employees);
            System.out.println("1. Execution time in seconds " + (endTime - startTime) / 1e9);

        }

        {
            long startTime = System.nanoTime();
            List<Employee> employees = restTemplate.getForObject(uri, List.class);
            long endTime = System.nanoTime();
            System.out.println(employees);
            System.out.println("2. Execution time in seconds  " + (endTime - startTime) / 1e9);

        }

        {
            long startTime = System.nanoTime();
            List<Employee> employees = restTemplate.getForObject(uri, List.class);
            long endTime = System.nanoTime();
            System.out.println(employees);
            System.out.println("3. Execution time in seconds  " + (endTime - startTime) / 1e9);

        }

        {
            long startTime = System.nanoTime();
            List<Employee> employees = restTemplate.getForObject(uri, List.class);
            long endTime = System.nanoTime();
            System.out.println(employees);
            System.out.println("4. Execution time in seconds  " + (endTime - startTime) / 1e9);

        }

    }
}
