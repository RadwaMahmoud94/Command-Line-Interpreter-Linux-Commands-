An operating system interfaces with a user through a Command Line Interpreter (CLI). A CLI is a software module capable of interpreting textual commands coming either from the user’s keyboard or from a script file. A CLI is often referred to as a shell.
Using Java
Interface for parser
Will be filled by arguments extracted by parse method. , Will be filled by the command extracted by parse method. ,Returns true if it was able to parse user input correctly. Otherwise false.In case of success, it should save the extracted command and arguments., to args and cmd variables. , It should also print error messages in case of too few arguments for a commands
