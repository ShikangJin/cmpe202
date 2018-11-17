# Summary

In this lab, I implement chain_of_responsibliity pattern by using lambda expression. Lambda expression implements the abstruct function of functional interfaces. By setting funtional interface, we can easily implement the interface with the parameters and return type that we want. 
<br>
<br>
After trying lambda expression, I find it is convenient if people want to create an one-time method and use or store it for later usage. Since the lambda expression can be created in another method, it means the system does not need to use any memory to store lambda expression before the outer method (which store the lambda expression) is called. Therefore, in my opinion, using lambda expression is a way to effectively manage memory usage.
<br>
<br>
Also, by changing "for loop" to lambda expression, the amount of code is cut obviously. Now I only use one line code:
`requests.forEach(req -> test.apply(req)); `
to iterate every element in the list. This feature is similar with the map method of array in javascript.
