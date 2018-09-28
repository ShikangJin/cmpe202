I use observer pattern to design the waitlist system of Din Tai Fung Restaurant. I choose observer pattern since this system matches behavior design pattern, and observer pattern here matches this circumstance properly. In the real world, restaurant always notifies waiting guests that there is an empty table, and this is what observer pattern does.

The observer pattern defines Restaurant class as the child of ConcreteSubject Class, which implements Subject interface, and defines Guest class as the child of ConcreteObserver Class, which implements Observer interface.

CRC Card (I attached CRC Card image in the folder) :

Class: Guest <br />
Responsibilities: 
	1. Gets name, phone number, and group size of guest
	2. Receives the notification from Restaurant, and see if there is an available table 
	3. Sends message to guest and asks Restaurant to add guest into waitingCallBack list
	4. Receives callback and tells Restaurant result <br />
Collaborators: Restaurant

Class: Restaurant <br />
Responsibilities: 
	1. Maintains a guest list
	2. Maintains an available table list and a using table list 
	3. Searches and provides available table id according to guest group size
	4. Notifies all guests when a table is released
	5. Puts guests into a waitingCallBack list after sending them message, meanwhile saves tables for them
	6. Updates table status according to guests’ callback message <br />
Collaborators: Guest

Class: Test <br />
Responsibilities: 
	1. Creates Restaurant object
	2. Creates Guest object
	3. Creates a test case for testing <br />
COllaborators: Guest, Restaurant
	
Simple workflow:
	
	1. When a new guest group comes, the application creates a Guest object, sets name, phone number, and group size for this object.
	
	2. Asks Restaurant object to add this Guest object into Guest list.
	
	3. When a table is released, Restaurant object notifies all Guest objects in the list, and each Guest object updates its status.
	
	4. When a Guest object updates, it gives Restaurant object a group size and asks if there is any available table. If yes, it sends message to the recorded phone number, and Restaurant object put this Guest object into a waitingCallBack list with the available table id. Then Restaurant object marks this table as "being used" (saves the table for this Guest)
	
	5. If the guest group replies message and it is confirm, then Guest object tells Restaurant object, then Restaurant object removes this Guest from both waitingCallBack list and Guest list. If the guest doesn't reply in time or replies "leave", then Guest object tells Restaurant object, and Restaurant releases the saved table and removes this Guest from both lists.
