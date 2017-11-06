Comp 124 HW5: Gesture Recognizer
================================

For this homework assignment, you will practice using data structures to implement an algorithm for gesture recognition of drawn 2D gestures.

### Due Dates
This homework will have two milestones:

* Part 1 **(Due Friday, November 10th)**: For this milestone, you should answer the questions below for the moodle assignment that corresponds with this homework.
* Part 2 **(Due Friday, November 17th)**: For this milestone you should commit and push the code to allow a user to draw a gesture. The gesture does not need to be recognized at this point.
* Part 3 **(Due Monday, November 27th)**: For this milestone you should commit and push the completed assignment that allows users to add templates and recognize gestures. The test files should pass.

### Part 1 Questions

The algorithm you will implement is called the $1 Gesture recognizer. Start by reading the [research paper](./res/1dollar.pdf) describing the algorithm which was published at the User Interface Software and Technology (UIST) Symposium in 2007. The pseudo-code for the algorithm can be found [here](./res/dollarpseudocode.pdf).

For part 1, you should answer the following questions:

1. What data structure will you use to store the points in the gesture? Justify your answer.
2. In order to draw the gesture on the CanvasWindow, you will need to use several of the methods defined in the MouseListener and MouseMotionListener interfaces. List each of the methods you will use, and briefly describe what actions you will need to take in order to draw the gesture on the CanvasWindow. 
3. **In your own words**, describe each step of the recognition algorithm. For each step, explain why the actions performed on the data are needed.
4. What is still confusing about the algorithm?

Please submit your answers in Moodle for the this homework assignment. Make sure that they are thoughtfully written. Please edit for grammar, clarity, and coherence. Yes, even in a CS course. Especially in a CS course!

### Part 2

For part 2, your code should allow the user to draw in the user interface shown in the image below. We have already given you the code that creates the user interface elements in `GestureWindow`.

![Gesture Recognizer Screenshot](./res/screenshot.png)

The user should be able to click and drag with the mouse to draw a gesture (e.g. the arrow drawn in the upper portion of the screen). This will require implementing the MouseListener and MouseMotionListener interfaces. Hint: Look back at the painter activity and Listing 6.26 in the textbook for similar examples.
The gesture can be drawn in a CanvasWindow using Line objects from the comp124graphics package between successive mouse points.

### Part 3

Complete the `Recognizer` class that implements the $1 gesture recognition algorithm. You will need to convert the pseudo-code linked above into actual java code. Make sure that you understand what the code is doing. Don't just blindly translate or your implementation may not work correctly. I have provided a test class that you may use to test your implementation. Uncomment the code in `TestRecognizer` and complete the todo comments in the testRecognize method. Don't forget to write tests for any additional non-trivial methods that you add.

The `Visualizer` class allows graphical debugging. This class draws each step as a different color. You may need to enlarge the window to see all of the steps. Feel free to modify this class as needed to help you debug the code and make sure it is working. Visually examine the results and see if they make sense. This will work for the resample, rotation, scaling, and translating methods. 

Make the addTemplate method work. This should create a gesture template for the path parameter. Think carefully about which data structure you will use in your Recognizer class to store the gesture templates. Practice class/Method decomposition!

Hook your recognizer up to the rest of your user interface. When the user releases the mouse, the gesture should be recognized, and the name of the closest match and the score should be displayed in a `matchlabel` label on the screen. See the screenshot above for an example.

### Helpful Hints

* When drawing the gesture, each time you move the mouse you need to store the 2D point representing its position at that point in time. You can store this point as a [Point2D](https://docs.oracle.com/javase/8/docs/api/java/awt/geom/Point2D.html) object. Since this is an abstract class, you will need to actually create Point2D.Double objects. Hint: look carefully at the methods defined in the Point2D class. Some of them may be useful when implementing the pseudo-code.
* In pseudo-code, a name in all capital letters represents a method. An arrow represents an assignment statement to assign a value to a variable. "|A|" represents the length of data structure A.
* The centroid of a group of points is the average of the x and y values of the points in the group, i.e. the point that minimizes the distance between itself and all the other points.
* The boundingBox method should return a [Rectangle2D](https://docs.oracle.com/javase/7/docs/api/java/awt/geom/Rectangle2D.html) that bounds all of the points.
* The Math class contains two different arctangent methods: [atan](https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html#atan(double)) and [atan2](https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html#atan2(double,%20double)). They differ based on the range of the angle that is returned. (-pi/2 to pi/2 for atan and -pi to pi for atan2). Make sure you use the correct one.
* The rotateBy method assumes that the angle omega is in radians, not degrees!

### Appropriate Resources

In this assignment, the primary learning goals are to gain practice using data structures, develop good object-oriented organizational habits, and to learn how to convert pseudo-code into valid java. As a published research algorithm, there are many code solutions that exist for the $1 gesture recognizer. Looking at these or any other student's code would negate the benefits you will gain by completing the assignment and is a violation of Macalester's academic integrity policy. You may discuss the assignment with other students, but do not share your code or look at other code. **The only resources you may use to help you on the assignment are the research paper and pseudo-code linked above.**  Misuse of resources will result in a zero grade and further action per Macalester's policy on Academic Integrity. If you get stuck, I would encourage you to visit the preceptor's or my office hours to get help.

### Submission

Part 1 will be submitted on moodle. It will be graded based on effort shown in answering the four questions.
 
The code for parts 2 and 3 should be committed and pushed to github.

Please make sure to follow the guidelines for [good java style](https://docs.google.com/a/macalester.edu/document/d/1YpCzhKhYy5JUQ6oCGJZdf92a0jjpmjMxfKfhPkFl5As/edit?usp=sharing). I have given you tests for most of the methods described in the pseudo-code, but you should add additional tests for any non-trivial methods you add.

To receive full credit, you must have:
* Good class decomposition
* Good method decomposition
* Correct Execution:
  * The user should be able to draw a gesture by clicking and dragging with the mouse
  * The user should be able to add a gesture that was just drawn as a template
  * After drawing a gesture, it should be recognized and the name and score should be displayed
* Correct Style
