package seedu.addressbook.commands;

import java.util.*;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all persons in address book by name "
            + "lexicographically.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_UPON_SUCCESS = "Address book is successfully sorted.";

    @Override
    public CommandResult execute() {
        addressBook.sortAllPersonsByName();
        return new CommandResult(MESSAGE_UPON_SUCCESS);
    }
}
