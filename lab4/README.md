I used observer pattern to design the waitlist system of Din Tai Fung Restaurant. 

The observer pattern defines Restaurant class as the child of ConcreteSubject Class, which implements Subject interface, and defines Guest class as the child of ConcreteObserver Class, which implements Observer interface.

Simple workflow:
	1. When a new guest group comes, the application creates a Guest object, sets name, phone number, and group size for this object.
	
	2. Asks Restaurant object to add this Guest object into Guest list.
	
	3. When a table is released, Restaurant object notifies all Guest objects in the list, and each Guest object updates its status.
	
	4. When a Guest object updates, it gives Restaurant object a group size and asks if there is any available table. If yes, it sends message to the recorded phone number, and Restaurant object put this Guest object into a waitingCallBack list with the available table id. Then Restaurant object marks this table as "being used" (saves the table for this Guest)
	
	5. If the guest group reply message and it is comfirm, then Guest object tells Restaurant object, then Restaurant object removes this Guest from both waitingCallBack list and Guest list. If the guest doesn't reply in time or replys "leave", then Guest object tells Restaurant object, and Restaurant releases the saved table and removes this Guest from both lists.
