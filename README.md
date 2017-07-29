# JSON_Parser


JSON (JavaScript Object Notation) is a lightweight data-interchange format.
This project is a simple JSON validator. For each non terminal a class is formed.
JSON is built on two structures:
* A collection of name/value pairs. In various languages, this is realized as an object, record, struct, dictionary, hash table, keyed list, or associative array.
* An ordered list of values. In most languages, this is realized as an array, vector, list, or sequence.
In JSON, they take on these forms:

An object is an unordered set of name/value pairs. An object begins with { (left brace) and ends with } (right brace). Each name is followed by : (colon) and the name/value pairs are separated by , (comma).
An array is an ordered collection of values. An array begins and end with [  ] respectively. Values are separated by , (comma).
A value can be a string in double quotes, or a number, or true or false or null, or an object or an array. These structures can be nested.
A string is a sequence of zero or more Unicode characters, wrapped in double quotes, using backslash escapes. A character is represented as a single character string. A string is very much like a C or Java string.
A number is very much like a C or Java number, except that the octal and hexadecimal formats are not used.

Grammer used is:
Start -> {} | {Element}
Element->"Alphanum":Value| "Alphanum":Value,Element
Array->Value| Value,Array| Null
Alphanum -> <String>
Value->"Alphanum"| {Element}| [Array]| Constant
Constant->null | true | false | <number>
