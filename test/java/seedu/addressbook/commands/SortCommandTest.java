package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {

    private AddressBook addressBook;
    private Command sortCommand;
    private List<Person> expectedPersonList;

    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("98765432", false),
                new Email("johnDoe@gmail.com", false), new Address("321, Clementi Ave 2, #02-25", false),
                new UniqueTagList());
        Person maryMee = new Person(new Name("Mary Mee"), new Phone("12345678", false),
                new Email("maryMee@gmail.com", false), new Address("123, Clementi Ave 1, #01-25", false),
                new UniqueTagList());
        Person daveCurry = new Person(new Name("Dave Curry"), new Phone("23456789", false),
                new Email("daveCurry@gmail.com", false), new Address("213, Clementi Ave 3, #03-25", false),
                new UniqueTagList());
        Person owenPhelps = new Person(new Name("Owen Phelps"), new Phone("34567891", false),
                new Email("owenPhelps@gmail.com", false), new Address("432, Clementi Ave 5, #05-25", false),
                new UniqueTagList());
        Person adamLam = new Person(new Name("Adam Lam"), new Phone("87654321", false),
                new Email("adamLam@gmail.com", false), new Address("234, Clementi Ave 4, #04-25", false),
                new UniqueTagList());

        addressBook = TestUtil.createAddressBook(johnDoe, maryMee, daveCurry, owenPhelps, adamLam);
        expectedPersonList = Arrays.asList(adamLam, daveCurry, johnDoe, maryMee, owenPhelps);
    }

    @Test
    public void execute() throws Exception {
        assertSortSuccessful(expectedPersonList);
    }

    /**
     * Executes the sort command and verifies the result
     * matches the persons in the expectedPersonList exactly.
     */
    private void assertSortSuccessful(List<Person> expectedPersonList) throws Exception {
        sortCommand = new SortCommand();
        sortCommand.setData(addressBook, Collections.emptyList());
        sortCommand.execute();

        UniquePersonList allPersons = addressBook.getAllPersons();
        UniquePersonList expectedPersons = new UniquePersonList(expectedPersonList);

        assertEquals(allPersons, expectedPersons);
    }
}
