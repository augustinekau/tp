package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.GradeBook;
import seedu.address.model.Model;

/**
 * Clears the grade book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Grade book has been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setGradeBook(new GradeBook());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
