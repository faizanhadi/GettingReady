# GettingReady
Programmatically process a list of commands for getting ready, enforce related rules, and display appropriate output.

The GettingReady driver starts the application by asking if in-built test cases are to be run or the User wants to give a custom input. The input needs to be in a format of "HOT 8, 6, 4, 2, 1, 7"

The input string needs to be parsed. This is handled by the "StringParse" class. Here, the input is parsed by maintaining the uppercase and removing all the extra spaces and the commas. The input is reformated and displayed on the console.

The inpur is then send to a class named "FailOrNot". Here, the input weather is checked. That is Hot or Cold. The respective functions are performed dealing with the commands in the input systematically.

The "FailOrNot" class uses CriteriaCheck class to check the different conditions that are to be enforced.

The final result is send back to "GettingReady" to be displaced.
