# Input Mask Introduction

In this lab, I implemented the Input Mask, which read users digits input and display them as corresponding card number, expire date, and CVC. </br></br>

My application allows users to input a string instead of one digit. After a string is inputed, the system will automatically analyze each char of this string, and ignore all substring except digit, "X", and "Delete". Also, this system will automatically calculate if input month is available or not. If not, it will correct the month. For example: input 2198 for month will be corrected to 02/19, and the last digit "8" will be passed to CVC.
</br> </br>
An Example Input: 1234567876543212395123 </br>
Output: 1234 5678 7654 3212 03/95 123
 
