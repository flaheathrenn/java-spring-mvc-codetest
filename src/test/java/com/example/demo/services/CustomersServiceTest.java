package com.example.demo.services;

import com.example.demo.models.Customer;
import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

public class CustomersServiceTest extends TestCase {

    private static CustomersService customersServiceUnderTest;

    @Override
    protected void setUp() {
        customersServiceUnderTest = new CustomersService();
    }

    public void testSortAscendingDuetime_sort() {
        ZonedDateTime newestJointime = ZonedDateTime.of(LocalDateTime.of(2021, 2, 28, 17, 30), ZoneId.of("Europe/London"));
        ZonedDateTime oldestDuetime = ZonedDateTime.of(LocalDateTime.of(2020, 11, 8, 7, 45), ZoneId.of("Europe/London"));
        Customer oldestCustomer = createMockCustomer(450L, "Customer Oldest", newestJointime, oldestDuetime);

        ZonedDateTime oldestJointime = ZonedDateTime.of(LocalDateTime.of(2021, 2, 13, 8, 30), ZoneId.of("Europe/London"));
        ZonedDateTime middleDuetime = ZonedDateTime.of(LocalDateTime.of(2021, 11, 8, 7, 40), ZoneId.of("Europe/London"));
        Customer middleCustomer = createMockCustomer(350L, "Customer Middle", oldestJointime, middleDuetime);

        ZonedDateTime middleJointime = ZonedDateTime.of(LocalDateTime.of(2021, 2, 13, 8, 31), ZoneId.of("Europe/London"));
        ZonedDateTime newestDuetime = ZonedDateTime.of(LocalDateTime.of(2021, 11, 8, 7, 45), ZoneId.of("Europe/London"));
        Customer newestCustomer = createMockCustomer(650L, "Customer Newest", middleJointime, newestDuetime);

        List<Customer> expectedSortedList = Arrays.asList(oldestCustomer, middleCustomer, newestCustomer);

        List<Customer> actualList = Arrays.asList(middleCustomer, oldestCustomer, newestCustomer);
        customersServiceUnderTest.sortAscendingDuetime(actualList);

        assertEquals(expectedSortedList, actualList);

    }

    /**
     * Test that the sort code is able to recognise when an earlier local time is later by virtue of its time zone
     */
    public void testSortAscendingDuetime_timeZones() {
        ZonedDateTime newestJointime = ZonedDateTime.of(LocalDateTime.of(2021, 2, 28, 17, 30), ZoneId.of("Europe/London"));
        ZonedDateTime oldestDuetime = ZonedDateTime.of(LocalDateTime.of(2020, 11, 8, 7, 45), ZoneId.of("Europe/London"));
        Customer oldestCustomer = createMockCustomer(450L, "Customer Oldest", newestJointime, oldestDuetime);

        ZonedDateTime oldestJointime = ZonedDateTime.of(LocalDateTime.of(2021, 2, 13, 8, 30), ZoneId.of("Europe/London"));
        ZonedDateTime newestDuetime = ZonedDateTime.of(LocalDateTime.of(2020, 11, 8, 6, 45), ZoneId.of("America/Toronto"));
        Customer newestCustomer = createMockCustomer(350L, "Customer Newest", oldestJointime, newestDuetime);

        List<Customer> expectedSortedList = Arrays.asList(oldestCustomer, newestCustomer);

        List<Customer> actualList = Arrays.asList(newestCustomer, oldestCustomer);
        customersServiceUnderTest.sortAscendingDuetime(actualList);

        assertEquals(expectedSortedList, actualList);

    }

    private Customer createMockCustomer(Long id, String name, ZonedDateTime jointime, ZonedDateTime duetime) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setJointime(jointime);
        customer.setDuetime(duetime);
        return customer;
    }
}