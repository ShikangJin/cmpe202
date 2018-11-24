# LAB #10- AspectJ & Feature IDE
The purpose of this lab is to compare the AspectJ & Feature IDE solution for Gumball Machine problem with the original JAVA solution. <br><br>
The original JAVA solution from Lab #1 used Factory Pattern by creating a Gumball Machine Factory Interface, and implementing it with three different types of Gumball Machine Factory. For each Gumball Machine Factory, it contained cost and required coin type variables to satisfy the requirement, and in the Main class, users need to select one Gumball Machine Factory to create a Gumball Machine, then use it.<br><br>
Compare with the original JAVA solution, the AspectJ & Feature IDE solution creates a model for Gumball Machine problem. The model defines all possible configurations for the problem, where each configuration represents a type of Gumball Machine. Below is the model for Gumball Machine problem<br>

![alt text](https://github.com/ShikangJin/cmpe202/blob/master/lab10/GumballMachineModel.png) <br>

In this model, we have three different types of available configurations. Each branch represents a feature for current configuration, the alternative branch, which has an arc between two branches, means the parent node can select only one of two branches, and if there is no arc between two branches, the parent node needs to use both of them. The final configuration will contain all selected features. <br><br> 

This solution uses AspectJ to implement the major functions for different configurations, and we do not need to create three different Gumball Machine classes. In this case, only one Gumball Machine Class is needed to deal with the basic functionalities amount all types of Gumball Machine, for example managing the coins inside of machine. All other detailed functionalities such as inserting coins and turning the crank will be implemented in AspectJ files. The Gumball Machine class only need to provide an empty function for each functionality, and AspectJ will find that function and add detailed solution for it. Below are configurations and outputs from AspectJ & Festure IDE solution<br><br>

Gumball Machine (Cost 25 Cents and Required Quarter Only) <br>
![alt text](https://github.com/ShikangJin/cmpe202/blob/master/lab10/ConfigureForMachine1.png) <br>
![alt text](https://github.com/ShikangJin/cmpe202/blob/master/lab10/OutputForMachine1.png) <br><br>

Gumball Machine (Cost 50 Cents and Required Quarter Only) <br>
![alt text](https://github.com/ShikangJin/cmpe202/blob/master/lab10/ConfigureForMachine2.png) <br>
![alt text](https://github.com/ShikangJin/cmpe202/blob/master/lab10/OutputForMachine2.png) <br><br>

Gumball Machine (Cost 50 Cents and Accept All Types of Coin) <br>
![alt text](https://github.com/ShikangJin/cmpe202/blob/master/lab10/ConfigureForMachine3.png) <br>
![alt text](https://github.com/ShikangJin/cmpe202/blob/master/lab10/OutputForMachine3.png) <br>
