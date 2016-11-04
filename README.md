Comp 124 HW6: Gesture Recognizer
================================

For this homework assignment, you will practice using data structures to implement an algorithm for gesture recognition of drawn 2D gestures.

### Due Dates
This homework will have three milestones:

* Part 1 **(Due Friday, November 11th)**: For this milestone, you should answer the questions below and bring your answers to hand in on paper in class.
* Part 2 **(Due Monday, November 14th)**: For this milestone you should commit and push the code to draw the user interface and allow a user to draw a gesture. The gesture does not need to be recognized at this point.
* Part 3 **(Due Tuesday, November 22nd)**: For this milestone you should commit and push the completed assignment that allows users to add templates and recognize gestures. The test files should pass.

### Part 1 Questions

The algorithm you will implement is called the $1 Gesture recognizer. Start by reading the [research paper](./res/1dollar.pdf) describing the algorithm which was published at the User Interface Software and Technology (UIST) Symposium in 2007. The pseudo-code for the algorithm can be found [here](./res/dollarpseudocode.pdf).

For part 1, you should answer the following questions:

1. What data structure will you use to store the points in the gesture? Justify your answer.
2. In order to draw the gesture on the CanvasWindow, you will need to use several of the methods defined in the MouseListener and MouseMotionListener interfaces. List each of the methods you will use, and briefly describe what actions you will need to take in order to draw the gesture on the CanvasWindow. 
3. In your own words, describe each step of the recognition algorithm. For each step, explain why the actions performed on the data are needed.
4. What is still confusing about the algorithm?

Please type your answers and submit them on paper in class. Make sure that they are thoughtfully written. Please edit for grammar, clarity, and coherence. Yes, even in a CS course. Especially in a CS course!

### Part 2

For part 2, your code should open a window and display the user interface shown in the image below.

![Gesture Recognizer Screenshot](./res/screenshot.png)

The user should be able to click and drag with the mouse to draw a gesture (e.g. the arrow drawn in the upper portion of the screen). This will require implementing the MouseListener and MouseMotionListener interfaces. Hint: Look back at the painter activity and Listing 6.26 in the textbook for similar examples.
The gesture can be drawn in a CanvasWindow using Line objects from the comp124graphics package between successive mouse points.

### Part 3

Create a `Recognizer` class that implements the $1 gesture recognition algorithm. You will need to convert the pseudo-code linked above into actual java code. Make sure that you understand what the code is doing. Don't just blindly translate or your implementation may not work correctly. I have provided a test class that you may use to test your implementation. Uncomment the code in `TestRecognizer` and complete the todo comments in the testRecognize method.

You can also use graphical debugging by passing your CanvasWindow to your recognizer class and creating a method that draws a gesture path as a series of ellipses. For example, you could test your resample method by drawing the original points in the gesture and the resampled points. Visually examine the results and see if they make sense. This will work for the rotation, scaling, and translating methods as well. 

Implement the ActionListener interface to make the "Add Template" button work. This button should create a gesture template for the most recently drawn gesture, using the value in the textbox as the name of the gesture. Think carefully about which data structure you will use in your Recognizer class to store the gesture templates.

Hook your recognizer up to the rest of your user interface. When the user releases the mouse, the gesture should be recognized, and the name of the closest match and the score should be displayed in a label on the screen.

### Helpful Hints

* When drawing the gesture, each time you move the mouse you need to store the 2D point representing its position at that point in time. You can store this point as a [Point2D](https://docs.oracle.com/javase/8/docs/api/java/awt/geom/Point2D.html) object. Since this is an abstract class, you will need to actually create Point2D.Double objects. Hint: look carefully at the methods defined in the Point2D class. Some of them may be useful when implementing the pseudo-code.
* In pseudo-code, a name in all capital letters represents a method. An arrow represents an assignment statement to assign a value to a variable.
* The centroid of a group of points is a point that minimizes the distance between itself and all the other points (i.e. the geometric center of the group). This can be calculated by adding all of the x values and all of the y values for the group of points and dividing each component by the number of points. This gives you the x and y positions of the centroid.
* The boundingBox method should return a [Rectangle2D](https://docs.oracle.com/javase/7/docs/api/java/awt/geom/Rectangle2D.html) that bounds all of the points.
* The Math class contains two different arctangent methods: [atan](https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html#atan(double)) and [atan2](https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html#atan2(double,%20double)). They differ based on the range of the angle that is returned. (-pi/2 to pi/2 for atan and -pi to pi for atan2). Make sure you use the correct one.
* The rotateBy method assumes that the angle omega is in radians, not degrees!

### Appropriate Resources

In this assignment, the primary learning goals are to gain practice using data structures, develop good object-oriented organizational habits, and to learn how to convert pseudo-code into valid java. As a published research algorithm, there are many code solutions that exist for the $1 gesture recognizer. Looking at these or any other student's code would negate the benefits you will gain by completing the assignment. You may discuss the assignment with other students, but do not share your code or look at other code. **The only resources you may use to help you on the assignment are the research paper and pseudo-code linked above.**  Misuse of resources will result in a zero grade and further action per Macalester's policy on Academic Integrity. If you get stuck, I would encourage you to visit the preceptor's or my office hours to get help.

### Submission

Part 1 will be submitted on paper in class. It will be graded using the following rubric:

| Topic | 4 | 3 | 2 | 1 |
| --- | --- | --- | --- | --- |
| Correctness and Ideas | Excels in responding to the questions and demonstrates sophistication of thought. Shows a thorough understanding of the algorithm and methods needed for implementation. Contains all necessary details. | A solid response. Clearly answers the questions, but may have minor lapses in development. Shows an understanding of the algorithm. Contains most necessary details. | Adequate but weaker and less effective at answering the questions. Shows basic comprehension of the algorithm, but with some lapses in understanding. Includes some details needed for implementation. | Does not show a clear understanding or does not answer the questions. Most details incorrect or missing. | 
| Justification and support | Uses examples, big-O notation, descriptive references to figures from the paper, etc. to appropriately and effectively justify answers, providing sufficient evidence and explanation to convince the reader of correctness. | Begins to offer reasons to support its points. Its examples bear some relevance. | Justification may be brief, or assumes that evidence speaks for itself. Often has lapses in logic. | Lacks supporting justification for answers. |
| Mechanics | Response is typed, well formatted, and almost entirely free of spelling, punctuation, and grammatical errors. | May contain a few errors, which may annoy the reader but do not impede understanding. | Usually contains several mechanical errors, but they do not interfere with understanding. | Usually contains either many mechanical errors or a few important errors that block understanding. |
 
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
