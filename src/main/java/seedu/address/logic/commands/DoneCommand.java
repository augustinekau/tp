package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.semester.Semester;
import seedu.address.model.semester.SemesterManager;

public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + "Stops the adding or editing of modules in the semester stated.\n"
            + "Parameters: MODULE_NAME\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_START_SEMESTER_SUCCESS =
            "You are done editing: %1$s";

    private final Semester toDone;

    /**
     * Creates a StartCommand to add the specified {@code Semester}
     */
    public DoneCommand(Semester semester) {
        requireNonNull(semester);
        toDone = semester;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        SemesterManager semesterManager = SemesterManager.getInstance();
        String currentSemester = semesterManager.getCurrentSemester().toString();
        semesterManager.setCurrentSemester(Semester.NA);
        return new CommandResult(String.format(MESSAGE_START_SEMESTER_SUCCESS, currentSemester));
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof DoneCommand
                && toDone.equals(((DoneCommand) other).toDone); // instanceof handles nulls
    }
}
