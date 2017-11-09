package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NONE;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.RemoveTag;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;

//@@author yewshengkai
/**
 * Parses input arguments and creates a new RemoveTag object
 */
public class RemoveTagParser implements Parser<RemoveTag> {

    /**
     * Parses the given {@code String} of arguments in the context of the RemoveTag
     * and returns an RemoveTag object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public RemoveTag parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NONE);
        try {
            Tag tag = ParserUtil.parseTag(argMultimap.getValue(PREFIX_NONE)).get();
            return new RemoveTag(tag);
        } catch (IllegalValueException ive) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemoveTag.MESSAGE_USAGE));
        }
    }

}
