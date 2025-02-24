# **Password Generator**
## *Documentation*
### <ins> Project Report: Simple Password Generator </ins>

### Project Overview
   The Simple Password Generator is a Java-based application designed to generate secure passwords based on user-defined criteria. Users can specify the length and types of characters to include in the password (lowercase letters, uppercase letters, digits, symbols). The application also evaluates the strength of the generated password using the zxcvbn library.

### Design Choices
<ins>User Input Validation:

+ Ensured that the password length input is within the acceptable range (8-20 characters) using a loop to validate user input.

+ Used a validateYesNoInput method to ensure only 'y' or 'n' inputs for including character types, preventing invalid inputs.

<ins>Password Generation:

+ Used a SecureRandom instance to generate random characters for the password.

+ Allowed the inclusion of a custom character set, providing an ability for users who want to define their own characters.

<ins>Password Strength Evaluation:

+ Integrated the zxcvbn library to assess password strength, providing a score to the user based on industry standards.

### Challenges Encountered 

+ <ins>Handling User Input:

Ensuring the application handling different types of input, including invalid or unexpected inputs.

+ <ins>Integrating External Libraries:

Incorporating the zxcvbn library into a Java project posed challenges. Detailed instructions were necessary to guide me through downloading and adding the library to my project's build path.

+ <ins> User Experience: </ins>

Ensuring that error messages were clear and helpful, and that the overall flow of the program was logical and easy to follow.

### <ins> Algorithms and data structures used </ins>

### Algorithms
User Input Validation:

+ Password Length Validation:
  
  + Loop until the user provides a valid integer input between 8 and 20.

  + If the input is invalid, prompt the user again.

Character Type Inclusion Validation:

+ Loop to ensure that the usr provides a 'y' or 'n' input for including lowercase, uppercase, digits, and symbols.

+ The validateYesNoInput method ensures that only valid 'y' or 'n' inputs are accepted.

Password Generation:

+ Character Pool Creation:

  + Based on user preferences, different character sets (lowercase, uppercase, digits, symbols) are added to the characterPool list.

  + If a custom character set is provided, those characters are also added to the pool.

+ Random Character Selection:

  + A SecureRandom instance is used to generate random indices to select characters from the characterPool.

  + This process continues until the password reaches the desired length.

+ Character Pool Shuffling:

  + The Collections.shuffle(characterPool) method is used to shuffle the pool to ensure randomness.

Password Strength Evaluation:

+ Zxcvbn Library:

  + The Zxcvbn instance evaluates the generated password's strength (from 0 to 4) .

  + It provides a score based on the password's complexity and industry standards.

### Data Structures
**ArrayList < Character >:**

+ Character Pool:

  + An ArrayList is used to store characters from different character sets (lowercase, uppercase, digits, symbols).

**SecureRandom:**

+ Random Number Generator:

  + A SecureRandom instance is used to randomly add the letters (uppercase, lowercase), digits, symbols, and character sets.

**char[]:**

+ Password Array:

  + A char array is used to store the generated password characters.

+ This array is converted to a String after populating it with random characters from the characterPool.

**Scanner:**

+ User Input:
  + A Scanner object is used to read user input from the console.

### <ins> Files were not used in input or output </ins>

## Usage

+ Download and Setup:

  + Download the zxcvbn library JAR file.

+ Run the Program:

  + Compile and run the SimplePasswordGenerator class.

  + The program will prompt you to enter the desired password length (between 8 and 20 characters).

  + Select Character Types:

    + Answer the prompts to include lowercase letters, uppercase letters, digits, and symbols by entering 'y' for yes and 'n' for no.

    + <ins> At least one character type must be chosen.</ins>

  + Optional Custom Character Set:

    + You can choose to use a custom character set by entering 'y' when prompted and then providing the custom characters.

  + Generate and Evaluate Password:

    + The program generates a password based on your criteria and displays it.

    + It also evaluates the password strength using the zxcvbn library and provides feedback.

  + Output:

    + The generated password and its strength score are displayed in the console.

## Output Example:
```
    Enter the password length. It must be between 8-20 characters: 8
    Include lowercase letters? (y/n): y
    Include uppercase letters? (y/n): n
    Include numbers? (y/n): y
    Include symbols? (y/n): y
    Would you like to use a custom character set? (y/n): n
    Generated password: qsd3j$zd
    Password strength: 2 (0=weak, 4=strong)

    Process finished with exit code 0
```
<ins>Other output examples will be given in a .txt file and a screenshot.</ins> 