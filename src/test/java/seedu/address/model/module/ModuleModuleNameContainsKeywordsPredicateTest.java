package seedu.address.model.module;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ModuleBuilder;

public class ModuleModuleNameContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        ModuleNameContainsKeywordsPredicate firstPredicate =
                new ModuleNameContainsKeywordsPredicate(firstPredicateKeywordList);
        ModuleNameContainsKeywordsPredicate secondPredicate =
                new ModuleNameContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        ModuleNameContainsKeywordsPredicate firstPredicateCopy =
                new ModuleNameContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_nameContainsKeywords_returnsTrue() {
        // One keyword
        ModuleNameContainsKeywordsPredicate predicate =
                new ModuleNameContainsKeywordsPredicate(Collections.singletonList("Alice"));
        assertTrue(predicate.test(new ModuleBuilder().withName("Alice Bob").build()));

        // Multiple keywords
        predicate = new ModuleNameContainsKeywordsPredicate(Arrays.asList("Alice", "Bob"));
        assertTrue(predicate.test(new ModuleBuilder().withName("Alice Bob").build()));

        // Only one matching keyword
        predicate = new ModuleNameContainsKeywordsPredicate(Arrays.asList("Bob", "Carol"));
        assertTrue(predicate.test(new ModuleBuilder().withName("Alice Carol").build()));

        // Mixed-case keywords
        predicate = new ModuleNameContainsKeywordsPredicate(Arrays.asList("aLIce", "bOB"));
        assertTrue(predicate.test(new ModuleBuilder().withName("Alice Bob").build()));
    }

    @Test
    public void test_nameDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        ModuleNameContainsKeywordsPredicate predicate =
                new ModuleNameContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new ModuleBuilder().withName("Alice").build()));

        // Non-matching keyword
        predicate = new ModuleNameContainsKeywordsPredicate(Arrays.asList("Carol"));
        assertFalse(predicate.test(new ModuleBuilder().withName("Alice Bob").build()));

        // Not relevant - aug
        // Keywords match phone and address, but does not match name
        // predicate = new ModuleNameContainsKeywordsPredicate(Arrays.asList("12345", "Main", "Street"));
        // assertFalse(predicate.test(new ModuleBuilder().withName("Alice")
        //         .withGrade("Main Street").build()));
    }
}