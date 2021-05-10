# Fall 2021 - Shopify Developer Intern Challenge
## Candidate: Walter Wong
Challenge Link: https://docs.google.com/document/d/1ZKRywXQLZWOqVOHC4JkF3LqdpO3Llpfk_CkZPR8bjak/edit#heading=h.n7bww7g70ipk

## Instructions
For this project I tested all the methods using JUnit, so you can run the code that way. Alternatively, I made a super rough interface class called 'ApplicationInterface.java', which demostrates some of the functionalities. You can input which item you would like, username, amount of money and then how many units of the item you would like to buy. Depending on how much money you have, and how many units you wanted to buy, the system will either inform you that you have purchased the item(s) successfully, or unsuccessful due to lack of funds, or lack of units available. Feel free to modify ApplicationInterface.java if you want to try different scenarios.

There should be two ways to achieve this:
1) Open the project using IntelliJ or another Java IDE and use the IDE interface to run the code. In IntelliJ that just means clicking the green play buttons or selecting 'Run' on the top toolbar. This will then open up the built-in terminal, allowing you to get the prompts. **I would recommend this method as I have tested it**
2) Using your computer's terminal/command prompt. First, navigate to the folder containing the project. Then run the interface by compiling: `javac ApplicationInterface.java` and then running `java ApplicationInterface.java`, which should then give you the prompts. However, when I tried this on my computer, I was getting a `error: cannot find symbol` for my three created datatypes, even though they were in the same package. Manually importing those classes also did not help, and I was not able to find any help online. Thus, I would recommend that you try the first method. 

## Test Case Coverage
ImageInfo and OrderSystem has 100% line coverage, while ImageRepository has 93% line coverage. All three have 100% method coverage. I tried to think up of as many scenarios as possible when writing test cases, and added to the test suite as I thought of more scenarios/discouvered bugs in the code.

## Narrative
The task was an Image Repository. I assumed that the ImageRepository would represent a specific shop, allowing the owner to add new items and restock, and allow consumers to purchase items. The OrderSystem represented one user with a shopping cart, I implemented it so that when an item was added to a shopping cart, it was taken away from the shop, so sort of reserving the item. This might not work well in reality, so a compromise might be that a consumer can reserve an item in their shopping cart for a set amount of time. ImageInfo contained the specific image for sale, as well as relevant information. I didn't do anything with this information this time, but I thought of what information was useful to know for sellers/buyers when brainstorming.

## Challenges
This was the first time that I have performed test driven development so it was definitely an eye-opener for me. It was a bit hard to do at first, but with each new class I became more proficient with it. For the first class I actually ended up completing the code before the test cases as I was thinking of creating skeleton code so that I could call those methods in the test case, but reverted to my old habits. By the third class I was able to stick strictly to creating the tests before coding, which I'm proud of. There's still more to learn as I had to go back and forth adding a few things that I had forgotten the first time around.

## Possible Future Improvements
* Do more with the image information
* Add concurrency functionality
* Create an User object that tracks things like the amount of money this user has, previous purchases, login details, etc.
* Improve the application interface
