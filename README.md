# graphical-roll-dice-v2

My solution for Chapter 6 Exercise 4 of “Introduction to Programming Using Java”.

NOTE: This is a javafx program. It requires the javafx library as a dependency. (See bottom of this README for javafx instructions).

Project Description:
In Exercise 6.3, you wrote a graphical pair-of-dice program where the dice are rolled when
the user clicks on the canvas. Now make a pair-of-dice program where the user rolls the
dice by clicking a button. The button should appear under the canvas that shows the
dice. Also make the following change: When the dice are rolled, instead of just showing
the new value, show a short animation during which the values on the dice are changed in
every frame. The animation is supposed to make the dice look more like they are actually
rolling.

Javafx setup instructions:
Download javafx from: https://gluonhq.com/products/javafx/ (I used javafx 12). Save it to a location of your choice.
Unpack the zip folder.
Open my project with your IDE of choice (I use intellij IDEA).
Add the javafx/lib folder as an external library for the project. For intellij, this means going to "project structure" -> "libraries" -> "add library" ->{javafx location}/lib
Add the following as a VM argument for the project: --module-path "{full path to your javafx/lib folder}" --add-modules javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.media,javafx.swing,javafx.web
Build and run the project as normal.
