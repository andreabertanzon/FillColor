# FillColor
This project is a simple tic tac toe game made in JavaFX.
Instead of creating a blob of code inside a single class I wanted to create a separation between the logic of the game or the Model so to speak, the view, so the
user interface, and the Controller. 

The operation of checking for a winner is done contunuosly by an observable list that as soon as it finds a winning combination returns the winner and a
pop up window declaring the winning player is opened and the game reset.
