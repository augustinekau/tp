package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_GRADE_A;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GRADE_C;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_A;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MOD_NAME_B;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_CODE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.module.Module;

/**
 * A utility class containing a list of {@code Module} objects to be used in tests.
 */
public class TypicalModules {

    public static final Module COM_ORG = new ModuleBuilder().withName("CS2100")
            .withGrade("A-")
            .withTags("CS2100").build();
    public static final Module EFF_COM = new ModuleBuilder().withName("CS2101")
            .withGrade("B-")
            .withTags("CS2101").build();
    public static final Module SWE = new ModuleBuilder().withName("CS2103T")
            .withGrade("A+").build();
    public static final Module COM_INFO = new ModuleBuilder().withName("ES2660")
            .withGrade("C").withTags("ES2660").build();
    public static final Module ASK_QN = new ModuleBuilder().withName("GEQ1000")
            .withGrade("C+").withTags("GEQ1000").build();
    public static final Module STATS = new ModuleBuilder().withName("ST2334")
            .withGrade("B").withTags("ST2334").build();
    public static final Module ALGO = new ModuleBuilder().withName("CS2040S")
            .withGrade("B+").withTags("CS2040S").build();

    // Manually added
    public static final Module GEH = new ModuleBuilder().withName("GEH1036")
            .withGrade("A").withTags("GEH").build();
    public static final Module GER = new ModuleBuilder().withName("GER1000")
            .withGrade("A").withTags("GER").build();

    // Manually added - Module's details found in {@code CommandTestUtil}
    public static final Module MOD_A = new ModuleBuilder().withName(VALID_MOD_NAME_A)
            .withGrade(VALID_GRADE_A).withTags(VALID_TAG_FRIEND).build();
    public static final Module MOD_B = new ModuleBuilder().withName(VALID_MOD_NAME_B)
            .withGrade(VALID_GRADE_C).withTags(VALID_TAG_CODE)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalModules() {
    } // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical modules.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Module module : getTypicalModules()) {
            ab.addModule(module);
        }
        return ab;
    }

    public static List<Module> getTypicalModules() {
        return new ArrayList<>(Arrays.asList(COM_ORG, EFF_COM, SWE, COM_INFO, ASK_QN, STATS, ALGO));
    }
}
